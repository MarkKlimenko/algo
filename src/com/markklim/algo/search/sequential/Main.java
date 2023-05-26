package com.markklim.algo.search.sequential;

import static com.markklim.algo.util.Assertions.assertEquals;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 4, 8, 23, 7, 4, 6, 3, 5, 7, 3, 2, 5};

        assertEquals(8, search(arr, 5));
        assertEquals(-1, search(arr, 10));
    }

    private static int search(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (value == arr[i]) {
                return i;
            }
        }

        return -1;
    }
}
