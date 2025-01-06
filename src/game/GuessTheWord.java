package game;

import java.util.Scanner;

public class GuessTheWord {

	private boolean play = true;
	private Words randomWord = new Words();
	private Scanner sc = new Scanner(System.in);		// For letter input from user
	private int rounds = 10;							// Number of try to guess the word
	private char lastRound;								// Stores character of user input

	public void start()
	{
		do {
			showWord();				// Prints the letters of word to be guessed
			getInput();				// Takes letter input from user and if it is in word then set it for hint
			checkInput();
		}while(play);
	}

	void showWord()
	{
		System.out.println("You have " + rounds + " tries left.");		// gives remaining number of tries
		System.out.println(randomWord);			// calls toString() of class Words
	}

	void getInput()
	{
		System.out.print("Enter a letter to guess the word : ");
		String userGuess = sc.nextLine();
		
		lastRound = userGuess.charAt(0);		// Get the first character from user input
	}

	// Checks guessed word is correct in limited number of try. Gives result of game
	void checkInput()
	{
		boolean isGuessedRight = randomWord.guess(lastRound);

		if(isGuessedRight)
		{
			if(randomWord.isGuessedRight())
			{
				System.out.println("Congrats.. You Won!");
				System.out.println("The word is : " + randomWord);
				play = false;
			}
		}
		else {
			rounds--;
			
			if(rounds == 0)
			{
				System.out.println("Game finished...");
				play = false;
			}
		}
	}

	// Closes the scanner after end of the game
	public void end() {
		sc.close();
	}
}
