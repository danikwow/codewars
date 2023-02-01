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