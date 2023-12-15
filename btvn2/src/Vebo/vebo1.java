package Vebo;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int truyvan = sc.nextInt();
        long[] a = new long[n+1];
        PriorityQueue<Long> lower = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Long> higher = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
            if (lower.isEmpty() || a[i] < lower.peek()) {
                lower.offer(a[i]);
            } else {
                higher.offer(a[i]);
            }

            if (Math.abs(lower.size() - higher.size()) >= 2) {
                if (lower.size() > higher.size()) {
                    higher.add(lower.poll());
                } else {
                    lower.add(higher.poll());
                }
            }
        }



        for (int i = 1; i <= truyvan; i++) {
            int t = sc.nextInt();
            if (t == 1) {
                Long q = sc.nextLong();
                if(higher.size()==0 && lower.size()==0){
                    higher.offer(q);
                }
                else if(higher.size()==0){
                    if (q > lower.peek()) higher.offer(q);
                    else lower.offer(q);
                }
                else if(lower.size()==0){
                    if (q > higher.peek()) higher.offer(q);
                    else lower.offer(q);
                }
                else if (q > higher.peek()){
                    higher.offer(q);
                }
                else lower.offer(q);
                while (Math.abs(lower.size() - higher.size()) >= 2) {
                    if (lower.size() > higher.size()) {
                        higher.add(lower.poll());
                    } else {
                        lower.add(higher.poll());
                    }
                }
            }
            if (t == 2) {
                if(lower.isEmpty() && higher.isEmpty()) {
                    //System.out.println(0);
                    continue;
                }
                if (lower.size() == higher.size()) {
                    //System.out.println(higher.poll());
                    lower.poll();
                } else {
                    if (lower.size() < higher.size()) {
                        //System.out.println(higher.poll());
                        higher.poll();
                    } else lower.poll();
                }
            }
            if (t == 3) {
                if(lower.isEmpty() && higher.isEmpty()) {
                    System.out.println(0);
                    continue;
                }
                if (lower.size() == higher.size()) {
                    System.out.println(lower.peek());
                } else {
                    if (lower.size() < higher.size()) {
                        System.out.println(higher.peek());
                    } else System.out.println(lower.peek());
                }
            }
        }
    }
}
