package Trackback;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class nQueen {
    List<List<String>> res = new ArrayList<List<String>>();
    int[][] board;
    int row = 0,n = 0;
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        LinkedList<String> permute = new LinkedList<String>();
        board = new int[n][n];
        return res;


    }
    public void backtrack(LinkedList<String> permute){
        if(permute.size()==row){
            res.add(new LinkedList<String>(permute));
            return;
        }
        String tempstr = "";
        for(int i = 0;i<n;i++){
            //做选择,查看这层决策数中各列能不能放,0表示可以放
            if(board[row][i] == 0){
                board[row][i] = 1;
                //攻击范围置1
                if(row==0){
                    board[row+1][i] = 1;
                }
                else if(row==n-1){
                    board[row-1][i] = 1;
                }
                else{
                    board[row+1][i] = 1;
                    board[row-1][i] = 1;
                }
                if(i==0){
                    board[row][i+1] = 1;
                }
                else if(i==n-1){
                    board[row][i-1] = 1;
                }
                else{
                    board[row][i+1] = 1;
                    board[row][i-1] = 1;
                }
                tempstr += "Q";
            }
            else
                tempstr += ".";

        }
        permute.add(tempstr);
        backtrack(permute);
        //撤销选择


    }
//    public boolean isValid(int col){
//        for(int i=0;i<n;i++){
//            if(board[row][i] == 0){
//                return false;
//            }
//        }
//        return true;
//    }
}
