import java.util.Scanner;

public class Program {

    public void program() {

        System.out.println("Backstory...");

        int answer;
        while (true) {
            System.out.println("You find yourself trapped in a small, dark lit room.\n\nWhat do you want to do?\n1. Look in the wardrobe\n2. Inspect right door\n3. Inspect left door\n4. inspect table");

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

            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
        }

    }
}
