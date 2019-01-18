import java.util.Scanner;
import com.zubiri.Hangman;

public class Interface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hangman hang = new Hangman();
		String surname = hang.selectSurname();
		hang.setSurname(surname);
		Scanner sc = new Scanner(System.in);
		// Print the games' description
		System.out.println("Welcome to the famous HANGMAN game.");
		System.out.println("You will have to guess which surname of the people in class is hidden between the voids.");
		System.out.println(
				"For this, you will be able to enter 3 letters that may appear in the surname, or not. After this, you will only have a chance to guess the surname and win the game.");
		boolean playAgain = true;
		while (playAgain == true) {

			int flag = 0;

			hang.printSelectedSurname();

			while (flag < 3) {

				System.out.println();
				System.out.println("Enter a letter");
				if (!sc.hasNextInt()) {
					// Create a string object with the letter's value

					String possibleLetter = sc.next().toLowerCase();
					String[] letterArray = possibleLetter.split(" ");
					if (letterArray.length == 1) {
						// Check that the player has entered just a character
						if (letterArray[0].length() == 1) {

							hang.checkLetter(letterArray[0].charAt(0));
							flag++;
							hang.printSelectedSurname();
							System.out.println();

						}
						// If the player entered more than one characters, ask him/her to enter just one
						else {
							System.out.println("Don't cheat, please enter just a letter.");
						}
					} else {
						System.out.println("Don't cheat, please enter just a letter.");
					}
				} else {
					System.out.println("That is not a letter, try it again.");
					sc.next();
				}

			}
			System.out.println("Three letters tried, now is time to guess the surname");
			System.out.println("Enter a surname");
			sc.nextLine();
			String playerWord = sc.nextLine().toLowerCase();
			String[] playerWordArray = playerWord.split(" ");
			if (playerWordArray.length == 1) {
				if (hang.playerWord(playerWord)) {
					System.out.println("Congratulations the surname was " + hang.getSurname());
				} else {
					System.out.println("Sorry, the surname was " + hang.getSurname());
				}
			} else {
				System.out.println("Enter just one word");
			}

			System.out.println("Do you want to play again? ");
			boolean incorrectResponse = true;
			while (incorrectResponse) {
				String choose = sc.next();
				if (choose.equals("yes")) {
					surname = hang.selectSurname();
					hang.setSurname(surname);
					char[] guessedletters = new char[3];
					hang.setGuessedLetters(guessedletters);
					hang.setTries(0);
					incorrectResponse = false;
				} else if (choose.equals("no")) {
					System.out.println("Bye!");
					playAgain = false;
					incorrectResponse = false;
				} else {
					System.out.println("Enter a valid option (yes/no)");
				}
			}
		}

	}

}