import java.util.Arrays;
import java.util.Comparator;

public class MeetingRoomsI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
				// TODO Auto-generated method stub
				return o1.start - o2.start;
			}
        	
		});
        
        for(int i = 1;i<intervals.length;i++) {
        	if(intervals[i].start < intervals[i-1].end)
        		return false;
        }
        return true;
    }

	public static class Interval {
		 int start;
		 int end;
		 Interval() { start = 0; end = 0; }
		 Interval(int s, int e) { start = s; end = e; }
	}
}
