package main.java.Heap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class HeapTest {
    @Test
    public void testHeap() {
        MinHeap heap = new MinHeap();
        heap.buildMinHeap(new int[]{1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17});
        heap.printAll();
        System.out.println("");
    }

    @Test
    public void testHeapFunc() {
        MinHeap heap = new MinHeap();
        heap.buildMinHeap(new int[]{1, 2, 5, 4, 6, 13, 10, 9, 8, 15, 17});

        System.out.println(heap.extractMin());
        heap.printAll();
        System.out.println("\n"+heap.getMin());


    }
}
