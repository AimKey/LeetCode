/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */

/**
    log(m + n) = 2^(m+n)
    Normal way: O(m + n)
    1. Merge the two array (O(m + n))
    2. Find the median (for odd and even arrays) (O(1))
 */

/**
    * Merge 2 array by comparing each number of each arr against each
    * other and then choose the smaller one. Do this until on array
    * is out of length. Then add the remainder to the final array
    * Only works on sorted array inputs
    * @param {number[]} nums1
    * @param {number[]} nums2
    * @returns {number[]} fin
    */
let mergeArr = function(nums1, nums2) {
    let finArr = [];
    let i = 0;
    let k = 0;
    do {
        let firstNum = nums1[i];
        let secNum = nums2[k];

        if (firstNum <= secNum) {
            finArr.push(firstNum)
            i++;
        } else {
            finArr.push(secNum);
            k++
        }
    } while (i < nums1.length || k < nums2.length);

    // Add the remainder if either of them is finished
    if (i >= nums1.length && k < nums2.length) {
        console.log('Adding the rest of nums2')
        for (let j = k; j < nums2.length; j++) {
            finArr.push(nums2[j]);
        }
    } else if (k > nums2.length && i < nums1.length) {
        console.log('Adding the rest of nums1')
        for (let j = i; j < nums1.length; j++) {
            finArr.push(nums1[j]);
        }
    }
    console.log(finArr)
    return finArr;
}

let a = [1, 10, 20, 30]
let b = [5, 6, 7, 15, 25]
console.log(mergeArr(a, b))

var findMedianSortedArrays = function(nums1, nums2) {

};




