package Trackback;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class nQueen {
    List<List<String>> res = new ArrayList<List<String>>();
    int n = 0;
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        LinkedList<String> permute = new LinkedList<String>();
        StringBuffer line = new StringBuffer();
        //棋盘初始化
        for (int i = 0;i<n;i++){
            line.append('.');
        }
        for (int i = 0;i<n;i++){
            permute.add(line.toString());
        }
        backtrack(permute,0);
        return res;


    }
    public void backtrack(LinkedList<String> permute,int row) {
        if (row == n) {
            res.add(new LinkedList<String>(permute));
            return;
        }
        for (int col = 0; col < n; col++) {
            //做选择,查看这层决策树中各个位置可不可以放
            if(!isValid(permute,row,col))
                continue;
            StringBuffer temp = new StringBuffer(permute.get(row));
            temp.setCharAt(col,'Q');
            permute.set(row,temp.toString());
            backtrack(permute,row+1);
            //撤销选择
            temp.setCharAt(col,'.');
            permute.set(row,temp.toString());




        }
    }
    public boolean isValid(LinkedList<String> permute, int row, int col){
        //检查列是否冲突
        for(int i = 0;i < n;i++){
            String rowstr = permute.get(i);
            if(rowstr.charAt(col) ==  'Q')
                return false;

        }
        //检查左上是否冲突
        for(int i=row-1,j = col-1;i>=0&&j>=0;i--,j--){
            String rowleftstr = permute.get(i);
            if(rowleftstr.charAt(j)=='Q')
                return false;

        }
        //检查右上
        for(int i=row-1,j = col+1;i>=0&&j<n;i--,j++){
            String rowrightstr = permute.get(i);
            if(rowrightstr.charAt(j)=='Q')
                return false;

        }
        return true;
    }

    public static void main(String[] args) {
        int n = 4;
        nQueen nq = new nQueen();
        nq.solveNQueens(n);
    }
}
