
public class MissingNumber {

	public static void main(String[] args) {
		System.out.println(new MissingNumber().missingNumber(new int[]{0,1,3}));

	}
	
	public int missingNumber(int[] nums) {
		
        for(int i = 0;i<nums.length;i++){
        	if(nums[i] != i){
        		int temp = nums[i];
        		if(temp < nums.length){
	        		nums[i] = nums[temp];
	        		nums[temp] = temp;
	        		i--;
        		} 
        		
        	}
        }
        
        for(int i = 0;i<nums.length;i++){
        	if(nums[i] != i){
        		return i;
        	}
        }
		
		return nums.length;
    }

}
