
public class UnionFind {

	private int[] levels = new int[10];
	private int[] all = new int[10];
	
	public static void main(String[] args) {
		int[][] relations = new int[][]{
			new int[]{1,2},
			new int[]{1,3},
			new int[]{1,4},
			new int[]{2,5},
			new int[]{2,6},
			new int[]{3,7},
			new int[]{8,9}
		};
		new UnionFind().unionfind(relations);

	}
	
	private void unionfind(int[][] relations){
		for(int i = 0;i<all.length;i++){
			all[i] = i;
		}
		
		for(int i = 0;i<relations.length;i++){
			
			int p = relations[i][0];
			int c = relations[i][1];
			
			setParent(p, c);
			
		}
		for(int i = 0;i<all.length;i++){
			System.out.print(all[i] + ",");
		}
		
	}
	
	private void setParent(int i, int p){
		int x = findParent(i);
		int y = findParent(p);
		if(levels[x] > levels[y]){
			all[y] = x;
			levels[x] = Math.max(levels[y]+1, levels[x]);
		} else {
			all[x] = y;
			levels[y] = Math.max(levels[x]+1, levels[y]);
		}
	}
	
	private int findParent(int i){
		int l = 0;
		while(i != all[i]){
			i = all[i];
			l++;
		}
		
		if(levels[i] < l)
			levels[i] = l;
		
		return i;
	}
	

}
