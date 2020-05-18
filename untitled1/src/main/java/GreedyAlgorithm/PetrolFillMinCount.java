package main.java.GreedyAlgorithm;

public class PetrolFillMinCount {
    static int vehicleAvgFullTank = 19;

    public static void main(String args[]) {
        int petrolPumps[] = {9, 9, 9, 10, 11, 12, 1, 13, 2};

        int totalDistance = 38;
        System.out.println("Total number of Fills Required:" + getPetrolFillUpCount(petrolPumps, vehicleAvgFullTank, totalDistance));
    }

    private static int getPetrolFillUpCount(int[] petrolPumps, int vehicleCurrentLimit, int totalDistanceLeft) {
        int fillCount = 1;
        int i = 0;
        while (totalDistanceLeft >= vehicleCurrentLimit) {
            totalDistanceLeft = totalDistanceLeft - petrolPumps[i];
            vehicleCurrentLimit = vehicleCurrentLimit - petrolPumps[i];
            ++i;
            if (vehicleCurrentLimit < petrolPumps[i]) {
                ++fillCount;
                vehicleCurrentLimit = vehicleAvgFullTank;
            }

        }
        return fillCount;
    }
}
