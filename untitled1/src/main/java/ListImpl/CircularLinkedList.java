package main.java.ListImpl;

public class CircularLinkedList {
    protected CLLNode tail;
    protected int length;

    //head=tail.next
    public CircularLinkedList() {
        this.tail = null;
        this.length = 0;
    }

    //Add data to beginning of the Head of the list
    public void add(String data) {
        this.addDataToHead(data);
    }

    public CLLNode getHead(CLLNode tail) {
        return tail.getNext();
    }

    public void setHead(CLLNode node) {
        tail.setNext(node);
    }

    public void addDataToHead(String data) {
        CLLNode temp = new CLLNode();
        temp.setData(data);
        if (tail == null) {//first data added
            tail = temp;
            this.setHead(tail);
        } else {//element exists in list
            temp.setNext(tail);
            tail.setNext(temp);//? i think this is wrong
        }
        length++;
    }

    public void addDataToTail(String data) {
        CLLNode temp = new CLLNode();
        temp.setData(data);
        if (tail == null) {//first data added
            tail = temp;
            this.setHead(tail);
        } else {//element exists in list
            temp.setNext(tail);
            tail.setNext(temp);//? i think this is wrong
        }
        length++;
    }

    public CLLNode generateCLL() {
        CLLNode tail = new CLLNode();
        tail.setData("0");
        int length = 0;
        CLLNode currentNode = tail;
        while (length <= 2) {
            CLLNode newNode = new CLLNode();
            newNode.setData((length + 1) + "");
            if (length == 2) {
                currentNode.setNext(tail);
            } else {
                currentNode.setNext(newNode);
            }
            currentNode = currentNode.getNext();
            ++length;
        }
        return tail;
    }

    public int getLengthOfCircularList(CLLNode tail) {
        int length = 0;
        CLLNode currentNode = tail.getNext();
        while (currentNode != tail) {
            ++length;
        }
        return length;
    }

}
