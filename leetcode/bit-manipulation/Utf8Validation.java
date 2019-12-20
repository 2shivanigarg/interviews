//A character in UTF8 can be from 1 to 4 bytes long, subjected to the following rules:
//
//For 1-byte character, the first bit is a 0, followed by its unicode code.
//For n-bytes character, the first n-bits are all one's, the n+1 bit is 0, followed by n-1 bytes with most significant 2 bits being 10.
//This is how the UTF-8 encoding would work:
//
//   Char. number range  |        UTF-8 octet sequence
//      (hexadecimal)    |              (binary)
//   --------------------+---------------------------------------------
//   0000 0000-0000 007F | 0xxxxxxx
//   0000 0080-0000 07FF | 110xxxxx 10xxxxxx
//   0000 0800-0000 FFFF | 1110xxxx 10xxxxxx 10xxxxxx
//   0001 0000-0010 FFFF | 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
//Given an array of integers representing the data, return whether it is a valid utf-8 encoding.
//
//Note:
//The input is an array of integers. Only the least significant 8 bits of each integer is used to store the data. This means each integer represents only 1 byte of data.
//
//Example 1:
//
//data = [197, 130, 1], which represents the octet sequence: 11000101 10000010 00000001.
//
//Return true.
//It is a valid utf-8 encoding for a 2-bytes character followed by a 1-byte character.
//Example 2:
//
//data = [235, 140, 4], which represented the octet sequence: 11101011 10001100 00000100.
//
//Return false.
//The first 3 bits are all one's and the 4th bit is 0 means it is a 3-bytes character.
//The next byte is a continuation byte which starts with 10 and that's correct.
//But the second continuation byte does not start with 10, so it is invalid.

class Solution {
    public boolean validUtf8(int[] data) {
        int count = 0;

        for(int i : data) {
            // This check is for validating the 1st byte
            if(count == 0) {
                // Getting 1st 3 bits by i >> 5
                // If 1st 3 bits are 0b110 (0b means all 0s), then it should be 2 byte character
                // Remaining number of bytes should be 1. Hence, we'll update the count to 1
                if(i >> 5 == 0b110) {
                    count = 1;
                } else if(i >> 4 == 0b1110) { // Check 1st 4 bits to be 0b1110
                    // Update remaining bytes to validate to 2
                    count = 2;
                } else if(i >> 3 == 0b11110) { // Check 1st 5 bits to be 0b11110
                    // Update the remaining bytes to validate to 3
                    count = 3;
                } else if(i >> 7 == 0b1) { // Checking if 1st bit is 0b10
                    // Validating 1 byte character
                    // For 1 byte character, if 1st bit is 1 then return false as 1st bit should be 0
                    return false;
                }
            } else {
                // Validating other remaining bits after count was set to some value
                // All the remaining bytes should have 1st 2 bits as 0b10
                // If not then we'll return false;
                if(i >> 6 != 0b10) {
                    return false;
                }
                count--;
            }
        }

        // Encoding is correct if count = 0 i.e. we have successfully validated all the bytes
        return count == 0;
    }
}
