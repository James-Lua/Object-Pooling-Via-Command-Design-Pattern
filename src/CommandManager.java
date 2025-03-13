public class CommandManager {
    private final CommandPool<MoveCommand> moveCommandPool;
    private final CommandHistory commandHistory;
    private final Player player;

    // CommandManager constructor: Initialize with a player, a command pool, and an empty command history.
    public CommandManager(Player player, int poolSize) {
        this.player = player;
        moveCommandPool = new CommandPool<>(poolSize, MoveCommand::new); // Create a pool for MoveCommand objects using a lambda as factory.
        commandHistory = new CommandHistory();
    }

    // Execute a move command and record it.
    public void executeMove(int toX, int toY) {
        MoveCommand cmd = moveCommandPool.acquire();
        cmd.initialize(player, toX, toY);
        cmd.execute();
        commandHistory.push(cmd);
    }

    // Undo the last executed command and return it to the pool
    public void undoLast() {
        Command cmd = commandHistory.pop();
        if (cmd != null) {
            cmd.undo();
            if (cmd instanceof MoveCommand) {
                moveCommandPool.release((MoveCommand) cmd);
            }
        } else {
            System.out.println("No command to undo!");
        }
    }
}