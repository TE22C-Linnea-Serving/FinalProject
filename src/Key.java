public class Key extends InteractibleItem{

    //Attributes
    private int id;
    private boolean used;

    //Constructor
    public Key(String name, String description, int id, boolean used){
        super(name, description, id);
        this.name = name;
        this.description = description;
        this.id = id;
        this.used = used;
    }

    //Methods
    public void use(){      //Override

    }
}
