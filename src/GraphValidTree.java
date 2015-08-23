


public class GraphValidTree {

	public static void main(String[] args) {
		System.out.println(new GraphValidTree().validTree(5, new int[][]{
				new int[]{0,1},
				new int[]{0,2},
				new int[]{0,3},
				new int[]{1,4}}));

	}
	
	public boolean validTree(int n, int[][] edges) {
		if(n <= 0)
			return false;
		
		if(edges.length != n -1)
			return false;
		
		int[] all = new int[n];
		for(int i = 0;i<n;i++){
			all[i] = i;
		}
		
		for(int i = 0;i<edges.length;i++){
			int a = edges[i][0];
			int b = edges[i][1];
			
			if(a == b)
				return false;
			
			//can be improve to logN for union, logN for find
			//this is nodes x edges
			int x = all[a];
			for(int j = 0;j<all.length;j++){
				if(all[j] == x){
					all[j] = all[b];
				}
			}
		}
		
		for(int i = 1;i<n;i++){
			if(all[i] != all[i-1])
				return false;
		}
		
        return true;
    }

}
