/**
 * Created by pfjia on 2017/5/7.
 */
public class Interval {
	int start, end;

	Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public String toString() {
		return "[" + start + "," + end + ']';
	}
}