package com.zyf.algorithm;

/**
 * 二分查找法
 */
public class BinarySearch {


    public static void main(String[] args) {
        int[] a = {1, 2, 3, 5, 6, 12, 24,21};
        int target = 6;
        System.out.println(binarySearchBasic(a, target));
    }

    /**
     * @param a      待查找的升序数组
     * @param target 待查找的目标值
     * @return 找到则返回索引，找不到返回-1
     */
    public static int binarySearchBasic(int[] a, int target) {
        int i = 0, j = a.length - 1;  //设置指针和初始值
        while (i <= j) {               //i~j 范围内有东西
            int m = (i + j) >>> 1;  //int m = (i + j) / 2;   右移一个可以看成是 除以2，向下取整
            if (target < a[m]) {      //目标在左边
                j = m - 1;
            } else if (a[m] < target) { //目标在右边
                i = m + 1;
            } else {                    //找到了
                return m;
            }
        }
        return -1;
    }
}
