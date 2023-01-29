package kyu7;

import java.util.Arrays;

public class RowSumOddNumbers {
    public static int rowSumOddNumbers(int n) {
        int num1 = (n * (n - 1)) + 1 ;
        int num2 = num1;
        if (n == 1) return n;
        for (int i = 1; i < n; i++){
            num1+= 2;
            num2 += num1;
        }
        return num2;
    }
/*    public static int rowSumOddNumbers(int n) {
        return n * n * n;
    }*/
}

