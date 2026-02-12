package art.stalaverse.rockPaperScissors;

import java.io.IOException;
import java.util.Scanner;

public class UserInterface {
	private int lineSize;
	private Player[] player;
	private int choice;
	private Scanner reader;
	public UserInterface(Player[] player) {
		lineSize=60;
		this.player = new Player[2];
		this.reader=new Scanner(System.in);
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