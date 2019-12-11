package codechef;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class ChFran {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = 0;
        if (scanner.hasNextInt()) {
            T = scanner.nextInt();
        }
        List<Bracks> list = new ArrayList<>();
        for (int i = 0; i < Math.pow(10, 9); i++) {
            list.add(new Bracks(0,0));
        }
        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            for (int j = 0; j < N ; j++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                Bracks bracks = list.get(a);
                bracks.open += 1;
                list.set(a, bracks);
                Bracks bracks1 = list.get(b);
                bracks1.closed += 1;
                list.set(b, bracks1);
            }
            Stack<Integer> stack = new Stack<>();
            boolean closed = false;
            Integer min = 0;
            for (int j = 0; j < list.size(); j++) {
                for (int k = 0; k < list.get(i).closed; k++) {
                    closed = true;
                    stack.pop();
                }
                for (int k = 0; k < list.get(i).open; k++) {
                    if (stack.size() < min && closed == true) {
                        min = stack.size();
                    }
                    stack.push(1);
                }
            }
            System.out.println(min);
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
