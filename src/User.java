import java.util.Scanner;

public class User {

    //Attributes
    private String name;
    Inventory backpack;

    public User(String name){
        name = giveName();
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
}
