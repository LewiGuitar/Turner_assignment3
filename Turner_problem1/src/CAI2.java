import java.security.SecureRandom;
import java.util.Scanner;

public class CAI2 {

	private static Scanner in = new Scanner(System.in);
	private static SecureRandom random = new SecureRandom();
	
	private int[] generateRandom(int num, int bound) {		
		
		int[] multiplicationNumbers = new int[num];
		
		for(int i = 0; i < num; i++) {
			multiplicationNumbers[i] = random.nextInt(bound);
		}
		
		return multiplicationNumbers;
	}
	
	private int generateRandom(int bound) {			
		return random.nextInt(bound);
	}
	
	
	public void quiz() {
		int[] numbers = generateRandom(2, 10);		
		
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
	
	private String getAnswer(int type) {
		//an input of 1 means a positive response, an input of 0 means a negative response
		int random = generateRandom(4);
		
		if(type == 1) {
			switch(random) {
				case 0: return "Very good!";				
				case 1: return "Excellent!"; 
				case 2: return "Nice work!";
				case 3: return "Keep up the good work!";
				default: return "Error";
			}
			
			
		} else if(type == 0){
			switch(random) {
				case 0: return "No. Please try again.";				
				case 1: return "Wrong. Try once more."; 
				case 2: return "Don’t give up!";
				case 3: return "No. Keep trying.";
				default: return "Error";
			}
		} else {
			return "Error";
		}
	}
	
	private void displayCorrectResponse() {
		String response = getAnswer(1);		
		System.out.println(response);
	}
	

	
	private void displayIncorrectResponse() {
		String response = getAnswer(0);
		System.out.println(response);		
	}
}
