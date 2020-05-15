package main.java.List;// Java program to swap elements of linked list by changing links

class LinkedList {

    static Node head;

    static class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    Node pairWiseSwap(Node node) { // 1 2 3 4 5 6 7
        if (node == null || node.next == null) {
            return node;
        }
        Node prev = node;//1 2 3 4 5 6 7
        Node curr = node.next;//2 3 4 5 6 7
        node = curr; //2 3 4 5 6 7

        while (true) {
            Node next = curr.next;//3 4 5 6 7
            curr.next = prev;//2 1 2 1 2 1 2 1
            if (next == null || next.next == null) {
                prev.next = next;
                break;
            }
            prev.next = next.next;//1 4 5 6 7
            prev = next;//3 4 5 6 7
            curr = prev.next;//4 5 6 7
        }
        return node;
    }

    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(5);
        list.head.next.next.next.next.next = new Node(6);
        list.head.next.next.next.next.next.next = new Node(7);
        System.out.println("Linked list before calling pairwiseSwap() ");
        list.printList(head);
        Node st = list.pairWiseSwap(head);
        System.out.println("");
        System.out.println("Linked list after calling pairwiseSwap() ");
        list.printList(st);
        System.out.println("");
    }
}