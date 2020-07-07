package main.java;

public class Service {
    Boolean reverseString(String str){
        char[] chars=str.toCharArray();
        if(str.length()==0) return false;
        int l=0,h=str.length()-1;
        while(l<h){
            char temp=chars[l];
            chars[l]=chars[h];
            chars[h]=temp;
            --h;
            ++l;
        }
        str=String.copyValueOf(chars);
        return true;
    }
     //SessionInfo
    User logged
             user.emailUd

    @GetMapping(value='api/getReverseString/{str}')
    @preAuthorize(managementCmpayId,PropertyCode);
    public String reverseAPI(@requestParam String str) throws Exception {
        if(reverseString(str)){
            return str;
        }
        throw new Exception("string  can't be reversed");
    }

}
// l     h
// A B C D
//  l h
//D B C A
//    h   l
//D C B A




