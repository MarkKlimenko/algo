package com.markklim.algo.util;

import java.io.Serializable;

public class Assertions {
    public static void assertEquals(Serializable expected, Serializable actual) {
        if (!expected.equals(actual)) {
            throw new AssertionError("Not equal " + expected + " to " + actual);
        }
    }

    public static void assertTrue(boolean value) {
        if (!value) {
            throw new AssertionError("Not true");
        }
    }
}
