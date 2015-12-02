package uk.pizey.tim;

/**
 * Hello world!
 */
public class Numerals {
  public static void main(String[] args) {
    if (args.length != 1) {
      System.err.println("A single roman numeral input is required.");
      System.exit(1);
    }
    int result = 0; 
    try {
      result = convert(args[0]);
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
      System.exit(1);
    }
    System.out.println(result);
  }

  public static int convert(String in) {
    String toConvert = in.toUpperCase();
    int value = 0;
    char[] chars = toConvert.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      int thisCharValue = convertChar(chars[i]);
      int nextCharValue = 0;
      int previousCharValue = 0;
      if (i + 1 < chars.length) {
        nextCharValue = convertChar(chars[i + 1]);
      }
      if (i - 1 > -1) {
        previousCharValue = convertChar(chars[i - 1]);
      }
      if (thisCharValue < nextCharValue) {
        if (!mayBeDeductedFrom(chars[i], chars[i + 1])) {
          throw new IllegalArgumentException(chars[i] + " may not be used as a prefix subtraction from " + chars[i + 1]);
        }
        if (previousCharValue != 0
            && previousCharValue < nextCharValue) {
          throw new IllegalArgumentException(
              "" + chars[i] + chars[i + 1] + " are preceded by a lesser numeral ("
                  + chars[i - 1] + ")");
        } else {
          value -= thisCharValue;
        }

      } else {
        value += thisCharValue;
      }
    }
    return value;
  }

  static int convertChar(char r) {
    switch (r) {
      case 'I':
        return 1;
      case 'V':
        return 5;
      case 'X':
        return 10;
      case 'L':
        return 50;
      case 'C':
        return 100;
      case 'D':
        return 500;
      case 'M':
        return 1000;
      default:
        throw new IllegalArgumentException(r + "is not one of IVXLCDM");
    }
  }

  static boolean mayBeDeductedFrom(char lesser, char greater) {
    if (lesser == 'I') {
      if (greater == 'X'
          || greater == 'V') {
        return true;
      }
    } else if (lesser == 'X') {
      if (greater == 'L') {
        return true;
      }
    } else if (lesser == 'C') {
      if (greater == 'D') {
        return true;
      }
    }
    return false;
  }
}
