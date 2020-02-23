import java.security.SecureRandom;
import java.util.Scanner;

public class CAI4 {

	private static Scanner in = new Scanner(System.in);
	private static SecureRandom random = new SecureRandom();
	
	
	
	private int[] generateRandomArray(int num, int bound) {
		SecureRandom random = new SecureRandom();
		
		int[] multiplicationNumbers = new int[num];
		
		for(int i = 0; i < num; i++) {
			multiplicationNumbers[i] = random.nextInt(bound);
		}
		
		return multiplicationNumbers;
	}
	
	private int generateRandomNumber(int bound) {			
		return random.nextInt(bound);
	}
	
	private int[] generateQuestionArgument(int difficulty) {
		
		switch(difficulty) {
			case 1: return generateRandomArray(2, 10);
			case 2: return generateRandomArray(2, 100);
			case 3: return generateRandomArray(2, 1000);
			case 4: return generateRandomArray(2, 10000);
			default: return null;		
		}	
		
	}
	
	
	public void quiz() {
		int numberCorrect = 0;
		int numberIncorrect = 0;
		int more = 1;
		int difficulty = 0;
		
		do {
			numberCorrect = 0;
			numberIncorrect = 0;
			
			promptDifficulty();
			difficulty = readDifficulty();
			
			for(int i = 0; i < 10; i++) {
								
				int [] numbers = generateQuestionArgument(difficulty);
		
				askQuestion(numbers);
				int answer = readResponse();
				int answerTrue = numbers[0] * numbers[1];
			
				if(isAnswerCorrect(answer, answerTrue)) {
					displayCorrectResponse();
					numberCorrect ++;
				} else {
					displayIncorrectResponse();
					numberIncorrect ++;
				}			
			}
		
			double ratio = getRatio(numberCorrect, numberIncorrect);
			
			displayCompletionMessage(ratio);
			
			more = moreQuizzes();		
			
		} while(more == 1);
		
	}
	
	
	private void askQuestion(int [] numbers) {
		System.out.println("How much is " + numbers[0] + " times " + numbers[1] + "?");
	}
	
	
	private int readResponse() {		
		return in.nextInt();
	}
	
	private void promptDifficulty() {
		System.out.printf("What difficulty problems would you like to solve?%n%nPress"
				+ " 1 for 1 digit numbers, 2 for up to 2 digit numbers, 3 for up to "
				+ "3 digit numbers and 4 for up to 4 digit numbers.%n");
		
		
	}
	
	private int readDifficulty() {
		
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
		int random = generateRandomNumber(4);
		
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
		System.out.printf("%s%n%n", response);
	}
	
	
	private void displayIncorrectResponse() {
		String response = getAnswer(0);
		System.out.printf("%s%n%n",response);		
	}
	
	private double getRatio(int correct, int wrong) {
		double ratio = correct /(double) (correct + wrong) * 100;
		return ratio;
	}
		
	private void displayCompletionMessage(double ratio) {
		
		System.out.printf("%nYour percentage was: %.2f%n", ratio);
		
		if(ratio < 75) {
			System.out.println("Please ask your teacher for extra help.");
		} else {
			System.out.println("Congratulations, you are ready to go to the next level!");
		}
	}
	
	private void askForContinue() {
		System.out.println("Enter 1 to take another quiz, and 0 to exit.");
	}
	
	private int moreQuizzes() {
		askForContinue();
		return readResponse();
	}	
}
