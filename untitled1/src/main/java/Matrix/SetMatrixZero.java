package main.java.Matrix;

public class SetMatrixZero {

    public static void main(String args[]){
        Solution1 solution=new Solution1();
        int[][] matrix={{1,1,1},
                        {1,0,1},
                        {1,1,1}};
        solution.setZeroes(matrix);
        System.out.println("3");
    }
}
class Solution1 {
    Boolean visited[][];
    public void setZeroes(int[][] matrix) {
        visited=new Boolean[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;++i){
            for(int j=0;j<matrix[0].length;++j){
                if(visited[i][j]==null && matrix[i][j]==0){
                    Line(matrix,i,j);
                }
            }
        }

        for(int i=0;i<matrix.length;++i){
            for(int j=0;j<matrix[0].length;++j){
                if(matrix[i][j]==-1){
                    matrix[i][j]=0;
                }
            }
        }

    }

    void Line(int[][] matrix,int i,int j){
        visited[i][j]=true;
        for(int m=0;m<matrix.length;++m){
            if(m!=i && visited[m][j]==null && matrix[m][j]!=0){
                visited[m][j]=true;
                matrix[m][j]=-1;
            }
        }
        for(int m=0;m<matrix[0].length;++m){
            if(m!=j && visited[i][m]==null && matrix[i][m]!=0){
                visited[i][m]=true;
                matrix[i][m]=-1;
            }
        }
    }
}