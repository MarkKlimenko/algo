package com.markklim.algo.other.factorial;

import static com.markklim.algo.util.Assertions.assertEquals;

public class Main {
    public static void main(String[] args) {
        assertEquals(1, factorialRecursive(0));
        assertEquals(1, factorialRecursive(1));
        assertEquals(479001600, factorialRecursive(12));

        assertEquals(1, factorial(0));
        assertEquals(1, factorial(1));
        assertEquals(479001600, factorial(12));
    }

    private static int factorialRecursive(int value) {
        // TODO: validations
        if (value == 0) {
            return 1;
        } else {
            return value * factorialRecursive(value - 1);
        }
    }

    private static int factorial(int value) {
        // TODO: validations
        int buf = 1;
        for(int i = value; i > 0; i--) {
            buf = buf * i;
        }
        return buf;
    }
}
