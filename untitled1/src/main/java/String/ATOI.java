
package main.java.String;

public class ATOI {
    public static int myAtoi(String str) {
        str.replaceAll("\\s+","");
        str.replaceAll("\\D+", "");
        return Integer.parseInt(str.trim());

    }
        public static boolean isPalindrome(int x) {
            Integer i=x;
            String str=i.toString();
            int l=0,h=str.length()-1;
            if(h==1){
                return str.substring(0,1).equals(str.substring(1,2));
            }else if(str.length()%2==0){
                return str.substring(l,h/2+1).equals(str.substring(h/2+1,h+1));
            }else{
                return str.substring(l,h/2).equals(str.substring(h/2+1,h+1));
            }
        }
    public static void main(String args[]){
        System.out.println(isPalindrome(1001));
    }

}
