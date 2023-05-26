package com.markklim.algo.sort.bubble;

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
        for (int i = 0; i < arr.length - 1; i++) {
            // use swapped for quick return from for
            boolean swapped = false;
            for (int j = 0; j < arr.length - 1; j++) {
                int left = arr[j];
                int right = arr[j + 1];

                if (left > right) {
                    arr[j] = right;
                    arr[j + 1] = left;

                    swapped = true;
                }
            }

            if(!swapped) {
                break;
            }
        }
    }
}
