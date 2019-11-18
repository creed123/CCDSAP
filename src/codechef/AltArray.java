package codechef;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AltArray {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T > 0) {
            int N = scanner.nextInt();
            List<Integer> list = new ArrayList<>();
            List<Integer> lengths = new ArrayList<>();
            while (N > 0) {
                list.add(scanner.nextInt());
                lengths.add(1);
                N--;
            }

            for (int i = 1; i < list.size(); i++) {
                for (int j = i; j >=1; j--) {
                    if (((list.get(j) > 0 && list.get(j-1) < 0) || (list.get(j) < 0 && list.get(j-1) > 0))
                            && (lengths.get(j).equals(lengths.get(j-1)))) {
                        lengths.set(j-1, lengths.get(j-1) + 1);
                    }
                }
            }
            lengths.forEach(elem ->  System.out.print(elem + " "));
            T--;
        }
    }
}