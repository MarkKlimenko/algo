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

    public static void quickSort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(arr, left, right);
            sort(arr, left, pivotIndex - 1);
            sort(arr, pivotIndex + 1, right);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int pivotValue = arr[right];
        int insertPointer = left - 1;

        for (int i = left; i < right; i++) {
            if (arr[i] < pivotValue) {
                insertPointer++;
                swap(arr, i, insertPointer);
            }
        }

        insertPointer++;
        swap(arr, insertPointer, right);
        return insertPointer;
    }

    private static void swap(int[] arr, int left, int right) {
        int buf = arr[left];
        arr[left] = arr[right];
        arr[right] = buf;
    }
}
