package week7;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'findMedian' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int partition(int l, int r, List<Integer> arr) {
        int i = l;
        int pivot = arr.get(r);
        for(int j = l; j < r; j++) {
            int val = arr.get(j);
            if(val < pivot) {
                arr.set(j, arr.get(i));
                arr.set(i++, val);
            }
        }
        int val = arr.get(r);
        arr.set(r, arr.get(i));
        arr.set(i, val);
        return i;
    }
    public static int findMedian(List<Integer> arr) {
        // Write your code here
        int n = arr.size();
        int k = n / 2;
        int l = 0, r = n - 1;
        while(true) {
            int pos = partition(l, r, arr);
            if(pos == k) {
                return arr.get(pos);
            }
            else if(pos < k) {
                l = pos + 1;
            }
            else {
                r = pos - 1;
            }
        }

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        int result = Result.findMedian(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
