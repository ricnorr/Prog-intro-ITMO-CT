package md2html;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class WorkWithMarkupOnSets {
    private static HashMap<String, Integer> dict;
    private static HashSet<Integer> open;
    private static HashSet<Integer> close;
    private static boolean activeSlash = false;
    private static HashMap<String,Integer> dict1;
    //private static HashSet<String> weWere = new HashSet<String>();
    public static final HashSet<String> MARK_UP;
    static {
        MARK_UP = new HashSet<String>(List.of("*", "**", "`", "__", "_", "--", "-", "++", "+"));
    }

    private static void resetMaps() {
        dict  = new HashMap<>();
        open = new HashSet<>();
        close = new HashSet<>();
    }

    private static String outTag(String in, int c) {
        switch (in) {
            case "__":
            case "**":
                return ((c == 0) ? "<strong>" : "</strong>");
            case "_":
            case "*":
                return ((c == 0) ? "<em>" : "</em>");
            case "--":
                return ((c == 0) ? "<s>" : "</s>");
            case "`":
                return ((c == 0) ? "<code>" : "</code>");
            case "++":
                return ((c == 0) ? "<u>" : "</u>");
        }
        return null;
    }

    static String extraSymbols(char x) {
        switch (x) {
            case '<':
                return "&lt;";
            case '>':
                return "&gt;";
            case '&':
                return "&amp;";
            default:
                return Character.toString(x);
        }
    }

    static void checkInSymbols1(StringBuilder in) {
        resetMaps();
        for (int i = 0; i < in.length(); i++) {
            if (in.charAt(i) == '\\') {
                activeSlash = true;
            }
            if (!activeSlash && MARK_UP.contains(Character.toString(in.charAt(i)))) {
                String mark = getMarkSubstring(in,i);
                if (mark == null) {
                    return;
                }
                Integer mapValue = dict.get(mark);
                if (mapValue == null) { //and previous is not a slash
                    dict.put(mark, i);
                } else {
                    open.add(mapValue);
                    dict.put(mark, null);
                    close.add(i);
                }
                i += mark.length() -1;
                activeSlash = false;
            }
        }
    }

    private static String getMarkSubstring(StringBuilder in, int c) {
        return ((c + 1 < in.length() && in.charAt(c) == in.charAt(c + 1))
                ? new String(new char[] {in.charAt(c), in.charAt(c + 1)})
                : Character.toString(in.charAt(c))
        );
    }

    static StringBuilder walkThrough1(StringBuilder in) {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < in.length(); i++) {
            if (MARK_UP.contains(Character.toString(in.charAt(i))) && !activeSlash) {
                String temp = getMarkSubstring(in, i);
                int sdv = temp.length();
                if (open.contains(i)) {
                    out.append(outTag(temp.toString(), 0));
                }
                else if (close.contains(i)) {
                    out.append(outTag(temp.toString(),1));
                } else {
                    out.append(in.charAt(i));
                }
                i += sdv - 1;
            } else {
                if (in.charAt(i) == '\\') {
                    activeSlash = true;
                } else {
                    out.append(in.charAt(i));
                    activeSlash = false;
                }
            }
        }
        return out;
    }
    public static void main(String[] args) {

    }
}
