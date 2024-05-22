import java.util.ArrayList;
import java.util.Random;

public class Table {
    private static final int MAX_PLAYERS = 4;
    private static final int MIN_PLAYERS = 2;

    private ArrayList<Player> players;
    private ArrayList<Tile> tiles;
    private Pile pile;
    private int round;
    private int numOfPlayers;
    private int currentPlayer;

    public Table() {
        this.players = new ArrayList<Player>();
        this.pile = new Pile();
        this.tiles = new ArrayList<Tile>();
    }

    public void addTile(Tile tile) {
        this.tiles.add(tile);
    }

    public void addPlayer(Player player) {
        if ( this.players.size() >= this.MAX_PLAYERS ) {
            throw new IllegalStateException("This table is full! MAX: " + this.MAX_PLAYERS);
        }

        this.players.add(player);
    }

    public void setPile(Pile pile) {
        this.pile = pile;
    }
    public Pile getPile() {
        return this.pile;
    }

    public int getRound() {
        return this.round;
    }
    public void nextRound() {
        this.round++;
        this.currentPlayer = (this.currentPlayer + 1) % this.players.size();
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
        return this.players.get(this.currentPlayer);
    }

    public void distributeTilesToPlayers() {
        for(int j = 0; j < 7; j++) {
            for (int i = 0; i < this.players.size(); i++) {
                this.players.get(i).pickFrom(this.pile.pull());
            }
        }
    }

    public void determineStartingPlayer() {
        int value = 0;

        for(int i = 0; i < this.players.size(); i++) {
            int new_value = this.players.get(i).highestTile().value();
            if (new_value > value) {
                value = new_value;
                this.currentPlayer = i;
            }
        }
    }

    public boolean isValidMove(Tile tile) {
        int rnd = new Random().nextInt();
        return rnd % 2 == 0;
    }

    public void print() {
        String str = "---- TABLE ----\n";

        for (Tile t: this.tiles) {
            str += t.toString() + " ";
        }

        str += "\n---- TABLE ----\n";

        System.out.println(str.trim());
    }
}
