public class GameLauncher {
    public static void main(String[] args) {
        TurnBasedGame game = new TurnBasedGame();

        game.executeStep();
        game.executeStep();
        game.undoStep();
    }
}