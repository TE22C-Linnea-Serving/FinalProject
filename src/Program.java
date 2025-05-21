import java.sql.SQLOutput;
import java.util.Collection;
import java.util.Scanner;

public class Program {

    public void program() {

        Scanner sc = new Scanner(System.in);

        String enter;
        int answer1;
        String answer;

        int stage = 1;

        Room room1 = new Room();
        User player = new User();
        Key key1 = new Key();

        InteractibleFurniture door1 = new InteractibleFurniture("Door", "The door that lead to another room", true,6);
        InteractibleFurniture cabinet1 = new InteractibleFurniture("Cabinet", "A small cabinet", false,0);
        InteractibleFurniture wardrobe1 = new InteractibleFurniture("Wardrobe", "A big wardrobe with a mystery", true,1);


        room1.furnitures.add(door1);
        room1.furnitures.add(cabinet1);
        room1.furnitures.add(wardrobe1);

        cabinet1.contains.items.add(new Key("Screwdriver", "A normal screwdriver", 1, false));
        cabinet1.contains.items.add(new Key("Mini flag", "A small flag with a sphere at the bottom", 2, false));
        player.backpack.items.add(new InteractibleItem("Nametag", "Name: " + player.giveName() + ", \"Researcher at Helix Corporation\"",3));
        Clue note1 = new Clue("Note", "A note with some text written on it", "\"\" \nThe ink is smudged, and it is too dark to try to make out what it says.\n", 4);
        wardrobe1.contains.items.add(new Clue("A paper", "A contract, seems to be about some kind of biological experiment", "\"...Contract stuff...\"", 5));
        wardrobe1.contains.items.add(new Key("Door key", "It seems to be the key that unlocks the door!", 6, false));
        Enemy rat = new Enemy(0, false, 10);

        System.out.println("Backstory...");
        System.out.println("You find yourself trapped in a small, dark lit room.\n\n");

        while(player.isAlive()) {
            System.out.println("What is your goal?\n1. To escape this room and obtain freedom.\n2. To remain, and live out the rest of your life here.");
            try {
                answer1 = sc.nextInt();

                if(answer1 == 1){
                    enter = sc.nextLine();
                    while(stage == 1) {
                        while (true) {
                            System.out.println("What do you want to do?\n1. Inspect wardrobe\n2. Inspect right door\n3. Inspect cabinet\n4. inspect table\n5. Show Inventory\n");
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

                                System.out.println("You walk over to the wardrobe and open it.\n");

                                if(wardrobe1.locked) {

                                    System.out.println("Inside, you find a hatch at the bottom of the wardrobe, but it seems stuck.\n");

                                    String text = "You take the screwdriver and rotate it 360 degrees multiple times, till the screw comes loose. \nYou do this for each screw, until the door hatch is completely detachable.\n";
                                    key1.use(player, wardrobe1, text);
                                } else {
                                    System.out.println("Inside, you find what seems to be an endless dark pit.\n");
                                    System.out.println("What do you want to do?\n1. Reach your hand down\n2. Don't do anything\n");

                                    while (true) {
                                        answer = sc.nextLine();
                                        if (answer.equalsIgnoreCase("1")) {
                                            if(!wardrobe1.contains.items.isEmpty()) {
                                                System.out.println("Inside, you find:");
                                                wardrobe1.contains.displayInventory();

                                                System.out.println("Do you want to pick it up? (y/n)");
                                                while(true) {
                                                    answer = sc.nextLine();
                                                    if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {
                                                        player.backpack.items.addAll(wardrobe1.contains.items);
                                                        wardrobe1.contains.items.clear();
                                                        System.out.println("You have now picket it up.");
                                                        break;
                                                    } else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n")) {
                                                        System.out.println("You chose not to pick up the items and leave.\n");
                                                        break;
                                                    } else {
                                                        System.out.println("Please write one of the options.\n");
                                                    }
                                                }
                                            }else{
                                                System.out.println("There is nothing here.\n");
                                            }
                                            break;
                                        } else if (answer.equalsIgnoreCase("2")) {
                                            System.out.println("You chose to not do anything, and leave.");
                                            break;
                                        } else {
                                            System.out.println("Please select one of the options.");

                                        }
                                    }
                                }
                                break;

                            //Right door
                            case "2":

                                if(door1.locked){       //If the door is locked

                                    System.out.println("You try opening the door, but it won’t move.");

                                    String text1 = "You put the door key into the key hole and turn it slowly.\nThe door that was once closed has now opened, revealing another room, this time a bit brighter.\nHowever, the key used to open the door, is now stuck in the keyhole, \nand refuses to let go, without you locking the door again.\n";
                                    key1.use(player, door1, text1);

                                }else{                  //If the door is unlocked
                                    System.out.println("You walk through the door.\n");
                                    stage = 2;
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

                    //SECOND ROOM CODE
                    while(stage == 2) {

                        while(rat.isRatInteraction())
                        System.out.println("As you are walking into the second room, a rat appears!\nThe rat immediatly starts running towards you, ands starts climbing your leg.\nWhat do you want to do?\n1. Nothing\n2. Punch it");
                        while(true){
                            try {
                                answer1 = sc.nextInt();
                            } catch (Exception e) {
                                System.out.println("Please write a number.\n");
                            }

                            if (answer1 == 1) {       //If the player does nothing, only text
                                System.out.println("You choose to do nothing while the rat is about to attack.\nJust when, a cat suddenly jumps out and attack the rat.\nThe rat that was once alive and moving, is now in the cat's mouth, hanging lifelessly.\n");
                                rat.changeRatInteraction();     //Makes it so that this interaction does not happen again
                                break;
                            } else if (answer1 == 2) {      //If the player punched the rat, triggers infectionRoute
                                System.out.println("You punch the rat!\nThe surprised rat does not have time to dodge, \nhowever, it manages to attack back with its teeth before fleeing, \nmaking you start bleeding a little.\n");
                                rat.changeToInfectionRoute();
                                rat.changeRatInteraction();     //Makes it so that this interaction does not happen again
                                break;
                            } else {                        //If the player wrote something that was not an option
                                System.out.println("Please write one of the possible options.\n");
                            }
                        }
                        enter = sc.nextLine();

                        //AFTER RAT INTERACTION
                        System.out.println("What do you want to do?\n1. OPTION 1\n2. OPTION 2\n3. OPTION 3\n4. Infection Rate TEST");
                        answer = sc.nextLine();
                        switch (answer){

                            case "1":

                                break;
                            case "2":

                                break;
                            case "3":

                                break;
                            case "4":

                                rat.infectionRateIncrease(player, rat, rat.isInfectionRoute());

                                break;
                        }
                    }
                    //END OF SECOND ROOM CODE



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
