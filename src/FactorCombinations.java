import java.util.ArrayList;
import java.util.List;


public class FactorCombinations {

	private List<List<Integer>> res = new ArrayList<List<Integer>>();
	
	public static void main(String[] args) {
		for(List<Integer> list : new FactorCombinations().getFactors(32)){
			for(int i : list){
				System.out.print(i+",");
			}
			System.out.println("");
		}

	}
	
	public List<List<Integer>> getFactors(int n) {
		
		if(n > 2) {
			work(n, new ArrayList<Integer>());
		}
		
		return res;
		
    }
	
	private void work(int n, List<Integer> list){
		int x = 2;
		
		if(!list.isEmpty()) {
			x = list.get(list.size() - 1);
		}
		
		for(int i = x;i<=Math.sqrt(n);i++){
			if(n % i == 0) {
				List<Integer> temp = new ArrayList<>(list);
				temp.add(i);
				temp.add(n/i);
				res.add(temp);
				list.add(i);
				work(n/i, list);
				list.remove(list.size()-1);
			}
		}
		
	}

}
