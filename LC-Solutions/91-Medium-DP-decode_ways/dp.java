/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 23, 2017
 Problem:    decode ways
 Difficulty: Medium
 Notes:

A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.

*/

// 2ms 70%
class Solution {
    public int numDecodings(String s) {
        if ((s.length() < 1) || (s.length() == 1 && s.equals("0"))) return 0;
        int[] dp = new int[s.length()+1];
        dp[0] = 1; 
        if (s.charAt(0) == '0') return 0;
        else dp[1] =1;

        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == '0'){
                if((s.charAt(i-1) == '1') || (s.charAt(i-1) == '2')) {
                    dp[i+1] = dp[i-1];
                } else {
                    return 0;
                }
            } else if (s.charAt(i-1) == '0') {
                dp[i+1] = dp[i];
            } else {
                int temp = (s.charAt(i-1) - '0') *10 + (s.charAt(i)-'0');
                dp[i+1] = dp[i] + (temp <= 26? dp[i-1]:0);   
            }
        }
        return dp[s.length()];
    }
}

//1ms 97%
// 想到这个dp 并且把总长度+1 并且前面第一个设成0 这几步都很重要
class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) return 0;
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = s.charAt(0)=='0'? 0: 1;
        for( int i = 2; i < dp.length; i++) {
            int first = s.charAt(i-1)-'0';
            int second = (s.charAt(i-2)-'0')*10+first;
            if (first > 0 && first <= 9) dp[i] += dp[i-1];
            if (second >= 10 && second <= 26) dp[i]+= dp[i-2];
        }
        return dp[dp.length - 1];
    }
}