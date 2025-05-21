public class Clue extends InteractibleItem{

    //Attributes
    private final String clue;

    public Clue(String name, String description, String clue, int id) {
        super(name, description, id);
        this.clue = clue;
    }

    //Methods
    public void use(){      //Override
        System.out.println(clue);
    }
}
