public class Clue extends InteractibleItem{

    //Attributes
    private String clue;

    public Clue(String name, String description, String clue) {
        super(name, description);
        this.name = name;
        this.description = description;
        this.clue = clue;
    }

    //Methods
    public void use(){      //Override

    }
}
