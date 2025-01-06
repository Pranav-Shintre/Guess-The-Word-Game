package game;

import java.util.Random;

public class Words {

	private String[] randomWords = {"animals", "happiness", "charger", "school", "indefinite", "steady", "birthday", "extreme", "rights", "properties", "ceremony", "lawyer", "independence", "beneath", "information", "students", "employee", "gems", "television", "book", "player"};

	private String selectedWord;				// Stores random word
	private Random random = new Random();		// Random class object creation
	private char[] letters;						// Stores user input letters

	// Constructor to set word randomly from given array and set letters[] length as same as that selectedWord length
	public Words() {
		selectedWord = randomWords[random.nextInt(randomWords.length)];		// selects word on the basis of length of randomWords array within array length
		letters = new char[selectedWord.length()];		// letters should be same as selectedWord length
	}

	// Iterates over the array of user-input(letters[]) if that array has letters then add it to text else adds '-'
	public String toString() {
		StringBuilder text = new StringBuilder();

		for(char letter : letters)
		{
			text.append((letter == '\u0000') ? '-' : letter);				// checks if letter is null (uses unicode of null to check)

			text.append(' ');
		}

		return text.toString();
	}

	// returns true if all the letters are filled then guess is correct
	public boolean isGuessedRight()
	{
		for(char letter : letters)
		{
			if(letter == '\u0000')
				return false;
		}
		return true;
	}
	
	// Iterate through our selectedWord and checks if user inputed letter is in selectedWord,
    // if yes then set it inside user-input(letters[]). If all letters are correctly guessed then return true
	public boolean guess(char letter)
	{
		boolean guessedRight = false;

		for(int i=0; i<selectedWord.length(); i++)
		{
			if(letter == selectedWord.charAt(i))
			{
				letters[i] = letter;
				guessedRight = true;
			}
		}

		return guessedRight;
	}
}
