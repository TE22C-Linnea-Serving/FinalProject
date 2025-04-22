import java.util.Scanner;

public class Program {

    public void program() {

        User player = new User("Jess");
        InteractibleFurniture n1 = new InteractibleFurniture("Cabinet", true);

        System.out.println("Backstory...");

        int answer;
        while (true) {
            System.out.println("You find yourself trapped in a small, dark lit room.\n\nWhat do you want to do?\n1. Inspect wardrobe\n2. Inspect right door\n3. Inspect cabinet\n4. inspect table");

            Scanner sc = new Scanner(System.in);
            try {
                answer = sc.nextInt();

                if(answer<5 && answer>0) {
                    break;
                }

            } catch (Exception e) {
                System.out.println("Try again");

            }
        }

        switch (answer){

            //Wardrobe
            case 1:

                break;

             //Right door
            case 2:
                System.out.println("You try opening the door, but it won’t move. Maybe you could look around to see if you can find a key?");
                break;

            //Cabinet
            case 3:
                System.out.println("You have found 2 items!!\n You pick up a screwdriver and a small flag with a sphere attached to the bottom");
                player.backpack.items.add(Key());
                break;

            //Table
            case 4:

                break;
        }

    }
}
