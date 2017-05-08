import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by pfjia on 2017/5/7.
 */

public class Solution {
	/**
	 * @param intervals,
	 *            a collection of intervals
	 * @return: A new sorted interval list.
	 */
	/**
	 *
	 * @param intervals
	 * @return
	 */
	public List<Interval> merge(List<Interval> intervals) {
		// write your code here
		intervals.sort(new Comparator<Interval>() {
			@Override
			public int compare(Interval i1, Interval i2) {
				return i1.start > i2.start ? 1
						: (i1.start == i2.start ? 0 : -1);
			}
		});
		// sort(intervals);
		// 排序后就可以只对相邻的两个区间进行判断
		for (int i = 0; i < intervals.size(); i++) {
			Interval now = intervals.get(i);
			if (i + 1 >= intervals.size()) {
				break;
			}
			Interval next = intervals.get(i + 1);
			if (canMerge(now, next)) {
				Interval newInterval = merge(now, next);
				intervals.remove(now);
				intervals.remove(next);
				intervals.add(i, newInterval);
				i--;
			}

		}
		return intervals;
	}

	/**
	 * 对intervals中的元素根据start进行排序 选择排序
	 *
	 */
	// public void sort(List<Interval> intervals) {
	// for (int i = 0; i < intervals.size(); i++) {
	// int minIndex = i;
	// for (int j = i + 1; j < intervals.size(); j++) {
	// minIndex = intervals.get(minIndex).start < intervals
	// .get(j).start ? minIndex : j;
	// }
	// // 交换两个元素
	// intervals.add(i, intervals.get(minIndex));
	// Interval temp = intervals.get(i + 1);
	// intervals.remove(i + 1);
	// intervals.add(minIndex, temp);
	// intervals.remove(minIndex + 1);
	// }
	// }

	public boolean canMerge(Interval i1, Interval i2) {
		int maxStart = i1.start > i2.start ? i1.start : i2.start;
		int minEnd = i1.end < i2.end ? i1.end : i2.end;
		if (maxStart <= minEnd) {
			return true;
		}
		return false;
	}

	public Interval merge(Interval i1, Interval i2) {
		int minStart = i1.start < i2.start ? i1.start : i2.start;
		int maxEnd = i1.end > i2.end ? i1.end : i2.end;
		return new Interval(minStart, maxEnd);
	}

	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(2, 3));
		intervals.add(new Interval(2, 2));
		intervals.add(new Interval(3, 3));
		intervals.add(new Interval(1, 3));
		intervals.add(new Interval(5, 7));
		intervals.add(new Interval(2, 2));
		intervals.add(new Interval(4, 6));
		Solution s = new Solution();
		s.merge(intervals);
		System.out.println(intervals);
	}
}
