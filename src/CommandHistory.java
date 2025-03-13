import java.util.Stack;

public class CommandHistory {
    private final Stack<Command> history = new Stack<>();

    public void push(Command cmd) {
        history.push(cmd);
    }

    public Command pop() {
        return history.isEmpty() ? null : history.pop();
    }

    public boolean isEmpty() {
        return history.isEmpty();
    }
}