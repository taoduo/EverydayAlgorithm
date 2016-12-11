package SolvedFirstTime;

/**
 * Leetcode Contest Problem
 */
public class ValidIPAddress {
  public static void main(String... args) {
    System.out.println(solve("256.256.256.256"));
  }

  public static String solve(String IP) {
    if (isIPv4(IP)) {
      return "IPv4";
    } else if (isIPv6(IP)) {
      return "IPv6";
    } else {
      return "Neither";
    }
  }

  public static boolean isIPv4(String IP) {
    String[] spl = IP.split("\\.");
    if (spl.length != 4) {
      return false;
    }
    for (int i = 0; i < spl.length; i++) {
      if (!isValidIPv4Digit(spl[i])) {
        return false;
      }
    }
    return true;
  }

  public static boolean isValidIPv4Digit(String digit) {
    // not empty, no leading 0
    if (digit.length() == 0 || (digit.length() != 1 && digit.startsWith("0"))) {
      return false;
    }
    try {
      int dig = Integer.parseInt(digit);
      if (dig > 255 || dig < 0) {
        return false;
      }
    } catch (Exception e) {
      return false;
    }
    return true;
  }

  public static boolean isIPv6(String IP) {
    String[] spl = IP.split(":");
    if (spl.length != 8) {
      return false;
    }
    for (int i = 0; i < spl.length; i++) {
      if (!isValidIPv6Digit(spl[i])) {
        return false;
      }
    }
    return true;
  }

  public static boolean isValidIPv6Digit(String digit) {
    digit = digit.toLowerCase();
    if (digit.length() == 0 || digit.length() > 4) {
      return false;
    }
    for (int i = 0; i < digit.length(); i++) {
      char c = digit.charAt(i);
      if (!((c >= 48 && c <= 57) || (c >= 97 && c <= 102))) {
        return false;
      }
    }

    return true;
  }
}
