package codechef;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class TachStick {

    public static void main(String[] args) throws IOException {
        final Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int D = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        while (N > 0) {
            list.add(scanner.nextInt());
            N--;
        }
        int pairs = 0;
        list.sort(Comparator.comparing(Integer::intValue));
        for (int i = 0; i < list.size() - 1;) {
            if (list.get(i) >= list.get(i+1) - D) {
                i+=2;
                pairs++;
            } else {
                i++;
            }
        }
        System.out.println(pairs);
    }
}