import java.util.ArrayList;

public class Table {
    private static final int MAX_PLAYERS = 4;
    private static final int MIN_PLAYERS = 2;

    private ArrayList<Player> players;
    private ArrayList<Domino> dominos;
    private Deck dominoDeck;
    private int round;
    private int numOfPlayers;

    public Table() {
        this.players = new ArrayList<Player>();
        this.dominoDeck = new Deck();
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

    public int getRound() {
        return this.round;
    }
    public void nextRound() {
        this.round++;
    }

    public void setNumberOfPlayers(int numOfPlayers) {
        if (numOfPlayers > this.MAX_PLAYERS) {
            throw new IllegalStateException("MAX available chairs " + this.MAX_PLAYERS);
        }
        if (numOfPlayers < this.MIN_PLAYERS) {
            throw new IllegalStateException("MIN available chairs " + this.MIN_PLAYERS);
        }

        this.numOfPlayers = numOfPlayers;
    }
    public int getNumberOfPlayers() {
        return this.numOfPlayers;
    }

    public Player getCurrentPlayer() {
        return this.players.get(this.round % this.players.size());
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
        Domino domino = this.getCurrentPlayer().play(0); // you need to implement this method in Player class

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
