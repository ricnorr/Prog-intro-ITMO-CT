
import java.io.*;
import java.util.*;

public class MyScanner {
    private BufferedReader worker;
    private String currentLine;
    private String nextString;
    private int pointer;

    public MyScanner (InputStream in) throws IOException {
        this.worker = new BufferedReader(new InputStreamReader(in));
        this.nextString = worker.readLine();
    }

    public MyScanner (String filename, String encoding) throws UnsupportedEncodingException, FileNotFoundException, IOException {
        this.worker = new BufferedReader(new InputStreamReader(new FileInputStream(new File(filename)), encoding));
        this.nextString = worker.readLine();
    }

    public MyScanner(String currentLine) {
        this.currentLine = currentLine;
    }

    public boolean hasNextInLine() {
        return pointer < currentLine.length();
    }

    public void close() throws IOException {
        if (worker != null) {
            worker.close();
        }
    }

    public int readIntegerInLine() throws NumberFormatException {
        skipSpaceNumber();
        int left = pointer;
        while (hasNextInLine() && !Character.isWhitespace(currentLine.charAt(pointer))) {
            pointer++;
        }
        return Integer.parseInt(currentLine.substring(left, pointer));
    }

    public boolean continueReadingWord() {
        return Character.isLetter(currentLine.charAt(pointer))
                || Character.getType(currentLine.charAt(pointer)) == Character.DASH_PUNCTUATION
                || currentLine.charAt(pointer) == '\'';
    }

    private void skipSpaceNumber() {
        while (pointer < currentLine.length() && Character.isWhitespace(currentLine.charAt(pointer))) {
            pointer++;
        }
    }

    public boolean hasNextLine() {
        return nextString != null;
    }

    private void skipSpaceWord() {
        while (pointer < currentLine.length() && !continueReadingWord()) {
            pointer++;
        }
    }

    public String readWordFromLine() {
        skipSpaceWord();
        int left = pointer;
        while (hasNextInLine() && continueReadingWord()) {
            pointer++;
        }
        if (left == pointer) { 
            return null; 
        }
        return currentLine.substring(left, pointer);
    }

    public void readLine() throws IOException {
        currentLine = nextString;
        nextString = worker.readLine();
		pointer = 0;
    }


}
