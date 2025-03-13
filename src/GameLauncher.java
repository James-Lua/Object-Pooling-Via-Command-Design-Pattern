public class GameLauncher {
    public static void main(String[] args) {
        TurnBasedGame game = new TurnBasedGame();

        for (int i = 1; i <= 4; i++) { game.movePlayer(i,i); }
        game.undo();
        game.undo();
        game.undo();

        game.movePlayer(100,55);
        game.movePlayer(100,200);

        game.undo();
        game.undo();
        game.undo();
        game.undo();
    }
}
