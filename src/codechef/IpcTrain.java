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
            Map<Integer, Integer> sadMap = new HashMap<>();
            while (N > 0) {
                Integer d = sc.nextInt();
                Integer t = sc.nextInt();
                Integer s = sc.nextInt();
                if (map.containsKey(d)) {
                    List<Integer> list = map.get(d);
                    list.add(s);
                    map.put(d, list);
                } else {
                    List list = new ArrayList();
                    list.add(s);
                    map.put(d, list);
                } if (sadMap.containsKey(s)) {
                    sadMap.put(s, sadMap.get(s) + t);
                } else {
                    sadMap.put(s, t);
                }
                N --;
            }
            map = map.entrySet().stream()
                    .sorted((a,b) -> (a.getKey() > b.getKey())? 1 : 0)
                    .collect(Collectors.toMap(e -> e.getKey(), e-> e.getValue()));

            List<Integer> heap = new ArrayList<>();
            for (int i = 1; i <= D; i++) {
                if (map.containsKey(i)) {
                    for (Integer sadness: map.get(i)) {
                        heap.add(sadness);
                        siftUp(heap);
                    }
                } if (!heap.isEmpty()) {
                    sadMap.put(heap.get(0), sadMap.get(heap.get(0)) - 1);
                    if (sadMap.get(heap.get(0)) == 0) {
                        Integer temp = heap.get(0);
                        heap.set(0, heap.get(heap.size() - 1));
                        heap.set(heap.size() - 1, temp);
                        heap.remove(heap.size() - 1);
                        siftDown(heap);
                    }
                }
            }
            Integer sum = 0;
            for (int i = 0; i < heap.size(); i++) {
                sum+=sadMap.get(heap.get(i)) * heap.get(i);
            }
            System.out.println(sum);
            T --;
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
            if (2*len + 1 <= heap.size() - 1 && heap.get(2*len + 1) > heap.get(len)) {
                Integer temp = heap.get(len);
                heap.set(len, heap.get(2*len + 1));
                heap.set(2*len + 1, temp);
                len = 2*len + 1;
            } else if (2*len + 2 <= heap.size() -1  && heap.get(2*len + 2) > heap.get(len)) {
                Integer temp = heap.get(len);
                heap.set(len, heap.get(2*len + 2));
                heap.set(2*len + 2, temp);
                len = 2* len + 2;
            } else {
                break;
            }
        }
    }
}