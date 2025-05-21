import static java.awt.SystemColor.text;

public class Furniture {

    //Attributes
     String name;
     String description;

    //Constructor
    Furniture(String name, String description){
        this.name = name;
        this.description = description;
    }

    //Methods
    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String showDescription(String description){

        System.out.println("Description: " + description);

        return description;
    }
}
