Here is a C# console application that solves the problem:

```csharp
using System;
using System.Collections.Generic;
using System.Linq;

public class Interval
{
    public int Start { get; set; }
    public int End { get; set; }
}

public class Program
{
    static void Main(string[] args)
    {
        List<Interval> intervals = new List<Interval>()
        {
            new Interval() { Start = 1, End = 3 },
            new Interval() { Start = 2, End = 6 },
            new Interval() { Start = 8, End = 10 },
            new Interval() { Start = 15, End = 18 }
        };

        var result = Merge(intervals);

        foreach (var interval in result)
        {
            Console.WriteLine($"[{interval.Start}, {interval.End}]");
        }
    }

    public static List<Interval> Merge(List<Interval> intervals)
    {
        if (intervals.Count <= 1)
            return intervals;

        intervals = intervals.OrderBy(i => i.Start).ToList();

        List<Interval> result = new List<Interval>();
        Interval start = intervals[0];
        Interval current;

        for (int i = 1; i < intervals.Count; i++)
        {
            current = intervals[i];

            if (current.Start <= start.End)
            {
                start.End = Math.Max(current.End, start.End);
            }
            else
            {
                result.Add(start);
                start = current;
            }
        }

        result.Add(start);

        return result;
    }
}
```

This program defines an `Interval` class with `Start` and `End` properties. It then defines a `Merge` method that takes a list of intervals, sorts them by the `Start` property, and merges overlapping intervals. The `Main` method creates a list of intervals, merges them, and prints the result.