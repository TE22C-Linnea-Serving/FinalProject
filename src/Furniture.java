import static java.awt.SystemColor.text;

public class Furniture {

    //Attributes
    public String name;
    public String description;

    //Constructor
    Furniture(String name, String description){
        this.name = name;
        this.description = description;
    }

    //Methods
    public String showDescription(String description){

        System.out.println("Description: " + description);

        return description;
    }
}
