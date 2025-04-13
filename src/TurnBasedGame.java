import java.util.ArrayList;
import java.util.List;

public class TurnBasedGame {

    public TurnBasedGame() {
        // Generate map FIRST
        MapGenerator.generateCellArray(5,5);
        CharacterGenerator.inputCharacterCreator();

        List<Cell> cellArray = MapGenerator.getCellArray();

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