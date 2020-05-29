package main.java.Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

class The_Comparator implements Comparator<Node> {
    public int compare(Node l1, Node l2)
    {
        return l1.data-l2.data;
    }
}
public class MergeKLists {
    public static Node mergeKSortedLists(Node arr[], int k) {
        Node head = null, last = null;

        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int i = 0; i < k; i++)
            if (arr[i] != null)
                pq.add(arr[i]);

        while (!pq.isEmpty()) {
            Node top = pq.peek();
            pq.remove();

            if (top.next != null)
                pq.add(top.next);

            if (head == null) {
                head = top;
            } else {
                last.next = top;
            }
            last = top;
        }
        return head;
    }



    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static Node mergeKLists(Node[] lists) {
            Node result=new Node();
            Node current=result,top=null;
            PriorityQueue<Node> pq=new PriorityQueue<>(lists.length,new The_Comparator());
            for(int i=0;i<lists.length;++i){
                pq.add(lists[i]);
            }
            while(!pq.isEmpty() ){
                top=pq.poll();//main point

                if(null!=top.next){
                    pq.add(top.next);
                }
                current.next=top;
                current= current.next;
            }

            return result.next;
        }


    public static void main(String args[]) {
        int k = 3;

        Node arr[] = new Node[k];

        arr[0] = new Node(1);
        arr[0].next = new Node(3);
        arr[0].next.next = new Node(5);
        arr[0].next.next.next = new Node(7);

        arr[1] = new Node(2);
        arr[1].next = new Node(4);
        arr[1].next.next = new Node(6);
        arr[1].next.next.next = new Node(8);

        arr[2] = new Node(0);
        arr[2].next = new Node(9);
        arr[2].next.next = new Node(10);
        arr[2].next.next.next = new Node(11);

      //  Node head = mergeKSortedLists(arr, k);
        Node head=mergeKLists(arr);
        printList(head);
    }
}

