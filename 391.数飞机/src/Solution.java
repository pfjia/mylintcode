import java.util.*;

/**
 * Created by pfjia on 2017/5/8 0008.
 */
public class Solution {
	/**
	 * @param airplanes:
	 *            An interval array
	 * @return: Count of airplanes are in the sky.
	 */
	public int countOfAirplanes(List<Interval> airplanes) {
		// write your code here
		if (airplanes.size() == 0) {
			return 0;
		}
		Map<Integer, Integer> map = new HashMap<>();

		// 在start时飞机数增加一辆，在end时飞机数减少一辆
		for (Interval airplane : airplanes) {
			int start = airplane.start;
			int end = airplane.end;
			if (!map.containsKey(start)) {
				map.put(start, 1);
			} else {
				map.put(start, map.get(start) + 1);
			}
			if (!map.containsKey(end)) {
				map.put(end, -1);
			} else {
				map.put(end, map.get(end) - 1);
			}
		}
		int maxCount = 0;
		int count = 0;
		// 根据飞机升降的时间进行排序
		List<Integer> list = new ArrayList<>(map.keySet());
		Collections.sort(list);

		for (Integer c : list) {
			count += map.get(c);
			maxCount = Math.max(maxCount, count);
		}
		return maxCount;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		List<Interval> airplanes = new ArrayList<>();
		airplanes.add(new Interval(1, 10));
		airplanes.add(new Interval(2, 3));
		airplanes.add(new Interval(5, 8));
		airplanes.add(new Interval(4, 7));
		int count = s.countOfAirplanes(airplanes);
		System.out.println(count);
	}

}
