package com.pandy.huawei.three;

public class A605_CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length && n > 0; i++) {
            if (flowerbed[i] == 0) {
                boolean emptyBefore = (i == 0 || (flowerbed[i-1] == 0));
                boolean emptyAfter = (i == flowerbed.length - 1 || (flowerbed[i+1] == 0));

                if (emptyAfter && emptyBefore) {
                    flowerbed[i] = 1;
                    n--;
                }
            }
        }
        return n <= 0;
    }
}
