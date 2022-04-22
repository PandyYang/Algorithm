package com.pandy.base.sort;

/**
 * @Author Pandy
 * @Date 2021/7/22 23:52
 *
 * 希尔排序 - 插入排序的改进版。为了减少数据的移动次数，在初始序列较大时取较大的步长，
 * 通常取序列长度的一半，此时只有两个元素比较，交换一次；之后步长依次减半直至步长为1，
 * 即为插入排序，由于此时序列已接近有序，故插入元素时数据移动的次数会相对较少，效率得到了提高。
 */
public class ShellSort {
    public static void shell(int[] arr) {
        int len = arr.length;
        int temp;
        for(int step = len/2; step >= 1; step /= 2) {
            for (int i = step; i < len; i++) {
                temp = arr[i];
                int j = i - step;
                while (j >= 0 && arr[j] > temp) {
                    arr[j+step] = arr[j];
                    j -= step;
                }
                arr[j+step] = temp;
            }
        }
    }

    void shellSort(int arr[]){
        int d = arr.length >> 1;
        while(d >= 1){
            for(int i = d; i < arr.length; i++){
                int rt = arr[i];
                for(int j = i - d; j >= 0; j -= d){
                    if(rt < arr[j]){
                        arr[j + d] = arr[j];
                        arr[j] = rt;
                    }else break;
                }
            }
            d >>= 1;
        }
    }
}
