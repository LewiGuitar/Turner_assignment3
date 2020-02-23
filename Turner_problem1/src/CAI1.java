import java.security.SecureRandom;
import java.util.Scanner;

public class CAI1 {
	
	private static Scanner in = new Scanner(System.in);
	private static SecureRandom random = new SecureRandom();
	
	private int[] generateRandom() {		
		
		int[] multiplicationNumbers = new int[2];
		
		for(int i = 0; i < 2; i++) {
			multiplicationNumbers[i] = random.nextInt(10);
		}
		
		return multiplicationNumbers;
	}
	
	
	public void quiz() {
		
		int[] numbers = generateRandom();
		
		while(true) {
			askQuestion(numbers);
			int answer = readResponse();
			int answerTrue = numbers[0] * numbers[1];
			
			if(isAnswerCorrect(answer, answerTrue)) {
				displayCorrectResponse();
				System.exit(0);
			} else {
				displayIncorrectResponse();
			}			
		}
	}
	
	
	private void askQuestion(int [] numbers) {
		System.out.println("How much is " + numbers[0] + " times " + numbers[1] + "?");
	}
	
	
	private int readResponse() {		
		return in.nextInt();
	}
	
	
	private boolean isAnswerCorrect(int answer, int answerTrue) {
		if(answer == answerTrue) {
			return true;
		} else {
			return false;
		}
	}
	
	
	private void displayCorrectResponse() {
		System.out.println("Very good!");
	}
	
	private void displayIncorrectResponse() {
		System.out.println("No. Please try again.");
	}
	

}
