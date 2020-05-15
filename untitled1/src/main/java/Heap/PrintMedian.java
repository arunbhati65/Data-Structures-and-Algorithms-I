package main.java.Heap;

public class PrintMedian {
    static void printMedian(int[] arr) {
        MinHeap minHeap = new MinHeap(arr.length);
        MaxHeap maxHeap = new MaxHeap(arr.length);

        maxHeap.insertMax(arr[0]);
        System.out.println(arr[0]);
        for (int i = 1; i < arr.length; ++i) {
            if (maxHeap.size > minHeap.size ) {
                if (arr[i] < maxHeap.getMax()) {
                    minHeap.insertMin(maxHeap.extractMax());
                    maxHeap.insertMax(arr[i]);
                } else {
                    minHeap.insertMin(arr[i]);
                }
                System.out.println((double) (maxHeap.getMax() + minHeap.getMin()) / 2);

            } else {
                if (arr[i] > minHeap.getMin()) {
                    maxHeap.insertMax(minHeap.extractMin());
                    minHeap.insertMin(arr[i]);
                } else {
                    maxHeap.insertMax(arr[i]);
                }
                System.out.println(maxHeap.getMax());

            }
        }
    }

    public static void main(String args[]) {
        printMedian(new int[]{5, 15, 10, 20, 3});
    }
}
