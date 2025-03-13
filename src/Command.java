public interface Command {
    void execute();
    void undo();
    void reset();
}


// If we want to store game steps in objects (which we would need to do for many functionalities), we face two main problems.

// Problem 1: Frequency of game steps in a turn-based game are determined by the player. If the player wants to play quickly, they
// will create new game step objects just as quickly, which will have an impact on performance. To solve this, we can utilize
// object pooling, limiting new game step objects from being needlessly created.

// Problem 2: Turn-based game steps can be complex, varied, and invoked from multiple sources. If we want to store game steps
// within objects, we need a way to set parameters on said object through varying operations while upholding OOP principles, and
// invoke said object from varying sources. To solve this, we can utilize the Command design pattern to decouple the request invoker
// and parameterize our object with any combination of operations.

// We can now have a recorded history of game-steps that we can use for functions like 'undo' and more.
// Our game steps should also be more resource-friendly, as we can limit the creation of game-step objects by
// reusing them instead of creating new ones and leaving the old ones for the automatic JVM garbage collection.