package com.linear.doublyLinked;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        // 添加元素到双链表的头部和尾部
        list.addFirst(1);
        list.addFirst(2);
        list.addLast(3);
        list.addLast(4);

        // 打印双链表的大小
        System.out.println("Size of the doubly linked list: " + list.size());

        // 打印双链表的元素
        System.out.print("Doubly linked list elements: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        // 移除双链表的头部和尾部元素
        list.removeFirst();
        list.removeLast();

        // 打印更新后的双链表
        System.out.print("Updated doubly linked list elements: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}
