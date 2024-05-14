import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Domino> hand = new ArrayList<>();

    public Player(String name) {
        this.setName(name);
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Domino> getHand() {
        return this.hand;
    }
    public void setHand(ArrayList<Domino> hand) {
        this.hand = hand;
    }
    public void pickFrom(Domino piece) {
        this.hand.add(piece);
    }

    public Domino play() {
        // Domino d = this.hand.get(0);
        return this.hand.remove(0);
    }
}
