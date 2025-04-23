public class InteractibleFurniture extends Furniture{

    //Attributes
    Inventory contains;
    private boolean locked;

    public InteractibleFurniture(String name, String description, boolean locket){
        super(name, description);
        this.name = name;
        this.description = description;
        this.locked = locked;
        contains = new Inventory();

    }
}
