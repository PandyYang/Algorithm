package com.pandy.base.array.package02;

class Search {
    public boolean search(int[] nums, int target) {
        if (nums.length == 0) return false;
        if (nums.length == 1) return nums[0] == target;
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return true;
            if (nums[left] < nums[mid]){ //如果左侧有序
                if (nums[left] <= target && target < nums[mid]) right = mid - 1;
                else left = mid + 1;
            }else if (nums[right] > nums[mid]){ //如果右侧有序
                if (nums[mid] < target && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            }
            else{ //如果与mid值相等，两边向中间压缩
                while(left <= right && nums[left] == nums[mid]) left++;
                while(left <= right && nums[right] == nums[mid]) right--;
            }
        }
        return false;
    }
}
