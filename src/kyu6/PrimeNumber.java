package kyu6;


public class PrimeNumber {
    public static boolean isPrime(int num) {
        boolean result = false;
        if (num <= 1) {
            result = false;
        }
        if (num == 2) { result = true;}
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                result = false;
                break;
            } else {
                result = true;
            }
        }
        return result;
    }
}
/*
import static java.math.BigInteger.valueOf;

class Prime {
    static boolean isPrime(int num) {
        return num > 1 && valueOf(num).isProbablePrime(10);
    }
}*/
