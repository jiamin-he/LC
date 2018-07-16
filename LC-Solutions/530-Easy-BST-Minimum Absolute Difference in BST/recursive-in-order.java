/*
Author: Jiamin
Date: Dec 20, 2017
Problem: Minimum Absolute Difference in BST
Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.

Example:

Input:

   1
    \
     3
    /
   2

Output:
1

Explanation:
The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
Note: There are at least two nodes in this BST.


*/

// inorder traversal, it is a sorted list.
// time comp O(N), space comp O(1)
// 15ms 61%
class Solution {
    int min = Integer.MAX_VALUE;
    TreeNode prev = null;
    public int getMinimumDifference(TreeNode root) {
        if(root == null) return min;
        getMinimumDifference(root.left);
        if(prev != null)
            min = Math.min(min, root.val - prev.val);
        prev = root;
        getMinimumDifference(root.right);
        return min;
    }
}