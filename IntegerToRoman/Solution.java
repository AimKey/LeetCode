class Main {

    public static void main(String[] args) {
        System.out.println(new Solution().intToRoman(1994));
        // new Solution().test();
    }
}

class Solution {

    public String intToRoman(int num) {
        StringBuilder s = new StringBuilder();
        // Prebuilt romans and values
        final int[] values = { 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000 };
        final String[] romans = { "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M" };

        // We will start to divide from the largest romain until the lowest
        int n = values.length - 1;
        while (num > 0) {
            int repeat = num / values[n]; // Ex: 2025 / 1000 = 2 => Repeat 2 times the M || 25 / 900 = 0 => Skip this iter
            while (repeat > 0) {
                s.append(romans[n]);
                repeat--;
            }
            num = num % values[n]; // Then we module to get the remainder: 2025 % 1000 = 25
            n--; // Reduce the roman value
        }
        return s.toString();
    }
}
