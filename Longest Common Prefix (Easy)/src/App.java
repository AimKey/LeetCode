
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
        String[] strings = new String[] { "flow", "flforreal", "fly" };
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
        StringBuilder result = new StringBuilder("");
        StringBuilder firstElement = new StringBuilder(strs[0]);
        for (int i = 0; i < firstElement.length(); i++) {
            if (isOtherCharactersTheSame(strs, firstElement.charAt(i), i)) {
                result.append(firstElement.charAt(i));
            } else {
                break;
            }
        }
        return result.toString();
    }

    public boolean isOtherCharactersTheSame(String[] strings, char character, int startPos) {
        boolean r = true;
        for (int i = 1; i < strings.length; i++) {
            String s = strings[i];
            if (startPos < s.length()) {
                if (s.substring(startPos, startPos + 1).toCharArray()[0] != character)
                    return false;
            } else {
                return false;
            }
        }
        return r;
    }
}
