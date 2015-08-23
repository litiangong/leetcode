
public class PalindromePermutation {

	public static void main(String[] args) {
		PalindromePermutation x = new PalindromePermutation();
		
		System.out.println(x.canPermutePalindrome("aada"));
		
	}
	
	public boolean canPermutePalindrome(String s) {
        int[] letters = new int[256];
        for(int i = 0;i<s.length();i++){
        	char c = s.charAt(i);
        	letters[c]++;
        }
        
        int max = s.length() %2;
        
        for(int i = 0;i<256;i++){
        	if(letters[i] % 2 == 1){
        		if(max == 0) {
        			return false;
        		} else {
        			max--;
        		}
        	}
        }
        
        return true;
    }
	

}
