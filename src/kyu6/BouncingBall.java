package kyu6;

public class BouncingBall {

    public static int bouncingBall(double h, double bounce, double window) {
        if (h <= 0 || bounce <= 0 || bounce >= 1 || window >= h) return -1;
        double height = h;
            int counter = 1;
            do {
                height = height * bounce;
                if (height > window) counter += 2;
            } while (height > window);
        return counter;
    }
}