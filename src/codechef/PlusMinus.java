package codechef;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PlusMinus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer T = 0;
        if (scanner.hasNextInt()) {
            T = scanner.nextInt();
        }
        for (int i = 0; i < T; i++) {
            Integer N = scanner.nextInt();
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < N; j++) {
                Integer a = scanner.nextInt();
                map.put(a, map.getOrDefault(a, 0) + 1);
            }
            Double sum = 0d;
            for (Integer val : map.values()) {
                if (val > 1) {
                    sum += fact((long) val) / ((fact(2l)) * fact((long) val - 2));
                }
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
