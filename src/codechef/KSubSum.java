package codechef;

import java.util.*;

public class KSubSum {
    static Integer K1;
    static Integer K2;
    static Integer K3;
    static PriorityQueue<Integer> pq1 = new PriorityQueue<>(Integer::compareTo);
    static PriorityQueue<Integer> pq2 = new PriorityQueue<>(Integer::compareTo);
    static PriorityQueue<Integer> pq3 = new PriorityQueue<>(Integer::compareTo);
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer T = scanner.nextInt();
        while (T > 0 ) {
            Integer N = scanner.nextInt();
            K1 = scanner.nextInt();
            K2 = scanner.nextInt();
            K3 = scanner.nextInt();
            List<Integer> list = new ArrayList<>();
            while (N > 0) {
                list.add(scanner.nextInt());
                N --;
            }
            pq1.clear();
            pq2.clear();
            pq3.clear();
            List<Integer> prefix = new ArrayList<>();
            Integer sum = 0;
            prefix.add(0);
            for (int i = 0; i < list.size(); i++) {
                prefix.add(sum + list.get(i));
                sum += list.get(i);
            }
            for (int i = 1; i < prefix.size(); i++) {
                for (int j = 0; j < i; j++) {
                    insertIntoQueue(pq1, K1, prefix.get(i) - prefix.get(j));
                    insertIntoQueue(pq2, K2, prefix.get(i) - prefix.get(j));
                    insertIntoQueue(pq3, K3, prefix.get(i) - prefix.get(j));
                }
            }
            System.out.println(pq1.peek() + " " + pq2.peek() + " " + pq3.peek());
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
