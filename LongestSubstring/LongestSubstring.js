/**
 * @param {string} s
 * @return {number}
    * Given a string s, find the length of the longest substring without repeating characters.
*/

// Not really the best way but hey it works
var lengthOfLongestSubstring = function(s) {
    let cur = []
    let maxLen = 0;

    for (let i = 0; i < s.length; i++) {
        let k = i;
        let curLen = 0;
        do {
            let char = s[k];
            // Check if the char is in our array
            if (cur.includes(s[k])) {
                maxLen = curLen > maxLen ? curLen : maxLen;
                cur = [];
                break;
            }
            cur.push(char);
            curLen++;
            k++;
        } while (k < s.length)
    }
    return maxLen;
};
