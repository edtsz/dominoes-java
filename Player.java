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

    public Domino play(int piece) {
        // Domino d = this.hand.get(0);
        return this.hand.remove(0);
    }

    public String toString() {
        String str = this.getName();
        str += ": ";

        for(Domino p: this.hand) {
            str += p.toString() + " ";
        }

        return str.trim();
    }
}
