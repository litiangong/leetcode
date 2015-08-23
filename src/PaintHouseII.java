
public class PaintHouseII {

	public static void main(String[] args) {
		PaintHouseII paintHouseII = new PaintHouseII();
		System.out.println(paintHouseII.minCostII(new int[][]{new int[]{1,5,3}, new int[]{2,9,4}}));

	}
	
	
	public int minCostII(int[][] costs) {
		
		if(costs == null || costs.length == 0){
			return 0;
		}
        
		int n = costs.length;
		int colors = costs[0].length;
		
		int[] dp = new int[colors];
		
		for(int i = 0;i<colors;i++){
			dp[i] = costs[0][i];
		}
		
		for(int j = 1;j<n;j++){
			int[] temp = new int[colors];
			for(int i = 0;i<colors;i++){
				temp[i] = getMin(dp, i) + costs[j][i];//careful
			}
			dp = temp;
		}
		
		
		return getMin(dp, Integer.MAX_VALUE);
    }
	
	public int getMin(int[] all, int exclude){
		int min = Integer.MAX_VALUE;
		for(int i = 0;i<all.length;i++){
			if(i != exclude){
				min = Math.min(min, all[i]);
			}
		}
		return min;
	}

}
