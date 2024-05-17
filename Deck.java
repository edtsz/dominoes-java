import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private ArrayList<Domino> dominoes;
    private Random random;

    public Deck() {
        this.dominoes = new ArrayList<Domino>();
        this.random = new Random();

        this.populate();
    }

    public void populate() {
        for (int i = 0; i < 7; i++) {
            for (int j = i; j < 7; j++) {
                this.dominoes.add(new Domino(i, j));
            }
        }
    }

    public Domino pull() {
        if (this.dominoes.isEmpty()) {
            throw new IllegalStateException("No more dominoes in the deck!");
        }

        return this.dominoes.remove(this.random.nextInt(this.dominoes.size()));
    }

    public ArrayList<Domino> pull(int totalPieces) {
        ArrayList<Domino> hand = new ArrayList<Domino>();
        for(int j = 0; j < totalPieces; j++) {
            hand.add(this.pull());
        }
        return hand;
    }

    public String toString() {
        String str = "";

        for(int i = 0; i < this.dominoes.size(); i++) {
            str += this.dominoes.get(i) + " ";
        }

        return str.trim();
    }
}
