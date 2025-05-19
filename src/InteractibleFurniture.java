public class InteractibleFurniture extends Furniture{

    //Attributes
    Inventory contains;
    private boolean locked;

    public InteractibleFurniture(String name, String description, boolean locked){
        super(name, description);
        this.name = name;
        this.description = description;
        this.locked = locked;
        contains = new Inventory();
    }

    public void displayContains(){
        for(Item item: contains.items) {
            System.out.print(item.name);
            System.out.print(", ");
        }
        System.out.println();
    }


}
