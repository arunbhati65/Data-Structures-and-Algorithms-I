package main.java.Heap;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class MinHeap {
    int arr[];
    int size;
    int capacity;

    public MinHeap() {

    }

    public MinHeap(int capacity) {
        this.arr = new int[capacity];
        this.size = 0;
        this.capacity = capacity;
    }

    public int getSize() {
        return this.size;
    }

    public Boolean isEmpty() {
        return this.size < 1;
    }

    public int getParent(int i) {
        return (i - 1) / 2;
    }

    public int getLeftChild(int i) {
        return 2 * i + 1;
    }

    public int getRightChild(int i) {
        return 2 * i + 2;
    }


    public void insertMin(int newValue) {  //O(log(size))
        if (this.getSize() + 1 > capacity) {
            System.out.println("Size is full");
            return;
        }
        //bottom to up
        size++;
        arr[size - 1] = newValue;
        int i = size - 1;
        while (i >= 0 && arr[getParent(i)] > arr[i]) {
            int temp = arr[getParent(i)];
            arr[getParent(i)] = arr[i];
            arr[i] = temp;
            i = getParent(i);
        }
    }


    public void printAll() {
        for (int i = 0; i < size; ++i) {
            System.out.print(arr[i] + " ");
        }
    }

    public int getMin() {
        return arr[0];
    }


    public int extractMin() {
        if (size == 0) {
            return Integer.MAX_VALUE;
        }
        if (size == 1) {
            size--;
            return arr[0];
        }
        int temp = arr[0];
        arr[0] = arr[size - 1];
        arr[size - 1] = temp;
        size--;
        minHeapify(0);
        return arr[size];
    }


    public int mindelete(int i) {
        int key;
        if (size < 1) {
            System.out.println("Wrong Position");
            return 0;
        }
        key = arr[i];
        arr[i] = arr[size - 1];
        size--;
        minHeapify(i);
        return key;
    }

    public void buildMinHeap(int[] arr) {
        this.arr = arr;
        this.capacity = arr.length;
        this.size = arr.length;
        for (int i = (size - 2) / 2; i >= 0; i--) {
            minHeapify(i);
        }
    }

    public void minHeapSort(int arr[]) {
        int n = arr.length;
        buildMinHeap(arr);

        for (int k = n - 1; k >= 0; k--) {
            int temp = arr[0];
            arr[0] = arr[k];
            arr[k] = temp;
            minHeapify(0, k);
        }
    }

    public void minHeapify(int i, int modifiedSize) { //O(logN)
        int leftIndex = getLeftChild(i);
        int rightIndex = getRightChild(i);
        int smallest = i;
        if (leftIndex < modifiedSize && arr[leftIndex] < arr[smallest]) {
            smallest = leftIndex;
        }
        if (rightIndex < modifiedSize && arr[rightIndex] < arr[smallest]) {
            smallest = rightIndex;
        }
        if (smallest != i) {
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
            minHeapify(smallest);
        }
    }


    public void minHeapify(int i) { //O(logN)
        int leftIndex = getLeftChild(i);
        int rightIndex = getRightChild(i);
        int smallest = i;
        if (leftIndex < size && arr[leftIndex] < arr[smallest]) {
            smallest = leftIndex;
        }
        if (rightIndex < size && arr[rightIndex] < arr[smallest]) {
            smallest = rightIndex;
        }
        if (smallest != i) {
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
            minHeapify(smallest);
        }
    }
}
