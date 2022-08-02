package com.pandy.base.array;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinmumNumberOfHost {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 计算成功举办活动需要多少名主持人
     *
     * @param n        int整型 有n个活动
     * @param startEnd int整型二维数组 startEnd[i][0]用于表示第i个活动的开始时间，startEnd[i][1]表示第i个活动的结束时间
     * @return int整型
     */
    public int minmumNumberOfHost(int n, int[][] startEnd) {
        Arrays.sort(startEnd, (o1, o2) -> {
            return o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1];
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();     // 用于存储刚结束活动的end时间
        pq.offer(startEnd[0][1]);

        for (int i = 1; i < n; i++) {
            if (startEnd[i][0] >= pq.peek()) {
                // 有空闲不需要增加主持人，当前主持人可以紧接着干下一个活
                pq.poll();                     // 把上一个活出队，当前活会入队
            }
            pq.offer(startEnd[i][1]);      // 如果跟上一个活时间重叠，就直接入队
        }

        return pq.size();  // 队列中积压的元素数量就是需要的主持人数
    }
}
