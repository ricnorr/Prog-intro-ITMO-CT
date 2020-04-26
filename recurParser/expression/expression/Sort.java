package expression;

import java.util.Random;

public class Sort {

    public static int[] quickSort(int[] arr, int[] players, int l, int r) {
        if (r > l) {
            int m = split(arr, players, l, r);
            quickSort(arr, players, l, m - 1);
            quickSort(arr, players, m + 1, r);
        }
        return arr;
    }

    private static int split(int[] arr, int[] players, int l, int r) {
        Random random = new Random();
        int x = random.nextInt(r-l);
        int pivot = arr[l + x];
        int pivotNum = l + x;
        for(int i = l; i <= r; i++) {
            if(arr[i] < pivot) {
                int temp = arr[l];
                int temp1 = players[l];
                arr[l] = arr[i];
                players[l] = players[i];
                arr[i] = temp;
                players[i] = temp1;
                l++;
            }
        }
        int temp1 = arr[l];
        int temp2 = players[l];
        arr[l] = pivot;
        players[l] = pivotNum;
        arr[pivotNum] = temp1;
        players[pivotNum] = temp2;
        return l;
    }
}
