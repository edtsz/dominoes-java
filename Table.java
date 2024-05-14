import java.util.ArrayList;

public class Table {
    private ArrayList<Player> players;
    private ArrayList<Domino> dominos;
    private Deck dominoDeck;
    private int currentPlayer;
    private static final int MAX_PLAYERS = 4;


    public Table() {
        this.players = new ArrayList<Player>();
    }

    public void addPlayer(Player player) {
        if ( this.players.size() >= this.MAX_PLAYERS ) {
            throw new IllegalStateException("This table is full! MAX: " + this.MAX_PLAYERS);
        }

        this.players.add(player);
    }

    public void setDeck(Deck dominoes) {
        this.dominoDeck = dominoes;
    }
    public Deck getDeck() {
        return this.dominoDeck;
    }

    public Player getCurrentPlayer() {
        this.currentPlayer = (this.currentPlayer + 1) % this.players.size();

        return this.players.get(currentPlayer);
    }

    public void distributeDominoesToPlayers() {
        for(int j = 0; j < 7; j++) {
            for (int i = 0; i < this.players.size(); i++) {
                this.players.get(i).pickFrom(this.dominoDeck.pull());
            }
        }
    }

    public void playTurn() {
        // Player currentPlayer = this.getCurrentPlayer(); // you need to implement this method based on your game rules
        Domino domino = this.getCurrentPlayer().play(); // you need to implement this method in Player class

        if (!this.isValidMove(domino)) {
            throw new IllegalArgumentException("Invalid move!");
        }
        // do something with the domino...
        System.out.println("// do something with the domino...");
    }

    private boolean isValidMove(Domino domino) {
        // you need to implement this method based on your game rules
        return true;
    }
}
