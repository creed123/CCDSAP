package codechef;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Chngit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer T = 0;
        if (scanner.hasNextInt()) {
          T = scanner.nextInt();
        }
        while (T > 0) {
            Integer N = scanner.nextInt();
            Map<Integer, Integer> map = new HashMap<>();
            Integer max = Integer.MIN_VALUE;
            for (int i = 0; i < N; i++) {
                Integer num = scanner.nextInt();
                map.put(num, map.getOrDefault(num, 0) + 1);
                max = Math.max(max, map.get(num));
            }
            System.out.println(N - max);
            T --;
        }
    }
}
