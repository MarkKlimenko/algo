package com.markklim.algo.search.binary;

import java.util.Arrays;

import static com.markklim.algo.util.Assertions.assertEquals;

public class Iterative {
    public static void main(String[] args) {
        int[] arr = {1, 4, 8, 23, 7, 4, 6, 3, 5, 7, 3, 2, 5};
        Arrays.sort(arr);

        assertEquals(6, search(arr, 5));
        assertEquals(-1, search(arr, 10));
    }

    public static int search(int[] arr, int value) {
        int left = 0;
        int right = arr.length - 1;

        while (right >= left) {
            // this solution could cause overflow
            // int middle = (start + finish) / 2;

            int middle = left + (right - left) / 2;

            if (value == arr[middle]) {
                return middle;
            } else if (value < arr[middle]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return -1;
    }
}
