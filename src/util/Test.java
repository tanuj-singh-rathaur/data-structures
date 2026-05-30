package util;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Tiny test helper that prints PASS / FAIL per assertion and a summary at the end.
 *
 * Usage:
 *   import util.Test;
 *   ...
 *   Test.equal("Test 1", sol.twoSum(new int[]{2,7,11,15}, 9), new int[]{1, 2});
 *   Test.equal("Test 2", sol.isPalindrome("racecar"), true);
 *   Test.summary();
 */
public class Test {

    private static int passed = 0;
    private static int failed = 0;

    public static void equal(String name, int actual, int expected) {
        check(name, actual == expected, String.valueOf(actual), String.valueOf(expected));
    }

    public static void equal(String name, long actual, long expected) {
        check(name, actual == expected, String.valueOf(actual), String.valueOf(expected));
    }

    public static void equal(String name, boolean actual, boolean expected) {
        check(name, actual == expected, String.valueOf(actual), String.valueOf(expected));
    }

    public static void equal(String name, String actual, String expected) {
        check(name, Objects.equals(actual, expected),
              "\"" + actual + "\"", "\"" + expected + "\"");
    }

    public static void equal(String name, int[] actual, int[] expected) {
        check(name, Arrays.equals(actual, expected),
              Arrays.toString(actual), Arrays.toString(expected));
    }

    public static void equal(String name, char[] actual, char[] expected) {
        check(name, Arrays.equals(actual, expected),
              new String(actual), new String(expected));
    }

    public static void equal(String name, List<?> actual, List<?> expected) {
        check(name, Objects.equals(actual, expected),
              String.valueOf(actual), String.valueOf(expected));
    }

    private static void check(String name, boolean ok, String got, String expected) {
        if (ok) {
            passed++;
            System.out.println("✓ PASS  " + name + "   got=" + got);
        } else {
            failed++;
            System.out.println("✗ FAIL  " + name + "   got=" + got + "   expected=" + expected);
        }
    }

    public static void summary() {
        System.out.println("---");
        System.out.println(passed + " passed,  " + failed + " failed");
        if (failed == 0 && passed > 0) {
            // Auto-detect the running class so the user knows which row to mark in the Masterclass.
            String cls = "this problem";
            for (StackTraceElement e : Thread.currentThread().getStackTrace()) {
                if (e.getMethodName().equals("main") && !e.getClassName().equals(Test.class.getName())) {
                    String full = e.getClassName();
                    cls = full.substring(full.lastIndexOf('.') + 1);
                    break;
                }
            }
            System.out.println("✓ ALL PASSED — open the Masterclass and mark " + cls + " complete.");
        }
        // Reset so re-running in the same JVM doesn't accumulate.
        passed = 0;
        failed = 0;
    }
}
