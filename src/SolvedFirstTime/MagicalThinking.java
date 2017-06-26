package SolvedFirstTime;

import java.util.Scanner;

/**
 * Google code jam
 */
public class MagicalThinking {
    public static void main(String...args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= t; i++) {
            int n = scanner.nextInt();
            scanner.nextLine();
            String[] ans = new String[n];
            for (int j = 0; j < n; j++) {
                ans[j] = scanner.nextLine();
            }
            String m = scanner.nextLine();
            int[] score = new int[n];
            for (int j = 0; j < n; j++) {
                score[j] = scanner.nextInt();
            }
            System.out.println("Case #" + i + ": " + magicalThinking(ans, score, m));
        }
    }

    public static int magicalThinking(String[] ans, int[] scores, String m) {
        int tot = ans[0].length();
        int max = ans[0].length();
        for (int i = 0; i < ans.length; i++) {
            int lost = tot - scores[i];
            max = Math.min(tot - Math.abs(lost - distance(m, ans[i])), max);
        }
        return max;
    }

    public static int distance(String s1, String s2) {
        int c = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                c++;
            }
        }
        return c;
    }
}
