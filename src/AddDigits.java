
public class AddDigits {

	public static void main(String[] args) {
		System.out.println(new AddDigits().addDigits(38));

	}
	
	public int addDigits(int num) {
        return num - 9*(((num-1)/9));
    }

}
