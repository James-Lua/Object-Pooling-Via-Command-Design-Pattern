public class MoveCommand implements Command {
    private Player player;
    private int fromX, fromY;
    private int toX, toY;
    private boolean executed;

    // Empty MoveCommand constructor.
    public MoveCommand() { }

    // initialize defines subject, location, and destination.
    // Called before && separate to execute() to ensure the command is loaded with the proper state.
    public void initialize(Player player, int toX, int toY) {
        this.player = player;
        this.fromX = player.getX();
        this.fromY = player.getY();
        this.toX = toX;
        this.toY = toY;
        this.executed = false;
    }

    // We execute the initialized movement command, given there is a valid subject and flag.
    @Override
    public void execute() {
        if (!executed && player != null) {
            player.setPosition(toX, toY);
            executed = true;
        }
    }

    // Reverse the movement action performed by execute() using the vector2 pair (fromX, fromY) that we saved on initialization.
    // We reset the executed flag so movement can be either 'redone' or redefined and executed. #Currently the object is reset on undo()#
    @Override
    public void undo() {
        if (executed && player != null) {
            player.setPosition(fromX, fromY);
            executed = false;
        }
    }

    // Clears the object for reuse. This is called by CommandPool when releasing command objects back into the pool.
    @Override
    public void reset() {
        this.player = null;
        this.fromX = this.fromY = this.toX = this.toY = 0;
        this.executed = false;
    }
}