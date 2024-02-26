package com.pandy.base.array.package01;

/**
 * 长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内,这样一来,本来这个数组就可以作为一个哈希表,但是其中有某几个元素捣乱了.
 * 那么，对于这个乱序的数组，从头开始遍历，每当遍历到一个数字 nums[i] ,如果他不等于i, (也就是他并不在自己应该在的哈希表的位置).
 * 我们就把他放到应该在的位置去,也就是把他和 nums[nums[i]] 进行交换．
 * 只要一直这么换换换…就一定会发生一个情况,就是要交换的这两个数字是一样的.因为有重复,当别的错位元素都回归自己本该在的位置时,
 * 重复元素肯定会被剩下来.此时我们就将他返回,就是我们要的答案.
 */

public class FindRepeatNumber {
    public int findRepeatNumber(int [] nums){
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if(nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                swap(nums, nums[i], nums[temp]);
            }
        }
        return -1;
    }

    public void swap(int []nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    public static void main(String[] args) {

    }
}
