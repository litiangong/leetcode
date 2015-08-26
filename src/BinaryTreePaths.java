import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

	public List<String> res = new ArrayList<>();
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		root.left = two;
		BinaryTreePaths path = new BinaryTreePaths();
		
		path.binaryTreePaths(root);
		for(String s : path.res) {
			System.out.println(s);
		}
	}
	
	public List<String> binaryTreePaths(TreeNode root) {
        List<Integer> ss = new ArrayList<>();
        recursive(root, ss);
        return res;
    }
	
	private void recursive(TreeNode root, List<Integer> list){
		if(root != null){
			list.add(root.val);
		} else
			return;
		
		if(root.left == null && root.right == null){
			
			StringBuilder sb = new StringBuilder();
			for(Integer val : list){
				if(sb.length() > 0){
					sb.append("->");
				}
				sb.append(val);
			}
			res.add(sb.toString());
			
		} else{ 
			if(root.left != null){
			
				recursive(root.left, list);
				list.remove(list.size()-1);
			
			} 
			
			if(root.right != null){
			
				recursive(root.right, list);
				list.remove(list.size()-1);
			
			}
		}
	}
	
	public static class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}

}
