import java.util.ArrayList;
import java.util.List;

class CommandMacro implements Command {
    private final List<Command> cmds = new ArrayList<>();

    public void add(Command cmd) {
        cmds.add(cmd);
    }

    public void remove(Command cmd) {
        cmds.remove(cmd);
    }

    @Override
    public void execute() {
        for (Command c : cmds) {
            c.execute();
        }
    }

    @Override
    public void undo() {
        for (int i = cmds.size() - 1; i >= 0; i--) {
            cmds.get(i).undo();
        }
    }

    @Override
    public void reset() {
        for (Command c : cmds) {
            c.reset();
        }
    }
}