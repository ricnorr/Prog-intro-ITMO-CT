import java.util.*;
import java.io.IOException;

public class ReverseTranspose {

    public static void outMatr(List<List<Integer>> buf) {
        for (List<Integer> line: buf) {
            for (Integer i : line) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        try {
            MyScanner scan = new MyScanner(System.in);
            try {
                List<List<Integer>> buf = new ArrayList<>();
                while (scan.hasNextLine()) {
                    scan.readLine();
                    int howManyInLine = 0;
                    while (scan.hasNextInLine()) {
                        if (howManyInLine >= buf.size()) {
                            buf.add(new ArrayList<Integer>());
                        }
                        int x = scan.readIntegerInLine();
                        buf.get(howManyInLine++).add(x);
                    }
                }
                outMatr(buf);
            } finally {
                scan.close();
            }
        } catch (IOException e) {
            System.out.println("Problems with" + " System.in" + e.getMessage());
        }
    }
}
