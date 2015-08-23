
public class SingleNumberIII {

	public static void main(String[] args) {
		
		int[] res = new SingleNumberIII().singleNumber(new int[]{1,2,1,3,2,5});
		System.out.println(res[0]+" "+res[1]);

	}
	
	public int[] singleNumber(int[] nums) {
		int c = 0;
        for(int i = 0;i<nums.length;i++){
        	c ^= nums[i];
        }
        int d = 1;
        int a = 0;
        int b = 0;
        for(int i = 0;i<32;i++){
        	d = d << i;
        	if((d & c) != 0){
        		for(int j = 0;j<nums.length;j++){
        			if((nums[j]&d) == 0){
        				a ^= nums[j];
        			} else {
        				b ^= nums[j];
        			}
        		}
        		break;
        	}
        }
        return new int[]{a,b};
    }

}
