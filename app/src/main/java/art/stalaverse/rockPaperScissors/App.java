package art.stalaverse.rockPaperScissors;

public class App {
	public static void main(String[] args) {
		Player player[]={new Player(), new Player()};
		UserInterface ui = new UserInterface(player);
		boolean exitFlag=false;
		do {
			ui.printMenu();
			switch(ui.getChoice()) {
				case 1:
					ui.printNewGame();
					break;
				case 2:
					ui.printRules();
					break;
				case 3:
					exitFlag=true;
					break;
				default:
					break;
			}
		} while (!exitFlag);
	}
}