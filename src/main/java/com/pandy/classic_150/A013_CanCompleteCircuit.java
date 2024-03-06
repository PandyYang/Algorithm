package com.pandy.classic_150;

public class A013_CanCompleteCircuit {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int totalTank = 0; // 总油箱剩余汽油量
        int currTank = 0;  // 当前油箱剩余汽油量
        int startStation = 0; // 起点加油站编号

        for (int i = 0; i < n; i++) {
            totalTank += gas[i] - cost[i]; // 计算总剩余汽油量
            currTank += gas[i] - cost[i]; // 更新当前油箱剩余汽油量

            // 如果当前油箱剩余汽油量小于 0，说明无法从当前加油站出发，更新起点加油站为下一个加油站，并将当前油箱剩余汽油量清零
            if (currTank < 0) {
                startStation = i + 1;
                currTank = 0;
            }
        }

        // 如果总剩余汽油量小于 0，则说明无法绕环路行驶一周，返回 -1；否则返回起点加油站的编号
        return totalTank >= 0 ? startStation : -1;
    }

}
