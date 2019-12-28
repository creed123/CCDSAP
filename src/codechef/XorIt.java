package codechef;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class XorIt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer T = 0;
        if (scanner.hasNextInt()){
            T = scanner.nextInt();
        }
        for (int i = 0; i < T; i++) {
            Map<Long, Long> map = new HashMap<>();
            Long left = Long.valueOf(scanner.next());
            Long right = Long.valueOf(scanner.next());
            long sum = 0;
            for (Long j = left; j <= right; j++) {
                if (j % 2 ==1 && j!=1) {
                    sum+=j-1;
                    continue;
                } if (map.containsKey(j/2)) {
                    sum += map.get(j/2) * 2;
                }
                Long num = j;
                Long count = 0l;
                long B = 0;
                while (num > 1) {
                    Long temp = num;
                    while (temp > 1) {
                        temp /= 2;
                        count++;
                    }
                    num = Math.round(num - Math.pow(2, count));
                    if (num > 0) {
                        B += Math.round(Math.pow(2, count));
                    }
                    count = 0l;
                }
                if (B == 0) {
                    sum -=1;
                } else {
                    sum+=B;
                }
                map.put(j, sum);
            }
            System.out.println(sum);
        }
    }
}