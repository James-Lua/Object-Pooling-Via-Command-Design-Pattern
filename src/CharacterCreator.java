import java.util.Scanner;

class CharacterCreator {

    // For testing purposes
    public static void inputCharacterCreator() {
        Scanner scanner = new Scanner(System.in);

        new PCCharacter();

        System.out.println("Enter name:");
        String pcName = scanner.nextLine();

        new PCCharacter(pcName);


        System.out.println("Enter name:");
        String npcName = scanner.nextLine();
        System.out.println("Enter X position:");
        int npcX = scanner.nextInt();
        System.out.println("Enter Y position:");
        int npcY = scanner.nextInt();
        System.out.println("Enter health:");
        int npcHealth = scanner.nextInt();

        new NPCCharacter(npcName, npcX, npcY, npcHealth);

        scanner.close();
    }

}
