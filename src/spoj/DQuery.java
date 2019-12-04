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
            return new DNode(Arrays.asList(list.get(end)), null, null);
        }
        DNode left = buildTree(start, (start + end)/2, list);
        DNode right = buildTree((start + end)/2 + 1, end, list);
        return new DNode(merge(left.distinct, right.distinct), left, right);
    }

    static List<Integer> query(Integer start, Integer end, Integer idx1, Integer idx2, DNode dnode) {
        if (idx1 == start && idx2 == end) {
            return dnode.distinct;
        }
        if (idx1 > (start + end)/2) {
            return query((start + end)/2 + 1, end, idx1, idx2, dnode.right);
        }
        if (idx2 <= (start + end)/2) {
            return query(start, (start + end)/2, idx1, idx2, dnode.left);
        }
        return merge(query(start, (start + end)/2, idx1, (start + end)/2, dnode.left),
                query( (start + end)/2 + 1, end, (start + end)/2 + 1, idx2, dnode.right));
    }

    static List<Integer> merge(List<Integer> l1, List<Integer> l2) {
        List<Integer> list = new ArrayList<>(l2);
        for (int i = 0; i < l1.size(); i++) {
            if (!list.contains(l1.get(i))) {
                list.add(l1.get(i));
            }
        }
        return list;
    }
}

class DNode {
    List<Integer> distinct;
    DNode left;
    DNode right;

    public DNode(List<Integer> distinct, DNode left, DNode right) {
        this.distinct = distinct;
        this.left = left;
        this.right = right;
    }
}
