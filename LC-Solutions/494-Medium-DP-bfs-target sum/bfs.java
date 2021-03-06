/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Nov 14, 2017
 Problem:    Target Sum
 Difficulty: medium
 Notes:
You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.

Find out how many ways to assign symbols to make sum of integers equal to target S.

Example 1:
Input: nums is [1, 1, 1, 1, 1], S is 3. 
Output: 5
Explanation: 

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

There are 5 ways to assign symbols to make the sum of nums be target 3.
Note:
The length of the given array is positive and will not exceed 20.
The sum of elements in the given array will not exceed 1000.
Your output answer is guaranteed to be fitted in a 32-bit integer.
*/

// 654 ms
class Solution {
    int count = 0;
    public int findTargetSumWays(int[] nums, int S) {
        plusOrMinus(nums, S, 0, 0);
        return count;
    }
    
    public void plusOrMinus (int[] nums, int S, int sum, int index){
        if(index == nums.length ) {
            if(sum == S) count ++;
            return;
        }
        plusOrMinus(nums, S, sum+nums[index], index+1);
        plusOrMinus(nums, S, sum-nums[index], index+1);
    }
}

// 872ms 1%
// Time complexity : O(2^n)
//
// Space complexity : O(n). The depth of the recursion tree can go upto n.
class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int[] res = new int[1];
        helper(nums, S, res, 0);
        return res[0];
    }
    public void helper(int[] nums, int target, int[] res, int index) {
        if(index == nums.length){
            if(target == 0) {
                res[0]++;      
            }
        } else if(index < nums.length){
            helper(nums, target+nums[index], res, index+1);
            helper(nums, target-nums[index], res, index+1);
        }
    }
}
