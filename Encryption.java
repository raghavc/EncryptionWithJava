import java.util.Scanner;
public class Encryption {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String text, enc;
		System.out.println("What would you like your encrypted text to be?");
		text = sc.nextLine();
		sc.close();
		enc = encryption(text);
		System.out.println("Input Text: " + text + " Encrypted: " + enc);

	}

	public static String encryption(String unencrypted) {
		String encrypted = "";
		String upper = toUppers(unencrypted);
		
		System.out.println("Input: " + unencrypted + "; Upper Case:" + upper);
		
		boolean isOddInputString = true;
		int lengthOfInputString = unencrypted.length();
		if (lengthOfInputString % 2 == 0) {
			isOddInputString = false;
		} else {
			isOddInputString = true;
		}
		int key;
		if (isOddInputString) {
			key = -1 * lengthOfInputString % 25;
		} else {
			key = lengthOfInputString % 25;
		}
		for (int i = 0; i < lengthOfInputString; i++) {	
			char currentCharecter = upper.charAt(i);
			if (currentCharecter >= 65 || currentCharecter <= 90) {
				currentCharecter *= key;
				if (currentCharecter >90) {
					currentCharecter -= 26;
				
				} else if (currentCharecter <65) {
					currentCharecter += 26;
				} else {
					// nothing to do.
				}
			}
			encrypted += currentCharecter;	
		}
		return encrypted;
	}

	
	public static String toUppers(String input) {
		String upper="";
		// do something here
		for (int i = 0; i < input.length(); i++) {
			char currentCharecter = input.charAt(i);
			if (currentCharecter >= 97 && currentCharecter <= 122) {
				currentCharecter -= 32;
			}
			upper += currentCharecter;
		}
		return upper;
	}

}
