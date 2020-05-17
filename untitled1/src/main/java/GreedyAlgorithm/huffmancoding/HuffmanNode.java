package main.java.GreedyAlgorithm.huffmancoding;

public class HuffmanNode implements Comparable<HuffmanNode>{
    int freq;
    char letter;

    HuffmanNode left;
    HuffmanNode right;

    public HuffmanNode(int freq, char letter, HuffmanNode left, HuffmanNode right) {
        this.freq = freq;
        this.letter = letter;
        this.left = left;
        this.right = right;
    }

    public HuffmanNode() {
    }

    public HuffmanNode(int freq, char letter) {
        this.freq = freq;
        this.letter = letter;
    }

    public int getFreq() {
        return freq;
    }

    public void setFreq(int freq) {
        this.freq = freq;
    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public HuffmanNode getLeft() {
        return left;
    }

    public void setLeft(HuffmanNode left) {
        this.left = left;
    }

    public HuffmanNode getRight() {
        return right;
    }

    public void setRight(HuffmanNode right) {
        this.right = right;
    }


    @Override
    public int compareTo(HuffmanNode o) {
        return this.freq-o.freq;
    }

    @Override
    public String toString() {
        return "HuffmanNode{" +
                "freq=" + freq +
                ", letter=" + letter +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
