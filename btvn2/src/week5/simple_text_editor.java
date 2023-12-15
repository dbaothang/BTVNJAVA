package week5;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int Q = sc.nextInt();
        String text = "";
        Stack <String> oldVersion = new Stack<>();
        for(int i = 0; i < Q; i++){
            int t = sc.nextInt();
            if(t==1)
            {
                oldVersion.push(text);
                String append = sc.next();
                text += append;

            }
            if(t==2)
            {
                oldVersion.push(text);
                int k = sc.nextInt();
                String newText = text.substring(0, text.length() - k);
                text = newText;

            }
            if(t==3)
            {
                int k = sc.nextInt();
                System.out.println(text.charAt(k - 1));

            }
            if(t==4)
            {
                if(!oldVersion.isEmpty()){
                    String oldText = oldVersion.pop();
                    text = oldText;
                }

            }
        }
    }

}