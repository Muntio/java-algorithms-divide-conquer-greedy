package assignment2;

import java.util.LinkedList;

public class Greedy {

    public static LinkedList<Activity> activitySelection(LinkedList<Activity> activities) {
        // TASK 1.B.a
        LinkedList<Activity> result = new LinkedList<>();
        boolean[] used = new boolean[activities.size()];

        Activity current = null;

        for (int k = 0; k < activities.size(); k++) {
            Activity next = null;
            int nextIndex = -1;

            for (int i = 0; i < activities.size(); i++) {
                if (used[i]) continue;

                Activity a = activities.get(i);

                if (current == null || !a.overlap(current)) {
                    if (next == null || a.overlap(next)) {
                        next = a;
                        nextIndex = i;
                    }
                }
            }

            if (next != null) {
                result.add(next);
                used[nextIndex] = true;
                current = next;
            }
        }

        return result;
    }

    public static LinkedList<Integer> makeChange(int amount, int[] denominations) {
        // TASK 1.B.b
        LinkedList<Integer> result = new LinkedList<>();

        for (int d : denominations) {
            while (amount >= d) {
                result.add(d);
                amount -= d;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        LinkedList<Activity> activities = new LinkedList<Activity>();
        activities.add(new Activity(1,1, 4));
        activities.add(new Activity(2, 3, 5));
        activities.add(new Activity(3, 0, 6));
        activities.add(new Activity(4, 5, 7));
        activities.add(new Activity(5, 3, 8));
        activities.add(new Activity(6, 5, 9));
        activities.add(new Activity(7, 6, 10));
        activities.add(new Activity(8, 8, 11));
        activities.add(new Activity(9, 8, 12));
        activities.add(new Activity(10, 2, 13));
        activities.add(new Activity(11, 12, 14));
        activitySelection(activities).forEach(a -> a.print());

        System.out.println();
        makeChange(1234, new int[] { 5000, 2000, 1000, 500, 200, 100, 50, 20, 10, 5, 2, 1 }).forEach(i -> System.out.println(i));
    }
}
