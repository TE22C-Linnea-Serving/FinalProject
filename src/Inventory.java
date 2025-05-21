import java.util.ArrayList;
import java.util.Scanner;

public class Inventory {

    //Attributes
    ArrayList<Item> items = new ArrayList<>();

    public Inventory(){

    }


    //Methods

    public void displayInventory(){
        int i = 1;
        for(Item item: items){
            System.out.println(i + ". " + item.name);
            i++;
        }
        System.out.println();
    }

    public void pickUp(User player, InteractibleFurniture interactibleFurniture){
        Scanner sc = new Scanner(System.in);

        if (!interactibleFurniture.contains.items.isEmpty()) {
            System.out.print("You have found:\n");
            interactibleFurniture.contains.displayInventory();
            System.out.println("Do you want to pick it up? (y/n)");
            while(true) {
                String answer = sc.nextLine();
                if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {
                    player.getBackpack().items.addAll(interactibleFurniture.contains.items);
                    interactibleFurniture.contains.items.clear();          //Picks up all items
                    System.out.println("You have now picket it up.\n");
                    break;
                } else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n")) {
                    System.out.println("You chose not to pick up the items and leave.\n");
                    break;
                } else {
                    System.out.println("Please write one of the options.\n");
                }
            }

        } else {
            System.out.println("There is nothing here.\n");
        }
    }
}
