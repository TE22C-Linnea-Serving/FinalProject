public class InteractibleFurniture extends Furniture{

    //Attributes
    private Inventory contains;
    private boolean locked;
    int id;

    public InteractibleFurniture(String name, String description, boolean locked, int id){
        super(name, description);
        this.name = name;
        this.description = description;
        this.locked = locked;
        contains = new Inventory();
        this.id = id;
    }

    public boolean isLocked() {
        return locked;
    }

    public Inventory getContains() {
        return contains;
    }

    public boolean changeLockedStatus(){
        if(locked){
            locked = false;
        }else{
            locked = true;
        }
        return locked;
    }
}
