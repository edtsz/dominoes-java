public class Tile {
    private int left;
    private int right;
    private boolean isFaceDown = true;

    public Tile(int left, int right) {
        this.setLeft(left);
        this.setRight(right);
    }

    public int getLeft() {
        return this.left;
    }
    public void setLeft(int left) {
        this.left = left;
    }

    public int getRight() {
        return this.right;
    }
    public void setRight(int right) {
        this.right = right;
    }

    public boolean isDouble() {
        return this.right == this.left;
    }

    public int value() {
        int value = this.right + this.left;
        if (this.isDouble()) {
            value += 20; // by pass to highest value
        }
        return value;
    }

    public void flip() {
        this.isFaceDown = !this.isFaceDown;
    }

    public void rotate() {
        int buffer = this.getLeft();
        this.setLeft(this.getRight());
        this.setRight(buffer);
    }

    public String toString() {
        return this.getLeft() + "•" + this.getRight();
    }
}
