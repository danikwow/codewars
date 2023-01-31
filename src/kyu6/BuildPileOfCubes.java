package kyu6;

public class BuildPileOfCubes {
    public static long findNb(long m) {
        long volume = 0;
        long result = 0;
        while(volume < m){
            result++;
            volume += result * result * result;
    }
        return (volume == m) ? result : -1;
    }
}
