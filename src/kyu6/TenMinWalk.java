package kyu6;

public class TenMinWalk {
    public static boolean isValid(char[] walk) {
            int x = 0, y = 0;
            int count = 0;
            for (int i = 0; i < walk.length; i++){
                count++;
            switch (walk[i]) {
                case 's' -> y--;
                case 'n' -> y++;
                case 'w' -> x--;
                case 'e' -> x++;
                }
            }
        return (x == 0 && y == 0 && count == 10);
    }
}