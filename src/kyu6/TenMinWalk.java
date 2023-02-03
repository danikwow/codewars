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
/*

import java.awt.Point;

public class TenMinWalk {
    public static boolean isValid(char[] walk) {
        Point point = new Point(0,0);
        for (char c : walk) {
            switch (c) {
                case 'n': point.translate(1,0); break;
                case 'e': point.translate(0,1); break;
                case 's': point.translate(-1,0); break;
                case 'w': point.translate(0,-1); break;
            }
        }
        return point.equals(new Point(0,0)) && walk.length == 10;
    }
}*/
