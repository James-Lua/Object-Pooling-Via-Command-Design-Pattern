import java.util.ArrayList;
import java.util.List;

public class MapGenerator {
    private static final List<Cell> cellArray = new ArrayList<>();

    public static void generateCellArray(int width, int height) {
        for (int y = 0; y <= height - 1; y++) {
            for (int x = 0; x <= width - 1; x++) {
                cellArray.add(new Cell(x, y));
            }
        }
    }

    public static List<Cell> getCellArray() {
        return cellArray;
    }

    public static Cell getCellAt(int x, int y) {
        for (Cell cell : cellArray) {
            if (cell.getX() == x && cell.getY() == y) {
                return cell;
            }
        }
        return null;
    }
}