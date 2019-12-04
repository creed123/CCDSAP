package spoj;

import java.util.*;

public class YodaNess {
    static Integer count;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer T = scanner.nextInt();
        while (T > 0) {
            count = 0;
            Integer num = scanner.nextInt();
            scanner.nextLine();
            String str = scanner.nextLine();
            String str2 = scanner.nextLine();
            Map<String, Integer> map = new HashMap<>();
            int i = 1;
            for (String s1 : Arrays.asList(str2.split(" "))) {
                map.put(s1, i);
                i++;
            }
            List<Integer> list = new ArrayList<>();
            for (String s2 : Arrays.asList(str.split(" "))) {
                list.add(map.get(s2));
            }
            sort(0, list.size() -1, list);
            System.out.println(count);
            T--;
        }
    }

    public static void sort(int start, int end, List<Integer> list) {
        if (start == end) {
            return;
        }
        sort(start, (start + end)/2, list);
        sort((start + end)/2 +1, end, list);
        List<Integer> temp = new ArrayList<>();
        int i = start;
        int j = (start+ end)/2 + 1;
        while( i <= (start + end)/2 && j<=end) {
            if (list.get(i) > list.get(j)) {
                    count += ((start + end)/2) - i + 1;
                    temp.add(list.get(j));
                    j++;
                } else {
                    temp.add(list.get(i));
                    i++;
                }
        }
        while (i <= (start + end)/2) {
            temp.add(list.get(i));
            i++;
        }
        while (j <= end) {
            temp.add(list.get(j));
            j++;
        }
        int k = start;
        for (int l = 0; k <= end; k++, l++) {
            list.set(k, temp.get(l));
        }
    }
}