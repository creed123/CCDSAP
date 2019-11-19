package codechef;

import java.util.*;

public class IpcTrain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer T = sc.nextInt();
        while (T > 0) {
            Integer N = sc.nextInt();
            Integer D = sc.nextInt();
            List<Trainer> trainers = new ArrayList<>();
            while (N > 0) {
                trainers.add(new Trainer(sc.nextInt(), sc.nextInt(), sc.nextInt()));
                N--;
            }
            Collections.sort(trainers,new Comparator<Trainer>(){
                public int compare(Trainer a,Trainer b){
                    return Integer.compare(a.day, b.day);
                }
            });            PriorityQueue<Trainer> priorityQueue = new PriorityQueue<Trainer>(new Comparator<Trainer>() {
                @Override
                public int compare(Trainer o1, Trainer o2) {
                    if (o1.sadness > o2.sadness)
                        return -1;
                    else if (o1.sadness < o2.sadness) {
                        return 1;
                    }
                    return 0;
                }
            });
            int j = 0;
            for (int i = 1; i <= D; i++) {
                while (j< trainers.size() && trainers.get(j).day == i) {
                        priorityQueue.offer(trainers.get(j));
                        j++;
                }
                if (!priorityQueue.isEmpty()) {
                    priorityQueue.peek().lectures --;
                    if (priorityQueue.peek().lectures == 0) {
                        priorityQueue.poll();
                    }
                }
            }
            Integer sum = priorityQueue.stream().map(p -> p.sadness * p.lectures).reduce((e1, e2) -> e1+e2).orElse(0);
            System.out.println(sum);
            T --;
        }

    }
}

 class Trainer {
     public Integer day;
     public Integer lectures;
     public Integer sadness;


     Trainer(Integer day, Integer lectures, Integer sadness) {
         this.day = day;
         this.lectures = lectures;
         this.sadness = sadness;
     }
 }
