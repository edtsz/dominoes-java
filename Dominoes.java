import java.util.ArrayList;
import java.util.Arrays;

class Dominoes {
	public static void main(String[] args) {
		Table g = new Table();
		g.setDeck(new Deck());

		Player p1 = new Player("P1");
		Player p2 = new Player("P2");

		g.addPlayer(p1);
		g.addPlayer(p2);
		g.distributeDominoesToPlayers();

		for (int i = 0; i < 4; i++) {
			System.out.println(g.getCurrentPlayer());
			g.nextRound();
		}

		System.out.print("DE: ");
		System.out.println(g.getDeck().toString());
	}
}
