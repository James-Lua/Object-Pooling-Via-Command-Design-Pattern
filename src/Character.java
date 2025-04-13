import java.util.ArrayList;
import java.util.List;

public abstract class Character {
    private static final List<Character> characterArrayList = new ArrayList<>();
    private final List<String> inventory = new ArrayList<>();
    private final CommandManager commandManager;
    private final ResourcePoints resourcePoints;
    private final Position position;
    private final String name;

    public Character(String name, Position position, ResourcePoints resourcePoints) {
        this.name = name;
        this.position = position;
        this.resourcePoints = resourcePoints;
        this.commandManager = new CommandManager();

        Cell initialCell = MapGenerator.getCellAt(this.position.getX(), this.position.getY());
        if (initialCell != null && !initialCell.isOccupied()) {
            initialCell.occupyCell();
        }

        characterArrayList.add(this);
    }

    public static List<Character> getCharacterArrayList() { return characterArrayList; }

    public CommandManager getCommandManager() { return this.commandManager; }

    public Position getPosition() { return this.position; }

    public String getName() { return this.name; }

    public ResourcePoints getResourcePoints() { return this.resourcePoints; }

    public List<String> getInventory() {
        return inventory;
    }
}