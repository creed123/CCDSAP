package codechef;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Subsplay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer T = 0;
        if (scanner.hasNextInt()) {
            T = scanner.nextInt();
        }
        for (int i = 0; i < T; i++) {
            Map<String, Integer> map = new HashMap<>();
            Integer N = scanner.nextInt();
            String s = scanner.next();
            for (int j = 0; j < N; j++) {
                String str = String.valueOf(s.charAt(j));
                map.put(str, map.getOrDefault(str, 0) + 1);
                for (int k = j + 1; k < N ; k++) {
                    str = str + s.charAt(k);
                    map.put(str, map.getOrDefault(str, 0) + 1);
                }
            }
            Integer max = 0;
            for (String str : map.keySet()) {
                if (map.get(str) > 1) {
                    max = Math.max(max, str.length());
                }
            }
            System.out.println(max);
        }
    }
}
