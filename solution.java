Here is a Java console application that solves the problem:

```java
import java.util.*;

class Interval {
    int start, end;
    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of intervals:");
        int n = scanner.nextInt();
        List<Interval> intervals = new ArrayList<>();
        System.out.println("Enter the intervals:");
        for (int i = 0; i < n; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            intervals.add(new Interval(start, end));
        }
        List<Interval> result = merge(intervals);
        System.out.println("Merged intervals:");
        for (Interval interval : result) {
            System.out.println(interval.start + " " + interval.end);
        }
    }

    public static List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1)
            return intervals;
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
        List<Interval> result = new LinkedList<>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for (Interval interval : intervals) {
            if (interval.start <= end)
                end = Math.max(end, interval.end);
            else {
                result.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        result.add(new Interval(start, end));
        return result;
    }
}
```

This console application first asks the user to input the number of intervals and then the intervals themselves. It then merges the overlapping intervals and prints the result. The `merge` method sorts the intervals by their start time and then iterates over them, merging overlapping intervals.