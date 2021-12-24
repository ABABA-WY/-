package 数据结构;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class LC232 {

}
class MyQueue {
    private Deque<Integer> s1;
    private Deque<Integer> s2;
    /** Initialize your data structure here. */
    public MyQueue() {
        s1 = new LinkedList<Integer>();
        s2 = new LinkedList<Integer>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        s1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(s2.isEmpty())
            out();
        return s2.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(s2.isEmpty())
            out();
        return s2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s2.isEmpty();
    }
    public void out(){
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
    }
}
