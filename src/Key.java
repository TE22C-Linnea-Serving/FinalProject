import java.util.Scanner;

public class Key extends InteractibleItem{

    //Attributes
    private int id;
    private boolean used;
    Room room1 = new Room();

    //Constructor
    public Key(String name, String description, int id, boolean used){
        super(name, description, id);
        this.name = name;
        this.description = description;
        this.id = id;
        this.used = used;
    }

    public Key() {
        super();
    }

    //Methods

    public void use(User player, InteractibleFurniture interactibleFurniture, String text1){
        Scanner sc = new Scanner(System.in);

        for (int i=0; i<=player.backpack.items.size()-1; i++){  //Goes through the players inventory
            if(player.backpack.items.get(i).id == interactibleFurniture.id){           //If the player has the door key in their inventory
                System.out.println("Do you want to use the " + player.backpack.items.get(i).name + "? (y/n)\n");

                while(true) {
                    String answer = sc.nextLine();
                    if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {
                        System.out.println(text1);  //Information for the player, unique for each interactible item
                        player.backpack.items.remove(i);
                        interactibleFurniture.locked = false;

                        break;
                    } else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n")) {
                        System.out.println("You leave without using the " + player.backpack.items.get(i).name + ".\n");
                        break;
                    }else{
                        System.out.println("Please write one of the options.\n");
                    }
                }
            }else if(i == player.backpack.items.size()-1){                                              //If the player does not have the door key in their inventory
                System.out.print("Maybe you could look around to see if you can find some sort of key?\n\n");
            }
        }
    }
}
