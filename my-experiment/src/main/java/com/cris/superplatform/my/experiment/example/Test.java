package com.cris.superplatform.my.experiment.example;

public class Test {
    public static int findNotDouble(int a[]) {
        int n = a.length;
        int result = a[0];
        int i;
        for (i = 1; i < n; ++i) {
            int temp = a[i];
            int temp2 = result ^ temp;
            result = temp2;
        }
        return result;
    }

    public static void main(String[] args) {
        int array[] = {1, 2, 3, 2, 4, 3, 5, 4, 1};
        int num = findNotDouble(array);
        System.out.println(num);
    }
}
