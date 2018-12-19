
import java.util.Random;

public class Hangman {

	private String surname="";
	private int tries = 0;
	private char[] guessedLetters = new char[3];
	private String[] surnames ={ "lazkano", "intxausti", "artola", "alberdi", "lekubide", "ortiz", "gonzalez" };

	
    public String getSurname() {
		return this.surname;
	}

	public void setSurname(String _surname) {
		this.surname = _surname;
	}
	
	public String selectSurname() {		
		//this.surname = surnames[new Random().nextInt(surnames.length)];
		return surnames[new Random().nextInt(surnames.length)];
	}

	public char[] getguessedLetters() {
		return this.guessedLetters;
	}
	
	public void setGuessedLetters(char[] array) {
		this.guessedLetters=array;
	}

	public int getTries() {
		return tries;
	}

	public void setTries(int tries) {
		this.tries = tries;
	}
	
	public String[] getSurnames() {
		return this.surnames;
	}

	public void setSurnames(String[] surnames) {
		this.surnames=surnames;
	}
	
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
	
	public boolean playerWord(String word) {
		boolean result = false;
		if(this.surname.equals(word)) {
			return true;
			//System.out.println("Congratulations the surname was "+ this.surname);
		}
		return result; 
		//else {
		//	System.out.println("Sorry, the surname was "+ this.surname);
		//}
	}

}

