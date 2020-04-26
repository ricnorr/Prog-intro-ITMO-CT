
import java.io.*;
import java.util.*;
public class WordStatIndex {

    public static void checkInWords(String s, Map<String, List<Integer>> dict, int place) {
        if (s == null) {
            return;
        }
        if (dict.containsKey(s)) {
            List<Integer> list = dict.get(s);
            list.add(place);
            int temp = list.get(0);
            list.set(0, list.get(0)+1); 
        } else {
            dict.put(s, new ArrayList<Integer>());
            List<Integer> list = dict.get(s); 
            list.add(1);
            list.add(place);
        }
    }

    public static void outfile(String where, Map<String, List<Integer>> dict) {
        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(where)), "utf8"));
            try {
                for (Map.Entry<String, List<Integer>> entry: dict.entrySet()) {
                    writer.write(entry.getKey());
                    for (Integer x: entry.getValue()) {
                        writer.write(" " + x);
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

    public static void connectRead(String inp, String encoding, Map<String,List<Integer>> dict)  throws UnsupportedEncodingException, FileNotFoundException, IOException {
        MyScanner fileScan = new MyScanner(inp, encoding);
        try {
            int countWords = 1; 
            while (fileScan.hasNextLine()) {
                fileScan.readLine();
                while (strScan.hasNextInLine()) {
                    checkInWords(fileScan.readWordFromLine().toLowerCase(), dict, countWords++); 
                }
            }
        } finally {
            fileScan.close();
        }
    }

    public static void main(String[] args) {
        Map<String, List<Integer>> dict = new LinkedHashMap<>(); 
        try {
            connectRead(args[0], "utf8", dict);
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









