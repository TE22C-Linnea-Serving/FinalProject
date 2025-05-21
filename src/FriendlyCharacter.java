import java.util.Scanner;

public class FriendlyCharacter extends Character {


    //Attributes
    private int friendliness=0;   //Level of friendliness (Changes interaction)
    private boolean catCompanion = false;       //Extra element to ending if true
    private boolean named = false;              //Have I named the cat
    private String name = "The cat";

    public FriendlyCharacter() {
    }

    //Methods



    public boolean isCatCompanion() {
        return catCompanion;
    }

    public void interact() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Do you want to pet " + name + "? (y/n)\n");
            String answer = sc.nextLine();

            if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {   //If the player wants to pet the cat
                while (true) {
                    if (friendliness == 0) {    //Friendliness is 0
                        System.out.println("The cat gets angry and shoo you away! T-T");
                        friendliness++;
                        break;
                    } else if (friendliness <= 2) { //Friendliness is 1 or 2
                        System.out.println("You pet the cat!");
                        friendliness++;
                        break;
                    } else if (friendliness <= 5) { //Friendliness is 3, 4 or 5
                        System.out.println(name + " is happy to see you and happily accepts pets!");
                        friendliness++;
                        if(!named){ //If user has not named cat
                            System.out.println("\nCongratulations!!\nYou have received the big honor of personally naming the cat.\nPlease accepts it gratefully and humbly, while you come up with the name.\n\nWhat do you want to name the cat?");
                            name = sc.nextLine();   //user will names cat
                            named = true;
                        }
                        break;
                    } else if (friendliness <= 9) { //Friendliness is 6, 7, 8 or 9
                        System.out.println(name + " meow a hello, as it welcomes you back to it's presence.");
                        friendliness++;
                        break;
                    } else {                        //Friendliness is above 9
                        System.out.println(name +" shall forever be your family, you are now a pact, inseparable from each other.\n" + name + " will forever be you companion, and will never leave your side!\n" + name + " happily accepts you attention!");
                        catCompanion = true;        //Enables some extra text on endings
                        break;
                    }
                }
                break;
            } else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n")) { //If the user does not want to pet the cat
                System.out.println("You leave without petting the cat :(\n");

                break;
            } else {
                System.out.println("Please write yes or no.\n");
                sc.nextLine();
            }
        }
    }
}
