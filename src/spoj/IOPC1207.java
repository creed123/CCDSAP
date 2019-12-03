package spoj;

import java.util.Scanner;

public class IOPC1207 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer T = scanner.nextInt();
        while (T > 0) {
            Integer Nx = scanner.nextInt();
            Integer Ny = scanner.nextInt();
            Integer Nz = scanner.nextInt();
            Integer Q = scanner.nextInt();
            Node headz = buildTree(0, Nz);
            Node heady = buildTree(0, Ny);
            Node headx = buildTree(0, Nx);
            while (Q > 0) {
                Integer opt = scanner.nextInt();
                switch (opt) {
                    case 0: {
                        Integer x = scanner.nextInt();
                        Integer y = scanner.nextInt();
                        update(0, Nx, headx, x, y);
                        break;
                    }
                    case 1: {
                        Integer x = scanner.nextInt();
                        Integer y = scanner.nextInt();
                        update(0, Ny, heady, x, y);
                        break;
                    }
                    case 2: {
                        Integer x = scanner.nextInt();
                        Integer y = scanner.nextInt();
                        update(0, Nz, headz, x, y);
                        break;
                    }
                    case 3 : {
                        Integer x1 = scanner.nextInt();
                        Integer y1 = scanner.nextInt();
                        Integer z1 = scanner.nextInt();

                        Integer x2 = scanner.nextInt();
                        Integer y2 = scanner.nextInt();
                        Integer z2 = scanner.nextInt();
                        Integer gx = query(0, Nx, headx, x1, x2).green;
                        Integer gy = query(0, Ny, heady, y1, y2).green;
                        Integer gz = query(0, Nz, headz, z1, z2).green;
                        Integer num =
                                gx*(y2-y1 + 1 - gy)*(z2-z1  + 1 - gz)
                                        + gy*(x2-x1 + 1 - gx)*(z2-z1 + 1 - gz)
                                        + gz*(x2-x1 + 1 - gx)*(y2-y1 + 1 - gy)
                                        + (gx*gy*(z2-z1 + 1 - gz)
                                        + gx*gz*(y2-y1 + 1 - gy)
                                        + gy*gz*(z2-z1 + 1 - gz))
                                        + gx*gy*gz;
                        System.out.println(num);
                        break;
                    }
                }
                Q --;
            }
            T--;
        }
    }

    static Node query(Integer start, Integer end, Node node, Integer idx1, Integer idx2) {
        if (start == idx1 && end == idx2) {
            return node;
        }
        if (idx1 > (start + end)/2) {
            return query((start + end)/2 + 1, end,node.right, idx1, idx2);
        } if (idx2 <= (start + end)/2) {
            return query(start, (start + end)/2, node.left, idx1, idx2);
        }
        Node left = query(start, (start + end)/2, node.left, idx1, (start + end)/2);
        Node right = query((start + end)/2 + 1, end ,node.right, (start + end)/2 + 1, idx2);
        return new Node(left, right, left.green + right.green);
    }

    static Node buildTree(Integer start, Integer end) {
        if (start >= end) {
            return new Node(null, null, 0);
        }
        Node left = buildTree(start, (start + end)/2);
        Node right = buildTree((start + end)/2+1, end);
        return new Node(left, right, 0);
    }

    static Integer update(Integer start, Integer end, Node node, Integer idx1, Integer idx2) {
        if (start == end) {
            node.green = node.green == 0? 1: 0;
            return node.green;
        }
        if (idx1 > (start + end)/2) {
            node.green = update((start + end)/2 + 1, end,node.right, idx1, idx2);
            return node.green;
        } if (idx2 <= (start + end)/2) {
            node.green =  update(start, (start + end)/2, node.left, idx1, idx2);
            return  node.green;
        }
        Integer left = update(start, (start + end)/2, node.left, idx1, (start + end)/2);
        Integer right = update((start + end)/2 + 1, end ,node.right, (start + end)/2 + 1, idx2);
        node.green = left + right;
        return node.green;
    }
}

class Node {
    Node left;
    Node right;
    Integer green;

    public Node(Node left, Node right, Integer green) {
        this.left = left;
        this.right = right;
        this.green = green;
    }
}
