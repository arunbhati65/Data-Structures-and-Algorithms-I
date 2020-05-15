package main.java.Sorting;

import main.java.Heap.MaxHeap;

public class CheckWhoWinsElection {

    static void checkWhoWinsElection(Integer[] arr) {
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.sort(arr);

        Integer maxCandidate = arr[0], currentCandidate = arr[0];
        Integer maxCandidateCount = 0, currentCandidateCount = 0;

        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] == currentCandidate) {
                currentCandidateCount++;
            } else {
                currentCandidate = arr[i];
                currentCandidateCount = 1;
            }
            if(currentCandidateCount>maxCandidateCount){
                maxCandidateCount=currentCandidateCount;
                maxCandidate=currentCandidate;
            }
        }
        System.out.println("PM of India is :- " + maxCandidate);
    }


    public static void main(String args[]) {
        Integer arr[] = {5, 3, 2, 6, 4, 7,7, 3, 7};
        checkWhoWinsElection(arr);
    }
}
