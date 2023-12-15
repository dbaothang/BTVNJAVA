package week11;

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
     * Complete the 'missingNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr
     *  2. INTEGER_ARRAY brr
     */

    /*public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
    // Write your code here
        int[] tmp = new int[10001];
        for(Integer a : arr) {
             tmp[a]++;
        }
        for(Integer b : brr) {
             tmp[b]--;
        }
        List<Integer> result = new ArrayList<>();
        for(int i = 1; i < 10001; i++){
            if(tmp[i] < 0) result.add(i);
        }
        return result;
    }*/

    /*public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr){
        TreeMap<Integer,Integer> map1 = new TreeMap<>();
        for (Integer x : arr){
            if(map1.containsKey(x)) map1.replace(x, map1.get(x)+1);
            else map1.put(x,1);
        }
        List<Integer> result = new ArrayList<>();
        for (Integer x : brr){
            if(!map1.containsKey(x))
            {
                if(!result.contains(x))
                result.add(x);
            }
            else if(map1.get(x)>0) map1.replace(x, map1.get(x)-1);
            else{
                if(!result.contains(x))
                result.add(x);
            }
        }
        Collections.sort(result);
        return result;
    }*/
    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr){
        Collections.sort(arr);
        Collections.sort(brr);
        int n = arr.size();
        int m = brr.size();
        int n2 = 0;
        int m2 = 0;
        List<Integer> result = new ArrayList<>();
        while(n2<n && m2 <m){
            if(arr.get(n2).equals(brr.get(m2))){
                n2++;
                m2++;
            }
            else{
                if(arr.get(n2)>brr.get(m2)){
                    if(!result.contains(brr.get(m2))){
                        result.add(brr.get(m2));
                    }
                    m2++;
                }
                else{
                    n2++;
                }
            }
        }
        while(m2<m){
            if(!result.contains(brr.get(m2))){
                result.add(brr.get(m2));
            }
            m2++;
        }
        return result;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.missingNumbers(arr, brr);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

