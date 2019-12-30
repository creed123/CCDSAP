package codechef;

import java.util.*;

public class Camc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer T = 0;
        if (scanner.hasNextInt()) {
            T = scanner.nextInt();
        }
        for (int i = 0; i < T; i++) {
            Integer N = scanner.nextInt();
            Integer M = scanner.nextInt();
            List<Color> colors = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                Color color = new Color(j % M, scanner.nextInt());
                colors.add(color);
            }
            Collections.sort(colors);
            Integer minRange = Integer.MAX_VALUE;
            int k =0;
            Map<Integer, Integer> colourToCount = new HashMap<>();
            for (int j = 0; j < N; j++) {
                for (; colourToCount.size() != M && k<N ; k++) {
                    colourToCount.put(colors.get(k).color, colourToCount.getOrDefault(colors.get(k).color, 0) + 1);
                }
                if (colourToCount.size() == M) {
                    minRange = Math.min(minRange, colors.get(k-1).value - colors.get(j).value);
                }
                colourToCount.put(colors.get(j).color, colourToCount.get(colors.get(j).color) - 1);
                if (colourToCount.get(colors.get(j).color) == 0) {
                    colourToCount.remove(colors.get(j).color);
                }
            }
            System.out.println(minRange);
        }
    }
}

class Color implements Comparable {
    Integer color;
    Integer value;

    public Color(Integer color, Integer value) {
        this.color = color;
        this.value = value;
    }

    @Override
    public int compareTo(Object o) {
        return Integer.compare(this.value, ((Color)o).value);
    }
}