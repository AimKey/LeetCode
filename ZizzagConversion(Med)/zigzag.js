/**
 * @param {string} s
 * @param {number} numRows
 * @return {string}
 * Example 1:

Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I

QWERTY, 1:
QWERTY

QWERTY, 2:
Q E T
W R Y


QWERTY, 3:
Q   T
W R Y
E

QWERTY, 4:
Q     T
W   Y
E T
R

0. If numrows = 1: return string

else :
1. Always fill the first column
2. For the second column and onwards:
  2.1 Enter placement mode, calc how many attempts : attemps = NR - 2 
  Ex: NR = 2 => No attempt to insert the middle columns
  Ex: NR = 3 => 3-1 = 1 => Insert one column in the middle

  2.2 Get the next position of the next column, loop and place it
  Ex: Numrows = 3
  
  let steps = attemps
  --- Loop ---
  Next position: pos[steps][y + 1] (y is the previous column index)
  Place char at pos
  attempts -= 1
  steps -= 1
  y += 1 (Move to the next column)

  if no more attemps:
    start to fill the column as normal
    reset the steps

  if the char arr is exhausted:
    Combine the characters and return

 */
var convert = function (s, numRows) {
  // Construct the array from the splitted
  let arr = ConstructArrayFromString(s, numRows);
  // console.log(`The array for ${s} has ${arr[0].length} rows and ${arr.length} columns`);
  // printArr(arr);

  let chars = s.split("");
  let len = chars.length;

  let colNum = 0;
  let charsLeft = len;
  let steps = numRows - 2;

  while (charsLeft > 0) {
    // Insert a full column
    let insertColumnChars = chars.splice(0, numRows);
    fillWholeColumn(arr, colNum, insertColumnChars);

    // Start to insert the middle columns if needed
    while (steps > 0 && charsLeft > 0) {
      colNum++;
      arr[steps][colNum] = chars.splice(0, 1);
      steps -= 1;
    }

    // Reset steps
    steps = numRows - 2;
    charsLeft = chars.length;
    colNum++;

    // console.log("=========================");
    // printArr(arr);
  }
  return collectArray(arr);
};

/**
 * @param {string} string The number of column for this string
 * @returns {Array<Array<string>>} array
 */
function ConstructArrayFromString(string, numRows) {
  let chars = string.split("");
  let len = chars.length;

  let colNum = 0;
  let charsLeft = len;
  let steps = numRows - 2;

  // console.log(`Chars left: ${charsLeft}, steps: ${steps}`);

  while (charsLeft > 0) {
    // Insert a full column
    charsLeft -= numRows;
    colNum++;

    // Start to insert the middle columns
    while (steps > 0 && charsLeft > 0) {
      steps -= 1;
      charsLeft -= 1;
      colNum++;
    }

    // Reset steps
    steps = numRows - 2;

    // console.log(`Chars left: ${charsLeft}, steps: ${steps}, numCols: ${colNum}`);
  }

  const result = Array.from({ length: numRows }, () => Array(colNum).fill("0"));
  return result;
}

/**
 * Fills an entire column of a 2D array with characters from the provided string.
 *
 * @param {Array<string>} arr - The 2D array to be filled.
 * @param {number} colIndex - The index of the column to fill.
 * @param {Array<string>} chars - The array string to fill the column
string><
 */
function fillWholeColumn(arr, colIndex, chars) {
  for (let i = 0; i < chars.length; i++) {
    // console.log(`Setting char ${chars[i]} at ${i},${colIndex}`);
    arr[i][colIndex] = chars[i];
  }
}

/**
 * @param {Array<string>} arr - The 2D array to be printed
 */
var printArr = (arr) => {
  for (let i = 0; i < arr.length; i++) {
    for (let j = 0; j < arr[0].length; j++) {
      process.stdout.write(arr[i][j] + " ");
    }
    console.log(); // Newline after each row
  }
};

/**
 * @param {Array<Array<string>>} arr The array to collect
 * @returns {string} The collected string
 */
var collectArray = (arr) => {
  let chars = [];
  arr.forEach((row) => {
    row.forEach((char) => {
      if (char !== "0") {
        chars.push(char);
      }
    });
  });

  let string = chars.join("");
  return string;
};

convert("PAYPALISHIRING", 2);
