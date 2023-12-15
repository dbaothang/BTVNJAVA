package week5;

import java.io.*;
import java.util.*;


public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        Queue<Integer> queue = new ArrayDeque<>();
        int q = sc.nextInt();
        while (q-- != 0) {
            int t = sc.nextInt();
            if (t == 1) {
                int x = sc.nextInt();
                queue.add(x);
            }
            else if (t == 2) {
                queue.remove();
            }
            else {
                System.out.println(queue.peek());
            }
        }
    }
}
