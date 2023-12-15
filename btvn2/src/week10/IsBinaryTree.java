package week10;

/* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.

The Node class is defined as follows:
    class Node {
        int data;
        Node left;
        Node right;
     }
*/
     boolean check(Node root, int minn, int maxx) {
             if(root == null) return true;
             if(root.data < minn || root.data > maxx){
        return false;
        }
        else return (check(root.left, minn, root.data - 1) && check(root.right, root.data + 1, maxx));
        }
        boolean checkBST(Node root) {
        return check(root, -1, 100005);

        }