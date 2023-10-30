package com.sort;

/*
 * ShellSort
 * time complexity {
 * average case:O(nlogn)
 * best case:O(nlog²n)
 * worst case:O(nlog²n)
 * }
 * space complexity:O(1)
 * sortord:in-place
 * stability:N
 */
public class ShellSort {
    public static int[] shellSort(int[] array) {
        if (array.length == 0)
            return array;
        int len = array.length;
        int temp, gap = len / 2;

        // 计算合适的初始间隔优化
        while (gap < len / 3) {
            gap = gap * 3 + 1;
        }

        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                temp = array[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && array[preIndex] > temp) {
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = temp;
            }
            gap /= 2;
        }
        return array;
    }
}
