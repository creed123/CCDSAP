package codechef;

import java.util.*;
import java.util.stream.Collectors;

public class IpcTrain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer T = sc.nextInt();
        while (T > 0) {
            Integer N = sc.nextInt();
            Integer D = sc.nextInt();
            Map<Integer, List<Integer>> map = new HashMap<>();
            while (N > 0) {
                Integer d = sc.nextInt();
                Integer t = sc.nextInt();
                Integer s = sc.nextInt();
                while (t > 0) {
                    if (map.containsKey(d)) {
                        List<Integer> list = map.get(d);
                        list.add(s);
                        map.put(d, list);
                    } else {
                        map.put(d, Arrays.asList(s));
                    }
                    t --;
                }
                N --;
            }
            map = map.entrySet().stream()
                    .sorted((a,b) -> (a.getKey() > b.getKey())? 1 : 0)
                    .collect(Collectors.toMap(e -> e.getKey(), e-> e.getValue()));
            List<Integer> heap = new ArrayList<>();
            for (int i = 1; i < D; i++) {
                for (Integer num : map.get(i)) {
                    heap.add(num);
                    siftUp(heap);
                }
                Integer temp = heap.get(0);
                heap.set(0, heap.get(heap.size() - 1));
                heap.set(heap.get(heap.size() - 1), temp);
                heap.remove(heap.size() - 1);
                siftDown(heap);
            }
            System.out.println(map.values().stream().map(v -> v.stream()
                    .reduce((e1, e2) -> e1 + e2).get())
                    .reduce((e1, e2) -> e1 + e2));
        }
    }

    static void siftUp(List<Integer> heap) {
        Integer len = heap.size() - 1;
        while (true) {
            if (heap.get(len) > heap.get(len/2)) {
                Integer temp = heap.get(len);
                heap.set(len , heap.get(len/2));
                heap.set(len/2, temp);
                len = len/2;
            } else {
                break;
            }
        }
    }

    static void siftDown(List<Integer> heap) {
        Integer len = 0;
        while (true) {
            if (2*len + 1 <= len - 1 && heap.get(2*len + 1) > heap.get(len)) {
                Integer temp = heap.get(len);
                heap.set(len, heap.get(2*len));
                heap.set(2*len, temp);
            } else if (2*len <= len -1  && heap.get(2*len) > heap.get(len)) {
                Integer temp = heap.get(len);
                heap.set(len, heap.get(2*len));
                heap.set(2*len, temp);
            } else {
                break;
            }
        }
    }
}