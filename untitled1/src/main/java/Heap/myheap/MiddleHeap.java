package main.java.Heap.myheap;

public class MiddleHeap {
    MinHeap minHeap;
    MaxHeap maxHeap;

    public MiddleHeap(int capacity) {
        if ((double) (capacity % 2) > 0.0) {
            this.minHeap = new MinHeap(capacity / 2);
            this.maxHeap = new MaxHeap(capacity / 2 + 1);
        } else {
            this.minHeap = new MinHeap(capacity / 2);
            this.maxHeap = new MaxHeap(capacity / 2);
        }
    }

    public void printAll(){
        maxHeap.printAll();
        minHeap.printAll();

    }

    public void insertMiddle(int newValue) {
        if (maxHeap.arr[0] == null) {
            maxHeap.insertMax(newValue);
        } else if (maxHeap.size > minHeap.size) {
            if (newValue < maxHeap.getMax()) {
                minHeap.insertMin(maxHeap.extractMax());
                maxHeap.insertMax(newValue);
            } else {
                minHeap.insertMin(newValue);
            }
        } else if (maxHeap.size == minHeap.size) {
            if (newValue > minHeap.getMin()) {
                maxHeap.insertMax(minHeap.extractMin());
                minHeap.insertMin(newValue);
            } else {
                maxHeap.insertMax(newValue);
            }
        }
    }

    public void getMedian() {
        if ((double) ((maxHeap.size + minHeap.size) % 2) > 0.0) {
            System.out.println( maxHeap.getMax());
        } else {
            System.out.println( maxHeap.getMax() +"&" +minHeap.getMin());
        }
    }

    public void extractMedian() {
        if ((double) ((maxHeap.size + minHeap.size) % 2) > 0.0) {
            System.out.println(maxHeap.extractMax());
        } else {
            System.out.println(maxHeap.extractMax() +" & "+ minHeap.extractMin());
        }
    }

    public void medianDelete(int i) {
        if ((double) ((maxHeap.size + minHeap.size) % 2) > 0.0) {
            System.out.println(maxHeap.maxdelete(0));
        } else {
            System.out.println(maxHeap.maxdelete(0) +" & "+ minHeap.mindelete(0));
        }
    }

}
