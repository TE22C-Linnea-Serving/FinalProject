import java.util.Collection;
import java.util.Scanner;

public class Program {

    public void program() {

        Scanner sc = new Scanner(System.in);

        boolean read1 =false;
        InteractibleFurniture cabinet1 = new InteractibleFurniture("Cabinet", "A small cabinet", false);
        cabinet1.contains.items.add(new Key("Screwdriver", "A normal screwdriver", 1, false));
        cabinet1.contains.items.add(new Key("Mini flag", "A small flag with a sphere at the bottom", 2, false));

        User player = new User();
        player.backpack.items.add(new InteractibleItem("Nametag", "Name: " + player.giveName() + ", \"Researcher at Helix Corporation\""));

        System.out.println(player.backpack.items.get(0).description);

        System.out.println("Backstory...");

        System.out.println("You find yourself trapped in a small, dark lit room.\n\n");

        while(true) {
            String answer = "";
            while (true) {
                System.out.println("What do you want to do?\n1. Inspect wardrobe\n2. Inspect right door\n3. Inspect cabinet\n4. inspect table\n5. Show Inventory");

                answer = sc.nextLine();
                System.out.println();

                if (answer.equals("1") || answer.equals("2") || answer.equals("3") || answer.equals("4") || answer.equals("5")) {
                    break;
                }
            }

            switch (answer) {

                //Wardrobe
                case "1":
                    //OM note inte är upptäckt
                    if(read1==false) {
                        System.out.println("There seems to be something at the bottom of the wardrobe, but you can't make out what it is.");

                    } else if(read1==true) {
                        //OM note är upptäckt

                    }

                    break;

                //Right door
                case "2":
                    System.out.println("You try opening the door, but it won’t move. Maybe you could look around to see if you can find some sort of key?\n");
                    break;

                //Cabinet
                case "3":

                    while(true) {
                        if (!cabinet1.contains.items.isEmpty()) {
                            System.out.print("You have found:\n");
                            cabinet1.contains.displayInventory();

                            System.out.println("Do you want to pick it up? (y/n)\n");
                            String answer2 = sc.nextLine();

                            if (answer2.equalsIgnoreCase("yes")) {

                                player.backpack.items.addAll(cabinet1.contains.items);
                                cabinet1.contains.items.clear();
                                System.out.println("You have picked it up.\n");
                                break;
                            } else if (answer2.equalsIgnoreCase("no")) {
                                System.out.println("You leave without picking anything up.\n");
                                break;
                            } else {
                                System.out.println("Please try again:\n");
                            }
                        } else {
                            System.out.println("There is nothing here.\n");
                            break;
                        }
                    }


                    break;

                //Table
                case "4":
                    Clue note1 = new Clue("Note", "A note with some text written on it", "\"\" \nThe ink is smudged, and it is too dark to try to make out what it says.\n");

                    System.out.println("A normal table with a note on it. Do you want to read the note?\n");

                    answer = sc.nextLine();

                    if(answer.equalsIgnoreCase("yes")){
                        note1.use();
                        read1 = true;

                    }else if (answer.equalsIgnoreCase("no")){

                        System.out.println("You leave without reading the note.\n");

                    }else{

                    }


                    break;

                //Inventory show
                case "5":
                    while(true) {
                        System.out.println("Your inventory currently contains: \n(write the number of the item you want to inspect)");
                        player.backpack.displayInventory();
                        System.out.println("0 to esc");

                        int answer1 = sc.nextInt();
                        if (answer1 <= player.backpack.items.size()+1) {
                            String enter = sc.nextLine();

                            System.out.println(player.backpack.items.get(answer1+1).description);

                            break;
                        } else if (answer1 == 0) {
                            break;
                        } else {
                            System.out.println("Please write one of the options");
                        }
                    }
                    break;
            }
        }

    }
}
