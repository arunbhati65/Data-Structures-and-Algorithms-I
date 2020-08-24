package main.java;

public class RSTest {
    //Arr 2
    int sndLargestIn(int[] arr) { //5 1 1 2 3  //o(n)
        int largestN = Integer.MIN_VALUE, sndLargest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] > largestN) {
                sndLargest = largestN;
                largestN = arr[i];
            } else if (sndLargest < arr[i]) {
                sndLargest = arr[i];
            }
        }
        return sndLargest;
    }

    //int h int m - angle
    /*
        12-360
        1- 360/12*9-270
        360 - 60 -15-> 6*15-> 95
     */
    double angleClockHands(int h,int m){
        int hourD=360/12*h;
        int minD=360/60*m;

        double twelthData=hourD-minD;
        double ans=Math.min(twelthData,360-twelthData);
        return  ans;
    }

/*    tree
    ===============
    Class Node {
        public String getId()
// Nullable public Node[] getChildren()
    }*/

    Class NodeRS{
         String id;
         NodeRS  [] children;

    }

    NodeRS findNode(NodeRS root,NodeRS target){
        if(root==null) retrun null;
        if(root.id.equals(target.id)){
            return root;
        }else{
            for(int i=0;i<root.children.length;++i){
                NodeRs ans=findNode(children[i],target);
                if(ans!=null) return ans;
            }
        }
    }

}
