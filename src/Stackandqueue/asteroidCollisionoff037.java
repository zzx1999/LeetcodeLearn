package Stackandqueue;

import java.util.Stack;

public class asteroidCollisionoff037 {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s = new Stack<>();
        int p = 0;
        while (p < asteroids.length) {
            if (s.empty() || s.peek() < 0 || asteroids[p] > 0) {//直接入栈的情况：栈空，栈顶为负数，入栈为正数
                s.push(asteroids[p]);
            } else if (s.peek() <= -asteroids[p]) {//栈顶被炸了
                if (s.pop() < -asteroids[p]) {
                    continue;
                }
            }
            p++;//栈顶和当前都被炸了
        }
//        boolean isi = false;
//        for(int i:asteroids){
//            if(i<0) {
//                if (!asterst.isEmpty()&&asterst.peek()>0) {
//                    while (asterst.peek() > 0) {
//                        int tmp = asterst.pop();
//                        if (tmp == Math.abs(i)) {
//                            break;
//                        } else if (tmp > -i) {//i爆炸
//                            asterst.add(tmp);
//                            isi = true;
//                            break;
//                        } else {//tmp爆炸
//                            continue;
//                        }
//                    }
//                    if(isi){
//                        isi = false;
//                        continue;
//                    }
//                }
//                else
//                    asterst.add(i);
//            }
//            else
//                asterst.add(i);
//            if(!asterst.isEmpty()){
//                if(asterst.peek()>0&&i<0){
//                    int tmp = asterst.pop();
//                    if(tmp==Math.abs(i))
//                        continue;
//                    asterst.add(tmp>Math.abs(i)?tmp:i);
//                }
//                else
//                    asterst.add(i);
//            }
//            else
//                asterst.add(i);
        int[] res = new int[s.size()];
        for(int i=s.size()-1;i>=0;i--){
            res[i] = s.pop();
        }
        return res;

    }

    public static void main(String[] args) {
        int[] a = {10,2,-5};
        asteroidCollisionoff037 ac = new asteroidCollisionoff037();
        ac.asteroidCollision(a);
    }
}
