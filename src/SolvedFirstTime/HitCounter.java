package SolvedFirstTime;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode Mock Interview
 */
public class HitCounter {
    private final int FIVE_MIN = 300;
    private Map<Integer, Integer> counter;

    public static void main(String...args) {
        HitCounter counter = new HitCounter();
        // hit at timestamp 1.
        counter.hit(1);

        // hit at timestamp 2.
        counter.hit(2);

        // hit at timestamp 3.
        counter.hit(3);

        // get hits at timestamp 4, should return 3.
        counter.getHits(4);

        // hit at timestamp 300.
        counter.hit(300);

        // get hits at timestamp 300, should return 4.
        System.out.println(counter.getHits(300));

        // get hits at timestamp 301, should return 3.
        System.out.println(counter.getHits(301));
    }

        /** Initialize your data structure here. */
    public HitCounter() {
        counter = new HashMap<>();
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        if (counter.get(timestamp) == null) {
            counter.put(timestamp, 1);
        } else {
            counter.put(timestamp, counter.get(timestamp) + 1);
        }
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int count = 0;
        for (int i = 0; i < FIVE_MIN; i++) {
            if (counter.containsKey(timestamp - i)) {
                count += counter.get(timestamp - i);
            }
        }
        return count;
    }
}
