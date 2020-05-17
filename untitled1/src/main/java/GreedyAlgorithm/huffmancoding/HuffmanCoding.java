package main.java.GreedyAlgorithm.huffmancoding;

import java.util.PriorityQueue;

public class HuffmanCoding {


    static PriorityQueue<HuffmanNode> initializeMinHeap(int[] freq, char[] letters) {
        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>();
        for (int i = 0; i < freq.length; ++i) {
            pq.add(new HuffmanNode(freq[i], letters[i]));
        }
        return pq;
    }

    static HuffmanNode prepareHuffManTree(PriorityQueue<HuffmanNode> pq) {
        while (pq.size() > 1) {
            HuffmanNode node = new HuffmanNode();
            HuffmanNode left = pq.poll();
            HuffmanNode right = pq.poll();
            node.setLeft(left);
            node.setRight(right);
            node.setFreq(left.getFreq() + right.getFreq());
            pq.add(node);
        }
        return pq.poll();
    }

    private static void printBinaryRepersentation(HuffmanNode root) {
    }

    public static void main(String args[]) {
        int[] freq = {12, 2, 7, 13, 14, 85};
        char[] letters = {'a', 'b', 'c', 'd', 'e', 'f'};
        PriorityQueue<HuffmanNode> pq = initializeMinHeap(freq, letters);
        HuffmanNode root = prepareHuffManTree(pq);
        printBinaryRepersentation(root);
    }


}
