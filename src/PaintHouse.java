
public class PaintHouse {

	public static void main(String[] args) {
		System.out.println(new PaintHouse().minCost(new int[][]{new int[]{1,2,3}, new int[]{3,2,1}}));

	}

	public int minCost(int[][] costs) {
		if(costs == null || costs.length == 0)
			return 0;
		
		int n = costs.length;
		int colors = 3;
		
        int[] dp = new int[colors];
        
        for(int i = 0;i<colors;i++){
        	dp[i] = costs[0][i];
        }
        
        for(int i = 1;i<n;i++){
        	int[] temp = new int[colors];
        	temp[0] = Math.min(dp[1], dp[2]) + costs[i][0];
        	temp[1] = Math.min(dp[0], dp[2]) + costs[i][1];
        	temp[2] = Math.min(dp[1], dp[0]) + costs[i][2];
        	dp = temp;
        }
        
        return Math.min(Math.min(dp[0], dp[1]),dp[2]);
    }

}
