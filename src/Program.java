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
        InteractibleFurniture door1 = new InteractibleFurniture("Door", "The door that lead to another room", true);
        InteractibleFurniture cabinet1 = new InteractibleFurniture("Cabinet", "A small cabinet", false);
        cabinet1.contains.items.add(new Key("Screwdriver", "A normal screwdriver", 1, false));
        cabinet1.contains.items.add(new Key("Mini flag", "A small flag with a sphere at the bottom", 2, false));
        player.backpack.items.add(new InteractibleItem("Nametag", "Name: " + player.giveName() + ", \"Researcher at Helix Corporation\"",3));
        Clue note1 = new Clue("Note", "A note with some text written on it", "\"\" \nThe ink is smudged, and it is too dark to try to make out what it says.\n", 4);
        room1.wardrobe1.contains.items.add(new Clue("A paper", "A contract, seems to be about some kind of biological experiment", "\"...Contract stuff...\"", 5));
        room1.wardrobe1.contains.items.add(new Key("Door key", "It seems to be the key that unlocks the door!", 6, false));
        System.out.println("Backstory...");
        System.out.println("You find yourself trapped in a small, dark lit room.\n\n");

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
                   /* System.out.println("You walk over to the wardrobe and open it.\n");

                    if(wardrobe1.locked) {

                        System.out.println("Inside, you find a hatch at the bottom of the wardrobe, but it seems stuck.\n");

                        for (int i = 0; i <= player.backpack.items.size() - 1; i++) { //Looks for the screwdriver in player inventory
                            if (player.backpack.items.get(i).id == 1) {     //The Screwdriver is in the players inventory

                                System.out.println("Do you want to use the screwdriver to unscrew the hatch door?\n");
                                answer = sc.nextLine();

                                while (true) {
                                    if (answer.equalsIgnoreCase("yes")) {

                                        System.out.println("You start unscrewing the hatch door...\nYou successfully removed the door hatch!\nHowever, the screwdriver broke!\n");
                                        wardrobe1.locked = false;           //Wardrobe now unlocked
                                        player.backpack.items.remove(i);    //Removes screwdriver from players inventory
                                        break;
                                    } else if (answer.equalsIgnoreCase("no")) {
                                        System.out.println("You chose to not do anything, and walk away from the wardrobe.\n");
                                        break;
                                    } else {
                                        System.out.println("Please write yes or no.\n");
                                    }
                                }
                            }
                        }
                    } else {
                        System.out.println("Inside, you find what seems to be an endless dark pit.\n");
                        System.out.println("What do you want to do?\n1. Reach your hand down\n2. Don't do anything\n");
                        answer = sc.nextLine();

                        while (true) {
                            if (answer.equalsIgnoreCase("1")) {
                                System.out.println("Yay");
                                break;
                            } else if (answer.equalsIgnoreCase("2")) {
                                System.out.println("You chose to not do anything, and leave.");
                                break;
                            } else {
                                System.out.println("Please select one of the options.");
                                enter = sc.nextLine();
                            }
                        }
                    }
                    */
                    break;

                //Right door
                case "2":

                    if(door1.locked){       //If the door is locked

                        System.out.println("You try opening the door, but it won’t move.");

                        for (int i=0; i<=player.backpack.items.size()-1; i++){  //Goes through the players inventory
                            if(player.backpack.items.get(i).id == 6){           //If the player has the door key in their inventory
                                System.out.println("Do you want to use the door key? (y/n)\n");
                                answer = sc.nextLine();

                                while(true) {
                                    if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {

                                        break;
                                    } else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n")) {
                                        System.out.println("You leave without using the key.\n");
                                        break;
                                    }else{
                                        System.out.println("Please write one of the options.\n");
                                    }
                                }
                            }else{                                              //If the player does not have the door key in their inventory
                                System.out.print("Maybe you could look around to see if you can find some sort of key?\n");
                            }


                        }

                    }else{                  //If the door is unlocked

                    }
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

                    System.out.println("A normal table with a note on it. Do you want to read the note? (y/n)\n");
                    answer = sc.nextLine();

                    while(true) {
                        if (answer.equalsIgnoreCase("yes")) {
                            note1.use();
                            break;
                        } else if (answer.equalsIgnoreCase("no")) {
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
    }
}
