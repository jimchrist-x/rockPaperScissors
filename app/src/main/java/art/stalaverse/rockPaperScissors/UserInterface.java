package art.stalaverse.rockPaperScissors;

import java.io.IOException;
import java.util.Scanner;

public class UserInterface {
	private int lineSize;
	private Player[] player;
	private int choice;
	private Scanner reader;
	private int rounds;
	private Object object;
	public UserInterface(Player[] player) {
		lineSize=60;
		this.player = new Player[2];
		this.reader=new Scanner(System.in);
		this.rounds=3;
		System.arraycopy(player, 0, this.player, 0, 2);
	}
	private void printLine() {
		String data="=".repeat(lineSize);
		System.out.print(data);
		System.out.println();
	}
	private static void clearScreen() {
		try {
			if (System.getProperty("os.name").contains("Windows")) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else {
				new ProcessBuilder("clear").inheritIO().start().waitFor();
			}
		} catch (IOException | InterruptedException e) {
			System.out.print("\n".repeat(50));
		}
	}
	public int getChoice() {
		return choice;
	}
	public void printNewGame() {
		clearScreen();
		for (int i=1;i<=2;i++) {
			System.out.printf("Player %d username: ", i);
			player[i-1].setNickname(reader.nextLine());
		}
		for (int i=0;i<rounds;i++) {
			for (int j=0;j<=1;j++) {
				clearScreen();
				System.out.println("It is " + player[j].getNickname() + "'s turn!");
				System.out.print("Choose your weapon (R,P,S): ");
				char ch;
				do {
					ch=Character.toUpperCase(reader.next().charAt(0));
					reader.nextLine();
					if (ch!='R' && ch!='P' && ch!='S') {
						System.out.println("Option doesn't exist!");
						System.out.print(": ");
					}
				} while (ch!='R' && ch!='P' && ch!='S');
				switch(ch) {
					case 'R':
						player[j].setChoice(object.ROCK);
						break;
					case 'P':
						player[j].setChoice(object.PAPER);
						break;
					case 'S':
						player[j].setChoice(object.SCISSORS);
						break;
					default:
						break;
				}

			}
			if (player[0].getObject()==player[1].getObject()) {
				System.out.println("Tie! Both players chose: " + player[0].getObject() + "!");
			}
			else if (player[0].getObject()==object.ROCK && player[1].getObject()==object.SCISSORS){
				player[0].incrementTimesWon();
				player[1].incrementTimesLost();
				System.out.println(player[0].getNickname() + " wins! " + player[0].getObject() + " beats " + player[1].getObject() + "!");
			}
			else if (player[0].getObject()==object.PAPER && player[1].getObject()==object.ROCK) {
				player[0].incrementTimesWon();
				player[1].incrementTimesLost();
				System.out.println(player[0].getNickname() + " wins! " + player[0].getObject() + " beats " + player[1].getObject() + "!");
			}
			else if (player[0].getObject()==object.SCISSORS && player[1].getObject()==object.PAPER) {
				player[0].incrementTimesWon();
				player[1].incrementTimesLost();
				System.out.println(player[0].getNickname() + " wins! " + player[0].getObject() + " beats " + player[1].getObject() + "!");
			}
			else {
				player[1].incrementTimesWon();
				player[0].incrementTimesLost();
				System.out.println(player[1].getNickname() + " wins! " + player[1].getObject() + " beats " + player[0].getObject() + "!");
			}
			System.out.println("Press Enter to continue...");
			reader.nextLine();
		}
		clearScreen();
		if (player[0].getTimesWon()>player[1].getTimesWon()) {
			System.out.println(player[0].getNickname() + " beat " + player[1].getNickname() + "!");
		}
		else if (player[0].getTimesWon()<player[1].getTimesWon()) {
			System.out.println(player[1].getNickname() + " beat " + player[0].getNickname() + "!");
		}
		else {
			System.out.println("Game turned out to be a tie!");
		}
		for (int i=0;i<=1;i++) {
			System.out.println(player[i].getNickname() + "'s winrate is " + Math.round(player[i].getWinRate()*100) + "%");
		}
	}
	

	public void printRules() {
		clearScreen();
		String[] rules = {
			"=".repeat(lineSize),
        	"\t\tOFFICIAL GAME RULES\t\t",
        	"=".repeat(lineSize),
        	"1. Rock crushes Scissors.",
        	"2. Scissors cuts Paper.",
        	"3. Paper covers Rock.",
        	"4. Same choice results in a Draw.",
        	"5. Enter 'R', 'P', or 'S' to play.",
        	"=".repeat(lineSize)
		};
		for (String rule : rules) {
			System.out.println(rule);
		}
	}
	public void printMenu() {
		clearScreen();
		printLine();
		System.out.println("\tROCK\t|\tPAPER\t|\tSCISSORS");
		printLine();
		System.out.println("\t\t-- Main Menu --");
		System.out.println();
		System.out.println("[1] Start New Game");
		System.out.println("[2] View Rules");
		System.out.println("[3] Exit");
		System.out.println();
		printLine();
		System.out.print(">");
		do {
			choice=reader.nextInt();
			reader.nextLine();
			if (choice>3 || choice<1) {
				System.out.println("Option doesn't exist, try again!");
				System.out.print(">");
			}
		} while (choice>3 || choice<1);
	}
}