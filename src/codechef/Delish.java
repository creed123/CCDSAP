package codechef;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Delish {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Integer T = scanner.nextInt();
        while (T > 0) {
            Integer N = scanner.nextInt();
            List<Integer> list = new ArrayList<>();
            while (N > 0) {
                list.add(scanner.nextInt());
                N--;
            }
            Integer min = list.get(0);
            Integer max = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i) + min < min && list.get(i) > list.get(i) + min) {
                    min = list.get(i) + min;
                }
                else if (list.get(i) < min && list.get(i) + min > list.get(i)) {
                    min = list.get(i);
                }
                if (list.get(i) + max > max && list.get(i) > list.get(i) + max) {
                    max = list.get(i);
                }
                else if (list.get(i) + max > max && list.get(i) + max > list.get(i)) {
                    max = list.get(i) + max;
                }
            }
            System.out.print(max - min);
        }
    }
}
