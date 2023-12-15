package week10;



public static int getHeight(Node root){
        return root == null ? -1 : root.ht;
        }

public static void update_height(Node root){
        root.ht = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        }

public static Node rotate_with_left(Node root){
        Node temp = root.left;
        root.left = temp.right;
        temp.right = root;

        update_height(root);
        update_height(temp);
        return temp;
        }

public static Node rotate_with_right(Node root){
        Node temp = root.right;
        root.right = temp.left;
        temp.left = root;

        update_height(root);
        update_height(temp);
        return temp;
        }


public static int getBalanceFactor(Node node) {
        if (node == null) {
        return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
        }

public static Node insert(Node root, int value){
        if (root == null) {
        Node ans = new Node();
        ans.val = value;
        ans.left = null;
        ans.right = null;
        ans.ht = 0;
        return ans;
        } else if(value < root.val){
        root.left = insert(root.left, value);
        if (getHeight(root.left) - getHeight(root.right) == 2){
        if (value > root.left.val){
        root.left = rotate_with_right(root.left);
        }
        root = rotate_with_left(root);
        }
        } else {
        root.right = insert(root.right, value);
        if (getHeight(root.right) - getHeight(root.left) == 2){
        if (value < root.right.val){
        root.right = rotate_with_left(root.right);
        }
        root = rotate_with_right(root);
        }
        }
        update_height(root);
        return root;
        }