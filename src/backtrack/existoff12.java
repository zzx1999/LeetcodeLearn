package backtrack;

import java.util.LinkedList;
import java.util.List;

public class existoff12 {
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j = 0;j<board[i].length;j++){
                if(dfs(board,word.toCharArray(),i,j,0)) return true;
            }
        }
        return false;

    }
    public boolean dfs(char[][] board, char[] word, int i,int j,int k){
        if(i>=board.length||i<0||j>=board[0].length||j<0||k>=word.length||board[i][j]!=word[k]) return false;//越界或者不匹配就返回false
        if(k==word.length-1) return true;//匹配到了最后
        char tmp = board[i][j];
        board[i][j] = '\0';//搜索到的置空
        boolean res = dfs(board,word,i+1,j,k+1)||dfs(board,word,i-1,j,k+1)
                ||dfs(board,word,i,j+1,k+1)||dfs(board,word,i,j-1,k+1);//向四周搜索看看有没有匹配的
        board[i][j] = tmp;//搜索完回溯
        return res;
    }
}
