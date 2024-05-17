import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Game {
	public static void main(String[] args) {
		clearTerminal();

		Scanner scanner = new Scanner(System.in);
		Table table = new Table();

		do {
			try {
				System.out.print("Numero de jogadores: ");
				table.setNumberOfPlayers(Integer.parseInt(scanner.nextLine()));
			} catch (Exception e) {
				System.err.print("~~~ ");
				System.err.print(e.getMessage());
				System.err.println(" ~~~");
			}
		} while (table.getNumberOfPlayers() == 0);

		clearTerminal();

		for(int i = 0; i < table.getNumberOfPlayers(); i++) {
			System.out.print("Nome do jogador "+(i + 1)+": ");
			table.addPlayer(new Player(scanner.nextLine()));
		}
		System.out.println();

		table.distributeTilesToPlayers();

		System.out.println();
		System.out.print("Deck: ");
		System.out.println(table.getPile().toString());

		table.determineStartingPlayer();
		System.out.println();

		for (int i = 0; i < table.getNumberOfPlayers(); i++) {
			System.out.println(table.getCurrentPlayer());
			table.nextRound();
		}
	}

    public static void clearTerminal() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
