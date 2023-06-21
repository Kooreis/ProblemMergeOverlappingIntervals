Here is a Python console application that solves the problem:

```python
def merge_intervals(intervals):
    if not intervals:
        return []

    intervals.sort(key=lambda x: x[0])
    merged = [intervals[0]]

    for current in intervals:
        previous = merged[-1]
        if current[0] <= previous[1]:
            previous[1] = max(previous[1], current[1])
        else:
            merged.append(current)

    return merged


def main():
    intervals = [[1, 3], [2, 6], [8, 10], [15, 18]]
    print("Original intervals: ", intervals)
    print("Merged intervals: ", merge_intervals(intervals))


if __name__ == "__main__":
    main()
```

This Python console application first sorts the intervals by their start times. Then it iterates over the sorted intervals, and for each one, it either merges it with the last interval in `merged` if they overlap, or it adds it to `merged` as a new interval if they don't overlap.