import java.util.Scanner;

class CharacterGenerator {

    // For testing purposes
    public static void inputCharacterCreator() {
        Scanner scanner = new Scanner(System.in);

        //new PCCharacter();

        System.out.println("Enter name:");
        String pcName = scanner.nextLine();

        //new PCCharacter(pcName);


        System.out.println("Enter name:");
        String npcName = scanner.nextLine();
        System.out.println("Enter X position:");
        int npcX = scanner.nextInt();
        System.out.println("Enter Y position:");
        int npcY = scanner.nextInt();
        System.out.println("Enter health:");
        int npcHealth = scanner.nextInt();

        //new NPCCharacter(npcName, npcX, npcY, npcHealth);

        scanner.close();
    }

    public static void spawnCharacter(Character character) {
        int xPos = character.getX();
        int yPos = character.getY();

        Cell initialCell = MapGenerator.getCellAt(xPos, yPos);
        if (initialCell != null && !initialCell.isOccupied()) {
            initialCell.occupyCell();
        }
        else {
            System.out.println("Cell Occupied, Searching for nearby unoccupied cell....");
            character.setPosition(xPos + 1, yPos); // Temporary
            spawnCharacter(character);
        }

    }
}
