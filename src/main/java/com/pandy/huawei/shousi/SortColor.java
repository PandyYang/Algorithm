package com.pandy.huawei.shousi;

public class SortColor {
    public static void sortColors(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int curr = 0;
        while (curr <= end) {
            if(arr[curr] == 0) {
                arr[curr] = arr[start];
                arr[start] = 0;
                start++;
                curr++;
            } else if (arr[curr] == 2) {
                arr[curr] = arr[end];
                arr[end] = 2;
                end--;
            } else {
                curr++;
            }
        }
    }

    public static void sortColors2(int[] nums) {
        int num0 = 0, num1 = 0, num2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[num2++] = 2;
                nums[num1++] = 1;
                nums[num0++] = 0;
            } else if (nums[i] == 1) {
                nums[num2++] = 2;
                nums[num1++] = 1;
            } else {
                nums[num2++] = 2;
            }
        }
    }

    public static void sortColor3(int[] nums) {
        int a = 0, b = 0, c = 0;
        for (int num : nums) {
            if (num == 0) a++;
            else if (num == 1) b++;
            else if (num == 2) c++;
        }

        int i = 0;
        for (int j = 0; j < a; j++) nums[i++] = 0;
        for (int j = 0; j < b; j++) nums[i++] = 1;
        for (int j = 0; j < c; j++) nums[i++] = 2;
    }

    public void sortColors3(int[] nums) {
        int red = 0, white = 0, blue = 0;
        for (int num : nums) {
            if (num == 0) red++;
            else if (num == 1) white++;
            else if (num == 2) blue++;
        }

        int i = 0;
        for (int j = 0; j < red; j++) nums[i++] = 0;
        for (int j = 0; j < white; j++) nums[i++] = 1;
        for (int j = 0; j < blue; j++) nums[i++] = 2;
    }

    public void sortColors4(int[] nums) {
        int a = 0, b = 0, c = 0;
        for(int n: nums) {
            if(n == 0) a++;
            else if(n == 1) b++;
            else if(n == 2) c++;
        }

        int i = 0;
        for(int j = 0; j < a; j++) nums[i++] = 0;
        for(int j = 0; j < b; j++) nums[i++] = 1;
        for(int j = 0; j < c; j++) nums[i++] = 2;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,0,2,1,1,0};
//        sortColors(arr);
        sortColors2(arr);
        for (int i : arr) {
            System.out.println("i = " + i);
        }
    }
}
