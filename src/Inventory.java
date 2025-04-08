import java.util.ArrayList;

public class Inventory {

    //Attributes
    ArrayList<Item> items = new ArrayList<>();

    public Inventory(){
        items.add(new InteractibleItem("NameTag", "A piece of paper with your name on it"));
    }


    //Methods
    public void displayInventory(){
        System.out.println("You currently have these items:");
        for(Item item: items){
            System.out.println(item.name);
        }
    }

    public void pickUp(){

    }
}
