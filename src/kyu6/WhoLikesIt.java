package kyu6;

import java.util.List;

class WhoLikesIt {
    public static String whoLikesIt(String... names) {
        List<String> peopleName = List.of(names);
        int length = peopleName.size();
        String result = "";
        if (length == 0) return "no one likes this";
        if (length == 1) {
            result = peopleName.get(0) + " likes this";
        }
        if (length == 2){
            result = peopleName.get(0) + " and " + peopleName.get(1) + " like this";
            return result;
        }
        if (length == 3){
            result = peopleName.get(0) + ", " + peopleName.get(1) + " and "+ peopleName.get(2) +" like this";
            return result;
        }
        if (length > 3){
            result += peopleName.get(0)
                    + ", " + peopleName.get(1)
                    + " and " + Integer.toString(length - 2)
                    + " others like this";
            return result;
        }
        return result;
    }
}
/* Other version
    public static String whoLikesIt(String... names) {
        final String Template1 = "%s likes this";
        final String Template2 = "%s and %s like this";
        final String Template3 = "%s, %s and %s like this";
        final String TemplateN = "%s, %s and %d others like this";
        return
                names.length == 0 ? "no one likes this" :
                names.length == 1 ? String.format(Template1, names[0]) :
                names.length == 2 ? String.format(Template2, names[0], names[1]) :
                names.length == 3 ? String.format(Template3, names[0], names[1], names[2]) :
                String.format(TemplateN, names[0], names[1], names.length-2);
*/

/*
    public static String whoLikesIt(String... nms) {
        switch (nms.length) {
          case 0: return "no one likes this";
          case 1: return String.format("%s likes this", nms[0]);
          case 2: return String.format("%s and %s like this", nms[0], nms[1]);
          case 3: return String.format("%s, %s and %s like this", nms[0], nms[1], nms[2]);
          default: return String.format("%s, %s and %d others like this", nms[0], nms[1], nms.length - 2);
        }
    }
    }
*/
