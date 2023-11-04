package com.linear.sequenced;

public class Test {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SequenceList list = new SequenceList(100);

        try {
            list.insert(list.size, new Students("S0001", "张三", "男", 18)); // 第一个参数list.size代表的是：我每次都是在顺序表的最后一个位置（当前线性表的长度的位置）进行插入操作。这一行里，size是等于0
            list.insert(list.size, new Students("S0002", "李四", "男", 19));
            list.insert(list.size, new Students("S0003", "王五", "女", 21));

            for (int i = 0; i < list.size; i++) {
                System.out.println(list.get(i));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
