package DidnotSolveFirstTime;

/**
 * Leetcode Problem
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 * Shame. Spent several days on this problem
 */
public class FindMedianSortedArrays {
  public static void main(String... args) {
    System.out.println(solve(new int[]{1}, new int[]{2, 3}));
  }

  // find the median of nums1 and nums2
  public static double solve(int[] nums1, int[] nums2) {
    int len = (nums1.length + nums2.length) / 2;
    // nums1 is shorter; nums2 is longer
    if (nums1.length > nums2.length) {
      int[] temp = nums1;
      nums1 = nums2;
      nums2 = temp;
    }

    // find the thresold
    int left = 0, right = nums1.length + 1;
    while (left < right) {
      int m = left + (right - left) / 2;
      int m2 = len - m;
      int mp = m - 1;
      int mp2 = m2 - 1;
      if (m != nums1.length && mp2 != -1 && nums1[m] < nums2[mp2]) {
        left = m;
      } else if (m2 != nums2.length && mp != -1 && nums2[m2] < nums1[mp]) {
        right = m;
      } else {
        left = m;
        break;
      }
    }
    System.out.println(left);
    // get the median at the thresold
    int thre1 = left;
    int thre2 = len - left;
    double median;
    if ((nums1.length + nums2.length) % 2 == 0) {
      int lm, rm;
      if (thre1 == 0) {
        lm = nums2[thre2 - 1];
      } else if (thre2 == 0) {
        lm = nums1[thre1 - 1];
      } else {
        lm = Math.max(nums1[thre1 - 1], nums2[thre2 - 1]);
      }
      if (thre1 == nums1.length) {
        rm = nums2[thre2];
      } else if (thre2 == nums2.length) {
        rm = nums1[thre1];
      } else {
        rm = Math.min(nums1[thre1], nums2[thre2]);
      }
      median = (lm + rm) / 2.0;
    } else {
      if (thre1 == nums1.length) {
        median = nums2[thre2];
      } else {
        median = Math.min(nums1[thre1], nums2[thre2]);
      }
    }
    return median;
  }
}
