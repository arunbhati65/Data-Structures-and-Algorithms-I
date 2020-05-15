package main.java.ListImpl;

// Java program to partition a
// linked list around a given value.
class GfG {

    /* Link list Node */
    static class Node {
        int data;
        Node next;
    }

    // A utility function to create a new node
    static Node newNode(int data) {
        Node new_node = new Node();
        new_node.data = data;
        new_node.next = null;
        return new_node;
    }

    // Function to make two separate lists and return
// head after concatinating
    static Node partition(Node head, int x) {

	/* Let us initialize first and last nodes of
	three linked lists
		1) Linked list of values smaller than x.
		2) Linked list of values equal to x.
		3) Linked list of values greater than x.*/
        Node smallerHead = null, smallerLast = null;
        Node greaterLast = null, greaterHead = null;
        Node equalHead = null, equalLast = null;

        // Now iterate original list and connect nodes
        // of appropriate linked lists.
        while (head != null) {
            // If current node is equal to x, append it
            // to the list of x values
            if (head.data == x) {
                if (equalHead == null)
                    equalHead = equalLast = head;
                else {
                    equalLast.next = head;
                    equalLast = equalLast.next;
                }
            }

            // If current node is less than X, append
            // it to the list of smaller values
            else if (head.data < x) {
                if (smallerHead == null)
                    smallerLast = smallerHead = head;
                else {
                    smallerLast.next = head;
                    smallerLast = head;
                }
            } else // Append to the list of greater values
            {
                if (greaterHead == null)
                    greaterLast = greaterHead = head;
                else {
                    greaterLast.next = head;
                    greaterLast = head;
                }
            }
            head = head.next;
        }

        // Fix end of greater linked list to NULL if this
        // list has some nodes
        if (greaterLast != null)
            greaterLast.next = null;

        // Connect three lists

        // If smaller list is empty
        if (smallerHead == null) {
            if (equalHead == null)
                return greaterHead;
            equalLast.next = greaterHead;
            return equalHead;
        }

        // If smaller list is not empty
        // and equal list is empty
        if (equalHead == null) {
            smallerLast.next = greaterHead;
            return smallerHead;
        }

        // If both smaller and equal list
        // are non-empty
        smallerLast.next = equalHead;
        equalLast.next = greaterHead;
        return smallerHead;
    }

    /* Function to print linked list */
    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    // Driver code
    public static void main(String[] args) {
        /* Start with the empty list */
        Node head = newNode(10);
        head.next = newNode(4);
        head.next.next = newNode(1);
        head.next.next.next = newNode(30);
        head.next.next.next.next = newNode(51);
        head.next.next.next.next.next = newNode(50);

        int x = 50;
        head = partition(head, x);
        printList(head);
    }
}

// This code is contributed by Prerna saini.
