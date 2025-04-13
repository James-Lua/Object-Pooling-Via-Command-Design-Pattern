public class CommandManager implements Command {
    private final CommandHistory commandHistory;
    private final CommandMacro commandMacro;

    public CommandManager() {
        this.commandMacro = new CommandMacro();
        this.commandHistory = new CommandHistory();
    }

    public void addCommand(Command command) {
        this.commandMacro.add(command);
    }

    @Override
    public void execute() {
        this.commandMacro.execute();
        this.commandHistory.push(this.commandMacro);
    }

    @Override
    public void undo() {
        CommandMacro lastCommandMacro = this.commandHistory.pop();
        lastCommandMacro.undo();
    }

    @Override
    public void reset() {
        this.commandMacro.reset();
    }
}