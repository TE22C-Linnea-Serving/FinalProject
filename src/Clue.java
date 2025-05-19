public class Clue extends InteractibleItem{

    //Attributes
    private String clue;

    public Clue(String name, String description, String clue, int id) {
        super(name, description, id);
        this.name = name;
        this.description = description;
        this.clue = clue;
        this.id = id;
    }

    //Methods
    public void use(){      //Override
        System.out.println(clue);
    }
}
