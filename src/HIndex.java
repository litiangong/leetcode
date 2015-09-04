import java.util.Arrays;

public class HIndex {

	public static void main(String[] args) {
		System.out.println(new HIndex().hIndex(new int[]{3, 0, 6, 1, 5}));
		System.out.println(new HIndex().hIndex(new int[]{1}));
		System.out.println(new HIndex().hIndex(new int[]{1,2,3,4,5,6}));
	}
	
	public int hIndex(int[] citations) {
        Arrays.sort(citations);
        for(int i = 0;i<citations.length;i++){
        	if(citations.length - i >= citations[i]){
        		return Math.max(citations.length - i,citations[i]) ;
        	}
        }
        return 0;
    }

}
