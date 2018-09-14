/*
Author: Jiamin
Date: Sep 8, 2018
Problem:  RLE Iterator
Difficulty: medium

Write an iterator that iterates through a run-length encoded sequence.

The iterator is initialized by RLEIterator(int[] A), where A is a run-length encoding of some sequence.  More specifically, for all even i, A[i] tells us the number of times that the non-negative integer value A[i+1] is repeated in the sequence.

The iterator supports one function: next(int n), which exhausts the next n elements (n >= 1) and returns the last element exhausted in this way.  If there is no element left to exhaust, next returns -1 instead.

For example, we start with A = [3,8,0,9,2,5], which is a run-length encoding of the sequence [8,8,8,5,5].  This is because the sequence can be read as "three eights, zero nines, two fives".

 

Example 1:

Input: ["RLEIterator","next","next","next","next"], [[[3,8,0,9,2,5]],[2],[1],[1],[2]]
Output: [null,8,8,5,-1]
Explanation: 
RLEIterator is initialized with RLEIterator([3,8,0,9,2,5]).
This maps to the sequence [8,8,8,5,5].
RLEIterator.next is then called 4 times:

.next(2) exhausts 2 terms of the sequence, returning 8.  The remaining sequence is now [8, 5, 5].

.next(1) exhausts 1 term of the sequence, returning 8.  The remaining sequence is now [5, 5].

.next(1) exhausts 1 term of the sequence, returning 5.  The remaining sequence is now [5].

.next(2) exhausts 2 terms, returning -1.  This is because the first term exhausted was 5,
but the second term did not exist.  Since the last term exhausted does not exist, we return -1.

Note:

0 <= A.length <= 1000
A.length is an even integer.
0 <= A[i] <= 10^9
There are at most 1000 calls to RLEIterator.next(int n) per test case.
Each call to RLEIterator.next(int n) will have 1 <= n <= 10^9.
 
*/
class Node {
    int val;
    int count;

    public Node(int v,int c) {
        val = v;
        count = c;
    }
}

class RLEIterator {
    
    Deque<Node> q;
    
    public RLEIterator(int[] A) {
        q = new ArrayDeque<>();
        int i = 0;
        while(i+2 <= A.length){
            int cur = A[i+1];
            int num = A[i];
            if(num != 0) {
                Node node = new Node(cur, num);
                q.offer(node);
            }
            i+=2;
        }
    }
    
    public int next(int n) {
        int val = -1;
        while(q.size() > 0 && q.peek().count <= n) {
            n -= q.peek().count;
            Node temp = q.pop();
            val = temp.val;
        }
        if(n > 0 && q.size() > 0 && n < q.peek().count) {
            Node temp = q.peek();
            val = temp.val;
            temp.count -= n;
            n = 0;
        }
        if(n == 0) return val;
        return -1;
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(A);
 * int param_1 = obj.next(n);
 */