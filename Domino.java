public class Domino {
    private int left;
    private int right;
    private boolean isFaceDown = true;

    public Domino(int left, int right) {
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

    public String toString() {
        return this.getLeft() + "•" + this.getRight();
    }

    public void flip() {
        this.isFaceDown = !this.isFaceDown;
    }

    public void rotate() {
        int buffer = this.getLeft();
        this.setLeft(this.getRight());
        this.setRight(buffer);
    }
}
