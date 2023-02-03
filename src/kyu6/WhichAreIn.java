package kyu6;

import java.util.ArrayList;
import java.util.List;

public class WhichAreIn {

    public static String[] inArray(String[] array1, String[] array2) {
        List<String> listRes = new ArrayList<>();
        String[] result;
        for (int i = 0; i < array1.length; i++) {
            for (String strings : array2) {
                if (strings.contains(array1[i])){
                    listRes.add(array1[i]);
                }
            }
        }
        listRes = listRes.stream().distinct().sorted().toList();
        result = new String[listRes.size()];
        for (int i = 0; i < listRes.size(); i++){
            result[i] = listRes.get(i);
        }
        return result;
    }
}
