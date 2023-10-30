package com.sort;

/* 
* BubbleSort
* time complexity {
* average case:O(n²)
* best case:O(n)
* worst case:O(n²)
* }
* space complexity:O(1)
* sortord:in-place
* stability:Y
*/
public class BubbleSort {
    public static int[] bubbleSort(int[] array) {
        if (array.length == 0)
            return array;
        // int n = array.length;
        for (int i = 0; i < array.length; i++) {
            boolean swapped = false;
            // int lastSwapIndex = 0;
            for (int j = 0; j < array.length - 1 - i/* 性能优化：n-1-i */; j++) {
                if (array[j + 1] < array[j]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    swapped = true;
                    // lastSwapIndex = j;
                }
            }
            if (!swapped)
                break;
            // n = lastSwapIndex + 1;// 下一轮只需要比较到最后一次交换的位置
        }
        return array;
    }
}
