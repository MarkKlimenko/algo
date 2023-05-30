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

    private static void sort(int start, int finish, int[] arr) {
        if (start < finish) {
            int pivotIndex = partition(start, finish, arr);
            sort(start, pivotIndex - 1, arr);
            sort(pivotIndex + 1, finish, arr);
        }
    }

    private static int partition(int start, int finish, int[] arr) {
        int pivot = arr[finish];
        int i = start - 1;

        for(int j = start; j < finish; j++) {
            if(arr[j] < pivot) {
                i++;
                swap(i, j, arr);
            }
        }

        i++;
        swap(i, finish, arr);
        return i;
    }

    private static void swap(int i, int j, int[] arr) {
        int buf = arr[i];
        arr[i] = arr[j];
        arr[j] = buf;
    }
}
