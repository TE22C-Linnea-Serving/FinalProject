import java.util.ArrayList;
import java.util.Scanner;

public class Inventory {

    //Attributes
    ArrayList<Item> items = new ArrayList<>();  //Creates an array list with items

    public Inventory(){

    }


    //Methods
    public void displayInventory(){     //Displays the inventory (can be any inventory)
        int i = 1;
        for(Item item: items){          //Goes through every item in the inventory
            System.out.println(i + ". " + item.getName());
            i++;
        }
        System.out.println();
    }

    //The method to pick up items from InteractableFurniture
    public void pickUp(User player, InteractibleFurniture interactibleFurniture){
        Scanner sc = new Scanner(System.in);

        if (!interactibleFurniture.getContains().items.isEmpty()) {     //If the InteractableFurniture is not empty
            System.out.print("You have found:\n");
            interactibleFurniture.getContains().displayInventory();     //Prints out the items in tha InteractableFurniture's inventory
            System.out.println("Do you want to pick it up? (y/n)");
            while(true) {
                String answer = sc.nextLine();
                if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {       //If the user wants to pick the items up
                    player.getBackpack().items.addAll(interactibleFurniture.getContains().items);                   //Adds all items in InteractableFurniture's inventory into the players backpack (inventory)
                    interactibleFurniture.getContains().items.clear();                                              //Removes all items in the InteractableFurniture's inventory
                    System.out.println("You have now picket it up.\n");
                    break;
                } else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n")) { //Of the user does not want to pick up the items
                    System.out.println("You chose not to pick up the items and leave.\n");
                    break;
                } else {
                    System.out.println("Please write yes or no\n");
                }
            }

        } else {                                            //If the InteractableFurniture's inventory is empty
            System.out.println("There is nothing here.\n");
        }
    }
}
