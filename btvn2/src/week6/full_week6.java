package week6;

import java.util.*;

public class full_week6 {
    1, insertion sort
    public static void insertion_sort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            // di chuyển các phần tử của arr[0 ... i-1], lớn hơn key
            // đến một vị trí trước vị trí hiện tại của chúng
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j -= 1;
            }
            arr[j + 1] = key;
            print(arr);
        }
    }

    public static void print(int[] arr) {
        for (int x : arr) System.out.print(x + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        insertion_sort(a);
    }

    2,selectionSort
    public class SelectionSort {
        public static void selection_sort(int[] arr){
            int n = arr.length;

            // duyệt từng phần tử
            for (int i=0; i<n-1; i++){

                // tìm phần tử nhỏ nhất trong mảng chưa được sắp xếp
                int min_idx = i;
                for (int j=i+1; j<n; j++){
                    if (arr[j] < arr[min_idx]) min_idx=j;
                }

                // hoán đổi phần tử nhỏ nhất với phần tử đầu tiên
                int temp = arr[min_idx];
                arr[min_idx] = arr[i];
                arr[i] = temp;
            }
        }

        public static void print(int[] arr){
            for (int x : arr) System.out.print(x + " ");
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i=0; i<n; i++) a[i] = sc.nextInt();
            selection_sort(a);
            print(a);
        }

        3,insertion_sort_part1
        public static void print(int[] a){
            for (int x : a) System.out.print(x + " ");
            System.out.println();
        }
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            int x = a[n-1];
            for (int i=n-2; i>=-1; i--){
                if (i == -1) {
                    a[0] = x;
                    print(a);
                    break;
                }
                if (a[i] > x) a[i+1] = a[i];
                else {
                    a[i+1] = x;
                    print(a);
                    break;
                }
                print(a);
            }
            sc.close();
        }

        4,javaSort
        class StudentComparator implements Comparator<Student> {
            // @Override
            public int compare(Student s1, Student s2){
                double cgpa1 = s1.getCgpa();
                double cgpa2 = s2.getCgpa();

                if (Math.abs(cgpa1 - cgpa2) < .00000001){
                    int nameComparator = s1.getName().compareTo(s2.getName());
                    if(nameComparator == 0){
                        return s1.getId()-s2.getId();
                    }
                    return nameComparator;
                }
                return (cgpa1 < cgpa2) ? 1 : (cgpa1 > cgpa2 ? -1 : 0);
            }
        }

        public class JavaSort {
            public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int testcases = sc.nextInt();

                List<Student> students = new ArrayList<Student>();
                while (testcases > 0){
                    int id = sc.nextInt();
                    String fname = sc.next();
                    double cgpa = sc.nextDouble();

                    Student st = new Student(id, fname, cgpa);
                    students.add(st);

                    testcases--;
                }

                Collections.sort(students, new StudentComparator());
                for (Student st : students){
                    System.out.println(st.getName());
                }

            }

            5,insertion_sort2
            public static void insertion_sort(int[] a){
                int n = a.length;
                for (int i=1; i<n; i++){
                    int key = a[i];
                    int j = i - 1;
                    while (j >= 0 && a[j] > key){
                        a[j+1] = a[j];
                        j -= 1;
                    }
                    a[j+1] = key;
                    print(a);
                }

            }
            public static void print(int[] a){
                for (int x : a) {
                    System.out.print(x + " ");
                }
                System.out.println();
            }
            public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int n = sc.nextInt();
                int[] a = new int[n];
                for (int i = 0; i < n; i++) a[i] = sc.nextInt();
                insertion_sort(a);
//        print(a);
            }

            6,counting_sort
            public class CountingSort1 {
                public static void main(String[] args) {
                    Scanner sc = new Scanner(System.in);
                    int n = sc.nextInt();
                    int[] a = new int[n];

                    int max = -1;
                    for (int i=0; i<n; i++){
                        a[i] = sc.nextInt();
                        max = Math.max(max, a[i]);
                    }

                    int[] ans = new int[max+1];
                    for (int i=0; i<n; i++){
                        ans[a[i]]++;
                    }

                    for (int x : ans) System.out.print(x + " ");

                }
            }



}
