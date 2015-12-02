package uk.pizey.tim;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple Numerals.
 */
public class NumeralsTest
    extends TestCase {
  /**
   * Create the test case
   *
   * @param testName name of the test case
   */
  public NumeralsTest(String testName) {
    super(testName);
  }

  /**
   * @return the suite of tests being tested
   */
  public static Test suite() {
    return new TestSuite(NumeralsTest.class);
  }

  public void testPartOne() {
    assertEquals(2944, Numerals.convert("MMDCDXLIV"));
    assertEquals(1000, Numerals.convert("M"));
  }

  public void testPartTwo() {
    // Values from http://www.onlineconversion.com/roman_numerals_advanced.htm
    String [] possibles = {
        "VIV", // invalid
        "MIX", // 1009
        "LID", // invalid
        "DIX", // 509
        "LICX", // invalid
        "CLIX", // 159
        "MMDLIV", //2554
        "MMXDLIV", // invalid
        "MCMXCX", // invalid
        "MCMXCVI" // 1996
    };
    for (String possible : possibles) {
      try {
        int arabic = Numerals.convert(possible);
        System.err.println(possible + " = " + arabic);
      } catch (IllegalArgumentException e) {
        System.err.println(possible + " is invalid as " + e.getMessage());
      }
    }
  }

  public void testValues() {
    // Could be expressed more simply as IX
    assertEquals(9, Numerals.convertOrZero("VIV"));
    assertEquals(1009, Numerals.convertOrZero("MIX"));
    assertEquals(0, Numerals.convertOrZero("LID"));
    assertEquals(509, Numerals.convertOrZero("DIX"));
    assertEquals(0, Numerals.convertOrZero("LICX"));
    assertEquals(159, Numerals.convertOrZero("CLIX"));
    assertEquals(2554, Numerals.convertOrZero("MMDLIV"));
    assertEquals(0, Numerals.convertOrZero("MMXDLIV"));
    // This should fail, requires a simplification rule
    assertEquals(2000, Numerals.convertOrZero("MCMXCX"));
    assertEquals(1996, Numerals.convertOrZero("MCMXCVI"));
    assertEquals(2057, Numerals.convertOrZero("MMLVII"));
    assertEquals(40, Numerals.convertOrZero("XL"));
    assertEquals(29, Numerals.convertOrZero("XXIX"));
    assertEquals(399, Numerals.convertOrZero("CCCXCIX"));
    assertEquals(444, Numerals.convertOrZero("CDXLIV"));
    assertEquals(1, Numerals.convertOrZero("I"));
    assertEquals(4, Numerals.convertOrZero("IV"));
    assertEquals(9, Numerals.convertOrZero("IX"));
    assertEquals(40, Numerals.convertOrZero("XL"));
    assertEquals(50, Numerals.convertOrZero("L"));
    assertEquals(90, Numerals.convertOrZero("XC"));
    assertEquals(100, Numerals.convertOrZero("C"));
    assertEquals(400, Numerals.convertOrZero("CD"));
    assertEquals(500, Numerals.convertOrZero("D"));
    assertEquals(900, Numerals.convertOrZero("CM"));
    assertEquals(1000, Numerals.convertOrZero("M"));

  }


}
