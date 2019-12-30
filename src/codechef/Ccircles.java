package codechef;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ccircles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer N = 0;
        Integer Q = 0;
        if (scanner.hasNextInt()) {
            N = scanner.nextInt();
        }
        if (scanner.hasNextInt()) {
            Q = scanner.nextInt();
        }
        List<Double> min = new ArrayList<>();
        List<Double> max = new ArrayList<>();
        List<Circle> circles = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            Integer X = scanner.nextInt();
            Integer Y = scanner.nextInt();
            Integer R = scanner.nextInt();
            for (Circle circle: circles) {
                if (Math.max(circle.R, R) - (Math.sqrt(Math.pow(circle.X - X, 2) + Math.pow(circle.Y - Y, 2))
                        + Math.min(circle.R, R)) >= 0) {
                    min.add(Math.max(circle.R, R) -
                            (Math.sqrt(Math.pow(circle.X - X, 2) + Math.pow(circle.Y - Y, 2))
                                    + Math.min(circle.R, R)));
                } else {
                    min.add(Math.sqrt(Math.pow(circle.X - X, 2) + Math.pow(circle.Y - Y, 2)) - (circle.R + R));
                }
                max.add(Math.sqrt(Math.pow(circle.X - X, 2) + Math.pow(circle.Y - Y, 2)) + (circle.R + R));
            }
            circles.add(new Circle(X, Y, R));
        }
        for (int i = 0; i < Q; i++) {
            Integer num = scanner.nextInt();
            Integer count = 0;
            for (int j = 0; j < max.size(); j++) {
                if (max.get(j) >= num && min.get(j) <= num) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}

class Circle {
    Integer X;
    Integer Y;
    Integer R;

    public Circle(Integer x, Integer y, Integer r) {
        X = x;
        Y = y;
        R = r;
    }
}
