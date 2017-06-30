package SolvedFirstTime;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/course-schedule-iii/
 */
public class ScheduleCourse {
    public static void main(String...args) {

    }

    public static int solve(int[][] courses) {
        Arrays.sort(courses, (o1, o2)->o1[1] - o2[1]);
        PriorityQueue<int[]> taken = new PriorityQueue<>((o1, o2)->o2[0] - o1[0]);
        taken.add(courses[0]);
        int time = courses[0][0];
        for (int i = 1; i < courses.length; i++) {
            if (courses[i][0] + time <= courses[i][1]) {
                taken.add(courses[i]);
                time += courses[i][0];
            } else {
                int[] longest = taken.peek();
                if (longest[0] > courses[i][0]) {
                    taken.poll();
                    taken.add(courses[i]);
                    time -= longest[0];
                    time += courses[i][0];
                }
            }

        }
        return taken.size();
    }
}
