import java.util.Scanner;

public class User {

    //Attributes
    private String name;
    Inventory backpack;
    private boolean alive = true;

    public User(){
        this.name = name;
        backpack = new Inventory();
    }

    //Methods
    public String giveName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("What is your name?");

        try{
             name = sc.nextLine();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return name;
    }

    public void chooseName(){

    }

    public boolean death(){
        alive = false;
        return alive;
    }

    public boolean isAlive() {
        return alive;
    }
}
