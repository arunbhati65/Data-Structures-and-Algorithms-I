package main.java.ListImpl;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class IntersectionOfTwoLinkedList {
    public static void main(String args[]) {
        ListNode a = new ListNode(4);
        a.next = new ListNode(1);
        a.next.next = new ListNode(8);
        a.next.next.next = new ListNode(4);
        a.next.next.next.next = new ListNode(5);

        ListNode b = new ListNode(5);
        b.next = new ListNode(0);
        b.next.next = new ListNode(1);
        b.next.next.next = new ListNode(8);
        b.next.next.next.next = new ListNode(4);
        b.next.next.next.next.next = new ListNode(5);

        getIntersectionNode(a,b);
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = 0, lengthB = 0;
        ListNode currentA = headA, currentB = headB;
        while (currentA != null || currentB != null) {
            if (currentA != null) {
                ++lengthA;
                currentA = currentA.next;
            }
            if (currentB != null) {
                ++lengthB;
                currentB = currentB.next;
            }
        }

        currentA = headA;
        currentB = headB;
        int diff = Math.abs(lengthA - lengthB);
        while (diff != 0) {
            if (lengthA > lengthB) {
                currentA = currentA.next;
            } else {
                currentB = currentB.next;
            }
            --diff;
        }
        while (currentA != null || currentB != null) {
            if (currentA.val == currentB.val) return currentA;
            currentA = currentA.next;
            currentB = currentB.next;
        }
        return null;
    }
}
