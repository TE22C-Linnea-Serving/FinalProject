public class Weapon extends InteractibleItem{

    //Attributes
    private int attackPower;

    //Constructor
    public Weapon(String name, String description, int attackPower, int id){
        super(name, description, id);
        this.name = name;
        this.description = description;
        this.attackPower = attackPower;
        this.id = id;
    }

    //Methods
    public void use(){      //Override

    }
}
