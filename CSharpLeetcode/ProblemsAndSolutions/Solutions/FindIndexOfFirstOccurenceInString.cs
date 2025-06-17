using System.Security.AccessControl;
using System.Text;

namespace FindFirstIndexOccurence.Solutions;

public class FindIndexOfFirstOccurenceInString
{
    public void Run()
    {
        var input = "abaacabbsadabcadabcabd";
        var pattern = "aa";
        int n = StrStr(input, pattern);
        Console.WriteLine(input);
        Console.WriteLine(pattern);
        Console.WriteLine("The location of the pattern: " + n);
    }

    // 2 string needle and haystack, return the first index of needle in the haystack
    /**
     * Constraints:
        1 <= haystack.length, needle.length <= 104
        haystack and needle consist of only lowercase English characters.
        Possible solutions:
        1. Force search: Start from index 0 and keep incrementing, then compare it one by one to find the one that is match
        2. Knuth Morris algorithm:
        - Match pattern and text until a mismatch is caught
        - calculate the distance of the pattern to the text
            Ex: If the pattern is                  ababx
            The "failure" function array would be: 00120
        Suppose the text is: "ababhabcdefababx"
        Using the pattern above, the iteration should be like this:
        1. ababh, we found that the h is not matched
        - Search in the pattern, we can see that we are at the b, which contains number 2 in failure function
        - So now, we will algin the pattern by the index of 2 of the pattern
        - Now it should be
     */
    public int StrStr(string haystack, string needle)
    {
        // Return if the length is invalid
        if (haystack.Length < 1 || needle.Length < 1) return -1;

        // Preprocessing the pattern first (Find sub-pattern in pattern)
        int[] lps = new int[needle.Length]; // Largest proper prefix
        lps = SetupPatternArray(needle, lps);

        for (int i = 0; i < lps.Length; i++)
        {
            Console.Write(lps[i] + " ");
        }

        // Start matching one by one
        int textIndex = 0;
        int lpsIndex = 0;
        while (textIndex < haystack.Length)
        {
            // If characters match, move both pointers forward
            if (haystack[textIndex] == needle[lpsIndex])
            {
                textIndex++;
                lpsIndex++;
                // If the entire pattern is traversed, return the result
                if (lpsIndex == needle.Length)
                {
                    return (textIndex - lpsIndex);
                }
            }
            // If there is a mismatch
            else
            {
                // If lpsIndex is not 0, meaning that the lps has traversed some, then we backtrack to find if there exist other prefix in the pattern
                if (lpsIndex != 0)
                    lpsIndex = lps[lpsIndex - 1];
                else
                    textIndex++;
            }
        }

        return -1;
    }

    public int[] SetupPatternArray(string needle, int[] lps)
    {
        int lpsIndex = 0;
        for (int i = 1; i < needle.Length; i++)
        {
            // Console.WriteLine(needle[i]);
            if (needle[lpsIndex] == needle[i])
            {
                lpsIndex += 1;
                lps[i] = lpsIndex;
                // Console.WriteLine("Matched, increasing: " + lpsIndex);
            }
            else if (needle[lpsIndex] != needle[i])
            {
                if (lpsIndex == 0)
                {
                    lps[i] = 0; // No matching, No current sub pattern, set the subpatternIndex to be 0
                    Console.WriteLine("Not matched and no prefix is found before, setting to 0");
                }
                else
                {
                    lpsIndex = lps[lpsIndex - 1];
                    i--; // Keep comparing the i with the lpsIndex until the lpsIndex is 0 or it is match. Then we will break out from this loop
                }
            }
        }

        return lps;
    }
}