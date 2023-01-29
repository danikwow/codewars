package kyu6;

public class DigitalRoot {
    public static int digital_root(final int n) {
        int[] arrayNum = convertNumToNumArray(n);
        int result = 0;
        int lng;
        for (int i = 0; i < arrayNum.length; i++){
            result += arrayNum[i] ;
        }
        lng = String.valueOf(result).length();
        return (lng != 1) ? digital_root(result) : result;
    }

    public static int[] convertNumToNumArray(final int n){
        int num = n;
        int lenght1 = String.valueOf(num).length();
        int[] result = new int[lenght1];
        for (int i = lenght1 - 1; i > -1; i--){
            result[i] = num % 10;
            num /= 10;
        }
        return result;
    }
}
