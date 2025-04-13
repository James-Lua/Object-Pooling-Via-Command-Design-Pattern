public class TurnBasedGame {

    public TurnBasedGame() {
        MapGenerator.generateCellArray(5, 5);
    }

    public void executeStep() {
        System.out.println("Executing Game Step...");
        for (Character c : Character.getCharacterArrayList()) {
            System.out.println("Executing CommandManager for " + c.getName());
            c.getCommandManager().execute();
        }
        System.out.println("Game Step Successfully Executed. \n");
    }

    public void undoStep() {
        System.out.println("Undoing Game Step");
        for (Character c : Character.getCharacterArrayList()) {
            System.out.println(c.getName() + " undoing CommandManager");
            c.getCommandManager().undo();
        }
        System.out.println("Game Step Successfully Undone. \n");
    }
}
