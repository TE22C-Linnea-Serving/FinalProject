public class Clue extends InteractibleItem{

    //Attributes
    private final String clue;

    public Clue(String name, String description, String clue, int id) {
        super(name, description, id);                                   //Does not care what the parent class has set these values to
        this.clue = clue;
    }

    //Methods

    //Method for when the user wants to use a Clue
    public void use(){      //Override
        System.out.println(clue);               //Prints out the clue the note has
    }
}
