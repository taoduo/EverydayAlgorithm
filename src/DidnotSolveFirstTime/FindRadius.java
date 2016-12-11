package DidnotSolveFirstTime;

import java.util.Arrays;

/**
 * Leetcode contest Problem
 * https://leetcode.com/contest/leetcode-weekly-contest-12/problems/heaters/
 * Get runtime error for the first time
 * One thing learned is to be careful using while to loop an array
 * The index might go over the index limit
 */
public class FindRadius {
  public static void main(String... args) {
    System.out.println(solve(new int[]{1}, new int[]{2,3,4}));
  }

  public static int solve(int[] houses, int[] heaters) {
    Arrays.sort(houses);
    Arrays.sort(heaters);
    int hoi = 0;
    int max = 0;
    if (houses[0] < heaters[0]) {
      max = heaters[0] - houses[0];
    }
    while (hoi < houses.length && houses[hoi] <= heaters[0]) {
      hoi++;
    }
    for (int i = 1; i < heaters.length; i++) {
      while (hoi < houses.length && houses[hoi] <= heaters[i]) {
        int dist = Math.min(houses[hoi] - heaters[i - 1], heaters[i] - houses[hoi]);
        max = Math.max(max, dist);
        hoi++;
      }
    }
    max = Math.max(max, houses[houses.length - 1] - heaters[heaters.length - 1]);
    return max;
  }
}
