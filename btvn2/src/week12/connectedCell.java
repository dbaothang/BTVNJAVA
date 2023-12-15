package week12;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'connectedCell' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY matrix as parameter.
     */

    public static int connectedCell(List<List<Integer>> matrix) {
        int maxx = 0;
        for (int i = 0; i < matrix.size(); i++)
            for (int j = 0; j < matrix.get(i).size(); j++)
                if (matrix.get(i).get(j) == 1) maxx = Math.max(maxx, DFS(matrix, i, j));
        return maxx;
    }

    public static int DFS(List<List<Integer>> matrix, int i, int j) {
        if (i < 0 || i >= matrix.size() || j < 0 || j >= matrix.get(i).size() || matrix.get(i).get(j) == 0){
            return 0;
        }
        matrix.get(i).set(j, 0);
        int tmp = 1;
        for (int row = -1; row <= 1; row++){
            for (int col = -1; col <= 1; col++){
                tmp += DFS(matrix, i + row, j + col);
            }
        }

        return tmp;
    }


}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> matrix = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                matrix.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.connectedCell(matrix);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

