package codechef;

import java.util.*;

public class Subsplay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer T = 0;
        if (scanner.hasNextInt()) {
            T = scanner.nextInt();
        }
        for (int i = 0; i < T; i++) {
            Map<String, Integer> map = new LinkedHashMap<>();
            Integer N = scanner.nextInt();
            String s = scanner.next();
            for (int j = N -1; j >=0; j--) {
                List<String> keys  = new ArrayList<>(map.keySet());
                for (String str : keys) {
                    map.put(s.charAt(j) + str, map.getOrDefault(s.charAt(j) + str, 0) + 1);
                }
                map.put(String.valueOf(s.charAt(j)), map.getOrDefault(String.valueOf(s.charAt(j)), 0) + 1);
            }
            Integer max = 0;
            for (String str : map.keySet()) {
                if (map.get(str) > 1) {
                    max = Math.max(max, str.length());
                }
            }
            System.out.print(max);
            if (i < T -1) {
                System.out.println();
            }
        }

    }

}