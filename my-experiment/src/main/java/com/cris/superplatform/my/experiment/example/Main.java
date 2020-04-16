package com.cris.superplatform.my.experiment.example;

/**
 * Mian
 *
 * @author cris.zhu
 * @date 2019/12/1
 */
public class Main {
    public static <T> void main(String[] args) {
        int[] array = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        int i = 0;
        int len = array.length;
        myMinHeapSort(array);
        for (i = 0; i < len; i++) {
            System.out.println(array[i] + " ");
        }
    }

    public static void adjustMinHeap(int[] a, int pos, int len) {
        int temp;
        int child;
        for (temp = a[pos]; 2 * pos + 1 <= len; pos = child) {
            child = 2 * pos + 1;
            if (child < len && a[child] > a[child + 1]) {
                child++;
            }
            if (a[child] < temp) {
                a[pos] = a[child];
            } else {
                break;
            }
        }
        a[pos] = temp;
    }

    public static void myMinHeapSort(int[] array) {
        int i;
        int len = array.length;
        for (i = len / 2 - 1; i >= 0; i--) {
            adjustMinHeap(array, i, len - 1);
        }
        for (i = len - 1; i >= 0; i--) {
            int tmp = array[0];
            array[0] = array[i];
            array[i] = tmp;
            adjustMinHeap(array, 0, i - 1);
        }
    }
}