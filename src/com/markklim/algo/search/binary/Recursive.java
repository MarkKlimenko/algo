package com.markklim.algo.search.binary;

import java.util.Arrays;

import static com.markklim.algo.util.Assertions.assertEquals;

public class Recursive {
    public static void main(String[] args) {
        int[] arr = {1, 4, 8, 23, 7, 4, 6, 3, 5, 7, 3, 2, 5};
        Arrays.sort(arr);

        assertEquals(6, search(arr, 5));
        assertEquals(-1, search(arr, 10));
    }

    public static int search(int[] arr, int value) {
        return binarySearch(arr, value, 0, arr.length - 1);
    }

    private static int binarySearch(int[] arr, int value, int left, int right) {
        if (left > right) {
            return -1;
        }

        int middleIndex = left + (right - left) / 2;

        if (value == arr[middleIndex]) {
            return middleIndex;
        } else if (value < arr[middleIndex]) {
            return binarySearch(arr, value, left, middleIndex - 1);
        } else {
            return binarySearch(arr, value, middleIndex + 1, right);
        }
    }
}
