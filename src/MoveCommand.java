public class MoveCommand implements Command {
    private Character character;
    private Cell cell;
    private int fromX, fromY;
    private int toX, toY;
    private boolean executed;

    // New init method for future cell system
    public MoveCommand(Character character, Cell cell) {
        if (!cell.isOccupied() && character != null) {
            this.cell = cell;
            this.character = character;
            this.fromX = character.getX();
            this.fromY = character.getY();
            this.toX = cell.getX();
            this.toY = cell.getY();
            this.executed = false;
        }
    }

    // Old init method for direct coordinate input
    public void moveToCoordinates(Character character, int toX, int toY) {
        if (this.character != null) { this.character = character;}

        this.fromX = character.getX();
        this.fromY = character.getY();
        this.toX = toX;
        this.toY = toY;

        this.executed = false;
    }

    @Override
    public void execute() {
        if (!this.executed && this.character != null && !this.cell.isOccupied()) {
            this.character.setPosition(toX, toY);
            this.cell.occupyCell();
            this.executed = true;
        }
    }

   @Override
    public void undo() {
        if (this.executed && this.character != null) {
            this.character.setPosition(this.fromX, this.fromY);
            this.executed = false;
        }
    }

    @Override
    public void reset() {
        // this.character = null; Currently not necessary
        this.fromX = this.fromY = this.toX = this.toY = 0;
        this.executed = false;
    }
}