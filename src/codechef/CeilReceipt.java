package codechef;

import java.util.Scanner;

public class CeilReceipt {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Integer N = scanner.nextInt();
        while (N > 0) {
            Integer p = scanner.nextInt();
            Integer totalItems = 0;
            while (p>0) {
                p -= (int) Math.pow(2, steps(p));
                totalItems++;
            }
            System.out.println(totalItems);
            N--;
        }
    }

    private static Integer steps(Integer p) {
        Integer steps = 0;
        while (p > 1) {
            p/=2;
            steps ++;
        }
        return steps < 11 ? steps: 11;
    }
}