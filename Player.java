import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Tile> hand;

    public Player(String name) {
        this.setName(name);
        this.hand = new ArrayList<Tile>();
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public boolean isValisTile(int index) {
        try {
            this.hand.get(index);
            return true;
        } catch(Exception ex) {
            return false;
        }
    }
    public ArrayList<Tile> getHand() {
        return this.hand;
    }
    public void setHand(ArrayList<Tile> hand) {
        this.hand = hand;
    }
    public void pickFrom(Tile piece) {
        this.hand.add(piece);
    }

    public Tile highestTile() {
        Tile p = this.hand.get(0);
        for(Tile c: this.hand) {
            if (c.value() > p.value()) {
                p = c;
            }
        }
        return p;
    }

    public Tile play(int piece) {
        // Tile d = this.hand.get(0);
        return this.hand.remove(piece);
    }

    public void printHand() {
        String header = "";
        String tiles = "";

        for (int i = 0; i < this.hand.size(); i++) {
            header += " " + i + "  ";
            tiles  += this.hand.get(i).toString() + " ";
        }

        System.out.println(header);
        System.out.println(tiles.trim());
    }
    public String toString() {
        String str = this.getName();
        str += ": ";

        for(Tile p: this.hand) {
            str += p.toString() + " ";
        }

        return str.trim();
    }
}
