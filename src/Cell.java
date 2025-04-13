public class Cell {
    private final int x, y;
    private boolean isOccupied;

    public Cell(int x, int y){
        this.x = x;
        this.y = y;
        this.isOccupied = false;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public boolean isOccupied(){
        return this.isOccupied;
    }

    public void occupyCell(){
        this.isOccupied = true;
        System.out.println("Cell at (" + this.x + ", " + this.y + ") is now occupied.");
    }

    public void leaveCell(){
        this.isOccupied = false;
        System.out.println("Cell at (" + this.x + ", " + this.y + ") is now unoccupied.");
    }
}
