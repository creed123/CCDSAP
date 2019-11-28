package codechef;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BigOf1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer T = 0;
        if (scanner.hasNextInt()) {
          T = scanner.nextInt();
        }
        for (int i = 0; i < T ; i++) {
            Integer N = scanner.nextInt();
            Integer C = scanner.nextInt();
            List<Integer> list = new ArrayList<>();
            List<Integer> size = new ArrayList<>();
            for (int j = 0; j <N ; j++) {
                list.add(j);
                size.add(j, 1);
            }
            for (int j = 0; j < C ; j++) {
                Integer a = scanner.nextInt();
                Integer b = scanner.nextInt();
                Integer root1 = findRoot(a - 1, list);
                Integer root2 = findRoot(b -1, list);
                if (root1.equals(root2)) {

                }
                else if (size.get(root1) > size.get(root2)) {
                    list.set(root2, root1);
                    size.set(root1, size.get(root1) + size.get(root2));
                } else {
                    list.set(root1, root2);
                    size.set(root2, size.get(root1) + size.get(root2));
                }
            }
            Integer Q = scanner.nextInt();
            for (int j = 0; j < Q; j++) {
                Integer a = scanner.nextInt();
                Integer b = scanner.nextInt();
                if (findRoot(a-1, list).equals(findRoot(b-1, list))) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            }
        }
    }

    public static Integer findRoot(Integer num, List<Integer> list) {
        while (!num.equals(list.get(num))) {
            num = list.get(num);
        }
        return num;
    }
}