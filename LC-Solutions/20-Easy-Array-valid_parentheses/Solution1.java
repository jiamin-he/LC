/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 21, 2017
 Problem:    Valid Parentheses
 Difficulty: Easy
 Notes:

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

*/

class Solution {
    public boolean isValid(String s) {
        char[] sc = s.toCharArray();
        if(sc.length%2==1) return false;
        Deque<Character> stack = new ArrayDeque<>();
        for(int i = 0; i< sc.length; i++) {
            if(sc[i] == '(' || sc[i] == '{' || sc[i] == '[')
                stack.push(sc[i]);
            else {
                if(stack.isEmpty()) return false;
                char temp = stack.peek();
                if(temp == '(' && sc[i]!=')') return false;
                if(temp == '[' && sc[i]!=']') return false;
                if(temp == '{' && sc[i]!='}') return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}