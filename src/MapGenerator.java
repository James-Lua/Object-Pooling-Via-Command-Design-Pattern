import java.util.ArrayList;
import java.util.List;

public class MapGenerator {
    private static final List<Cell> cellArray = new ArrayList<>();

    public static void generateCellArray(int width, int height) {
        for (int y = 0; y <= height - 1; y++) {
            for (int x = 0; x <= width - 1; x++) {
                Cell cell = new Cell();
                cell.setPosition(x, y);
                cellArray.add(cell);
            }
        }
    }

    public static List<Cell> getCellArray() {
        return cellArray;
    }

    public static Cell getCellAt(int x, int y) {
        for (Cell cell : cellArray) {
            if (cell.getPosition().getX() == x && cell.getPosition().getY() == y) {
                return cell;
            }
        }
        return null;
    }
}