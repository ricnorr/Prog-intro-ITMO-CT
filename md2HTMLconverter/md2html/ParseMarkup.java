
package md2html;

import java.util.*;

class ParseMarkup {
    private StringBuilder inputLine;
    private static final Map<String, String> TAGS = Map.of(
            "__", "strong",
            "**", "strong",
            "_", "em",
            "*", "em",
            "--", "s",
            "`", "code",
            "++", "u"
    );

    private static final Map<Character, String> EXTRA_SYMB = Map.of(
            '<', "&lt;",
            '>', "&gt;",
            '&', "&amp;"
    );

    ParseMarkup (StringBuilder inputLine) {
        this.inputLine = inputLine;
    }

    private String charToHtml(char x) {
        return EXTRA_SYMB.getOrDefault(x , Character.toString(x));
    }

    public Map<String, Integer> checkInSymbols(int i) {
        Map<String, Integer> oddEvenStat = new HashMap<>();
        while (i < inputLine.length() - 1) {
            if (inputLine.charAt(i) == '\\') {
                i += 2;
                continue;
            }
            String mark = getMarkSubstring(i);
            if (TAGS.containsKey(mark)) {
                oddEvenStat.put(mark, oddEvenStat.getOrDefault(mark, 0) + 1);
                i += mark.length() - 1;
            } else {
                i++;
            }
        }
        return oddEvenStat;
    }

    private String getMarkSubstring(int c) {
        String result = String.valueOf(inputLine.charAt(c));
        return c + 1 < inputLine.length() && inputLine.charAt(c) == inputLine.charAt(c + 1)
                ? result + inputLine.charAt(c+1)
                : result;
    }
    
   StringBuilder walkThrough(int start, Map<String, Integer> oddEvenStat) {
        Set<String> wasOpened = new HashSet<>();
        StringBuilder out = new StringBuilder();
        for (int i = start; i < inputLine.length() - 1; i++) {
            String temp = getMarkSubstring(i);
            String tag = TAGS.get(temp);
            if (tag != null) {
                int markDict = oddEvenStat.get(temp);
                StringBuilder open = new StringBuilder("<");
                if (markDict % 2 == 1) {
                    open.append("/");
                }
                if (markDict != 1 || wasOpened.contains(temp)) {
                    out.append(open).append(tag).append(">");
                    wasOpened.add(temp);
                } else {
                    out.append(temp);
                }
                oddEvenStat.put(temp, markDict - 1);
                i += temp.length() - 1;
            } else {
                if (inputLine.charAt(i) == '\\') {
                    i++;
                }
                if (i < inputLine.length()) {
                    out.append(charToHtml(inputLine.charAt(i)));
                }
            }
        }
        return out;
    }

}

