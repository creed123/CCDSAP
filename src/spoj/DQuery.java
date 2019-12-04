package spoj;

import java.util.*;

public class DQuery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer N =0;
        if (scanner.hasNextInt()) {
            N = scanner.nextInt();
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(scanner.nextInt());
        }
        Integer q = scanner.nextInt();
        DNode head = buildTree(0, N - 1, list);
        for (int i = 0; i < q; i++) {
            Integer a = scanner.nextInt();
            Integer b = scanner.nextInt();
            System.out.println(query(0, N - 1, a - 1, b - 1, head).size());
            }
        }


    static DNode buildTree(Integer start, Integer end, List<Integer> list) {
        if (start >= end) {
            Set<Integer> set = new HashSet<>();
            set.add(list.get(end));
            return new DNode(set, null, null);
        }
        DNode left = buildTree(start, (start + end)/2, list);
        DNode right = buildTree((start + end)/2 + 1, end, list);
        return new DNode(merge(left.distinct, right.distinct), left, right);
    }

    static Set<Integer> query(Integer start, Integer end, Integer idx1, Integer idx2, DNode dnode) {
        if (idx1.equals(start) && idx2.equals(end)) {
            return dnode.distinct;
        }
        if (idx1 > (start + end)/2) {
            return query((start + end) / 2 + 1, end, idx1, idx2, dnode.right);
        }
        if (idx2 <= (start + end)/2) {
            return query(start, (start + end) / 2, idx1, idx2, dnode.left);
        }
        return merge(query(start, (start + end)/2, idx1, (start + end)/2, dnode.left),
                query( (start + end)/2 + 1, end, (start + end)/2 + 1, idx2, dnode.right));
    }

    static Set<Integer> merge(Set<Integer> l1, Set<Integer> l2) {
        Set s = new HashSet(l2);
        s.addAll(l1);
        return s;
    }
}

class DNode {
    Set<Integer> distinct;
    DNode left;
    DNode right;

    public DNode(Set<Integer> distinct, DNode left, DNode right) {
        this.distinct = distinct;
        this.left = left;
        this.right = right;
    }
}
