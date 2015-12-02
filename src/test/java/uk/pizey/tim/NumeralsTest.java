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
}
