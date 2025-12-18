class Main {

    public static void main(String[] args) {
        System.out.println(new Solution().intToRoman(1994));
        // new Solution().test();
    }
}

class Solution {

    /**
     * 4 or 9 == 5 - 1 or 10 - 1
     * 3 or 8 and below == III or VIII
     * Larger numbers stand first
     * 1. Divide the number by the largest roman numeral value
     * 2. Append the corresponding roman numeral to the result string
     * 3. Get the remainder from the substract
     * 4. Repeatablely until the remainder is 0
     * @param num
     * @return
     */
    public String intToRoman(int num) {
        var res = new StringBuilder("");
        int remain = 0;
        Roman[] powers = { Roman.I, Roman.X, Roman.C, Roman.M };
        int powerIdx = powers.length - 1;
        do {
            int pow = powers[powerIdx].value;
            // divide
            remain = num % pow; // Ex: 2025 % 1000 = 25
            num = num / pow; // Ex: 2025 / 1000 = 2
            String s = "";
            // process
            if (pow == Roman.M.value) {
                s = converter(num, Roman.M, Roman.N, Roman.F);
            } else if (pow == Roman.C.value) {
                s = converter(num, Roman.C, Roman.D, Roman.M);
            } else if (pow == Roman.X.value) {
                s = converter(num, Roman.X, Roman.L, Roman.C);
            } else {
                s = converter(num, Roman.I, Roman.V, Roman.X);
            }
            res.append(s);
            num = remain;
            powerIdx--;
        } while (remain > 0);
        return res.toString();
    }

    public String converter(int num, Roman one, Roman five, Roman ten) {
        System.out.println(
            // "Converting: " + num + ", one: " + one.name() + ", five: " + five.name() + ", ten: " + ten.name()
        );
        StringBuilder res = new StringBuilder();
        if (num == 4) {
            res.append(one.name() + five.name());
        } else if (num == 9) {
            res.append(one.name() + ten.name());
        } else {
            boolean overFour = num > 4 ? true : false;
            int numsToAdd = 0;
            if (overFour) {
                // Ex: 70 => 7 - (50 / 10) = 2 => L + X + X
                res.append(five);
                numsToAdd = num - five.value / one.value;
            } else {
                numsToAdd = num;
            }
            if (numsToAdd > 0) {
                var str = appendOnes(one.name(), numsToAdd);
                res.append(str);
            }
        }
        return res.toString();
    }

    public String appendOnes(String str, int times) {
        String res = "";
        for (int i = 0; i < times; i++) {
            res += str;
        }
        return res;
    }

    public static enum Roman {
        I(1),
        V(5),
        X(10),
        L(50),
        C(100),
        D(500),
        M(1000),
        N(5000),
        F(10000);

        private final int value;

        Roman(int value) {
            this.value = value;
        }
    }
}
