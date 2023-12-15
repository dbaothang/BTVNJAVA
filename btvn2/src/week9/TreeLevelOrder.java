package week9;



    /*

    class Node
        int data;
        Node left;
        Node right;
    */
public static void levelOrder(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        System.out.print(root.data+" ");
        while(!q.isEmpty()){
        Node tmp = q.poll();
        if(tmp.left != null){
        q.add(tmp.left);
        System.out.print(tmp.left.data+" ");
        }
        if(tmp.right != null){
        q.add(tmp.right);
        System.out.print(tmp.right.data+" ");
        }
        }


        }


