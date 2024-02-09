import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}

class Main {
    public void run() {
        int[] nums = new int[] { 1, 1, 2 };
        int k = removeDuplicates(nums);
        System.out.println("Result:");
        System.out.println("k = " + k);
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    /*
     * In this program, I should:
     * Alternate the original array in a way so that all unique number is line up at
     * the start
     * Ex: [1, 1, 2, 3, 3, 4, 4] -> [1,2,3,4,3,4,4]
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return 1;
        // This is the index of the unique numbers and also the length of them
        int uniqueNumLocation = 0;
        int i;
        for (i = 0; i < nums.length; i++) {
            // IF the LAST number is unique, assign it to head of the unique number list
            if (i == nums.length - 1) {
                if (nums[i] != nums[i - 1]) {
                    nums[uniqueNumLocation] = nums[i];
                }
            } else {
                // Iterate and find the unique number
                // Assign it to the head (unique number list)
                // Increment the unique array index

                // If the next num is duplicate:
                if (nums[i] == nums[i + 1]) {
                    // If there are duplicate, we skip to the last one
                    while (nums[i] == nums[i + 1]) {
                        i++;
                        if (i >= nums.length - 1)
                            break;
                    }
                    nums[uniqueNumLocation] = nums[i - 1];
                } else {
                    // This happens if the number is alone and has no duplicates
                    nums[uniqueNumLocation] = nums[i];
                }
            }
            uniqueNumLocation++;
        }
        return uniqueNumLocation;
    }
}