package week8;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        int n = A.length();
        /* Enter your code here. Print output to STDOUT. */
        int l = 0, r = n - 1;
        while(l < r) {
            if(A.charAt(l) != A.charAt(r)) {
                System.out.println("No");
                return;
            }
            l++;
            r--;
        }
        System.out.print("Yes");
    }
}




