package DidnotSolveFirstTime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Leetcode Problem
 * https://leetcode.com/problems/anagrams/
 * Did not get the O(n) solution the first time
 * When hashing does not work well for some problems, try sorting
 */
public class GroupAnagrams {
    public static void main(String... args) {
        List<List<String>> res = solve(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        for (List<String> r : res) {
            for (String s : r) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

    public static List<List<String>> solve(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            String so = stringSort(s);
            if (map.containsKey(so)) {
                map.get(so).add(s);
            } else {
                map.put(so, new ArrayList<>());
                map.get(so).add(s);
            }
        }
        for (List<String> s : map.values()) {
            res.add(s);
        }
        return res;
    }

    public static String stringSort(String str) {
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}
