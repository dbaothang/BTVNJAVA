package week5;

public class full_week5 {
    //5
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int Q = scanner.nextInt();
        String text = "";
        Stack <String> oldVersion = new Stack<>();

        for (int i = 0; i < Q; i++) {
            int request = scanner.nextInt();

            switch (request) {

                case 1:
                {

                    oldVersion.push(text);


                    String append = scanner.next();
                    text += append;
                    break;
                }


                case 2:
                {

                    oldVersion.push(text);


                    int k = scanner.nextInt();


                    String newText = text.substring(0, text.length() - k);
                    text = newText;
                    break;
                }


                case 3:
                {

                    int k = scanner.nextInt();
                    System.out.println(text.charAt(k - 1));
                    break;
                }

                //undo
                case 4:
                {

                    if (!oldVersion.isEmpty()) {
                        String oldText = oldVersion.pop();
                        text = oldText;
                    }
                    break;
                }
            }
        }
        scanner.close();
    }

     //2
     public static String isBalanced(String s) {
         // Write your code here
         Stack<Integer> stack = new Stack<>();
         for(int i = 0; i < (int) s.length(); i++) {
             if(s.charAt(i) == '(') stack.push(0);
             else if(s.charAt(i) == '[') stack.push(1);
             else if(s.charAt(i) == '{') stack.push(2);
             else if(s.charAt(i) == ')') {
                 if(stack.isEmpty() == false && stack.peek() == 0) stack.pop();
                 else return "NO";
             }
             else if(s.charAt(i) == ']') {
                 if(stack.isEmpty() == false && stack.peek() == 1) stack.pop();
                 else return "NO";
             }
             else {
                 if(stack.isEmpty() == false && stack.peek() == 2) stack.pop();
                 else return "NO";
             }
         }
         if(stack.isEmpty() == true) return "YES";
         return "NO";

     }

     //3
     public static void main(String[] args) {
         /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
         Scanner sc = new Scanner(System.in);
         Queue<Integer> queue = new ArrayDeque<>();
         int q = sc.nextInt();
         while (q-- != 0) {
             int type = sc.nextInt();
             if (type == 1) {
                 int x = sc.nextInt();
                 queue.add(x);
             }
             else if (type == 2) {
                 queue.remove();
             }
             else {
                 System.out.println(queue.peek());
             }
         }

     }

     //6
     public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
         // Write your code here
         int maxHeight = 0;

         Stack<Integer> st1 = new Stack<>();
         Stack<Integer> st2 = new Stack<>();
         Stack<Integer> st3 = new Stack<>();

         fillStacks(st1, h1, st2, h2, st3, h3);

         // Run a loop until every stack has at-least 1 element
         while (!st1.isEmpty() && !st2.isEmpty() && !st3.isEmpty()) {

             int stack1Height = st1.peek();
             int stack2Height = st2.peek();
             int stack3Height = st3.peek();

             // If all stacks are of same height, just return the height
             if (stack1Height == stack2Height && stack2Height == stack3Height) {
                 maxHeight = st1.peek();
                 break;
             }

             // Else find the stack with maximum height and remove the block
             if (stack1Height >= stack2Height && stack1Height >= stack3Height) {
                 st1.pop();
             } else if (stack2Height >= stack1Height && stack2Height >= stack3Height) {
                 st2.pop();
             } else if (stack3Height >= stack1Height && stack3Height >= stack2Height) {
                 st3.pop();
             }
         }

         return maxHeight;

     }

    public static void fillStacks(Stack<Integer> st1, List<Integer> h1, Stack<Integer> st2,List<Integer> h2 , Stack<Integer> st3, List<Integer> h3) {
        int st1TotalHeight = 0, st2TotalHeight = 0, st3TotalHeight = 0;

        // pushing consolidated height into the stack instead of individual cylinder
        // height
        for (int i = h1.size() - 1; i >= 0; i--) {
            st1TotalHeight += h1.get(i);
            st1.push(st1TotalHeight);
        }
        for (int i = h2.size() - 1; i >= 0; i--) {
            st2TotalHeight += h2.get(i);
            st2.push(st2TotalHeight);
        }
        for (int i = h3.size() - 1; i >= 0; i--) {
            st3TotalHeight += h3.get(i);
            st3.push(st3TotalHeight);
        }
    }

