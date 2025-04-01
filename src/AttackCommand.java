public class AttackCommand implements Command {
    private PCCharacter PCCharacter; // In future will be a target-able character entity from a character class.
    private PCCharacter target; // In future will be a target-able character entity from a character class.

    @Override
    public void execute() {
        //target.hp += 1;
    }

    @Override
    public void undo() {

    }

    @Override
    public void reset() {

    }
}
