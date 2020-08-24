package main.java.Tree;

class BNode{
    int val;
    BNode left;
    BNode right;
}
public class RightSumTree {
    public static void main(String args[]){
        BNode root=new BNode();
        root.val=2;
        BNode left=new BNode();
        left.val=2;
        BNode right=new BNode();
        right.val=2;
        BNode rightright=new BNode();
        rightright.val=2;
        right.right=rightright;
        root.left=left;
        root.right=right;
        rightSumTree(root);
        System.out.println(root);
    }

    private static int rightSumTree(BNode root) {
        if(root==null) return 0;
        int left=rightSumTree(root.left);
        int right=rightSumTree(root.right);
        root.val=root.val+right;
        return root.val+left;
    }
}
