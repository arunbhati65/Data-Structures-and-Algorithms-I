package main.java.Tree;

import java.util.HashMap;
import java.util.TreeSet;

public class buildTree {
    static int preIndex=0;
    public BTNode buldTreeWrap(char[] in, char[] pre, int len) {
        HashMap<Character,Integer> map= new HashMap<>();
        for(int i=0;i<in.length;++i){
            map.put(in[i],i);
        }

        return buildTre(in,pre,0,len-1,map);
    }

    private BTNode buildTre(char[] in, char[] pre, int inStart, int inEnd, HashMap<Character, Integer> map) {
        if (inStart > inEnd)
            return null;

    /* Pick current node from Preorder traversal using preIndex
    and increment preIndex */
        char curr = pre[preIndex++];
        BTNode tNode = newNode(curr);

        /* If this node has no children then return */
        if (inStart == inEnd)
            return tNode;

        /* Else find the index of this node in Inorder traversal */
        int inIndex = map.get(curr);

    /* Using index in Inorder traversal, construct left and
    right subtress */
        tNode.left = buildTre(in, pre, inStart, inIndex - 1, map);
        tNode.right = buildTre(in, pre, inIndex + 1, inEnd, map);
        TreeSet treeSet=new TreeSet();
    //    treeSet.a
        return tNode;


    }

    private BTNode newNode(char data) {
        BTNode node = new BTNode();
        node.data = data;
        node.left = node.right = null;
        return (node);
    }

    public void printInorder(BTNode root) {
        if (root!=null){
            printInorder(root.left);
            System.out.println(root.data);
            printInorder(root.right);
        }
    }
}
