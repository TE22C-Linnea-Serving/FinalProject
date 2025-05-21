import java.util.Scanner;

public class Key extends InteractibleItem{

    //Attributes

    //Constructor
    public Key(String name, String description, int id){
        super(name, description, id);
    }

    public Key() {
        super();
    }

    //Methods

    public void use(User player, InteractibleFurniture interactibleFurniture, String text1){
        Scanner sc = new Scanner(System.in);
        boolean hasKey = false;

        for (int i=0; i<=player.getBackpack().items.size()-1; i++){  //Goes through the players inventory
            if(player.getBackpack().items.get(i).getId() == interactibleFurniture.getId()){           //If the player has the door key in their inventory
                System.out.println("Do you want to use the " + player.getBackpack().items.get(i).getName() + "? (y/n)\n");

                while(true) {
                    String answer = sc.nextLine();
                    if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {
                        System.out.println(text1);  //Information for the player, unique for each interactable item
                        player.getBackpack().items.remove(i);
                        interactibleFurniture.changeLockedStatus();

                        break;
                    } else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n")) {
                        System.out.println("You leave without using the " + player.getBackpack().items.get(i).getName() + ".\n");
                        hasKey = true;
                        break;
                    }else{
                        System.out.println("Please write one of the options.\n");
                    }
                }
            }else if(i == player.getBackpack().items.size()-1 && !hasKey){                                              //If the player does not have the door key in their inventory
                System.out.print("Maybe you could look around to see if you can find some sort of key?\n\n");
            }
        }
    }
}
