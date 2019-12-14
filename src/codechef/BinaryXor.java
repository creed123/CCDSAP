package codechef;

import java.util.*;

public class BinaryXor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer T = 0;
        if (scanner.hasNextInt()) {
            T = scanner.nextInt();
        }
        for (int i = 0; i < T; i++) {
            Integer N = scanner.nextInt();
            String s1 = scanner.next();
            String s2 = scanner.next();
            Map<Character, Long> map1 = new HashMap<>();
            Map<Character, Long> map2 = new HashMap<>();
            for (int j = 0; j < N; j++) {
                map1.putIfAbsent(s1.charAt(j), 0l);
                map2.putIfAbsent(s2.charAt(j), 0l);
                int finalJ = j;
                map1.computeIfPresent(s1.charAt(j),
                        (Character k, Long l) -> map1.get(s1.charAt(finalJ)) + 1);
                map2.computeIfPresent(s2.charAt(j),
                        (Character k, Long l) -> map2.get(s2.charAt(finalJ)) + 1);
            }
            Set<Long> set = new HashSet<>();
            Integer l = map1.getOrDefault('1', 0l) > map2.getOrDefault('0', 0l) ? 1: 0;
            for (Long j = Math.min(map1.getOrDefault('1', 0l), map2.getOrDefault('0', 0l)); j >= 0; j--) {
                if (l.equals(1)) {
                    if (map2.getOrDefault('1', 0l) - (map1.getOrDefault('1', 0l) - j) >= 0) {
                        set.add(j + map2.getOrDefault('1', 0l) - (map1.getOrDefault('1', 0l) - j));
                    }
                }
                if (l.equals(0)) {
                    if (map1.getOrDefault('0', 0l) - (map2.getOrDefault('0', 0l) - j) >= 0) {
                        set.add(j + map1.getOrDefault('0', 0l) - (map2.getOrDefault('0', 0l) - j));
                    }
                }
            }
            Double sum = 0.0;
            Double nfact = fact(Long.valueOf(N));
            for (Long val : set) {
                sum += nfact/((fact(val)) * fact(N - val));
            }
            System.out.println(Math.round(sum));
        }

    }

    static double fact(Long num) {
        double fact = 1l;
        for (int i = 1; i <=num ; i++) {
            fact = fact * (i % (Math.pow(10, 9) + 7)) % ((Math.pow(10, 9) + 7));
        }
        return fact;
    }
}
