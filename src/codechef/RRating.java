package codechef;

import java.util.*;

public class RRating {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer T = 0;
        if (scanner.hasNextInt()) {
            T = scanner.nextInt();
        }
        PriorityQueue<Integer> min = new PriorityQueue<>(Comparator.naturalOrder());
        PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());
        Integer num = 0;
        for (int i = 0; i < T; i++) {
            Integer opt = scanner.nextInt();
            if (opt.equals(2)) {
                if (min.size() == 0) {
                    System.out.println("No reviews yet");
                } else {
                    System.out.println(min.peek());
                }
            } else {
                num++;
                Integer val = scanner.nextInt();
                max.add(val);
                if (!max.isEmpty() && !min.isEmpty() && min.peek() < max.peek()) {
                    min.add(max.remove());
                    max.add(min.remove());
                }
                if (min.size() < num/3) {
                    min.add(max.remove());
                }
            }
        }
    }
}