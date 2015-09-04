import java.util.ArrayList;
import java.util.List;

public class EncodeDecodeStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
    	StringBuilder sb =new StringBuilder();
        for(String s : strs) {
        	sb.append(s.length()+"@"+s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        while(s.indexOf("@") > 0){
        	int x = s.indexOf("@");
        	int len = Integer.parseInt(s.substring(0, x));
        	res.add(s.substring(x+1, x+1+len));
        	s = s.substring(x+1+len);
        }
        return res;
    }

}
