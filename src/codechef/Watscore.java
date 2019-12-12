package codechef;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Watscore {
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
                Integer b = scanner.nextInt();
                map.put(a, Math.max(map.getOrDefault(a, 0), b));
            }
            System.out.println(map.keySet().stream().filter(k -> k < 9).map( k -> map.get(k)).reduce(Integer::sum).orElse(0));
        }
    }
}