class Main {

    public static void main(String[] args) {
        System.out.println("R: " + new Solution().longestPalindrome("abbcccba"));
    }
}

class Solution {

    /**
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        System.out.println("Incoming: " + s);

        StringBuilder origin = new StringBuilder(s);
        String result = s;
        int max = 0;
        for (int i = 0; i < origin.length(); i++) {
            int j = origin.length() - 1;
            // J is the second cursor that travel backwards
            while (j > i) {
                // Find the character j that matches i
                if (origin.charAt(i) != origin.charAt(j)) {
                    j--;
                    continue;
                }
                // Because j matches i, we check the substring between i and j
                String sub = origin.substring(i, j + 1);
                if (isPalindrome(sub)) {
                    if (sub.length() > max) {
                        max = sub.length();
                        result = sub;
                    }
                    break;
                }
                j--;
            }
        }
        if (result == s) {
            return s.substring(0, 1);
        }
        return result;
    }

    public boolean isPalindrome(String s) {
        var index = 0;
        for (int i = s.length() - 1; i > 0; i--) {
            if (s.charAt(index) != s.charAt(i)) {
                System.out.println("Not palidrome: " + s);
                return false;
            }
            index++;
        }
        System.out.println("Is palindrome: " + s);
        return true;
    }
}
