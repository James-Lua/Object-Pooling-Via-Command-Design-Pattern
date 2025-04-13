public class MoveCommand implements Command {
    private final Character character;
    private Cell nextCell, previousCell;
    private boolean executed;

    public MoveCommand(Character character, Cell nextCell) {
        this.character = character;
        this.nextCell = nextCell;
        this.previousCell = MapGenerator.getCellAt(character.getPosition().getX(), character.getPosition().getY());

        // This logic will eventually be moved to a different class that handles what cells can be selected based on distance and occupied bool.
        if (nextCell.isOccupied()) {
            System.out.println(character.getName() + " cannot move to occupied cell!");
            return;
        }

        this.executed = false;
    }

    @Override
    public void execute() {
        if (!this.executed && !this.nextCell.isOccupied()) {
            if (this.previousCell != null) { this.previousCell.leaveCell(); }
            this.nextCell.occupyCell();
            this.character.getPosition().setPosition(this.nextCell.getX(), this.nextCell.getY());
            this.executed = true;
        }
    }

    @Override
    public void undo() {
        if (this.executed) {
            // Free the current cell
            this.nextCell.leaveCell();

            // Re-occupy the previous cell
            if (this.previousCell != null) {
                this.previousCell.occupyCell();
                this.character.getPosition().setPosition(this.previousCell.getX(), this.previousCell.getY());
            }
            this.executed = false;
        }
    }

    @Override
    public void reset() {
        this.nextCell = null;
        this.previousCell = null;
        this.executed = false;
    }
}