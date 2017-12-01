/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Nov 30, 2017
 Problem:    climbing stairs
 Difficulty: Easy
 Notes:
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.


Example 1:

Input: 2
Output:  2
Explanation:  There are two ways to climb to the top.

1. 1 step + 1 step
2. 2 steps
Example 2:

Input: 3
Output:  3
Explanation:  There are three ways to climb to the top.

1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step

*/


// fibonacci 

// 5 ms 1%
class Solution {
    public int climbStairs(int n) {
        if(n == 0) return 1;
        int[] ways = new int[n+1];
        ways[0] = 1;
        ways[1] = 1;
        for(int i = 2; i <= n; i++){
            ways[i] = ways[i-1] + ways[i-2];
        }
        return ways[n];
    }
}


// 4ms save space 6%
class Solution {
    public int climbStairs(int n) {
        if(n == 0) return 1;
        int prev = 1;
        int pprev = 1;
        for(int i = 2; i <= n; i++){
            int temp = prev;
            prev += pprev;
            pprev = temp;
        }
        return prev;
    }
}
