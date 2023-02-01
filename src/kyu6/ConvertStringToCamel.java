package kyu6;

import javax.management.openmbean.ArrayType;
import java.util.Arrays;
import java.util.List;
public class ConvertStringToCamel {
    public static String toCamelCase(String s){
        List<String> r1 = List.of(s.split("[-_]"));
        char[] b1;
        String result = r1.get(0);
        for (int i = 1; i < r1.size(); i++) {
            b1 = new char[r1.get(i).length()];
            b1 = r1.get(i).toCharArray();
            b1[0] = Character.toUpperCase(b1[0]);
            result += String.valueOf(b1);
        }
        return result;
    }
}

/* Other Solution
import java.util.Arrays;

class Solution{

    static String toCamelCase(String str){
        String[] words = str.split("[-_]");
        return Arrays.stream(words, 1, words.length)
                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
                .reduce(words[0], String::concat);
    }
}*/
