package codechef;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BadMath {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Integer T = scanner.nextInt();
        while (T > 0) {
            Integer N = scanner.nextInt();
            Integer M = scanner.nextInt();
            String str = scanner.next();

            List<String> list = new ArrayList<>();
            while (N > 0) {
                list.add(String.valueOf(str.charAt(N - 1)));
                N--;
            }
            Double num = 0.0;
            List<Double> refs = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                if (!list.get(i).equals("_")) {
                    num += Integer.valueOf(list.get(i)) * Math.pow(2, i);
                } else {
                    refs.add(Math.pow(2, i));
                }
            }
            System.out.println(getVals(refs, M, num, 0));
            T--;
        }
    }


    public static Integer getVals(List<Double> refs, Integer M, Double sum, Integer idx) {
        if (idx == refs.size() - 1) {
            if (((sum + refs.get(idx)) % M == 0) && ((sum % M == 0))) {
                return 2;
            } else if (((sum + refs.get(idx)) % M == 0) || ((sum % M == 0))) {
                return 1;
            } else {
                return 0;
            }
        }
        return getVals(refs, M, sum + refs.get(idx), idx + 1)
                + getVals(refs, M, sum, idx + 1);
    }
}