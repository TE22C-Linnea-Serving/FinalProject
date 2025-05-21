import java.util.Scanner;

public class User {

    //Attributes
    private String name;
    private final Inventory backpack;
    private int knowledge = 0;

    public User(){
        name = getName();
        backpack = new Inventory();
        knowledge = getKnowledge();
    }


    //Methods
    public Inventory getBackpack() {
        return backpack;
    }

    public void showInventory(){
        Scanner sc = new Scanner(System.in);
        int answer1;

        while (true) {
            System.out.println("Your inventory currently contains: \n(write the number of the item you want to inspect)");
            System.out.println("0. esc");
            backpack.displayInventory();    //Shows what items are inside the backpack

            while (true) {
                try {
                    answer1 = sc.nextInt();
                    break;
                } catch (Exception e) {
                    System.out.println("Please write a number.\n");
                    sc.nextLine();  //Enter
                }
            }
            sc.nextLine();  //Enter

            if (answer1 == 0) {
                break;

            } else if (answer1 <= backpack.items.size()) {      //If the users answer is lower or equal to the amount if items in their backpack
                answer1--;                                      //lowers the number by one
                System.out.println("Description: " + backpack.items.get(answer1).getDescription() + "\n");  //Shows the description of the items that the user wanted to inspect

            } else {
                System.out.println("Please write one of the options\n");
            }
        }
    }

    //Increases amount of knowledge by one
    public void increaseKnowledge(){
            knowledge++;
    }

    public int getKnowledge(){
        return knowledge;
    }

    //Method where the user registers their name
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

    public String getName() {
        return name;
    }

    //Player is alive
    public boolean isAlive() {
        return true;
    }
}
