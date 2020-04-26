
package md2html;

import java.io.*;

public class Md2Html {

    private static void initStructure(StringBuilder line, BufferedWriter writer) throws IOException {
        int pointer = 0;
        while (pointer < line.length() && line.charAt(pointer) == '#') {
            pointer++;
        }

        String tag;
        if (pointer != 0 && pointer < line.length() && line.charAt(pointer) == ' ') {
            tag = "h" + pointer++;
        } else {
            tag = "p";
            pointer = 0;
        }

        ParseMarkup parser = new ParseMarkup(line);
        line = parser.walkThrough(pointer, parser.checkInSymbols(pointer));
        writer.write("<" + tag + ">");
        writer.write(line.toString());
        writer.write("</" + tag + ">");
        writer.newLine();
    }

    private static void wrap(BufferedReader reader, BufferedWriter writer) throws IOException {
        while (true) {
            String line = reader.readLine();
            if (line == null) {
                return;
            }
            if (line.isBlank()) {
                continue;
            }
            StringBuilder paragraph = new StringBuilder();
            while (line != null && !line.isBlank()) {
                paragraph.append(line).append('\n');
                line = reader.readLine();
            }
            initStructure(paragraph, writer);
        }
    }


    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(args[0])),"utf8"));
            try {
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(args[1])), "utf8"));
                try {
                    wrap(reader, writer);
                } finally {
                    writer.close();
                }
            } finally {
                reader.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (UnsupportedEncodingException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

