package week10;



    /*
    class Node
        int data;
        Node left;
        Node right;
    */
public static Node lca(Node root, int v1, int v2) {

        // Write your code here.
        Node ans = null;
        /*if(p.val>q.val){
            int tmp = q.val;
            q.val = p.val;
            p.val = tmp;

        }*/
        while(root!=null){
        if( (root.data>v1 && root.data<v2) || (root.data<v1 && root.data>v2)){
        ans = root;
        break;
        }
        else if(root.data==v1 || root.data==v2){
        ans = root;
        break;
        }
        else if(root.data<v1){
        root = root.right;
        }
        else if(root.data>v2){
        root = root.left;
        }

        }
        return ans;
        }


