package eg.edu.alexu.csd.datastructure.hangman.cs07;

import java.util.Random;

import eg.edu.alexu.csd.datastructure.hangman.IHangman;

/**
 * the public class of the game
 */
public class HangMan implements IHangman {

	private String[] arrayOfwords;
	private static String randomWord;
	private int maxWrongGuess;
	private int lengthOGussedWord;
	private int wrongGuessCounter = 0;
	private String tempWord;
	private static char[] charGussed;
	

	@Override
	public void setDictionary(final String[] words) {

		arrayOfwords = words;

	}

	@Override
	public String selectRandomSecretWord() {
		if (arrayOfwords == null) {
			return null;
		}

		int length = arrayOfwords.length;
		Random generator = new Random();
		int randomInt = generator.nextInt(length);
		randomWord = arrayOfwords[randomInt];
		lengthOGussedWord = randomWord.length();
		charGussed = new char[lengthOGussedWord];
		for (int i = 0; i < lengthOGussedWord; i++) {
			charGussed[i] = '-';
		}
		return randomWord;
	}

	@Override
	public String guess(Character c) {

		int count = 0;
		String userWord = "";

//		if (tempWord.equals(randomWord)) {
//			return null;
//		}
		if (c == null) {
			return null;
		}

		for (int i = 0; i < lengthOGussedWord; i++) {

			char x = randomWord.charAt(i);
			char y = Character.toLowerCase(x);
			char z = Character.toUpperCase(x);
			if (x == c || y == c || z == c) {
				charGussed[i] = randomWord.charAt(i);
			} else {
				count++;
			}
		}

		for (int j = 0; j < lengthOGussedWord; j++) {
			userWord = userWord + charGussed[j];
		}
		if (userWord.equals(randomWord)) {

			tempWord = randomWord;
			return randomWord;
		}

		if (count == lengthOGussedWord) {
			wrongGuessCounter++;

			// return NULL if user reached max wrong guesses
			if (wrongGuessCounter == maxWrongGuess) {
				return null;
			}
		}
		return userWord;
	}

	@Override
	public void setMaxWrongGuesses(Integer max) {

		this.maxWrongGuess = max;
	}
}
