package codechef;

import java.util.*;

public class PurifIt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer T = 0;
        if (scanner.hasNextInt()) {
            T = scanner.nextInt();
        }
        for (int i = 0; i < T; i++) {
            String str = scanner.next();
            StringBuilder made = new StringBuilder("");
            made.append(str.charAt(0));
            Character curr = str.charAt(0);
            Integer idx = 0;
            Map<Integer, Integer> map = new HashMap<>();
            map.put(idx, map.getOrDefault(idx, 0) + 1);
            for (int j = 1; j < str.length(); j++) {
                if (str.charAt(j) != curr) {
                    curr = str.charAt(j);
                    made.append(curr);
                    idx++;
                }
                map.put(idx, map.getOrDefault(idx, 0) + 1);
            }
            String unique = made.toString();
            Integer center = unique.length()/2;
            Integer count = 0;
            while (unique.length() > 3) {
                Set<Integer> indexes = new TreeSet<>();
                for (int j = center - 3; j <= center; j++) {
                    if (j < 0) {
                        continue;
                    }
                    Integer found = findMinIdx(map, j);
                    if (!found.equals(center)) {
                        indexes.add(found);
                    }
                }
                if (indexes.stream().map(map::get).reduce(Integer::sum).orElse(0) >= map.get(center) || indexes.isEmpty()) {
                    count += map.get(center);
                    map.put(center - 1, map.getOrDefault(center -1, 0) + map.getOrDefault(center + 1, 0));
                    for (int k = center; k < unique.length() - 2; k++) {
                        map.put(k, map.getOrDefault(k+2, 0));
                    }
                    map.remove(unique.length() - 1);
                    map.remove(unique.length() - 2);
                    if (center <= 0) {
                        unique = unique.substring(center + 1);
                    } else if (center >= unique.length() - 1) {
                        unique = unique.substring(0, center);
                    } else {
                        unique = unique.substring(0, center - 1) + unique.substring(center + 1);
                    }
                    center = unique.length()/2;
                } else {
                    center = indexes.iterator().next();
                }
            }
            System.out.println(count);
        }
    }

    static Integer findMinIdx( Map<Integer, Integer> map, Integer idx) {
        Integer min = idx;
        for (int i = idx; i <= idx + 3; i++) {
            if (!map.containsKey(i)) {
                return min;
            }
            if (map.get(min) >= map.get(i)) {
                min = i;
            }
        }
        return min;
    }
}
