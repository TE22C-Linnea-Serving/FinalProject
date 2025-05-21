import java.util.Scanner;

public class Key extends InteractibleItem{

    //Attributes

    //Constructor
    public Key(String name, String description, int id){
        super(name, description, id);                       //Does not care what the parent class sets these values to
    }

    public Key() {
        super();
    }

    //Methods

    //Method for when the user wants to use a Key
    public void use(User player, InteractibleFurniture interactibleFurniture, String text1){
        Scanner sc = new Scanner(System.in);
        boolean hasKey = false;             //Sets that the user does not have the key in the beginning

        for (int i=0; i<=player.getBackpack().items.size()-1; i++){  //Goes through the players inventory
            if(player.getBackpack().items.get(i).getId() == interactibleFurniture.getId()){           //If the player has the door key in their inventory
                System.out.println("Do you want to use the " + player.getBackpack().items.get(i).getName() + "? (y/n)\n");  //Asks user if they want to use the key

                while(true) {
                    String answer = sc.nextLine();
                    if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {   //If the user wants to use the key
                        System.out.println(text1);  //Information for the player, unique for each interactable item
                        player.getBackpack().items.remove(i);   //Removes the key from the players backpack
                        interactibleFurniture.changeLockedStatus(); //Changes the locked status on the InteractableFurniture

                        break;
                    } else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n")) { //If the user does not want to use the key
                        System.out.println("You leave without using the " + player.getBackpack().items.get(i).getName() + ".\n");
                        hasKey = true;  //Shows that the user actually has the key, and therefore won't activate a condition on row 43
                        break;
                    }else{
                        System.out.println("Please write one of the options.\n");
                    }
                }
            }else if(i == player.getBackpack().items.size()-1 && !hasKey){      //If every item has been checked in the players backpack, and the player does not have a key                                          //If the player does not have the door key in their inventory
                System.out.print("Maybe you could look around to see if you can find some sort of key?\n\n");
            }
        }
    }
}
