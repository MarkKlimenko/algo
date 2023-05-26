package com.markklim.algo.sort.quick;

import java.util.Arrays;

import static com.markklim.algo.util.Assertions.assertEquals;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 4, 8, 23, 7, 4, 6, 3, 5, 7, 3, 2, 5};

        int[] expectedArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(expectedArr);

        sort(arr);
        assertEquals(0, Arrays.compare(expectedArr, arr));
    }

    private static void sort(int[] arr) {

    }
}
