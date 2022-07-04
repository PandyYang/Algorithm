package com.pandy.company.bytedance;

/**
 * @author: Pandy
 * @create: 2022/7/1
 * <p>
 * 解题思路 补0，使每一个数字都是一样的长度。
 * <p>
 * 我们先假设n可以为0，故:
 * <p>
 * 对于n为1位数，0 - 9，此时n为几就返回几；
 * <p>
 * 对于n为2位数，此时给0 - 9 中前面都补一个0，变为00 01 ... 09 ... 99 增加了10^1个0，故n相应的加上新补的数个数，即 n += 10^1;
 * <p>
 * 对于n为3位数，此时给00 - 99中前面都补一个0，增加了10^2个0，故n相应变为 n += 10^2；以此类推。 ...
 * <p>
 * 结束条件就是 当前位数i满足：i * Math.pow(10, i) > k，即k包含在当前位数的序列中;
 * <p>
 * 然后通过 n / i定位到目标数字，通过n % i定位到在这个数字中的那个位置。
 **/
public class FindNthDigit {

    public static void main(String[] args) {
        FindNthDigit findNthDigit = new FindNthDigit();
        int nthDigit = findNthDigit.findNthDigit(11);
        System.out.println("nthDigit = " + nthDigit);
    }

    public int findNthDigit(int n) {
        long k = n;
        for (int i = 1; ; i++) {
            if (i * Math.pow(10, i) > k) {
                return Long.toString(k / i).charAt((int) (k % i)) - '0';
            }
            k += Math.pow(10, i);
        }
    }
}
