package Vebo;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        PriorityQueue<Long> lower = new PriorityQueue<>();
        TreeMap<Long,Long> mp = new TreeMap<>();
        Long sum = (long)0;
        for (long i=1;i<n;i++){
            long t = sc.nextLong();
            if(t==1){
                long q = sc.nextLong();
                lower.offer(q);
                mp.put(i,q);
            }
            if(t==2){
                long q = sc.nextLong();
                while(lower.size()>=q){
                    for (Map.Entry<Long, Long> entry : mp.entrySet()) {
                        if (entry.getValue().equals(lower.peek())) {
                            mp.remove(entry.getKey());
                            break;
                        }
                    }
                    lower.poll();
                }
            }
        }
        long t = sc.nextLong();
        long tmp = sc.nextLong();
        if(lower.size()<tmp) System.out.println(-1);
        else{
            while(lower.size()>0){
                sum+=lower.poll();
            }
            System.out.println(sum);
            for (Map.Entry<Long, Long> entry : mp.entrySet()) {
                System.out.print(entry.getKey()+" ");
            }

        }
    }
}
