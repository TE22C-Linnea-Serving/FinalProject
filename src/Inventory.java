import java.util.ArrayList;

public class Inventory {

    //Attributes
    ArrayList<Item> items = new ArrayList<>();

    public Inventory(){

    }


    //Methods

    public void displayInventory(){
        System.out.println("You currently have these items in your inventory:");
        for(Item item: items){
            System.out.println(item.name);
        }
        System.out.println();
    }

    public void pickUp(){


    }
}
