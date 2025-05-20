public class InteractibleFurniture extends Furniture{

    //Attributes
    Inventory contains;
    boolean locked;
    int id;

    public InteractibleFurniture(String name, String description, boolean locked, int id){
        super(name, description);
        this.name = name;
        this.description = description;
        this.locked = locked;
        contains = new Inventory();
        this.id = id;
    }

    public boolean changeLockedStatus(boolean locked){
        if(locked){
            locked = false;
        }else{
            locked = true;
        }
        return locked;
    }
}
