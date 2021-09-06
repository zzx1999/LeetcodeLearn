package Stackandqueue;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class MinStackoff30 {
    //定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的
    // min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是
    // O(1)。
    Stack<Integer> st;
    Stack<Integer> stprix;
    /** initialize your data structure here. */
    public MinStackoff30() {
        st = new Stack<>();
        stprix = new Stack<>();
    }

    public void push(int x) {
        st.push(x);
        if(stprix.isEmpty()||x<=stprix.peek()){
            stprix.push(x);
        }
    }

    public void pop() {
        if(st.pop().equals(stprix.peek()))
            stprix.pop();
    }

    public int top() {
        return st.peek();
    }

    public int min() {
        //使用辅助栈B B中元素保持严格降序
        return stprix.peek();
        //不和题意，没有控制到O（1）
//        List<Integer> list = new LinkedList<>();
//        while (!st.isEmpty()){
//            int t = st.pop();
//            list.add(t);
//        }
//        if(list.size()==0)
//            return
//        int res = Collections.min(list);
//        int n = list.size();
//        for(int i = n-1;i>=0;i--){
//            st.push(list.get(i));
//        }
//        return res;

    }
}
