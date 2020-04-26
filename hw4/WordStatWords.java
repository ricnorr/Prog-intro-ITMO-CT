
import java.io.*;
import java.util.*;
public class WordStatWords {

    public static String[] words = new String[1_000_000];
    public static int size = 0;
    public static int[] times = new int[1_000_000];

    public static void checkInWords(String s) {
		if (s == null) {
            return;
        }
		s = s.toLowerCase();
        int i = 0;
        while (i < size && !words[i].equals(s)) {
            i++;
        }
        if (i == size) {
            words[i] = s;
            size++;
        }
        times[i]++;
    }

    public static void outfile(String where) {
        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(where)), "utf8"));
            try {
                for (int i = 0; i < size; i++) {
                    writer.write(words[i] + " " + times[i]);
                    writer.newLine();
                    //words[i] = null;
                    //times[i] = 0;
                }
            } finally {
                writer.close();
				//size = 0;
            }
        } catch (IOException e) {
            System.out.println("Something went wrong" + e.getMessage());
        }
    }

    public static void sortArrs() {
        for (int i = size - 1; i >= 1; i--) {
            for (int j = 0; j <= i -1; j++) {
                int d = words[j].compareTo(words[j+1]);
                if (words[j].compareTo(words[j+1]) > 0) {
                    String tempStr = words[j];
                    int tempInt = times[j];
                    words[j] = words[j+1];
                    times[j] = times[j+1];
                    words[j+1] = tempStr;
                    times[j+1] =  tempInt;
                }
            }
        }
    }

    public static void connectRead(String inp, String encoding) throws IOException {
		MyScanner fileScan = new MyScanner(inp, encoding);
		try {
			while (fileScan.hasNextLine()) {
				fileScan.readLine();
				while (fileScan.hasNextInLine()) {
					checkInWords(fileScan.readWordFromLine());
				}
			}
		} finally {
			fileScan.close();
		}	
		
    }

    public static void main(String[] args) {
		try {
           connectRead(args[0], "utf8");
           sortArrs();
           outfile(args[1]);
           outfile(args[2]);
		} catch (IOException e) {
		    System.out.println("Problems with" + " file" + e.getMessage());
		}
    }
}