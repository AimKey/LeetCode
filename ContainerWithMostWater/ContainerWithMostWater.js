/**
 * @param {number[]} height
 * @return {number}
 */
var maxArea = function (height) {
  let maxArea = 0;
  let pointerLeft = 0;
  let pointerRight = height.length - 1;
  while (pointerLeft < pointerRight) {
    // Determine which side is holding the smaller column
    let heightLeft = height[pointerLeft];
    let heightRight = height[pointerRight];

    // Calc the area
    let newHeight = Math.min(heightLeft, heightRight);
    let dist = pointerRight - pointerLeft;
    let newArea = newHeight * dist;
    maxArea = Math.max(newArea, maxArea);

    // Move
    if (heightLeft < heightRight) {
      pointerLeft++;
    } else {
      pointerRight--;
    }
  }
  return maxArea;
};

console.log(maxArea([1, 8, 6, 2, 5, 4, 8, 3, 7]));
console.log(maxArea([1, 1]));
