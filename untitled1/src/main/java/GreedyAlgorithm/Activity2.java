package main.java.GreedyAlgorithm;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        List<Consumer> list = new LinkedList<>();
        for(int i=0;i<intervals.length;++i){
            list.add(new Consumer(intervals[i][0],intervals[i][1]));
        }
        Collections.sort(list);
        int slotCount=0;
        int i=0;
        while (!list.isEmpty()){
            ++slotCount;
            List<Consumer> served=new LinkedList<>();
            served.add(list.get(0));
            for(;i<list.size();++i){
                if(list.get(i).start>=served.get(served.size()-1).end){
                }else {
                    ++i;
                    break;
                }
            }
            served=null;
        }

        return slotCount;
    }
}

class Consumer implements Comparable<Consumer>{
    public int start;
    public int end;

    public Consumer(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Consumer consumer = (Consumer) o;
        return start == consumer.start &&
                end == consumer.end;
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }

    @Override
    public int compareTo(Consumer o) {
        return start-o.start;
    }
}


