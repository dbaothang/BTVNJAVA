package week9;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'closestNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    public static void mergeSort(List<Integer> nums, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(nums, l, m);
            mergeSort(nums, m + 1, r);
            merge(nums, l, m, r);
        }
    }

    public static void merge(List<Integer> nums, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = nums.get(l+i);
        }
        for (int j = 0; j < n2; j++) {
            R[j] = nums.get(m + 1 + j);
        }

        int i = 0, j = 0;
        int k = l;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                nums.set(k, L[i]);
                i++;
            } else {
                nums.set(k, R[j]);
                j++;
            }
            k++;
        }

        while (i < n1) {
            nums.set(k, L[i]);
            i++;
            k++;
        }

        while (j < n2) {
            nums.set(k, R[j]);
            j++;
            k++;
        }
    }

    public static List<Integer> closestNumbers(List<Integer> arr) {

        // Write your code here
        int n = arr.size();
        mergeSort(arr,0,n-1);
        if (arr == null || arr.size() < 2) {
            return new ArrayList<Integer>();
        }

        int minDifference = Integer.MAX_VALUE;
        List<Integer> result = new ArrayList<Integer>();

        for (int i = 1; i < arr.size(); i++) {
            int currentDifference = Math.abs(arr.get(i) - arr.get(i - 1));

            if (currentDifference < minDifference) {
                minDifference = currentDifference;
                result.clear();
                result.add(arr.get(i - 1));
                result.add(arr.get(i));
            } else if (currentDifference == minDifference) {
                result.add(arr.get(i - 1));
                result.add(arr.get(i));
            }
        }

        return result;

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

        List<Integer> result = Result.closestNumbers(arr);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

