import java.util.ArrayList;

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

    public void pickUp(){


    }
}
