import java.util.Arrays;

public class App {

    public static int removeElement(int[] nums, int val) {
        int r = 0;
        if (nums.length <= 1) {
            if (nums.length == 0)
                return 0;
            if (nums[0] == val) {
                return 0;
            } else
                return 1;
        }
        // 1 1
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                // Delete and move all values back
                // System.out.println("i = " + i);
                nums[i] += 1; // 2 1
                for (int j = i; j < nums.length - 1; j++) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    // System.out.println(Arrays.toString(nums));
                }
                // 1 2
                i--;
                r--;
            } else {
                r++;
            }
        }
        return r;
    }

    public static int test(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    public static void main(String[] args) throws Exception {
        int[] test = new int[] { 1, 1 };
        System.out.println("Original: " + Arrays.toString(test));
        int r = removeElement(test, 1);
        // System.out.println(r);
        System.out.println("After: ");
        for (int i = 0; i < r; i++) {
            System.out.print(test[i] + " ");
        }
    }

}
