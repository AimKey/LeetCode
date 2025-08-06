/**
 * @param {number} x
 * @return {number}
 * 123 % 10 = 3
 * remainder += 3 * 10 ^ 0
 *
 */
var reverse = function (x) {
  let upperBound = Math.pow(-2, 31);
  let lowerBound = Math.pow(2, 31) - 1;
  let reversed = 0;
  let remainder = 0;
  let power = 0;
  let isNegative = x < 0;
  if (isNegative) x = -x; // Remove the negative sign first

  while (x != 0) {
    remainder = x % 10;
    reversed = reversed * 10 + remainder;
    x = (x / 10) | 0;
    power--;
  }

  if (isNegative) reversed = -reversed;

  if (reversed < upperBound || reversed > lowerBound) {
    return 0;
  }

  return reversed;
};

reverse(123);
reverse(1230);
reverse(-123);
