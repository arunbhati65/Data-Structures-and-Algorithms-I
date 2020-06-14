package main.java.Tree;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public static List<Integer> getAllElements(BTNode root1, BTNode root2) {
        root1=flatten(root1);
        root2=flatten(root2);
        List<Integer> list=new LinkedList<>();
        while(root1!=null && root2!=null){
            if(root1.data>=root2.data){
                list.add(root2.data);
                root2=root2.right;
            }else{
                list.add(root1.data);
                root1=root1.right;
            }
        }
        while(root1!=null){
            list.add(root1.data);
            root1=root1.right;
        }
        while(root2!=null){
            list.add(root2.data);
            root2=root2.right;
        }
        return list;
    }

    static BTNode tail=null,curr;
    static BTNode flatten(BTNode root) {
        if(root==null) return null;
        tail=new BTNode(-1);
        curr=tail;
        inOrder(root);
        return tail.right;
    }

    static void inOrder(BTNode root){
        if(root==null) return ;
        inOrder( root.left);
        curr.left=null;
        curr.right=root;
        curr=root;
        inOrder( root.right);
    }


    public static void main(String args[]){
        //[2,1,4]
        //[1,0,3]
        BTNode root1=new BTNode(2); root1.left=new BTNode(1);  root1.right=new BTNode(4);
        BTNode root2=new BTNode(1); root2.left=new BTNode(0);  root2.right=new BTNode(3);
        getAllElements(root1,root2);
    }
}