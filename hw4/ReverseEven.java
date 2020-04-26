
import java.io.IOException;
import java.util.Scanner;
public class ReverseEven {
	
    public static int[] reverseL(int[] a, int j) {
        int[] res = new int[j];
        for (int i = j - 1; i >= 0; i--) {
            res[res.length - i - 1] = a[i];
        }
        return res;
    }

    public static void main(String[] args) {
        try {
            MyScanner scan = new MyScanner(System.in);
			try {
                int[][] buf = new int[1_000_000][];
                int i = 0;
                int[] temp = new int[1_000_000];
                while (scan.hasNextLine()) {
                    scan.readLine();
                    MyScanner scanStr = new MyScanner(scan.returnLine());
                    int j = 0;
                    while (scanStr.hasNextInLine()) {
                        int x = scanStr.readIntegerInLine();
                        if (x % 2 == 0) {
                            temp[j++] = x;
                        }
                    }
                    buf[i++] = reverseL(temp, j);
                }
                for (int j = i - 1; j >= 0; j--) {
                    for (int k = 0; k < buf[j].length; k++) {
                        System.out.print(buf[j][k] + " ");
                    }
                    System.out.println();
                }
			} finally {
                scan.close();
			}
        } catch (IOException e) {
            System.out.println("Problems with" + " System.in" + e.getMessage());
        }
    }
}

