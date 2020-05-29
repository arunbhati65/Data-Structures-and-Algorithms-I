package main.java.Heap;

public class MinHeap {
    public static Integer arr[];
    public static int size;
    public static int capacity;

    public static Integer[] getArr() {
        return arr;
    }

    public static void setArr(Integer[] arr) {
        MinHeap.arr = arr;
    }

    public static void setSize(int size) {
        MinHeap.size = size;
    }

    public static int getCapacity() {
        return capacity;
    }

    public static void setCapacity(int capacity) {
        MinHeap.capacity = capacity;
    }

    public MinHeap() {

    }

    public MinHeap(int capacity) {
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


    public void insertMin(int newValue) {  //O(log(size))
        if (this.getSize() + 1 > capacity) {
            System.out.println("Size is full");
            return;
        }
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

    public static void printAll(Integer[] arrr) {
        for (int i = 0; i < arrr.length; ++i) {
            System.out.print(arrr[i] + " ");
        }
    }


    public int getMin() {
        return arr[0];
    }


    public int extractMin() {
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
        MinHeapify(arr,size,0);
        return arr[size];
    }


    public int Mindelete(int i) {
        int key;
        if (size < 1) {
            System.out.println("Wrong Position");
            return 0;
        }
        key = arr[i];
        arr[i] = arr[size - 1];
        size--;
        MinHeapify(arr,size,i);
        return key;
    }


    public static void buildMinHeap(Integer[] arrr) {
        arr = arrr;
        capacity = arr.length;
        size = arr.length;
        for (int i = (size - 2) / 2; i >= 0; i--) {
            MinHeapify(arr,size,i);
        }
    }



    public static void MinHeapify(Integer[] arrr, int modifiedSize, int i) { //O(logN)
        int leftIndex = 2*i + 1;
        int rightIndex = 2*i + 2;
        int smallest = i;
        if (leftIndex < modifiedSize && arrr[leftIndex] < arrr[smallest]) {
            smallest = leftIndex;
        }
        if (rightIndex < modifiedSize && arrr[rightIndex] < arrr[smallest]) {
            smallest = rightIndex;
        }
        if (smallest != i) {
            int temp = arrr[i];
            arrr[i] = arrr[smallest];
            arrr[smallest] = temp;
            MinHeapify(arrr,modifiedSize,smallest);
        }
    }

    public static void sort(Integer arr[]) {
        int n = arr.length;
        buildMinHeap(arr);

        for (int i = n - 1; i >=1; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            //we are putting the smallest one in the last position and keep decreasing the size
            MinHeapify(arr, i, 0);
        }
    }

}
