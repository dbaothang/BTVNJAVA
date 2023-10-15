package week3;

public class closet_number {

        public static List<Integer> closestNumbers(List<Integer> arr) {

            if (arr == null || arr.size() < 2) {
                return new ArrayList<Integer>();
            }

            int minDifference = Integer.MAX_VALUE;
            List<Integer> result = new ArrayList<Integer>();

            Collections.sort(arr);

            for (int i = 1; i < arr.size(); i++) {
                int currentDifference = Math.abs(arr.get(i) - arr.get(i - 1));

                if (currentDifference < minDifference) {
                    minDifference = currentDifference;
                    result.clear();
                    result.add(arr.get(i - 1));
                    result.add(arr.get(i));
                } else if (currentDifference == minDifference) {
                    result.add(arr.get(i - 1));
                    result.add(arr.get(i));
                }
            }

            return result;
        }
}
