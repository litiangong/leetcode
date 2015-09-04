import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class ClosestBSTKNodes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private double target;
	private TreeNode closest;
	private double diff = Double.MAX_VALUE;
	
	public List<Integer> closestKValues(TreeNode root, double target, int k) {
		this.target = target;
		
        Stack<TreeNode> pre = new Stack<>();
        Stack<TreeNode> suc = new Stack<>();
        
        fillPre(root, pre);
        fillSuc(root, suc);
        
        while(!pre.isEmpty() && pre.peek().val != closest.val){
        	pre.pop();
        }
        while(!suc.isEmpty() && suc.peek().val != closest.val){
        	suc.pop();
        }
        
        if(!suc.isEmpty())
        	suc.pop();
        
        List<Integer> res = new ArrayList<>();
        res.add(pre.pop().val);
        while(res.size() < k){
        	if(!pre.isEmpty() && !suc.isEmpty()) {
	        	int a = pre.peek().val;
	        	int b = suc.peek().val;
	        	
	        	if(Math.abs(a - target) < Math.abs(b - target)){
	        		res.add(pre.pop().val);
	        	} else {
	        		res.add(suc.pop().val);
	        	}
        	} else if(pre.isEmpty()){
        		res.add(suc.pop().val);
        	} else {
        		res.add(pre.pop().val);
        	}
        	
        }
        
        return res;
    }
	
	private void fillSuc(TreeNode root, Stack<TreeNode> stack) {
		
		if(diff > Math.abs(root.val - target)){
			diff = Math.abs(root.val - target);
			closest = root;
		}
		
		if(root.right != null) {
			fillSuc(root.right, stack);
		}
		stack.push(root);
		if(root.left != null) {
			fillSuc(root.left, stack);
		}
	}

	private void fillPre(TreeNode root, Stack<TreeNode> stack) {
		if(root.left != null) {
			fillPre(root.left, stack);
		}
		stack.push(root);
		if(root.right != null) {
			fillPre(root.right, stack);
		}
		
	}

	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { 
			 val = x; 
		}
	}
}
