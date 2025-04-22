public class User {

    //Attributes
    private String name;
    Inventory backpack;

    public User(String name){
        this.name = name;
        backpack = new Inventory();
    }

    //Methods
    public String getName() {
        return name;
    }

    public void chooseName(){

    }
}
