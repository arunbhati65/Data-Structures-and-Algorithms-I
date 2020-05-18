package main.java.GreedyAlgorithm.ActivitySelectionORIntervalSchedulling;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

class Activity implements Comparable<Activity> {
    int start, finish;

    @Override
    public int compareTo(Activity o) {
        return this.finish - o.finish;
    }

    public Activity(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "start=" + start +
                ", finish=" + finish +
                '}';
    }
};

public class IntervalScheduling {
    static void printMaxActivities(Activity arr[]) {

        Arrays.sort(arr);
        List<Activity> listOfSortedActivity =  Arrays.asList(arr);
        AtomicReference<Activity> prev = new AtomicReference<>();
        System.out.println(listOfSortedActivity.get(0));
        listOfSortedActivity.forEach(activity -> {
            if (prev.get()!=null) {
                if(activity.start>prev.get().finish){
                    System.out.println(activity);
                    prev.set(activity);
                }
            }else {
                prev.set(activity);
            }
        });



    }

    public static void main(String args[]) {
        Activity arr[] = {new Activity(5, 9), new Activity(1, 2), new Activity(3, 4), new Activity(0, 6),
                new Activity(5, 7), new Activity(8, 9)};
        printMaxActivities(arr);
    }
}

