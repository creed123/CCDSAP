package codechef;

import java.util.Scanner;
import java.util.Stack;

public class ChFran {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = 0;
        if (scanner.hasNextInt()) {
            T = scanner.nextInt();
        }
        for (int i = 0; i < T; i++) {
            Bracks[] bracks = new Bracks[(int) Math.round(Math.pow(10, 6))];
            int maxb = Integer.MIN_VALUE;
            int N = scanner.nextInt();
            for (int j = 0; j < N ; j++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                maxb = Math.max(maxb, b);
                if (bracks[a] == null) {
                    Bracks bracks1 = new Bracks(0, 0);
                    bracks1.open +=1;
                    bracks[a] = bracks1;
                }
                else {
                    Bracks bracks1 = bracks[a];
                    bracks1.open += 1;
                    bracks[a] = bracks1;
                }
                if (bracks[b] == null) {
                    Bracks bracks1 = new Bracks(0, 0);
                    bracks1.closed +=1;
                    bracks[b] = bracks1;
                } else {
                    Bracks bracks1 = bracks[b];
                    bracks1.closed += 1;
                    bracks[b] = bracks1;
                }
            }
            Stack<Integer> stack = new Stack<>();
            boolean closed = false;
            Integer min = Integer.MAX_VALUE;
            Integer subsets = 0;
            for (int j = 1; j <= maxb; j++) {
                if (bracks[j] != null) {
                    for (int k = 0; k < bracks[j].open; k++) {
                        if (closed) {
                            if (stack.size() == 0) {
                                subsets ++;
                            } else if (min > stack.size()) {
                                min = stack.size();
                                if (subsets == 0) {
                                    subsets++;
                                }
                            }
                        }
                        stack.push(1);
                    }
                    for (int k = 0; k < bracks[j].closed; k++) {
                        closed = true;
                        stack.pop();
                    }
                    if (subsets > 1) {
                        min = -1;
                        break;
                    }
                }
            }
            System.out.println(subsets > 1 ? -1:min == Integer.MAX_VALUE ? 0: min);
        }
    }
}

class Bracks {
    Integer open;
    Integer closed;

    public Bracks(Integer open, Integer closed) {
        this.open = open;
        this.closed = closed;
    }
}