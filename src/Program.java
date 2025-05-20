import java.sql.SQLOutput;
import java.util.Collection;
import java.util.Scanner;

public class Program {

    public void program() {

        Scanner sc = new Scanner(System.in);

        String enter;
        int answer1;
        String answer;

        Room room1 = new Room();
        User player = new User();
        Key key1 = new Key();

        InteractibleFurniture door1 = new InteractibleFurniture("Door", "The door that lead to another room", true,6);
        InteractibleFurniture cabinet1 = new InteractibleFurniture("Cabinet", "A small cabinet", false,0);

        room1.furnitures.add(door1);
        room1.furnitures.add(cabinet1);
        room1.furnitures.add(room1.wardrobe1);

        cabinet1.contains.items.add(new Key("Screwdriver", "A normal screwdriver", 1, false));
        cabinet1.contains.items.add(new Key("Mini flag", "A small flag with a sphere at the bottom", 2, false));
        player.backpack.items.add(new InteractibleItem("Nametag", "Name: " + player.giveName() + ", \"Researcher at Helix Corporation\"",3));
        Clue note1 = new Clue("Note", "A note with some text written on it", "\"\" \nThe ink is smudged, and it is too dark to try to make out what it says.\n", 4);
        room1.wardrobe1.contains.items.add(new Clue("A paper", "A contract, seems to be about some kind of biological experiment", "\"...Contract stuff...\"", 5));
        room1.wardrobe1.contains.items.add(new Key("Door key", "It seems to be the key that unlocks the door!", 6, false));
        System.out.println("Backstory...");
        System.out.println("You find yourself trapped in a small, dark lit room.\n\n");

        while(true) {
            System.out.println("What is your goal?\n1. To escape this room and obtain freedom.\n2. To remain, and live out the rest of your life here.");
            try {
                answer1 = sc.nextInt();

                if(answer1 == 1){
                    enter = sc.nextLine();
                    while(true) {
                        while (true) {
                            System.out.println("What do you want to do?\n1. Inspect wardrobe\n2. Inspect right door\n3. Inspect cabinet\n4. inspect table\n5. Show Inventory");
                            answer = sc.nextLine();
                            System.out.println();       //Space

                            if (answer.equals("1") || answer.equals("2") || answer.equals("3") || answer.equals("4") || answer.equals("5")) {
                                break;
                            }else{
                                System.out.println("Please write one of the option.");
                                enter = sc.nextLine();
                            }
                        }

                        switch (answer) {

                            //Wardrobe
                            case "1":

                                room1.showWardrobe(player, answer,"");
                                break;

                            //Right door
                            case "2":

                                if(door1.locked){       //If the door is locked

                                    System.out.println("You try opening the door, but it won’t move.");

                                    for (int i=0; i<=player.backpack.items.size()-1; i++){  //Goes through the players inventory
                                        if(player.backpack.items.get(i).id == door1.id){           //If the player has the door key in their inventory
                                            System.out.println("Do you want to use the door key? (y/n)\n");

                                            while(true) {
                                                answer = sc.nextLine();
                                                if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {
                                                    System.out.println("You put the door key into the key hole and turn it slowly.\nThe door that once closed has now opened, revealing another room, this time a bit lighter.\n");
                                                    System.out.println("However, the key used to open the door, is now stuck in the keyhole, \nand refuses to let go without you locking the door again.\n");

                                                    key1.use(player, i);

                                                    //player.backpack.items.remove(i);
                                                    //door1.locked = false;

                                                    break;
                                                } else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n")) {
                                                    System.out.println("You leave without using the key.\n");
                                                    break;
                                                }else{
                                                    System.out.println("Please write one of the options.\n");
                                                }
                                            }
                                        }else if(i == player.backpack.items.size()-1){                                              //If the player does not have the door key in their inventory
                                            System.out.print("Maybe you could look around to see if you can find some sort of key?\n");
                                        }


                                    }

                                }else{                  //If the door is unlocked
                                    System.out.println("You walk through the door.\n");
                                }
                                break;

                            //Cabinet
                            case "3":

                                while(true) {
                                    if (!cabinet1.contains.items.isEmpty()) {
                                        System.out.print("You have found:\n");
                                        cabinet1.contains.displayInventory();

                                        System.out.println("Do you want to pick it up? (y/n)\n");
                                        answer = sc.nextLine();
                                        if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {

                                            player.backpack.items.addAll(cabinet1.contains.items);
                                            cabinet1.contains.items.clear();
                                            System.out.println("You have picked it up.\n");
                                            break;
                                        } else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n")) {
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

                                System.out.println("A normal table with a note on it. Do you want to read the note? (y/n)\n");
                                answer = sc.nextLine();

                                while(true) {
                                    if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {
                                        note1.use();
                                        break;
                                    } else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n")) {
                                        System.out.println("You leave without reading the note.\n");
                                        break;
                                    } else {
                                        System.out.println("Please write yes or no.");
                                    }
                                }
                                break;


                            //Inventory show
                            case "5":
                                while(true) {
                                    System.out.println("Your inventory currently contains: \n(write the number of the item you want to inspect)");
                                    System.out.println("0. esc");
                                    player.backpack.displayInventory();

                                    while(true) {
                                        try {
                                            answer1 = sc.nextInt();
                                            break;
                                        } catch (Exception e) {
                                            System.out.println("Please write a number.\n");
                                            enter = sc.nextLine();
                                        }
                                    }

                                    enter = sc.nextLine();

                                    if (answer1 == 0) {
                                        break;

                                    } else if(answer1 <= player.backpack.items.size()) {
                                        answer1--;
                                        System.out.println("Description: " + player.backpack.items.get(answer1).description + "\n");

                                    } else {
                                        System.out.println("Please write one of the options\n");
                                    }
                                }
                                break;
                        }
                    }
                } else if (answer1 == 2) {
                    new Ending().ending1();
                    break;
                } else {
                    System.out.println("Please choose one of the options.\n");
                }
            } catch (Exception e) {
                System.out.println("please choose one of the options.\n");
            }
        }
    }
}
