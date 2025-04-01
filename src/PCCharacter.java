public class PCCharacter extends Character {

    public PCCharacter(String name, int x, int y, int hp) {
        super(name, x, y, hp);
    }

    public PCCharacter(String name, int x, int y) {
        super(name, x, y, 100);
    }

    public PCCharacter(String name) {
        super(name, 0, 0, 100);
    }

    public PCCharacter() {
        super("Jeff", 0, 0, 100);
    }

}