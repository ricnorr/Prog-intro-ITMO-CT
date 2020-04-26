
import java.io.*;
import java.util.*;

public class WordStatLineIndex {

    public static void checkInWords(String s, Map<String, List<MyPair>> dict, int place, int line ) {
        if (s == null) {
            return;
        }
		s = s.toLowerCase();
		List<MyPair> temp = dict.get(s);
		if (temp == null) {
			temp = new ArrayList<MyPair>();
		    dict.put(s, temp);
		}
		temp.add(new MyPair(line,place));
    }

    public static void outfile(String where, Map<String, List<MyPair>> dict) {
        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(where)), "utf8"));
            try {
                for (Map.Entry<String, List<MyPair>> entry: dict.entrySet()) {
                    writer.write(entry.getKey() + " " + entry.getValue().size());
                    for (MyPair x: entry.getValue()) {
                        writer.write(" " + x.getFirst() + ":" + x.getSecond());
                    }
                    writer.newLine();
                }
            } finally {
                writer.close();
            }
        } catch (IOException e) {
            System.out.println("Something went wrong" + e.getMessage());
        }
    }

    public static Map<String, List<MyPair>> connectRead(String inp, String encoding) 
	        throws UnsupportedEncodingException, FileNotFoundException, IOException {
        Map<String, List<MyPair>> dict = new TreeMap<>();
        MyScanner fileScan = new MyScanner(inp, encoding);
        try {
            int countLines = 0;
            while (fileScan.hasNextLine()) {
				countLines++;
                int countWords = 1;
                fileScan.readLine();
                while (fileScan.hasNextInLine()) {
                    checkInWords(fileScan.readWordFromLine(), dict, countWords++, countLines);
                }
            }			
			
            return dict;
        } finally {
            fileScan.close();
        }
    }

    public static void main(String[] args) {
        try {
            Map<String, List<MyPair>> dict = connectRead(args[0], "utf8");
            outfile(args[1], dict);
        } catch (UnsupportedEncodingException e) {
            System.out.println(e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
