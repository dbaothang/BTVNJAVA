package week3;

public class chaos {
        public static void minimumBribes(List<Integer> q) {
            //Link: https://www.hackerrank.com/challenges/new-year-chaos/problem
            int count = 0;
            for (int i = q.size()-1; i >=0; i--) {
                if(q.get(i) - (i+1)>2){
                    System.out.println("Too chaotic");
                    return;
                }else{
                    for (int j = Math.max(0,q.get(i)-2); j < i ; j++) {
                        if(q.get(j) > q.get(i)){
                            count++;
                        }
                    }
                }
            }
            System.out.println(count);

        }

}
