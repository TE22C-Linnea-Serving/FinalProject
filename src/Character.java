public class Character {

    //Attributes
    private String name;
    private int id;

    //Constructor
    public Character(){
        name = getName();
        id = getId();
    }

    //Method
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
