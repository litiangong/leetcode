import java.util.Stack;

public class VerifyPreorder {

	public static void main(String[] args) {
		System.out.print(new VerifyPreorder().verifyPreorder(new int[]{}));

	}
	
	public boolean verifyPreorder(int[] preorder) {
		
        if(preorder == null || preorder.length == 0)
        	return false;
        
        return verifyPreorder(preorder, 0);
        
    }

	private boolean verifyPreorder(int[] preorder, int i) {
		int low = Integer.MIN_VALUE;
	    Stack<Integer> path = new Stack<>();
	    for (int p : preorder) {
	        if (p < low)
	            return false;
	        while (!path.empty() && p > path.peek())
	            low = path.pop();
	        path.push(p);
	    }
	    return true;
	}
	
	//O(1) space
	
//	public boolean verifyPreorder(int[] preorder) {
//	    int low = Integer.MIN_VALUE, i = -1;
//	    for (int p : preorder) {
//	        if (p < low)
//	            return false;
//	        while (i >= 0 && p > preorder[i])
//	            low = preorder[i--];
//	        preorder[++i] = p;
//	    }
//	    return true;
//	}

}
