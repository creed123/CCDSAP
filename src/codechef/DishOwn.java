package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.*;

public class DishOwn {
    static StreamTokenizer st = new StreamTokenizer (new BufferedReader(new InputStreamReader(System.in)));
    static class sc {
        static int nextInt () throws IOException {
            st.nextToken();
            return (int)st.nval;
        }
    }
    public static void main(String[] args) throws IOException {
        Integer T = sc.nextInt();
        while (T-- > 0) {
            Integer N = sc.nextInt();
            List<Integer> dishes = new ArrayList<>();
            List<Integer> owner = new ArrayList<>();
            for (int i = 0; i < N ; i++) {
                Integer n = sc.nextInt();
                dishes.add(n);
                owner.add(i);
            }
            Integer Q = sc.nextInt();
            for (int i = 0; i <Q; i++) {
                Integer op = sc.nextInt();
                if (op.equals(0)) {
                    Integer x = sc.nextInt();
                    Integer y = sc.nextInt();
                    Integer root1 = findRoot(x-1, owner);
                    Integer root2 = findRoot(y-1, owner);
                    if (root1.equals(root2)) {
                        System.out.println("Invalid query!");
                    } else {
                        if (dishes.get(root1) > dishes.get(root2)) {
                            owner.set(root2, root1);
                        } else if (dishes.get(root2) > dishes.get(root1)) {
                            owner.set(root1, root2);
                        }
                    }
                } else {
                    Integer next = sc.nextInt();
                    System.out.println(findRoot(next - 1, owner) + 1);
                }
            }
        }
    }

    public static Integer findRoot(Integer num, List<Integer> list) {
        if (list.get(num) != num) {
            num = findRoot(list.get(num), list);
        }
        return num;
    }
}