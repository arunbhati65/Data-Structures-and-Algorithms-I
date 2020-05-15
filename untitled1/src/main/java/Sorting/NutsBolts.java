package main.java.Sorting;

public class NutsBolts {

    public static void main(String[] args) {
        // Nuts and bolts are represented as array of characters
        char nuts[] = {'@', '#', '$', '%', '^', '&'};
        char bolts[] = {'$', '%', '&', '^', '@', '#'};

        // Method based on quick sort which matches nuts and bolts
        matchPairs(nuts, bolts, 0, 5);

        System.out.println("Matched nuts and bolts are : ");
        printArray(nuts);
        printArray(bolts);
    }

    private static void printArray(char[] arr) {
            for (char ch : arr) {
                System.out.print(ch + " ");
            }
            System.out.print("\n");
        }

    private static void matchPairs(char[] nuts, char[] bolts, int low,
                                   int high) {
        if (low < high) {
            // Choose last character of bolts array for nuts partition.
            int pivot = partition(nuts, low, high, bolts[high]);

            // Now using the partition of nuts choose that for bolts
            // partition.
            partition(bolts, low, high, nuts[pivot]);

            // Recur for [low...pivot-1] & [pivot+1...high] for nuts and
            // bolts array.
            matchPairs(nuts, bolts, low, pivot - 1);
            matchPairs(nuts, bolts, pivot + 1, high);
        }
    }

    private static int partition(char[] arr, int l, int h, char pivot) {
        int i = l - 1;
        int j = h + 1;
        while (true) {
            do {
                i++;
            } while (arr[i] < pivot);
            do {
                j--;
            } while (arr[j] > pivot);
            if (i >= j) return j;
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }


}
/*


    // Method which works just like quick sort
    private static void matchPairs(char[] nuts, char[] bolts, int low,
                                   int high) {
        if (low < high) {
            // Choose last character of bolts array for nuts partition.
            int pivot = partition(nuts, low, high, bolts[high]);

            // Now using the partition of nuts choose that for bolts
            // partition.
            partition(bolts, low, high, nuts[pivot]);

            // Recur for [low...pivot-1] & [pivot+1...high] for nuts and
            // bolts array.
            matchPairs(nuts, bolts, low, pivot - 1);
            matchPairs(nuts, bolts, pivot + 1, high);
        }


    static int partition(char[] arr, int l, int h, char pivot) {

    }


    // Method to print the array

 */