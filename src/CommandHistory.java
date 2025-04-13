import java.util.Stack;

class CommandHistory {
    private final Stack<CommandMacro> history = new Stack<>();

    public void push(CommandMacro commandMacro) {
        history.push(commandMacro);
    }

    public CommandMacro pop() {
        return history.isEmpty() ? null : history.pop();
    }

    public boolean isEmpty() {
        return history.isEmpty();
    }
}