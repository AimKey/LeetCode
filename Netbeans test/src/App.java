
public class App {
    public static void main(String[] args) throws Exception {
        String[] strings = new String[] { "flower", "flow", "flight" };
        longestCommonPrefix(strings);
    }

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder s = new StringBuilder();
        String result = "";
        for (String string : strs) {
            s.append(string);
        }
        System.out.println(s);
        return result;
    }
}
