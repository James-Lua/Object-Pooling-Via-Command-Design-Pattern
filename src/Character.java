import java.util.ArrayList;

public abstract class Character {
    private static final ArrayList<Character> characterArrayList = new ArrayList<>();
    private final CommandManager commandManager;
    private final String name;
    private int x, y;
    private int hp;

    public Character(String name, int x, int y, int hp) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.hp = hp;

        System.out.println("\n...Creating Character [" + this + "]...\n");
        this.commandManager = new CommandManager();
        System.out.println("\n...Created Character [" + this + "] with Command Manager object [" + commandManager + "], name " + name + ", position (" +  x + ", " + y + "), and health set to " + hp + "...\n");

        characterArrayList.add(this);
    }

    public static ArrayList<Character> getCharacterArrayList() { return characterArrayList; }

    public CommandManager getCommandManager() { return this.commandManager; }

    public String getName() { return this.name; }

    public int getX() { return this.x; }

    public int getY() { return this.y; }

    public void setPosition(int x, int y) {
        System.out.println(this.name + " was at (" + this.x + ", " + this.y + "), moving...");
        this.x = x;
        this.y = y;
        System.out.println(this.name + " moved to (" + x + ", " + y + ")");
    }

    public int getHP() { return this.hp; }

    public void setHP(int hp) { this.hp = hp; }

    public void reset() {}
}