package main.java.Heap;

class Node implements Comparable<Node> {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }
    Node(){}

    @Override
    public int compareTo(Node o) {
        return this.data-o.data;
    }
}
