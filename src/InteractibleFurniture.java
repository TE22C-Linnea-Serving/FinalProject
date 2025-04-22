public class InteractibleFurniture extends Furniture{

    //Attributes
    Inventory contains;
    private boolean locked;

    public InteractibleFurniture(String name, boolean locket){
        super(name);
        this.name = name;
        this.locked = locked;
        contains = new Inventory();

    }
}
