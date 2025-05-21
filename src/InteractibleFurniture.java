public class InteractibleFurniture extends Furniture{

    //Attributes
    private final Inventory contains;
    private boolean locked;
    private final int id;

    public InteractibleFurniture(String name, String description, boolean locked, int id){
        super(name, description);
        this.locked = locked;
        contains = new Inventory();
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public boolean isLocked() {
        return locked;
    }

    public Inventory getContains() {
        return contains;
    }

    public void changeLockedStatus(){
        locked = !locked;
    }
}
