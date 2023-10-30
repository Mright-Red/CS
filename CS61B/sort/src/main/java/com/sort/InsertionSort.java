package com.sort;

/*
 * InsertionSort
 * time complexity {
 * average case:O(n²)
 * best case:O(n)
 * worst case:O(n²)
 * }
 * space complexity:O(1)
 * sortord:in-place
 * stability:Y
 */
public class InsertionSort {
    public static int[] insertionSort(int[] array) {
        if (array.length == 0)
            return array;
        int current;
        for (int i = 0; i < array.length - 1; i++) {
            current = array[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && current < array[preIndex]) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }
        return array;
    }
}
