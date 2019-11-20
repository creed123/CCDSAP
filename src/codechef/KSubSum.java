package codechef;

import java.util.*;

public class KSubSum {
    static Integer K1;
    static Integer K2;
    static Integer K3;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer T = 0;
        if (scanner.hasNextInt()) {
            T = scanner.nextInt();
        }
        while (T > 0 ) {
            Integer N = scanner.nextInt();
            K1 = scanner.nextInt();
            K2 = scanner.nextInt();
            K3 = scanner.nextInt();
            Integer K = Math.max(Math.max(K1, K2), K3);
            List<Integer> list = new ArrayList<>();
            while (N > 0) {
                list.add(scanner.nextInt());
                N --;
            }
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            List<Integer> prefix = new ArrayList<>();
            Integer sum = 0;
            prefix.add(0);
            for (int i = 0; i < list.size(); i++) {
                prefix.add(sum + list.get(i));
                sum += list.get(i);
            }
            for (int i = 1; i < prefix.size(); i++) {
                for (int j = 0; j < i; j++) {
                    insertIntoQueue(pq, K, prefix.get(i) - prefix.get(j));
                }
            }
            List<Integer> nums = new ArrayList<>(pq);
            nums.sort(Comparator.reverseOrder());
            System.out.println(nums.get(K1-1) + " " + nums.get(K2-1) + " " + nums.get(K3-1));
            T --;
        }
    }

    static void insertIntoQueue(PriorityQueue<Integer> pq, Integer limit, Integer value) {
        if (pq.size() < limit) {
            pq.offer(value);
        } else {
            if (pq.peek() < value) {
                pq.poll();
                pq.offer(value);
            }
        }
    }

}
