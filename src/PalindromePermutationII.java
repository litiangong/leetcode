import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class PalindromePermutationII {

	public static void main(String[] args) {
		PalindromePermutationII x = new PalindromePermutationII();
		for(String s : x.generatePalindromes("aabbcc")){
			System.out.println(s);
		}
	}
	
	public List<String> generatePalindromes(String s) {
        int[] letters = new int[256];
        for(int i = 0;i<s.length();i++){
        	char c = s.charAt(i);
        	letters[c]++;
        }
        
        int max = s.length() %2;
        
        Set<String> toPerm = new HashSet<String>();
        StringBuilder toperm = new StringBuilder();
        
        String mid = "";
        
        for(int i = 0;i<256;i++){
        	if(letters[i] % 2 == 1){
        		if(max == 0) {
        			return new ArrayList<String>();
        		} else {
        			mid = String.valueOf(Character.toChars(i));//int to char
        			max--;
        			if(letters[i] > 1){
        				for(int x = 0;x<letters[i]/2;x++){
                			toperm.append(Character.toChars(i));//int to char
                		}
        			}
        		}
        	} else {
        		for(int x = 0;x<letters[i]/2;x++){
        			toperm.append(Character.toChars(i));
        		}
        	}
        }
        
        perm(new StringBuilder(), toperm.toString(), toPerm, new boolean[toperm.length()], mid);
        
        return new ArrayList<String>(toPerm);
    }
	
	//always use a set for cases like aaaaa
	
	private void perm(StringBuilder sb, String src, Set<String> toPerm, boolean[] bs, String mid) {
		if(sb.length() == src.length()){
			String reverse = new StringBuilder(sb).reverse().toString();//do not reverse the orginal SB
			toPerm.add(sb.toString() + mid + reverse);
			
		} else {
		
			for(int i = 0;i<bs.length;i++){
				if(!bs[i]){
					sb.append(src.charAt(i));
					bs[i] = true;
					perm(sb, src, toPerm, bs, mid);
					bs[i] = false;//restore state
					sb.deleteCharAt(sb.length()-1);//restore state
				}
			}
		}
		
	}
	

}
