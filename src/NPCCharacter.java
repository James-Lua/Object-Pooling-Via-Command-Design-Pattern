public class NPCCharacter extends Character{

    public NPCCharacter(String name, int x, int y, int hp) {
        super(name, x, y, hp);
    }

    public NPCCharacter(String name, int x, int y) {
        super(name, x, y, 100);
    }

    public NPCCharacter(String name) {
        super(name, 0, 0, 100);
    }

    public NPCCharacter() {
        super("Evil John", 0, 0, 100);
    }

}
