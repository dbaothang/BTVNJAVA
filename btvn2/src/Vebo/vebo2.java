package Vebo;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        PriorityQueue<Long> higher = new PriorityQueue<>();
        long sum = 0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        long[] a = new long[n+1];
        long[] ans = new long[n+1];
        for (int i=1;i<=n;i++){
            a[i] = sc.nextInt();
        }
        higher.offer(a[1]);
        sum+=a[1];
        ans[1] = a[1];
        for(int i=2;i<=n;i++){
            if(higher.size()<k){
                higher.offer(a[i]);
                sum+=a[i];
                ans[i]=sum;
            }
            else{
                long t = higher.peek();
                if(t<a[i]){
                    higher.poll();
                    higher.offer(a[i]);
                    sum=sum-t+a[i];
                    ans[i]=sum;
                }
                else{
                    ans[i]=sum;
                }
            }
        }
        for (int i=1;i<=n;i++){
            System.out.print(ans[i]+" ");
        }
    }
}
