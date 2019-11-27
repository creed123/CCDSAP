package review;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class CapiMove {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer T = 0;
        if (scanner.hasNextInt()) {
             T = scanner.nextInt();
        }
        while (T > 0) {
            Integer N = scanner.nextInt();
            List<Integer> populations = new ArrayList<>();
            List<Integer> subsets = new ArrayList<>();
            for (int i = 1; i <= N; i++) {
                Integer num = scanner.nextInt();
                populations.add(num);
                subsets.add(i);
            }
            for (int i = 0; i < N-1; i++) {
                Integer V = scanner.nextInt();
                Integer U = scanner.nextInt();
                if (subsets.get(V-1) > subsets.get(U-1)) {
                    subsets.replaceAll((Integer integer) -> {
                        if (integer.equals(subsets.get(V -1))) {
                            return subsets.get(U -1 );
                        }
                        return integer;
                    });
                } else {
                    subsets.replaceAll((Integer integer) -> {
                        if (integer.equals(subsets.get(U - 1))) {
                            return subsets.get(V - 1);
                        }
                        return integer;
                    });
                }
            }
            Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
            for (AtomicInteger i = new AtomicInteger(0); i.get() < N; i.incrementAndGet()) {
                map.putIfAbsent(subsets.get(i.get()), new PriorityQueue<>());
                map.computeIfPresent(subsets.get(i.get()), (Integer key, PriorityQueue priorityQueue) -> {
                    priorityQueue.add(populations.get(i.get()));
                    return priorityQueue;
                });
            }
            for (int i = 0; i <N ; i++) {
                System.out.print(map.get(subsets.get(i)).poll() + " ");
            }
            if (T > 1) {
                System.out.println();
            }
            T --;
        }
    }
}
