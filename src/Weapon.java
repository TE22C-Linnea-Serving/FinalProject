public class Weapon extends InteractibleItem{

    //Attributes
    private int attackPower;

    //Constructor
    public Weapon(String name, String description, int attackPower){
        super(name, description);
        this.name = name;
        this.description = description;
        this.attackPower = attackPower;
    }

    //Methods
    public void use(){      //Override

    }
}
