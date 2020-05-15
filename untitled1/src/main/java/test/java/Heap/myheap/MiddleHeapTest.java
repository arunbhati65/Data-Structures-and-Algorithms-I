package test.java.Heap.myheap;

import org.junit.Test;

public class MiddleHeapTest {
    @Test
    public void func(){
        main.java.Heap.myheap.MiddleHeap middleHeap=new main.java.Heap.myheap.MiddleHeap(7);
        middleHeap.insertMiddle(1);
        middleHeap.insertMiddle(12);
        middleHeap.insertMiddle(2);
        middleHeap.extractMedian();
        middleHeap.extractMedian();
    }
}