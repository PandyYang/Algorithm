package com.pandy.base.array.package01;

/**
 * @author Pandy
 * @date 20/12/2021
 * 题目描述：
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完 成一个函数，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
 * 思路：
 * 从右上角或者左下角开始寻找，可以根据数值大小进行调整。
 */
public class Find {
    private static boolean find(int[][] arr, int target) {

        if (arr.length == 0 || arr[0].length == 0) return false;

        int x = 0, y = arr[0].length - 1;
        while (x < arr.length && y > 0) {
            int num = arr[x][y];
            if (num == target) {
                return true;
            } else if (num > target){
                y--;
            } else {
                x++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr =
                {
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                };
        boolean b = find(arr, 5);

        System.out.println("b = " + b);
    }
}
