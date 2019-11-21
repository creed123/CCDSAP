package spoj;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Wierdfn {
    public static void main(String[] args) {
        PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> min = new PriorityQueue<>(Comparator.naturalOrder());
        Scanner scanner = new Scanner(System.in);
        Integer T = scanner.nextInt();
        for (int i = 0; i < T  ; i++) {
            Integer a = scanner.nextInt();
            Integer b = scanner.nextInt();
            Integer c = scanner.nextInt();
            Integer n = scanner.nextInt();
            Integer sum = 0;
            for (int j = 1; j <= n; j++) {
                Integer num = j > 1 ? a * max.peek() + b * j + c : 1;
                min.add(num);
                if (min.size() - max.size() == 1) {
                    max.add(min.remove());
                }
                sum+=num;
            }
            System.out.println(sum);
            max.clear();
            min.clear();
        }
    }
}