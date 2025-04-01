public class MoveCommand implements Command {
    private Character character;
    private int fromX, fromY;
    private int toX, toY;
    private boolean executed;


    public void initialize(Character character, int toX, int toY) {
        if (this.character != null) { this.character = character;}
        // each character has their own pool, so reused objects may already have their character assigned.

        this.fromX = character.getX();
        this.fromY = character.getY();
        this.toX = toX;
        this.toY = toY;

        this.executed = false;
    }

    // We execute the initialized movement command, given there is a valid subject and flag.
    @Override
    public void execute() {
        if (!executed && character != null) {
            character.setPosition(toX, toY);
            executed = true;
        }
    }

    // Reverse the movement action performed by execute() using the vector2 pair (fromX, fromY) that we saved on initialization.
    // We reset the executed flag so movement can be either 'redone' or redefined and executed. #Currently the object is reset on undo()#
    @Override
    public void undo() {
        if (executed && character != null) {
            character.setPosition(fromX, fromY);
            executed = false;
        }
    }

    // Clears the object for reuse. This is called by CommandPool when releasing command objects back into the pool.
    @Override
    public void reset() {
        // this.character = null; Currently not necessary
        this.fromX = this.fromY = this.toX = this.toY = 0;
        this.executed = false;
    }
}