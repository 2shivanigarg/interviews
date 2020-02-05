// Given a time represented in the format "HH:MM", form the next closest time by reusing the current digits. 
// There is no limit on how many times a digit can be reused.

// You may assume the given input string is always valid. For example, "01:34", "12:09" are all valid. "1:34", "12:9" are all invalid.

// Example 1:

// Input: "19:34"
// Output: "19:39"
// Explanation: The next closest time choosing from digits 1, 9, 3, 4, is 19:39, which occurs 5 minutes later. 
// is not 19:33, because this occurs 23 hours and 59 minutes later.

class Solution {
    public String nextClosestTime(String time) {
        int minutes = Integer.parseInt(time.substring(0, 2)) * 60;
        minutes += Integer.parseInt(time.substring(3));
        
        HashSet<Integer> digits = new HashSet<>();
        for(char c: time.toCharArray()) {
            digits.add(c - '0');
        }
        
        while(1) {
            // Simulating next time by adding 1 minute to the minutes
            // % by (24 * 60) so as to wrap time at midnight i.e. if it is 11:59 then it should become 00:00
            minutes = (minutes + 1) % (24 * 60);
            int[] nextTime = { minutes / 60 / 10, minutes / 60 % 10, minutes % 60 / 10, minutes % 60 % 10};
            
            boolean isValid = true;
            for(int digit: nextTime) {
                if(!digits.contains(digit)) {
                    isValid = false;
                }
            }
            
            if(isValid) {
                String hour = minutes / 60;
                String minute = minutes % 60;
                String time = String.format("%02d:%02d", hour, minute);
                return time;
            }
        }
    }
}
