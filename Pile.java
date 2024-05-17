import java.util.ArrayList;
import java.util.Random;

public class Pile {
    private ArrayList<Tile> tiles;
    private Random random;

    public Pile() {
        this.tiles = new ArrayList<Tile>();
        this.random = new Random();

        this.populate();
    }

    public void populate() {
        for (int i = 0; i < 7; i++) {
            for (int j = i; j < 7; j++) {
                this.tiles.add(new Tile(i, j));
            }
        }
    }

    public Tile pull() {
        if (this.tiles.isEmpty()) {
            throw new IllegalStateException("No more tiles in the deck!");
        }

        return this.tiles.remove(this.random.nextInt(this.tiles.size()));
    }

    public String toString() {
        String str = "";

        for(int i = 0; i < this.tiles.size(); i++) {
            str += this.tiles.get(i) + " ";
        }

        return str.trim();
    }
}
