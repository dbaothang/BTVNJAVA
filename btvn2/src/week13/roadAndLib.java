package week13;

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
     * Complete the 'roadsAndLibraries' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER c_lib
     *  3. INTEGER c_road
     *  4. 2D_INTEGER_ARRAY cities
     */

    public static long roadsAndLibraries(int n, int c_lib, int c_road, List<List<Integer>> cities) {
        // Write your code here
        if (cities == null || cities.isEmpty()) {
            return (long) n * c_lib;
        }

        if (c_lib <= c_road) {
            return (long) c_lib * n;
        }

        Map<Integer, Set<Integer>> citiesMap = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            citiesMap.put(i, new HashSet<Integer>());
        }

        boolean[] visited = new boolean[n + 1];

        for (List<Integer> road : cities) {
            int from = road.get(0);
            int to = road.get(1);

            citiesMap.get(from).add(to);
            citiesMap.get(to).add(from);
        }

        long answer = 0;

        for (int city = 1; city <= n; city++) {
            if (!visited[city]) {
                visited[city] = true;
                int cityNumberOfTown = 1;
                Queue<Integer> queue = new LinkedList<>();
                queue.add(city);

                while (!queue.isEmpty()) {
                    Integer cityFrom = queue.poll();

                    Iterator<Integer> iterator = citiesMap.get(cityFrom).iterator();

                    while (iterator.hasNext()) {
                        int connectedCity = iterator.next();

                        if (!visited[connectedCity]) {
                            queue.add(connectedCity);
                            cityNumberOfTown++;
                            visited[connectedCity] = true;
                        }
                    }
                }

                answer += (long) (cityNumberOfTown - 1) * (long) c_road + (long) c_lib;
            }
        }

        return answer;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                int c_lib = Integer.parseInt(firstMultipleInput[2]);

                int c_road = Integer.parseInt(firstMultipleInput[3]);

                List<List<Integer>> cities = new ArrayList<>();

                IntStream.range(0, m).forEach(i -> {
                    try {
                        cities.add(
                                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                        .map(Integer::parseInt)
                                        .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                long result = Result.roadsAndLibraries(n, c_lib, c_road, cities);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
