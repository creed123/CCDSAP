package codechef;

import java.math.BigInteger;
import java.util.Scanner;

public class CountFlags {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer T = 0;
        if (scanner.hasNextInt()) {
            T = scanner.nextInt();
        }
        for (int i = 0; i < T; i++) {
            Integer N = scanner.nextInt();
            BigInteger total = BigInteger.ZERO;

            BigInteger threeColors = BigInteger.valueOf(N * (N - 1)).multiply(BigInteger.valueOf(N - 2));
            total = total.add(
                    (BigInteger.valueOf(N* (N-1)).add(threeColors))
                    .multiply(BigInteger.valueOf(2)));

            total = total.add(threeColors);
            total = total.add(((BigInteger.valueOf(N * (N -1))
                    .multiply(BigInteger.valueOf((N -2) * (N -3))))
                    .add(threeColors)).multiply(BigInteger.valueOf(2)));
            System.out.println(total.toString());
        }
    }
}