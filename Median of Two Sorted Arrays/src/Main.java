import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

class Main {

    public static void main(String[] args) {
        int[] nums1 = new int[] { 1,3 };
        int[] nums2 = new int[] { 2 };
        System.out.println(new Solution().findMedianSortedArrays(nums1, nums2));
    }
}

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Merge the two array first
        Integer[] merged = new Integer[nums1.length + nums2.length];
        int index = 0;
        for (int i = 0; i < nums1.length; i++) {
            merged[index] = nums1[i];
            index++;
        }

        for (int i = 0; i < nums2.length; i++) {
            merged[index] = nums2[i];
            index++;
        }
        // Sort them
        Arrays.sort(merged, (a, b) -> a - b);
        // Find the median
        double median = 0;
        if (merged.length % 2 == 0) {
            // median = sum of the 2 num in the middle / 2 (Ex: 4 => num1 + num2) 1 2 3 4 5 6
            median = (merged[merged.length / 2] + merged[merged.length / 2 - 1]) * 1.0 / 2;
        } else {
            // median = the middle number (Ex: 5 nums => 5 / 2 = 2 (The second num))
            median = merged[merged.length / 2];
        }
        printArray(merged);
        return median;
    }

    public <T> void printArray(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
