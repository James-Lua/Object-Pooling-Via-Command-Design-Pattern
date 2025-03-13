public class TurnBasedGame {
    private Player player;
    private final CommandManager commandManager;

    public TurnBasedGame() {
        // Starting position (0,0)
        player = new Player(0, 0);
        commandManager = new CommandManager(player, 5);
    }

    // Wrapper method.
    public void movePlayer(int toX, int toY) {
        commandManager.executeMove(toX, toY);
        // Future movement logic can be wrapped here.
    }

    // Wrapper method.
    public void undo() {
        commandManager.undoLast();
        // Would need to wrap other logic that would take place on an undo, like world history and health history, etc.
    }
}
