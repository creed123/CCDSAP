package codechef;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class TJSec {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer T = 0;
        if (scanner.hasNextInt()) {
             T = scanner.nextInt();
        }
        while (T > 0) {
            Integer K = scanner.nextInt();
            Integer N = scanner.nextInt();
            PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Comparator.naturalOrder());
            while (N > 0) {
                Integer num = scanner.nextInt();
                if (pq.size() < K) {
                    pq.add(num);
                } else {
                    if (pq.peek() < num) {
                        pq.remove();
                        pq.add(num);
                    }
                }
                if (pq.size() < K) {
                    System.out.print(-1 + " ");
                } else {
                    System.out.print(pq.peek() + " ");
                }
                if (N > 1) {
                    System.out.println();
                }
                N --;
            }
            if (T > 1) {
                System.out.println();
            }
            T--;
        }
    }
}