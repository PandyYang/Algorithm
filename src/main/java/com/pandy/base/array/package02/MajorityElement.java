package com.pandy.base.array.package02;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Pandy
 * @create: 2022/2/26
 * <p>
 * 寻找众数
 * <p>
 * 解法1： hashmap
 * 一个大小为n的数组，找到其中的多数元素，多数元素是指在数组中出现次数大于n/2的元素。
 * Map遍历所有元素出现次数 找出最大的即可
 * <p>
 * 解法2：投票算法
 * 这段代码使用了一种称为摩尔投票算法（Boyer-Moore Voting Algorithm）的方法来找到数组中出现次数超过一半的主要元素。其基本思想是遍历数组，通过两两抵消相同元素和不同元素的数量，最终剩下的必然是主要元素。
 *
 * 在这个算法中，`count` 记录的是候选主要元素的出现次数。当遇到相同的元素时，`count` 加一；当遇到不同的元素时，`count` 减一。最终，如果数组中的主要元素出现次数超过一半，那么经过抵消后，`count` 一定会大于 0。
 *
 * 这是因为主要元素的出现次数超过了数组长度的一半，所以在数组中，主要元素出现的次数会比其他任何元素都要多。在摩尔投票算法中，每当遇到不同的元素时，就会将候选主要元素的计数抵消掉一个，但是由于主要元素出现次数超过了一半，所以抵消过程中候选主要元素的计数不会被完全抵消为 0，最终会剩余一定数量的计数。因此，在算法执行结束时，`count` 会大于 0，表示候选主要元素的出现次数超过了一半。
 *
 * 综上所述，出现 `count` 大于 0 的情况是因为算法保证了主要元素的出现次数超过一半，使得在遍历结束后，候选主要元素的计数不会被完全抵消为 0，而是会剩余一定数量的计数，从而使得 `count` 大于 0。
 **/
public class MajorityElement {
    public static int majority2(int[] nums) {
        int count = 1;
        int majority = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                majority = nums[i];
            }
            if (nums[i] == majority) {
                count++;
            } else {
                count--;
            }
        }
        return majority;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5};
        int i = majority2(arr);
        System.out.println("i = " + i);
    }

    public int majority(int[] nums) {
        HashMap<Integer, Integer> keyVal = new HashMap<>();
        for (int num : nums) {
            if (keyVal.containsKey(num)) {
                keyVal.put(num, keyVal.get(num) + 1);
            } else {
                keyVal.put(num, 1);
            }
        }

        int max = Integer.MIN_VALUE;
        int key = 0;
        for (Map.Entry<Integer, Integer> entry : keyVal.entrySet()) {
            if (entry.getKey() > max) {
                max = entry.getValue();
                key = entry.getKey();
            }
        }
        return key;
    }
}
