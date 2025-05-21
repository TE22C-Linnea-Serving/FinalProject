public class Weapon extends InteractibleItem{

    //Attributes

    //Constructor
    public Weapon(String name, String description, int id){
        super(name, description, id);
        this.name = name;
        this.description = description;
        this.id = id;
    }

    //Methods
    public void use(){      //Override

    }
}
