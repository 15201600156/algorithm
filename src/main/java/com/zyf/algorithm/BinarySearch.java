package com.zyf.algorithm;

/**
 * 二分查找法
 * <p>
 * <p>
 * 二分查找性能：
 * 时间复杂度
 * 最坏情况：O（logn）
 * 最好情况：如果待查找元素恰好在数组中央，只需要循环一次O（1）
 * 空间复杂度
 * 需要常数个指针i,j,m，因此额外占用的空间是O（1）
 */
public class BinarySearch {


    public static void main(String[] args) {
        int[] a = {1, 2, 3, 5, 6, 12, 24, 21};
        int target = 6;
        System.out.println(binarySearchBasic(a, target));
        System.out.println(binarySearchAlternative(a, target));

        System.out.println(binarySearchBalance(a, target));


    }

    /**
     * 二分查找基础版
     *
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

    /**
     * 二分查找改动版
     *
     * @param a      待查找的升序数组
     * @param target 待查找的目标值
     * @return 找到则返回索引，找不到返回-1
     */
    public static int binarySearchAlternative(int[] a, int target) {
        int i = 0, j = a.length;  //改动第一处
        while (i < j) {               //改动第二处
            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m;          //改动第三处
            } else if (a[m] < target) {
                i = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }


    /**
     * 二分查找平衡版
     */

    public static int binarySearchBalance(int[] a, int target) {
        int i = 0, j = a.length;
        while (1 < j-i) {
            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m;
            } else {
                i = m;
            }
        }
        if (a[i] == target) {
            return i;
        } else {
            return -1;
        }
    }
}
