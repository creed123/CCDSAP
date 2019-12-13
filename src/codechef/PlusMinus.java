package codechef;
import org.omg.CORBA.INTERNAL;

import java.util.Scanner;

public class PlusMinus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer T = 0;
        if (scanner.hasNextInt()) {
            T = scanner.nextInt();
        }
        for (int i = 0; i < T; i++) {
            Integer count = 0;
            Integer count_zero = 0;
            Integer N = scanner.nextInt();
            for (int j = 0; j < N; j++) {
                Long a = Long.valueOf(scanner.next());
                if (a == 2l) {
                    count ++;
                } else if (a == 0l) {
                    count_zero++;
                }
            }
            System.out.println(count * (count - 1)/2 + count_zero *(count_zero -1)/2);
        }
    }
}
