public class Item {

    //Attributes
    private String name;
    private String description;
    private int id;


    //Constructor
    public Item(String name, String description, int id){
        this.name = name;
        this.description = description;
        this.id = id;
    }

    public Item() {

    }

    //Methods
    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }
}
