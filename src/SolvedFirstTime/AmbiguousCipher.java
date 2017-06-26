package SolvedFirstTime;

import java.util.Scanner;

/**
 * Google code jam
 */
public class AmbiguousCipher {
    public static void main(String...args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n; i++) {
            String code = scanner.nextLine();
            System.out.println("Case #" + i + ": " + decipher(code));
        }
    }

    public static String decipher(String code) {
        if (code.length() % 2 == 1) {
            return "AMBIGUOUS";
        }
        int[] codeNum = strToNum(code);
        int[] retNum = new int[code.length()];
        retNum[1] = codeNum[0];
        for (int i = 3; i < code.length(); i+=2) {
            retNum[i] = solveForTheUnknown(retNum[i - 2], codeNum[i - 1]);
        }
        retNum[code.length() - 2] = codeNum[code.length() - 1];
        for (int i = code.length() - 4; i >= 0; i-=2) {
            retNum[i] = solveForTheUnknown(retNum[i + 2], codeNum[i + 1]);
        }
        return numToStr(retNum);
    }

    private static int[] strToNum(String code) {
        int[] num = new int[code.length()];
        for (int i = 0; i < code.length(); i++) {
            num[i] = charToNum(code.charAt(i));
        }
        return num;
    }

    private static String numToStr(int[] num) {
        char[] str = new char[num.length];
        for (int i = 0; i < num.length; i++) {
            str[i] = numToChar(num[i]);
        }
        return new String(str);
    }

    private static int charToNum(char c) {
        return c - 65;
    }

    private static char numToChar(int n) {
        return (char) (n + 65);
    }

    private static int solveForTheUnknown(int o, int c) {
        return (c - o + 26) % 26;
    }
}
