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
		table.determineStartingPlayer();

		do {
			clearTerminal();
			System.out.print("Pile: ");
			System.out.println(table.getPile().toString());

			System.out.println();
			table.print();
			System.out.println();

			Player player = table.getCurrentPlayer();
			System.out.print("`" + player.getName() + "` ");
			System.out.println("escolha uma peça: ");
			player.printHand();
			System.out.print("ou # para pescar: ");

			String choose = scanner.nextLine();
			if (choose.equals("#")) {
				player.pickFrom(table.getPile().pull());
				continue;
			}

			int tile;
			try {
				tile = Integer.parseInt(choose);
			} catch (Exception ex) {
				continue;
			}
			if (! player.isValisTile(tile)) {
				continue;
			}

			// Pick a piece from player
			Tile piece = player.getHand().get(tile);

			//
			if (!table.isValidMove(piece)) {
				continue;
			}

			player.play(tile);
			table.addTile(piece);

			table.nextRound();

		} while (true);

	}

    public static void clearTerminal() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
