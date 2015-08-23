
public class UglyNumber {
	
	public static void main(String[] args){
		UglyNumber number = new UglyNumber();
		System.out.println(number.nthUglyNumber(11));
	}

	
	public int nthUglyNumber(int n) {
		int[] ugly = new int[Math.max(n, 5)];
		
		for(int i = 0;i<5;i++){
			ugly[i] = i+1;
		}
		
		if(n<=5){
			return ugly[n-1];
		}
		
		int index  = 4;

		int twoNextIndex = 2;
		int threeNextIndex = 2;
		int fiveNextIndex = 4;
		
		int twoNext = 2 * ugly[twoNextIndex];
		int threeNext = 3 * ugly[threeNextIndex];
		int fiveNext = 5 * ugly[fiveNextIndex];
		
		while(index < n - 1){
			while((twoNext = 2 * ugly[twoNextIndex]) <= ugly[index]){
				twoNextIndex++;
			}
			
			while((threeNext = 3 * ugly[threeNextIndex]) <= ugly[index]){
				threeNextIndex++;
			}
			
			while((fiveNext = 5 * ugly[fiveNextIndex]) <= ugly[index]){
				fiveNextIndex++;
			}
			
			if(twoNext <= threeNext && twoNext <= fiveNext){
				twoNextIndex ++;
				ugly[++index] = twoNext;
			} else if(threeNext <= twoNext && threeNext <= fiveNext){
				threeNextIndex ++;
				ugly[++index] = threeNext;
			} else if(fiveNext <= twoNext && fiveNext <= threeNext){
				fiveNextIndex ++;
				ugly[++index] = fiveNext;
			}
		}
		
		return ugly[index];
		
        
    }
	
}
