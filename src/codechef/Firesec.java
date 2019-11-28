package codechef;

import java.util.*;
import java.util.stream.Collectors;

public class Firesec {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer T = 0;
        if (scanner.hasNextInt()) {
            T = scanner.nextInt();
        }
        for (int i = 0; i <T; i++) {
            Integer N = scanner.nextInt();
            Integer M = scanner.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                list.add(j);
            }
            for (int j = 0; j < M; j++) {
                Integer n = scanner.nextInt();
                Integer m = scanner.nextInt();
                Integer root1 = findRoot(n-1, list);
                Integer root2 = findRoot(m-1, list);
                if (root1 > root2) {
                    list.set(root1, root2);
                } else {
                    list.set(root2, root1);
                }
            }
            Map<Integer, Long> map =
                    list.stream().collect(Collectors.groupingBy(Integer::intValue,
                                    Collectors.mapping(Integer::intValue, Collectors.counting())));
            System.out.print(map.keySet().size() + " ");
            System.out.print(map.values().stream().reduce((k1,k2) -> (k1%1000000007)*(k2 % 1000000007)).get() % 1000000007);
            if (i < T -1) {
                System.out.println();
            }
        }
    }

    public static Integer findRoot(Integer num, List<Integer> list) {
        while (list.get(num) != num) {
            num = list.get(num);
        }
        return num;
    }
}