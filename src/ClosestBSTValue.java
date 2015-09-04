
public class ClosestBSTValue {

	public static void main(String[] args) {
		

	}
	
	public int closestValue(TreeNode root, double target) {
        if(root.val == target){
        	return root.val;
        }
        
        if(target < root.val) {
        	if(root.left == null)
        		return root.val;
        	
        	int c = closestValue(root.left, target);
        	if(root.val - target > Math.abs(c - target))
        		return c;
        	
        } else {
        	if(root.right == null)
        		return root.val;
        	
        	int c = closestValue(root.right, target);
        	if( Math.abs(root.val - target) > Math.abs(c - target))
        		return c;
        }
        

    	return root.val;
		
    }
	
	
	public static class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}

}
