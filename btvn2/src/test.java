import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int truyvan = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        PriorityQueue<Integer> lower = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> higher = new PriorityQueue<>();

        for (int i = 1; i <= n; i++) {
            if (lower.isEmpty() || a[i] < lower.peek()) {
                lower.add(i);
            } else {
                higher.add(i);
            }

            if (Math.abs(lower.size() - higher.size()) >= 2) {
                if (lower.size() > higher.size()) {
                    higher.add(lower.poll());
                } else {
                    lower.add(higher.poll());
                }
            }
        }
        for (int i = 1; i <= truyvan; i++) {
            int t = sc.nextInt();
            if (t == 1) {
                int q = sc.nextInt();
                if (q > a[higher.peek()]) higher.add(q);
                else lower.add(q);
            }
            if (t == 2) {
                if (lower.size() == higher.size()) {
                    System.out.println(a[higher.poll()]);
                } else {
                    if (Math.abs(lower.size() - higher.size()) >= 2) {
                        if (lower.size() > higher.size()) {
                            higher.add(lower.poll());
                        } else {
                            lower.add(higher.poll());
                        }
                    }
                    if (lower.size() < higher.size()) {
                        System.out.println(a[higher.poll()]);
                    } else System.out.println(a[lower.poll()]);
                }
            }
            if (t == 3) {
                if (lower.size() == higher.size()) {
                    System.out.println(higher.peek());
                } else {
                    if (Math.abs(lower.size() - higher.size()) >= 2) {
                        if (lower.size() > higher.size()) {
                            higher.add(lower.poll());
                        } else {
                            lower.add(higher.poll());
                        }
                    }
                    if (lower.size() < higher.size()) {
                        System.out.println(higher.peek());
                    } else System.out.println(lower.peek());
                }
            }
        }
    }
}
