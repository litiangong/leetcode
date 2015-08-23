import java.util.Arrays;


public class ThreeSumSmaller {

	public static void main(String[] args) {
		System.out.println(new ThreeSumSmaller().threeSumSmaller(new int[]{-2,0,1,3}, 2));

	}
	
	public int threeSumSmaller(int[] nums, int target) {
		
		if(nums.length <= 2)
			return 0;
        
		Arrays.sort(nums);
		int count = 0;
		
		
		//very cool idea
		for(int k = 2;k<nums.length;k++){
			int i = 0;
			int j = k-1;
			while(i<j){
				if(nums[i] + nums[j] + nums[k] < target){
					count+=j-i;
					i++;
				} else {
					j--;
				}
			}
			
			
		}
			
			
		return count;
    }

}
