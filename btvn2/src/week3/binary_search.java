package week3;

public class binary_search {
    public static int binarySearch(int[] a, int number) {
        int max = a.length-1;
        int min = 0;
        while (min <= max) {
            int mid = (max+min)/2;
            if (a[mid] == number) return mid;
            else if (a[mid] > number) {
                max = mid-1;
            }
            else min = mid +1;
        }
        return -1;
    }
}
