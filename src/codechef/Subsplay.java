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
            Map<Character, Integer> map = new HashMap<>();
            Integer N = scanner.nextInt();
            String s = scanner.next();
            for (int j = 0; j < s.length(); j++) {
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            }
            Integer sum = 0;
            for (Integer val : map.values()) {
                sum+=val/2;
            }
            System.out.println(sum);
        }
    }
}
