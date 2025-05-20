public class Item {

    //Attributes
    String name;
    String description;
    int id;
    boolean used;

    //Constructor
    public Item(String name, String description, int id, boolean used){
        this.name = name;
        this.description = description;
        this.id = id;
        used = false;
    }

    public Item(String name, String description, int id){

    }

    public Item() {

    }

    //Methods

    public String showDescription(String description){

        return description;
    }
}
