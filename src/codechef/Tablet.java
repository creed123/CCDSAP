package codechef;

import java.util.Scanner;

public class Tablet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer T = 0;
        if (scanner.hasNextInt()) {
            T = scanner.nextInt();
        }
        for (int i = 0; i < T; i++) {
            Integer N = scanner.nextInt();
            Integer B = scanner.nextInt();
            Integer max = Integer.MIN_VALUE;
            for (int j = 0; j < N; j++) {
                Integer w = scanner.nextInt();
                Integer h = scanner.nextInt();
                Integer p = scanner.nextInt();
                if (p <= B) {
                    max = Math.max(w*h, max);
                }
            }
            if (max == Integer.MIN_VALUE) {
                System.out.println("no tablet");
            } else {
                System.out.println(max);
            }
        }
    }
}
