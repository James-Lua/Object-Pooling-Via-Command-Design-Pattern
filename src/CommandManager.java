public class CommandManager {
    //private final CommandPool<MoveCommand> moveCommandPool;
    //private final CommandHistory commandHistory;
    //private final Character character;

    public CommandManager() {
        //this.character = character;

        // Create a pool for MoveCommand objects using a lambda as factory.
        //moveCommandPool = new CommandPool<>(MoveCommand::new, 5);

        //commandHistory = new CommandHistory();
    }

    /* Undo the last executed command and return it to the pool
    public void undoLast(Command command) {
        Command cmd = commandHistory.pop();
        if (cmd != null) {
            cmd.undo();
            //CommandPool<command>.release(command);
        } else {
            System.out.println("No command to undo!");
        }
    }
     */

    public Command getAllCommands() {
        return null;
    }
}