public class Cell {
    private final int x, y;
    private boolean isOccupied;

    public Cell(int x, int y){
        this.x = x;
        this.y = y;
        this.isOccupied = false;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public boolean isOccupied(){
        return isOccupied;
    }

    public void occupyCell(){
        isOccupied = true;
    }
}
