package SolvedFirstTime;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 */
public class ValidSudoku {
  public static void main(String... args) {
    System.out.println(solve(new char[][]{
        ".87654321".toCharArray(),
        "2........".toCharArray(),
        "3........".toCharArray(),
        "4........".toCharArray(),
        "5........".toCharArray(),
        "6........".toCharArray(),
        "7........".toCharArray(),
        "8........".toCharArray(),
        "9........".toCharArray()}));
  }

  public static boolean solve(char[][] board) {
    boolean[] bol = new boolean[10];
    Arrays.fill(bol, false);
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] != '.') {
          int num = board[i][j] - 48;
          if (!bol[num]) {
            bol[num] = true;
          } else {
            return false;
          }
        }
      }
      Arrays.fill(bol, false);
    }
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[j][i] != '.') {
          int num = board[j][i] - 48;
          if (!bol[num]) {
            bol[num] = true;
          } else {
            return false;
          }
        }
      }
      Arrays.fill(bol, false);
    }
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        int xs = i * 3;
        int ys = j * 3;
        for (int x = 0; x < 3; x++) {
          for (int y = 0; y < 3; y++) {
            int a = xs + x, b = ys + y;
            if (board[a][b] != '.') {
              int num = board[a][b] - 48;
              if (!bol[num]) {
                bol[num] = true;
              } else {
                return false;
              }
            }
          }
        }
        Arrays.fill(bol, false);
      }
    }
    return true;
  }
}
