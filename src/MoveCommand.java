public class MoveCommand implements Command {
    private Character character;
    private Cell nextCell, previousCell;
    private int fromX, fromY;
    private int toX, toY;
    private boolean executed;

    public MoveCommand(Character character, Cell nextCell) {
        if (!nextCell.isOccupied() && character != null) {
            this.nextCell = nextCell;
            this.character = character;
            this.fromX = character.getX();
            this.fromY = character.getY();
            this.toX = nextCell.getX();
            this.toY = nextCell.getY();
            this.executed = false;
        }
    }

    // Debug function
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
        if (!this.executed && this.character != null && !this.nextCell.isOccupied()) {
            this.previousCell = MapGenerator.getCellAt(this.character.getX(), this.character.getY());
            if (this.previousCell != null) {
                this.previousCell.leaveCell();
            }
            this.character.setPosition(this.toX, this.toY);
            this.nextCell.occupyCell();
            this.executed = true;
        }
    }

   @Override
    public void undo() {
        if (this.executed && this.character != null) {
            this.nextCell.leaveCell();
            if (this.previousCell != null) {
                this.previousCell.occupyCell();
            }
            this.character.setPosition(this.fromX, this.fromY);
            this.executed = false;
        }
    }

    @Override
    public void reset() {
        this.fromX = this.fromY = this.toX = this.toY = 0;
        this.executed = false;
    }
}