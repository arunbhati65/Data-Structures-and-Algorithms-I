package main.java.Graph;

public class WordBooggle {
    public static void main(String args[]){
        SolutionBoogle s=new SolutionBoogle();
        char[][] board={{'a','b'},{'c','d'}};
        System.out.println(s.exist(board,"acdb"));
    }
}

class SolutionBoogle {
    Boolean visited[][];
    public boolean exist(char[][] board, String word) {
        visited=new Boolean[board.length][board[0].length];
        for(int i=0;i<board.length;++i){
            for(int j=0;j<board[0].length;++j){
                if(word.charAt(0)!=board[i][j]) continue;
                visited[i][j]=true;
                if(helper(board,word,i,j,""))  return true;
                visited[i][j]=null;
            }
        }
        return false;
    }

    Boolean helper(char[][] board, String word,int i,int j,String s){
        if(!word.contains(s+board[i][j])) return false;
        if(word.equals(s+board[i][j])) return true;
        int []x={0,0,-1,1};
        int []y={1,-1,0,0};
        for(int m=0;m<x.length;++m){
            if(!(i+x[m]<0 || j+y[m]<0 || i+x[m]>=board.length || j+y[m]>=board[0].length || visited[i+x[m]][j+y[m]]!=null)){
                visited[i+x[m]][j+y[m]]=true;
                if(helper(board,word,i+x[m],j+y[m],s+board[i][j])) return true;
                visited[i+x[m]][j+y[m]]=null;
            }
        }
        return false;
    }
}