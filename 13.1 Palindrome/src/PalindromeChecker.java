/** Write a description of the program here
 * Describe the purpose of this program
 * The author of this program:
 * The creation date:
 * Version of the program:
 */
public class PalindromeChecker {
	private String reverse;
	private boolean isPalendrome;
	private String input;

	public PalindromeChecker(String input) {
		this.input = input;
	}

	public void reverseBuild() {
		String Input = this.input;
		StringBuilder Reverse = new StringBuilder();
		for (int i = Input.length() - 1; i >= 0; i--) {
			Reverse.append(Input.charAt(i));
		}
		reverse = Reverse.toString();
	}
	public void palindromecheck(){
		isPalendrome = reverse.equals(input);
	}

	public boolean isPalendrome() {
		return isPalendrome;
	}

	public String getReverse() {
		return reverse;
	}
}
