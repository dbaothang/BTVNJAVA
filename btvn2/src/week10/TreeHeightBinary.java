package week10;



    /*
    class Node
        int data;
        Node left;
        Node right;
    */
static int maxx = 0;
static int[] arr = new int[25];
public static int height(Node root) {
        // Write your code here.
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
        Node tmp = q.poll();
        if(tmp.left != null){
        q.add(tmp.left);
        arr[tmp.left.data] = arr[tmp.data]+1;
        maxx = Math.max(maxx, arr[tmp.left.data]);
        }
        if(tmp.right != null){
        q.add(tmp.right);
        arr[tmp.right.data] = arr[tmp.data]+1;
        maxx = Math.max(maxx, arr[tmp.right.data]);
        }
        }
        return maxx;
        }


