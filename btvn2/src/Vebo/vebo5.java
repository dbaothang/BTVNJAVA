package Vebo;

import java.io.*;
import java.util.*;

public class Solution {
    static int[] a = new int[300001];
    static int[] t = new int[300001*4];
    public static void build(int l, int r, int id) {
        if (l == r) {
            t[id] = a[l];
            return;
        }
        int mid = (l + r) / 2;
        build(l, mid, 2 * id);
        build(mid + 1, r, 2 * id + 1);
        t[id] = Math.min(t[2 * id], t[2 * id + 1]);
    }

    public static int get(int l, int r, int id, int u, int v) {
        if (v < l || r < u) return Integer.MAX_VALUE;
        if (u <= l && r <= v) return t[id];
        int mid = (l + r) / 2;
        int left = get(l, mid, 2 * id, u, v);
        int right = get(mid + 1, r, 2 * id + 1, u, v);
        return Math.min(left, right);
    }
    public static void update(int id, int l, int r, int pos, int val){
        if (l == r) {
            t[id] = val;
        } else {
            int mid = (l + r) / 2;
            if (pos <= mid) {
                update(2 * id, l, mid, pos, val);
            } else {
                update(2 * id + 1, mid + 1, r, pos, val);
            }
            t[id] = Math.min(t[2 * id], t[2 * id + 1]);
        }
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i=1;i<=n;i++){
            a[i] = sc.nextInt();
        }
        build(1,n,1);
        int q = sc.nextInt();
        for (int i=1;i<=q;i++){
            int o = sc.nextInt();
            if(o==1){
                int m = sc.nextInt();
                int k = sc.nextInt();
                System.out.println(get(1,n,1,m,k));
            }
            else {
                int m = sc.nextInt();
                int k = sc.nextInt();
                update(1,1,n,m,k);
            }

        }
    }
}
