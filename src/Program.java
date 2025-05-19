import java.util.Collection;
import java.util.Scanner;

public class Program {

    public void program() {

        Scanner sc = new Scanner(System.in);

        InteractibleFurniture cabinet1 = new InteractibleFurniture("Cabinet", "A small cabinet", false);
        cabinet1.contains.items.add(new Key("Screwdriver", "A normal screwdriver", 1, false));
        cabinet1.contains.items.add(new Key("Mini flag", "A small flag with a sphere at the bottom", 2, false));

        User player = new User("Jess");
        player.backpack.items.add(new InteractibleItem("Nametag", "A iece of lastic with your name on it."));

        System.out.println("Backstory...");

        System.out.println("You find yourself trapped in a small, dark lit room.\n\n");

        while(true) {
            String answer = "";
            while (true) {
                System.out.println("What do you want to do?\n1. Inspect wardrobe\n2. Inspect right door\n3. Inspect cabinet\n4. inspect table\n5. Show Inventory");

                answer = sc.nextLine();

                if (answer.equals("1") || answer.equals("2") || answer.equals("3") || answer.equals("4") || answer.equals("5")) {
                    break;
                }
            }

            switch (answer) {

                //Wardrobe
                case "1":

                    break;

                //Right door
                case "2":
                    System.out.println("You try opening the door, but it won’t move. Maybe you could look around to see if you can find a key?");
                    break;

                //Cabinet
                case "3":

                    while(true) {
                        System.out.print("You have found: ");
                        cabinet1.displayContains();

                        System.out.println("Do you want to pick it up?");
                        String answer2 = sc.nextLine();

                        if (answer2.equalsIgnoreCase("yes")) {

                            player.backpack.items.addAll(cabinet1.contains.items);
                            cabinet1.contains.items.clear();

                            break;
                        } else if (answer2.equalsIgnoreCase("no")) {
                            break;
                        } else {
                            System.out.println("Please try again:\n");
                        }
                    }


                    break;

                //Table
                case "4":

                    break;

                //Inventory show
                case "5":
                    player.backpack.displayInventory();
                    break;
            }
        }

    }
}
