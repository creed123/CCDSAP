package codechef;
import java.util.*;

public class Anumula {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer T = 0;
        if (scanner.hasNextInt()) {
            T = scanner.nextInt();
        }
        while (T > 0) {
            Integer N = scanner.nextInt();
            ArrayList<Integer> al = new ArrayList<>();
            for (int i = 1; i <= Math.pow(2,N) ; i++) {
                Integer num = scanner.nextInt();
                al.add(num);
            }
            al.sort(Comparator.naturalOrder());
            al.sort((o1, o2) -> o1 > o2 ? 1 : -1);
            List<Integer> sum = new ArrayList<>();
            List<Integer> globalSum = new ArrayList<>();
            List<Integer> values = new ArrayList<>();
            for (int i = 1; i < al.size() && values.size() <= N; i++) {
                if (!sum.contains(al.get(i))) {
                    Integer size = globalSum.size();
                    for (int j = 0; j < size; j++) {
                        globalSum.add(globalSum.get(j) + al.get(i));
                    }
                    for (int j = 0; j <values.size() ; j++) {
                        globalSum.add(values.get(j) + al.get(i));
                    }
                    values.add(al.get(i));
                    sum.clear();
                    sum.addAll(globalSum);
                } else {
                    for (int j = 0; j < sum.size(); j++) {
                        if (sum.get(j).equals(al.get(i))) {
                            sum.remove(j);
                            break;
                        }
                    }
                }
            }
            for (int i = 0; i < values.size() - 1; i++) {
                System.out.print(values.get(i) + " ");
            }
            System.out.print(values.get(values.size() - 1));
            System.out.println();
            T --;
        }
    }
}