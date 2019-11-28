package codechef;

import java.util.*;

public class Firesec {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer T = 0;
        if (scanner.hasNextInt()) {
            T = scanner.nextInt();
        }
        for (int i = 0; i <T; i++) {
            Integer N = scanner.nextInt();
            Integer M = scanner.nextInt();
            List<Integer> list = new ArrayList<>();
            List<Integer> size = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                list.add(j);
                size.add(1);
            }
            for (int j = 0; j < M; j++) {
                Integer n = scanner.nextInt();
                Integer m = scanner.nextInt();
                Integer root1 = findRoot(n-1, list);
                Integer root2 = findRoot(m-1, list);
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
            Long combinations = 1l;
            Integer components = 0;
            for (int j = 0; j < list.size(); j++) {
                if (j == findRoot(j, list)) {
                    components++;
                    combinations = ((combinations%1000000007)*(size.get(j) % 1000000007))%1000000007;
                }
            }
            System.out.println(components + " " + combinations);

        }
    }

    public static Integer findRoot(Integer num, List<Integer> list) {
        while (list.get(num) != num) {
            num = list.get(num);
        }
        return num;
    }
}