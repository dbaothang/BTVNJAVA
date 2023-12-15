class Solution {

    int[] parent = new int[100000];
    int x;
    public int find(int u){
        if(parent[u]<=-1) return u;
        else return parent[u]=find(parent[u]);
    }

    public void Union(int a, int b) {
        a=find(a);
        b=find(b);

        if(a==b) return;
        else {
            if(parent[a]<parent[b]) {
                parent[a]+=parent[b];
                parent[b]=a;
                x--;
            }
            else {
                parent[b]+=parent[a];
                parent[a]=b;
                x--;
            }
        }
    }
    public int makeConnected(int n, int[][] connections) {
        int m = connections.length;
        x = n;
        for (int i = 0; i < n; i++) {
            parent[i] = -1;
        }
        for (int i = 0; i < connections.length; i++) {
            int t = connections[i][0];
            int q = connections[i][1];
            Union(t, q);
        }
        if (x == 1) return 0;
        if (m < n - 1) return -1;
        return x - 1;
    }






















        /*boolean[] ans = new boolean[100000];
        int m=connections.length;
        //int tmp=0;
        for (int i=0;i<n;i++){
            ans[i]=false;
        }
        int tmp = 0;
        for (int i=0;i<connections.length;i++){
            int t = connections[i][0];
            int q = connections[i][1];
            if(!ans[t]){
                ans[t]=true;
                n--;
                tmp++;
            } 
            if(!ans[q]){
                ans[q]=true;
                n--;
                tmp++;
            } 
        }
        if(n==0) return 0;
        if(m-tmp+1>=n) return n;
        else return -1;
    }*/
    }
}