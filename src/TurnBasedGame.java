public class TurnBasedGame {
    CommandMacro masterMacro;

    public TurnBasedGame() {
        masterMacro = new CommandMacro();
        CharacterCreator.inputCharacterCreator();
    }

    public void executeStep() {
        for(Character c : Character.getCharacterArrayList()) {
            masterMacro.add(c.getNextMove());
        }
        masterMacro.execute();
    }

    public void undoStep() {
        // send undo to master macro
    }
}