public class Main {
    public static void main(String[] args) throws Exception {
        new App().run();
    }
}

class App {
    public void run() {
        int[] nums1 = new int[] { 1, 2 };
        int[] nums2 = new int[] { 3, 4 };
        System.out.println(Solution.findMedianSortedArrays(nums1, nums2));
    }

}

class Solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int lengthNum1 = nums1.length;
        int lengthNum2 = nums2.length;
        int k = (int) (lengthNum1 + lengthNum2) / 2;
        int temp = 0;
        double result = 0;
        for (int count = 0; count <= k; count++) {
            System.out.println("Result: " + result + ", temp: " + temp + ", count: " + count);
            if (i == lengthNum1)
                i--;
            if (j == lengthNum2)
                j--;
            if (nums1[i] < nums2[j]) {
                if (count == k - 1) {
                    temp = nums1[i];
                }
                i++;
                result = nums1[i];
            } else {
                if (count == k - 1) {
                    temp = nums2[i];
                }
                j++;
                result = nums2[j];
            }
        }
        if ((lengthNum1 + lengthNum2) * 1.0 / 2 > k) {
            return result;
        } else {
            return (result + temp) / 2;
        }
    }
}
