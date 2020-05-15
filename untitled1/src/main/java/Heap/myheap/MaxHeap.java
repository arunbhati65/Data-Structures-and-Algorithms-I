package main.java.Heap.myheap;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MaxHeap {
    Integer arr[];
    int size;
    int capacity;

    public MaxHeap(int capacity) {
        this.arr = new Integer[capacity];
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


    public void insertMax(int newValue) {  //O(log(size))
        if (this.getSize() + 1 > capacity) {
            System.out.println("Size is full");
            return;
        }
        size++;
        arr[size - 1] = newValue;
        int i = size - 1;
        while (i >= 0 && arr[getParent(i)] < arr[i]) {
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


    public int getMax() {
        return arr[0];
    }


    public int extractMax() {
        if (size == 0) {
            return Integer.MIN_VALUE;
        }
        if (size == 1) {
            size--;
            return arr[0];
        }
        int temp = arr[0];
        arr[0] = arr[size - 1];
        arr[size - 1] = temp;
        size--;
        maxHeapify(arr,size,0);
        return arr[size];
    }


    public int maxdelete(int i) {
        int key;
        if (size < 1) {
            System.out.println("Wrong Position");
            return 0;
        }
        key = arr[i];
        arr[i] = arr[size - 1];
        size--;
        maxHeapify(arr,size,i);
        return key;
    }


    public void buildMaxHeap(Integer[] arr) {
        this.arr = arr;
        this.capacity = arr.length;
        this.size = arr.length;
        for (int i = (size - 2) / 2; i >= 0; i--) {
            maxHeapify(arr,size,i);
        }
    }



    public void maxHeapify(Integer[] arrr, int modifiedSize, int i) { //O(logN)
        int leftIndex = 2*i + 1;
        int rightIndex = 2*i + 2;
        int largest = i;
        if (leftIndex < modifiedSize && arrr[leftIndex] > arrr[largest]) {
            largest = leftIndex;
        }
        if (rightIndex < modifiedSize && arrr[rightIndex] > arrr[largest]) {
            largest = rightIndex;
        }
        if (largest != i) {
            int temp = arrr[i];
            arrr[i] = arrr[largest];
            arrr[largest] = temp;
            maxHeapify(arrr,modifiedSize,largest);
        }
    }

    public void sort(Integer arr[]) {
        int n = arr.length;
        buildMaxHeap(arr);

        for (int i = n - 1; i >=1; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            //we are putting the largest one in the last position and keep decreasing the size
            maxHeapify(arr, i, 0);
        }
    }


}
