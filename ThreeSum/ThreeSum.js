/**
 * @param {number[]} nums
 * @return {number[][]}
 * Sort the array, fix the first number, for the second and third number, use two pointers
 */
var threeSum = function (nums) {
  // Sort the array
  nums = nums.sort((a, b) => a - b); //ASC
  let r = [];
  for (let i = 0; i < nums.length - 2; i++) {
    // Since we sort our array, the duplicate will happens if the previous and the current i is the same
    if (i > 0 && nums[i] == nums[i - 1]) {
      continue;
    }
    let firstNum = nums[i];
    let leftPointer = i + 1;
    let rightPointer = nums.length - 1;
    while (leftPointer < rightPointer) {
      let secondNum = nums[leftPointer];
      let thirdNum = nums[rightPointer];

      let total = firstNum + secondNum + thirdNum;

      // Total > 0 => The third num is too big
      if (total > 0) {
        rightPointer--;
      } else if (total < 0) {
        // Total < 0 => The second num is too small
        leftPointer++;
      } else {
        r.push([firstNum, secondNum, thirdNum]);
        leftPointer++;

        // Same as the first condition we checked before
        while (nums[leftPointer] == nums[leftPointer - 1]) {
          leftPointer++;
        }
      }
    }
  }
  return r;
};

/**
 * @param {Number[]} numbers
 * @returns {Map<Number, boolean>} map
 */
var setupHashmap = (numbers) => {
  let map = new Map();
  for (let num of numbers) {
    map.set(num, num);
  }
  return map;
};

/**
 * @param {Number[]} firstArr
 * @param {Number[]} secondArr
 * @returns {Boolean}
 */
var areTwoArrayTheSame = (firstArr, secondArr) => {
  if (firstArr[0] == secondArr[0] && firstArr[1] == secondArr[1] && firstArr[2] == secondArr[2]) return true;
  else return false;
};

console.log(threeSum([-1, 0, 1, 2, -1, -4]));
console.log(threeSum([0, 1, 1]));
console.log(threeSum([0, 0, 0]));
