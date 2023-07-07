package com.markklim.algo.search.binary;

import java.util.Arrays;

import static com.markklim.algo.util.Assertions.assertEquals;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 4, 8, 23, 7, 4, 6, 3, 5, 7, 3, 2, 5};
        Arrays.sort(arr);

        assertEquals(6, search(arr, 5));
        assertEquals(-1, search(arr, 10));
    }

    private static int search(int[] arr, int value) {
        int start = 0;
        int finish = arr.length - 1;

        while (finish >= start) {
            // this solution could cause overflow
            // int middle = (start + finish) / 2;

            int middle = start + (finish - start) / 2;

            if (value == arr[middle]) {
                return middle;
            } else if (value > arr[middle]) {
                start = middle + 1;
            } else {
                finish = middle - 1;
            }
        }

        return -1;
    }
}
