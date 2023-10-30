package com.sort;

import java.util.Arrays;

/* 排序算法 */

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

        int[] list4 = { 8, 9, 5, 7, 4, 2, 1, 3, 0, 6 };
        ShellSort.shellSort(list4);
        System.out.println("\n希尔排序后的数组:");
        for (int num : list4) {
            System.out.print(num + " ");
        }

        int[] list5 = { 2, 3, 8, 5, 0, 9, 7, 6, 1, 4 };
        int[] sortedList5 = MergeSort.mergeSort(list5);
        System.out.println("\n归并排序后的数组:\n" + list5);// 哈希
        System.out.println("\n归并排序后的数组:\n" + Arrays.toString(sortedList5));

        int[] list6 = { 8, 9, 5, 7, 4, 2, 1, 3, 0, 6 };
        QuickSort.quickSort(list6, 0, list6.length - 1);
        System.out.println("\n快速排序后的数组:\n" + Arrays.toString(list6));

        int[] list7 = { 8, 9, 5, 7, 4, 2, 1, 3, 0, 6 };
        HeapSort.heapSort(list7);
        System.out.println("\n堆排序后的数组:\n" + Arrays.toString(list7));

        int[] list8 = { 8, 9, 5, 7, 4, 2, 1, 3, 0, 6 };
        CountingSort.countingSort(list8);
        System.out.println("\n计数排序后的数组:\n" + Arrays.toString(list8));

        // 桶排序调用
        // 基数排序调用
    }
}
