import java.util.ArrayList;
import java.util.Scanner;

public class Room {

    //Attributes

    private boolean lightLevel;
    ArrayList<Furniture> furnitures = new ArrayList();
    InteractibleFurniture wardrobe1 = new InteractibleFurniture("Wardrobe", "A big wardrobe with a mystery", true);

    //Methods
    public String showRoomDescription(){
        String text = "null";

        return text;
    }

    public void showWardrobe(User player, String answer, String enter){
        Scanner sc = new Scanner(System.in);

        System.out.println("You walk over to the wardrobe and open it.\n");

        if(wardrobe1.locked) {

            System.out.println("Inside, you find a hatch at the bottom of the wardrobe, but it seems stuck.\n");

            for (int i = 0; i <= player.backpack.items.size() - 1; i++) { //Looks for the screwdriver in player inventory
                if (player.backpack.items.get(i).id == 1) {     //The Screwdriver is in the players inventory

                    System.out.println("Do you want to use the screwdriver to unscrew the hatch door?\n");
                    answer = sc.nextLine();

                    while (true) {
                        if (answer.equalsIgnoreCase("yes")) {

                            System.out.println("You start unscrewing the hatch door...\nYou successfully removed the door hatch!\nHowever, the screwdriver broke!\n");
                            wardrobe1.locked = false;           //Wardrobe now unlocked
                            player.backpack.items.remove(i);    //Removes screwdriver from players inventory
                            break;
                        } else if (answer.equalsIgnoreCase("no")) {
                            System.out.println("You chose to not do anything, and walk away from the wardrobe.\n");
                            break;
                        } else {
                            System.out.println("Please write yes or no.\n");
                        }
                    }
                }
            }
        } else {
            System.out.println("Inside, you find what seems to be an endless dark pit.\n");
            System.out.println("What do you want to do?\n1. Reach your hand down\n2. Don't do anything\n");

            while (true) {
                answer = sc.nextLine();
                if (answer.equalsIgnoreCase("1")) {
                    if(!wardrobe1.contains.items.isEmpty()) {
                        System.out.println("Inside, you find:");
                        wardrobe1.contains.displayInventory();

                        System.out.println("Do you want to pick it up? (y/n)");
                        while(true) {
                            answer = sc.nextLine();
                            if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {
                                player.backpack.items.addAll(wardrobe1.contains.items);
                                wardrobe1.contains.items.clear();
                                System.out.println("You have now picket it up.");
                                break;
                            } else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n")) {
                                System.out.println("You chose not to pick up the items and leave.\n");
                                break;
                            } else {
                                System.out.println("Please write one of the options.\n");
                            }
                        }
                    }else{
                        System.out.println("There is nothing here.\n");
                    }
                    break;
                } else if (answer.equalsIgnoreCase("2")) {
                    System.out.println("You chose to not do anything, and leave.");
                    break;
                } else {
                    System.out.println("Please select one of the options.");

                }
            }
        }
    }
}
