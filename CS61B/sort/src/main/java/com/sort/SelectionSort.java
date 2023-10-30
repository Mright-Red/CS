package com.sort;

/*
 * SelectionSort
 * time complexity {
 * average case:O(n²)
 * best case:O(n²)
 * worst case:O(n²)
 * }
 * space complexity:O(1)
 * sortord:in-place
 * stability:N
 */
public class SelectionSort {
    public static int[] selectionSort(int[] array) {
        if (array.length == 0)
            return array;
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex]) // 找到最小的数
                    minIndex = j; // 将最小数的索引保存
            }
            // 交换元素
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        return array;
    }
}
