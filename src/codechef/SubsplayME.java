package codechef;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SubsplayME {
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
                for (int k = j; k < N; k++) {
                    map.put(s.substring(j, k + 1), map.getOrDefault(s.substring(j, k + 1), 0) + 1);
                    for (int l = j + 1; l < k - 1; l++) {
                    }
                }
            }

            Map<Integer, Boolean> recurseMap = new HashMap<>();
            findSubsequence(map, s, new String(), 0, N, recurseMap);
            Integer max = 0;
            for (String str : map.keySet()) {
                if (map.get(str) > 1) {
                    max = Math.max(max, str.length());
                }
            }
            System.out.print(max);
            if (i < T - 1) {
                System.out.println();
            }
        }

    }

    static void findSubsequence(Map<String, Integer> map, String s, String sub, Integer n, Integer N, Map<Integer, Boolean> recurseMap) {
        if (n >= N) {
            return;
        }
        if (!sub.isEmpty()) {
            map.put(sub + s.charAt(n), map.getOrDefault(sub + s.charAt(n), 0) + 1);
            if (!recurseMap.getOrDefault(n, false)) {
                findSubsequence(map, s, sub + s.charAt(n), n + 1, N, recurseMap);
            }
        }
        map.put(String.valueOf(s.charAt(n)), map.getOrDefault(s.charAt(n), 0) + 1);
        if (!recurseMap.getOrDefault(n, false)) {
            findSubsequence(map, s, sub, n + 1, N, recurseMap);
            findSubsequence(map, s, String.valueOf(s.charAt(n)), n + 1, N, recurseMap);
        }
        recurseMap.put(n, true);
    }
}
