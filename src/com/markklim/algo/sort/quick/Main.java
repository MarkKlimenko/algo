package com.markklim.algo.sort.quick;

import java.util.Arrays;

import static com.markklim.algo.util.Assertions.assertEquals;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 4, 8, 23, 7, 4, 6, 3, 5, 7, 3, 2, 5};

        int[] expectedArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(expectedArr);

        quickSort(arr);
        assertEquals(0, Arrays.compare(expectedArr, arr));

        int[] arrEmpty = {};
        int[] expectedEmpty = {};
        quickSort(arrEmpty);
        assertEquals(0, Arrays.compare(expectedEmpty, arrEmpty));
    }

    private static void quickSort(int[] arr) {
        sort(0, arr.length - 1, arr);
    }

    private static void sort(int left, int right, int[] arr) {
        if (left < right) {
            int pivotIndex = partition(left, right, arr);
            sort(left, pivotIndex - 1, arr);
            sort(pivotIndex + 1, right, arr);
        }
    }

    private static int partition(int left, int right, int[] arr) {
        int pivot = arr[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(i, j, arr);
            }
        }

        i++;
        swap(i, right, arr);
        return i;
    }

    private static void swap(int i, int j, int[] arr) {
        int buf = arr[i];
        arr[i] = arr[j];
        arr[j] = buf;
    }
}
