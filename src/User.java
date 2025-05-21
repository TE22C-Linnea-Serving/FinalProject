import java.util.Scanner;

public class User {

    //Attributes
    private String name;
    Inventory backpack;
    private int knowledge = 0;
    private boolean chanceForKnowledge1 = true;

    public User(){
        name = getName();
        backpack = new Inventory();
        knowledge = getKnowledge();
    }


    //Methods
    public void showInventory(){
        Scanner sc = new Scanner(System.in);
        int answer1;

        while (true) {
            System.out.println("Your inventory currently contains: \n(write the number of the item you want to inspect)");
            System.out.println("0. esc");
            backpack.displayInventory();

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

            } else if (answer1 <= backpack.items.size()) {
                answer1--;
                System.out.println("Description: " + backpack.items.get(answer1).description + "\n");

            } else {
                System.out.println("Please write one of the options\n");
            }
        }
    }

    public void increaseKnowledge(){
            knowledge++;
    }

    public int getKnowledge(){
        return knowledge;
    }

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

    public boolean isAlive() {
        return true;
    }
}
