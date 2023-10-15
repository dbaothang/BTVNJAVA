package week2;

import java.util.*;
public class basum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[10001];
        for (int i=1;i<=n;i++){
            a[i] = sc.nextInt();
        }
        int ans = 0;
        for(int i = 0; i < n-2; i++){
            // ensure no repetition
            if(i > 0 && a[i] == a[i-1])
                continue;
            // binary search on remaining elements
            int x = a[i], y = i+1, z = n-1;

            while(y < z){
                if(a[y] + a[z] + x ==0){
                    // save valid ans
                    ans++;
                    System.out.println ( x + a[y] + a[z]);
                    // inc b and dec c till no repetition.
                    int t = a[y];
                    while(y < n && a[y] == t)
                        y++;

                    t = a[z];
                    while(z >=0 && a[z] == t)
                        z--;
                }
                else if(a[y]+a[z] +x < 0 ){
                    y++; // sum less than target // duplicate is handled as not valid ans.
                }
                else
                    z--;
            }
        }
    }
}
