package spoj;

import java.util.Scanner;

public class HelpR2D2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer T = 0;
        if (scanner.hasNextInt()) {
          T  = scanner.nextInt();
        }
        while (T > 0) {
            Integer K = scanner.nextInt();
            Integer n = scanner.nextInt();
            StarNode head = buildTree(0, n-1, K);
            for (int i = 0; i < n;) {
                if (scanner.hasNextInt()) {
                    Integer v = scanner.nextInt();
                    updateTree(0, n -1,v, head);
                    i++;
                } else if (scanner.hasNext()) {
                    scanner.next();
                    Integer num = scanner.nextInt();
                    Integer v = scanner.nextInt();
                    for (int j = 0; j < num; j++, i++) {
                        updateTree(0, n -1,v, head);
                    }
                }
            }
            System.out.println(head.count + " " + head.waste);
            T --;
        }
    }

    static StarNode updateTree(Integer start, Integer end, Integer v, StarNode node) {
        if (node.maxVal < v) {
            return null;
        } if (node.left == null && node.right == null) {
            node.maxVal -= v;
            node.waste= node.maxVal;
            node.count = node.count == 0 ? 1: node.count;
            return node;
        }
        if (updateTree(start, (start + end)/2, v, node.left) == null) {
            updateTree((start + end)/2 + 1, end, v, node.right);
        }
        node.count = node.count < node.right.count + node.left.count? node.right.count + node.left.count: node.count;
        node.waste = node.right.waste + node.left.waste;
        node.maxVal = Math.max(node.left.maxVal, node.right.maxVal);
        return node;
    }

    static StarNode buildTree(Integer start, Integer end, Integer K) {
        if (start == end) {
            return new StarNode(0, K, 0, null, null);
        }
        StarNode left = buildTree(start, (start + end)/2, K);
        StarNode right = buildTree((start + end)/2 + 1, end, K);
        return new StarNode(left.waste + right.waste ,
                Math.max(left.maxVal, right.maxVal),
                left.count + right.count, left, right);
    }
}

class StarNode {
    Integer waste;
    Integer maxVal;
    Integer count;
    StarNode left;
    StarNode right;

    public StarNode(Integer waste, Integer maxVal, Integer count, StarNode left, StarNode right) {
        this.waste = waste;
        this.maxVal = maxVal;
        this.count = count;
        this.left = left;
        this.right = right;
    }
}