package kyu6;

public class StringSplit {
    public static String[] solution(String s) {
        String[] result = {};
        int count = 0;
        if (s.length() % 2 == 0) {
            result = new String[s.length() / 2];
            for (int i = 0; i < result.length; i++) {
                result[i] = ("" + s.charAt(count) + s.charAt(count + 1));
                count+= 2;
            }
        }
        if (s.length() % 2 != 0) {
            result = new String[(s.length() / 2) + 1];
            for (int i = 0; i < result.length - 1; i++) {
                result[i] = ("" + s.charAt(count) + s.charAt(count + 1));
                count+= 2;
            }
            result[result.length - 1] = ("" + s.charAt(s.length() - 1) + "_");
        }
        return result;
    }
}

/*
public class StringSplit {
    public static String[] solution(String s) {
        s = (s.length() % 2 == 0)?s:s+"_";
        return s.split("(?<=\\G.{2})");
    }
}
*/
