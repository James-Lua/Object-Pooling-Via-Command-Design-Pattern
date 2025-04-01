import java.util.Stack;

public class CommandPool<C extends Command> {

    private final Stack<C> pool = new Stack<>(); // Command object pool, stores our unused/available command objects.
    private final CommandFactory<C> factory; // Generic factory interface, used to create new command objects when the pool is empty.

    // Basic constructor that makes use of the generic factory with a parameter for initial pool size.
    public CommandPool(CommandFactory<C> factory, int initialSize) {
        this.factory = factory;
        for (int i = 0; i < initialSize; i++) {
            pool.push(factory.create());

            System.out.println("Created object [" + pool.getLast().toString() + "] for pool [" + super.toString() + "], pool now contains " + pool);
        }
    }

    // If the pool is empty, factory creates a new object, else pop from top of the stack.
    public C acquire() {
        return pool.isEmpty() ? factory.create() : pool.pop();
    }

    // Basic push function, calls reset to clean the object before pushing it back into the stack.
    public void release(C command) {
        command.reset();
        pool.push(command);
    }

    // Generic Factory inner interface, used to create new commands. Could be expanded to a full factory pattern if needed.
    public interface CommandFactory<C extends Command> {
        C create();
    }
}