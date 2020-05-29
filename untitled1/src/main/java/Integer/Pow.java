package main.java.Integer;

public class Pow {
    public static double myPow(double x, int n) {

        double result=1;
        if(n>0){
            for(int i=1;i<=n;++i){
                result=result*x;
            }
        }
        if(n<0){
            n=Math.abs(n);
            for(int i=1;i<=n;++i){
                result=result/x;
            }
        }
        if(n==0){return 1;}

        return result;

    }
    public static void main(String args[]){
        System.out.println(myPow(2.000,-2));
    }
}
