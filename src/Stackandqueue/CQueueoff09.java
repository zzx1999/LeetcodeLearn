package Stackandqueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
//使用两个栈实现队列——先进先出
public class CQueueoff09 {
    Stack<Integer> st1;
    Stack<Integer> st2;
    public CQueueoff09(){
        st1 = new Stack<>();
        st2 = new Stack<>();
    }
    public void appendTail(int value) {
        st1.push(value);

    }

    public int deleteHead() {
        if(st2.isEmpty()){
            while (!st1.isEmpty()){
                st2.push(st1.pop());
            }
        }
        if(st2.isEmpty())
            return -1;
        return st2.pop();
    }
}
