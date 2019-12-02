package spoj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Gss1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer N = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        while (N > 0) {
            list.add(scanner.nextInt());
            N--;
        }
        SegmentNode head = buildTree(list, 0, list.size() - 1);
        Integer M = scanner.nextInt();
        while (M > 0) {
            Integer x = scanner.nextInt();
            Integer y = scanner.nextInt();
            SegmentNode node = query(head, 0, list.size() - 1, x - 1, y - 1);
            System.out.println(node.maxSum);
            M --;
        }
    }

    static SegmentNode buildTree(List<Integer> list, int start, int end) {
        if (start >= end) {
            return new SegmentNode(null, null, list.get(end), list.get(end), list.get(end));
        }
        SegmentNode left = buildTree(list, start, (start + end)/2);
        SegmentNode right = buildTree(list, (start + end)/2, end);
        return new SegmentNode(right, left, Math.max(left.maxPrefixSum, left.sum + right.maxPrefixSum),
                Math.max(right.maxSuffixSum, left.maxSuffixSum + right.sum), left.sum + right.sum);
    }

    static SegmentNode query(SegmentNode current, int start, int end, int idx1, int idx2) {
        if (start == idx1 && end == idx2) {
            return current;
        }
        if (idx1 > (start + end)/2) {
            return query(current.right, (start + end)/2 + 1, end, idx1, idx2);
        } if (idx2 < (start + end)/2) {
            return query(current.left, start, (start + end) / 2, idx2, idx1);
        }
        SegmentNode left = query(current.left, start, (start + end) / 2, idx1, (start + end) / 2);
        SegmentNode right = query(current.right, (start + end)/2 + 1, end, (start + end) / 2 + 1, idx2);
        return new SegmentNode(right, left, Math.max(left.maxPrefixSum, left.sum + right.maxPrefixSum),
                Math.max(right.maxSuffixSum, left.maxSuffixSum + right.sum), left.sum + right.sum);
    }
}

class SegmentNode {
    SegmentNode right;
    SegmentNode left;
    Integer maxPrefixSum;
    Integer maxSuffixSum;
    Integer sum;
    Integer maxSum;

    public SegmentNode(SegmentNode right, SegmentNode left, Integer maxPrefixSum, Integer maxSuffixSum, Integer sum) {
        this.right = right;
        this.left = left;
        this.maxPrefixSum = maxPrefixSum;
        this.maxSuffixSum = maxSuffixSum;
        this.sum = sum;
        if (left != null && right!= null) {
            this.maxSum = merge(right, left);
        } else this.maxSum = maxPrefixSum;
    }

    static int merge(SegmentNode right, SegmentNode left) {
        return Math.max(right.maxSum, Math.max(left.maxSum, Math.max(left.maxPrefixSum,
                Math.max(left.sum + right.maxPrefixSum,
                        Math.max(right.sum + left.maxSuffixSum,
                                Math.max(left.maxPrefixSum + right.maxSuffixSum,
                                        left.sum + right.sum))))));
    }
}