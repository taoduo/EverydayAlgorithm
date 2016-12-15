package DidnotSolveFirstTime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Really hard and elegant problem, not in terms of coding but in terms of how to come up with a clean recursive solution.
 * My general approach is that for every decision making: I will win when there is a choice that
 * makes sure that I will win. I will lose, when for every choice, my opponent will have some way to
 * make sure he/she wins by making the right choice next time.
 * Winning is related to the number of possible divisions that can happen on this number: if the number of possible divisions
 * is odd, then the current player wins; if even, his/her opponent wins. So I just care about whether
 * the number of divisions can be odd.
 *
 * ANECDOTE:
 * It is like that I take a number, I try all ways of division at my point and then throw the results to my
 * opponent, asking "can you win by this?" If my opponent say "Yes!" I am sad and silently go to try
 * the next one. If he crys "No", I will be happy and announce my victory in front of the whole world.
 * (or to my opponent if this is not the decisive victory yet. But it is good to make them feel bad, or low in morale, right?)
 * If I run out of possible choices and for all of my choices, my opponent always say "Yes!", I will surrender and yell at them "it is not a
 * fair game!!!"
 * https://www.hackerrank.com/contests/w25/challenges/stone-division
 */
public class StoneDivision {
    public static Map<Long, Boolean> memorize = new HashMap<>();
    public static void main(String...args) {
        Scanner scn = new Scanner(System.in);
        List<Long> s = new ArrayList<>();
        long n = scn.nextLong(), m = scn.nextInt();
        for (int i = 0; i < m; i++) {
            Long l = scn.nextLong();
            if (n % l == 0) {
                s.add(l);
            }
        }
        for (long l : s) {
            if (l % 2 == 0) {
                System.out.println("First");
                return;
            }
        }
        if (solve(n, s)) {
            System.out.println("First");
        } else {
            System.out.println("Second");
        }

    }

    /*
     * return whether count of division of n using s can be odd
     */
    public static boolean solve(long n, List<Long> s) {
        // the the total number of divisions happen to n will be <even> * <whatever> + 1(this division)
        // the number is assured to be odd, then return true, "the number can have odd count of divisions"
        if (memorize.get(n) != null) {
          return memorize.get(n);
        }
        for (long l : s) {
            // if the division can have odd division
            boolean temp = solve(n / l, s);
            memorize.put(n / l, temp);
            if (n % l == 0 && !temp) {
                return true;
            }
        }
        return false;
    }
}
