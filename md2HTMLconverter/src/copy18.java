import java.io.*;

public class copy18 {
    /*
    private static boolean flagNew = true;
    private static String turnToBase;
    private static StringBuilder base;
    private static BufferedWriter writer;
    private static boolean justStartPar;
    public static void wrap(BufferedReader reader, BufferedWriter writer, char end, Integer pointer) throws IOException { //на title и на параграф
        while (true) { //пока что я не умею бахать пробелы в одном параграфе
            if (turnToBase == null) { //конец файла
                return;
            }
            else if (turnToBase.isEmpty()) { //пустая строка
                if (flagNew == false) {
                    flagNew = true;
                    return;
                } else {
                    turnToBase = reader.readLine();
                    base.append("\n");
                }
            }
            else if (pointer >= turnToBase.length()) { //закончилось место
                turnToBase = reader.readLine();
                pointer = 0;
            }
            else if (pointer == 0 && turnToBase.charAt(0) == '#' && flagNew) {
                flagNew = false;
                int temp = 0;
                while (pointer < turnToBase.length() && turnToBase.charAt(pointer) == '#') {
                    pointer++;
                    temp++;
                }
                base.append("<h").append(temp).append(">");
                wrap(reader, writer, '\n', pointer);
                base.append("</h").append(temp).append(">");
                writer.write(base.toString());
                writer.newLine();
                base = new StringBuilder();
                turnToBase = reader.readLine();
                pointer = 0;
            }
            else if (pointer == 0 && flagNew == true) {
                flagNew = false;
                justStartPar = true;
                base.append("<p>");
                wrap(reader,writer, '\n', pointer);
                base.append("</p>");
                writer.write(base.toString());
                writer.newLine();
            } else {
                base.append(turnToBase.charAt(pointer));
                pointer++;
            }
        }
    }
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt")),
                    "utf8")
            );
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("output.txt")),"utf8"));
            base = new StringBuilder();
            turnToBase = new String();
            int pointer = 0;
            turnToBase = reader.readLine();
            wrap(reader, writer, '\n', pointer);
            writer.close();
        } catch (FileNotFoundException e) {
        } catch (UnsupportedEncodingException e) {
        } catch (IOException e) {
        }
    } */
}
