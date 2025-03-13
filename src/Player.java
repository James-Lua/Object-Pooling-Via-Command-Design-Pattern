public class Player {
    private int x, y;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public int getY() { return y; }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
        System.out.println("Player moved to (" + x + ", " + y + ")");
    }
}