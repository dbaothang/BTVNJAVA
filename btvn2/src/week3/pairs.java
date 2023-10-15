package week3;

public class pairs {

        public static int pairs(int k, List<Integer> arr) {
            Set<Integer> numberSet = new HashSet<>();
            int count = 0;

            for (int num : arr) {
                if (numberSet.contains(num - k)) {
                    count++;
                }
                if (numberSet.contains(num + k)) {
                    count++;
                }
                numberSet.add(num);
            }

            return count;
        }
}
