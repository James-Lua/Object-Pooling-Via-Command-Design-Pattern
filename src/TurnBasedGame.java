import java.util.ArrayList;
import java.util.List;

public class TurnBasedGame {

    public TurnBasedGame() {
        // Currently for testing
        CharacterCreator.inputCharacterCreator();
        mapGenerator.generateCellArray(5,5);
        List<Cell> cellArray = mapGenerator.getCellArray();

        ArrayList<Character> cAL = Character.getCharacterArrayList();
        Character characterFirst = cAL.getFirst();
        characterFirst.getCommandManager().addCommand(new MoveCommand(characterFirst, cellArray.get(8)));
        characterFirst.getCommandManager().addCommand(new MoveCommand(characterFirst, cellArray.get(30)));
    }

    public void executeStep() {
        for(Character c : Character.getCharacterArrayList()) {
            c.getCommandManager().execute();
        }
    }

    public void undoStep() {
        for(Character c : Character.getCharacterArrayList()) {
            c.getCommandManager().undo();
        }
    }
}