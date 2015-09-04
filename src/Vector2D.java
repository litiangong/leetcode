import java.util.ArrayList;
import java.util.List;

public class Vector2D {

	public static void main(String[] args) {
		final List<Integer> l1 = new ArrayList<Integer>() {{
			add(1);
			add(2);
		}};
		
		final List<Integer> l2 = new ArrayList<Integer>() {{
			add(3);
		}};
		
		final List<Integer> l3 = new ArrayList<Integer>() {{
			add(4);
			add(5);
			add(6);
		}};
		
		Vector2D i = new Vector2D(new ArrayList<List<Integer>>() {{
			add(l1);
			add(l2);
			add(l3);
		}});
		
		while (i.hasNext()) {
			System.out.println(i.next());
		}
		
		

	}
	private boolean hasNext = false;
	private int x, y;
	private int next = -1;
	private List<List<Integer>> vec2d;
	public Vector2D(List<List<Integer>> vec2d) {
		this.vec2d = vec2d;
		goNext();
    }
	
	private void goNext(){
    	hasNext = false;
		for(;y<vec2d.size();y++){
        	for(;x<vec2d.get(y).size();x++){
        		if(vec2d.get(y).get(x) != null){
        			hasNext = true;
        			next = vec2d.get(y).get(x);
        			if(x == vec2d.get(y).size()-1){
        				x = 0;
        				y++;
        			} else {
        				x++;
        			}
        			return;
        		}
        	}
        }
	}

    public int next() {
    	if(hasNext) {
	    	int res = next;
	    	goNext();
	    	
	    	return res;
    	}
    	return -1;
    }

    public boolean hasNext() {
        return hasNext;
    }

}
