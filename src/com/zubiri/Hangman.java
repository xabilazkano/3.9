package com.zubiri;

import java.util.Random;

public class Hangman {

	private String surname = "";
	private int tries = 0;
	private char[] guessedLetters = new char[3];
	private String[] surnames = { "lazkano", "intxausti", "artola", "alberdi", "lekubide", "ortiz", "gonzalez" };
	
	/**
	 * Gets the surname
	 * @return 
	 */

	public String getSurname() {
		return this.surname;
	}
	
	/**
	 * Sets the surname
	 * @param _surname
	 */

	public void setSurname(String _surname) {
		this.surname = _surname;
	}

	

	/**
	 * Gets the guessed letters array
	 * @return
	 */
	public char[] getguessedLetters() {
		return this.guessedLetters;
	}

	/**
	 * Sets the guessed letters array
	 * @param array
	 */
	public void setGuessedLetters(char[] array) {
		this.guessedLetters = array;
	}

	/**
	 * Gets the number of tries
	 * @return
	 */
	public int getTries() {
		return tries;
	}
	
	/**
	 * Sets the number of tries
	 * @param tries
	 */
	public void setTries(int tries) {
		this.tries = tries;
	}

	/**
	 * Gets the surnames array
	 * @return
	 */
	public String[] getSurnames() {
		return this.surnames;
	}

	/**
	 * Sets the surnames array
	 * @param surnames
	 */
	public void setSurnames(String[] surnames) {
		this.surnames = surnames;
	}

	/**
	 * Selects a surname from the array
	 * @return returns the surname
	 */
	public String selectSurname() {
		
		return surnames[new Random().nextInt(surnames.length)];
	}
	
	/**
	 * Prints the selected surname using underscores for the letters that we haven't used
	 */
	public void printSelectedSurname() {
		for (int i = 0; i < surname.length(); i++) {
			boolean found = false;
			for (int e = 0; e < guessedLetters.length; e++) {
				if (guessedLetters[e] == surname.charAt(i)) {
					System.out.print(surname.charAt(i) + " ");
					found = true;
				}
			}
			if (!found) {
				System.out.print("_ ");
			}
		}
	}

	/**
	 * It checks if the entered letter is in the surname or not
	 * @param letter 
	 */
	public void checkLetter(char letter) {

		for (int i = 0; i < surname.length(); i++) {
			if (surname.charAt(i) == letter) {
				// If it is, open another loop which will go checking if the player had already
				// guessed that letter
				boolean found = false;
				int index2 = 0;
				while (index2 < guessedLetters.length && guessedLetters[index2] != letter && !found) {
					if (!Character.isLetter(guessedLetters[index2])) {
						// If he/she had not done so, save the letter in the array 'guessedletters'
						guessedLetters[tries] = surname.charAt(i);
						// Increment once the variable 'tries' for a future possible letter
						tries++;
						// Define the variable 'found' as true so as to get out of the loop
						found = true;
					}
					// Increment the variable 'index2' so as to check the next letter of the array
					// 'guessed'
					index2++;
				}
			}
		}

	}

	/**
	 * It controls if we have guessed the surname
	 * @param word The surname
	 * @return It will return true or false
	 */
	public boolean playerWord(String word) {
		boolean result = false;
		if (this.surname.equals(word)) {
			return true;
			
		}
		return result;
	
		
	}

}
