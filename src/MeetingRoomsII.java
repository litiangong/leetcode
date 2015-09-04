
public class MeetingRoomsII {

	public static void main(String[] args) {
		System.out.println(new MeetingRoomsII().minMeetingRooms(new Interval[]{new Interval(0, 30)}));

	}
	
	public int minMeetingRooms(Interval[] intervals) {
        int[] all = new int[3600];
        int max = 0;
        for(Interval i : intervals){
        	for(int x = i.start;x<=i.end;x++){
        		all[x] ++;
        		if(all[x] > max){
        			max = all[x];
        		}
        	}
        	
        }
        
        return max;
    }
	
	public static class Interval {
		 int start;
		 int end;
		 Interval() { start = 0; end = 0; }
		 Interval(int s, int e) { start = s; end = e; }
	}

}
