
public class App {
    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}

/**
 * Main
 */
class Main {
    public void run() {
        String[] strings = new String[] { "ab", "a" };
        String s = longestCommonPrefix(strings);
        System.out.println("Prefix: " + s);
    }

    /*
     * Steps to take:
     * 1. Create a for loop for the FIRST string
     * 2. loop through every characters of the FIRST string. Then compare to the
     * rest of the elements
     * 3. If the rest of the elements matches the first character of the FIRST
     * element, we add it into our prefix
     * 3.1 If one character is mismatched, we will just break the loop and return
     * our prefix result
     * 
     */
    public String longestCommonPrefix(String[] strs) {
        // Loop through the first element
        StringBuilder result = new StringBuilder("");
        StringBuilder firstElement = new StringBuilder(strs[0]);
        for (int i = 0; i < firstElement.length(); i++) {
            if (isOtherCharactersTheSame(strs, firstElement.charAt(i), i)) {
                System.out.println(firstElement.charAt(i) + " is a prefix");
                result.append(firstElement.charAt(i));
            }
        }
        return result.toString();
    }

    public boolean isOtherCharactersTheSame(String[] strings, char character, int startPos) {
        boolean r = true;
        for (int i = 1; i < strings.length; i++) {
            String s = strings[i];
            // If it has only one char
            if (s.length() == 1) {
                if (s.toCharArray()[0] != character)
                    return false;
            } else if (startPos < s.length()) {
                // Still contain characters to compare (Ex: "ab" -> s.length = 2, startPost
                // should be 0 and 1)
                // Funny thing here is that the end index in the substring already - 1 for us,
                // so we don't
                // have to worry about it
                System.out.printf("Comparing %s and character %s, position: %d\n", s, character, startPos);
                System.out.println(s.substring(startPos, startPos + 1));
                if (s.substring(startPos, startPos + 1).toCharArray()[0] != character)
                    return false;
            } else
                return false;
        }
        return r;
    }
}
