package com.sort;

/* 排序算法 */

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

class BubbleSort {
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

class SelectionSort {
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

class InsertionSort {
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

class ShellSort {
    public static int[] shellSort(int[] array) {
        if (array.length == 0)
            return array;
        int len = array.length;
        int temp, gap = len / 2;
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

public class Main {
    public static void main(String[] args) throws Exception {
        int[] list1 = { 2, 3, 8, 5, 0, 9, 7, 6, 1, 4 };
        BubbleSort.bubbleSort(list1);
        System.out.println("冒泡排序后的数组：");
        for (int num : list1) {
            System.out.print(num + " ");
        }
        int[] list2 = { 8, 9, 5, 7, 4, 2, 1, 3, 0, 6 };
        SelectionSort.selectionSort(list2);
        System.out.println("\n选择排序后的数组:");
        for (int num : list2) {
            System.out.print(num + " ");
        }
        int[] list3 = { 8, 9, 5, 7, 4, 2, 1, 3, 0, 6 };
        InsertionSort.insertionSort(list3);
        System.out.println("\n插入排序后的数组:");
        for (int num : list3) {
            System.out.print(num + " ");
        }
    }
}
