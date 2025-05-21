import java.sql.SQLOutput;
import java.util.Collection;
import java.util.Scanner;

public class Program {

    public void program() {

        Scanner sc = new Scanner(System.in);

        String enter;
        int answer1;
        String answer = "";

        int stage = 1;

        Room room1 = new Room();
        Room room2 = new Room();
        User player = new User();
        Key key1 = new Key();

        InteractibleFurniture door1 = new InteractibleFurniture("Door", "The door that lead to another room", true,3);
        InteractibleFurniture cabinet1 = new InteractibleFurniture("Cabinet", "A small cabinet", false,0);
        InteractibleFurniture wardrobe1 = new InteractibleFurniture("Wardrobe", "A big wardrobe with a mystery", true,1);
        InteractibleFurniture bookshelf1 = new InteractibleFurniture("Bookcase", "A small bookcase with four books", false, 0);
        InteractibleFurniture desk1 = new InteractibleFurniture("Desk", "A normal desk", true, 4);

        room1.furnitures.add(door1);
        room1.furnitures.add(cabinet1);
        room1.furnitures.add(wardrobe1);

        room2.furnitures.add(bookshelf1);


        cabinet1.contains.items.add(new Key("Screwdriver", "A normal screwdriver", 1, false));
        cabinet1.contains.items.add(new Key("Mini flag", "A small flag with a sphere at the bottom", 2, false));
        player.backpack.items.add(new InteractibleItem("Nametag", "Name: " + player.giveName() + ", \"Researcher at Helix Corporation\"",0));
        Clue note1 = new Clue("Note", "A note with some text written on it", "\"If you are seeing this, please do not attempt to escape. \nYou will endanger everyone if you manage to do so because of...\" \nThe ink is smudged, and it is too dark to try to make out what it says.\n", 0);
        wardrobe1.contains.items.add(new Clue("A paper", "A contract, seems to be about some kind of biological experiment", "\"...Contract stuff...\"", 0));
        wardrobe1.contains.items.add(new Key("Door key", "It seems to be the key that unlocks the door!", 3, false));
        bookshelf1.contains.items.add(new Key("Desk key", "It seems to be the key that unlocks the desk drawer!", 4, false));
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
                        while (player.isAlive()) {
                            System.out.println("What do you want to do?\n1. Inspect wardrobe\n2. Inspect right door\n3. Inspect cabinet\n4. inspect table\n5. Show Inventory\n");
                            answer = sc.nextLine();
                            System.out.println();       //Space

                            if (answer.equals("1") || answer.equals("2") || answer.equals("3") || answer.equals("4") || answer.equals("5")) {
                                break;
                            }else{
                                System.out.println("Please write one of the option.");
                                enter = sc.nextLine();
                            }
                            rat.infectionRateIncrease(player, rat, rat.isInfectionRoute()); //Happens after every choice in main menu
                        }

                        switch (answer) {

                            //Wardrobe
                            case "1":

                                System.out.println("You walk over to the wardrobe and open it.\n");

                                if(wardrobe1.locked) {

                                    System.out.println("Inside, you find a hatch at the bottom of the wardrobe, but it seems stuck.\n");

                                    String text = "You take the screwdriver and rotate it 360 degrees multiple times, till the screw comes loose. \nYou do this for each screw, until the door hatch is completely detached.\n";
                                    key1.use(player, wardrobe1, text);
                                } else {
                                    System.out.println("Inside, you find what seems to be an endless dark pit.\n");
                                    System.out.println("What do you want to do?\n1. Reach your hand down\n2. Don't do anything\n");

                                    while (true) {
                                        answer = sc.nextLine();
                                        if (answer.equalsIgnoreCase("1")) {
                                            player.backpack.pickUp(player,wardrobe1);

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
                                    System.out.println("What do you want to do?\n1. Walk through the door\n2. Lock the door again\n");
                                    answer = sc.nextLine();
                                    
                                    while(true) {
                                        if (answer.equalsIgnoreCase("1")) {
                                            System.out.println("You walk through the door.\n");
                                            stage = 2;
                                            
                                            break;
                                        } else if (answer.equalsIgnoreCase("2")) {
                                            new Ending().ending3();         //Activates an ending
                                            
                                        } else {
                                            System.out.println("Pleas write one of the options.\n");
                                        }
                                    }
                                }
                                break;

                            //Cabinet
                            case "3":

                                player.backpack.pickUp(player, cabinet1);


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

                        while (player.isAlive()) {
                            while (rat.isRatInteraction()) {        //Happens if the interaction has not been triggered before
                                    System.out.println("As you are walking into the second room, a rat appears!\nThe rat immediatly starts running towards you, ands starts climbing your leg.\nWhat do you want to do?\n1. Nothing\n2. Punch it");

                                    try {
                                        answer1 = sc.nextInt();
                                    } catch (Exception e) {
                                        System.out.println("Please write a number.\n");
                                    }

                                    if (answer1 == 1) {       //If the player does nothing, only text
                                        System.out.println("You choose to do nothing while the rat is about to attack.\nJust when you think everything is over, a cat suddenly jumps out and attack the rat.\nThe rat that was once alive and moving, is now in the cat's mouth, hanging lifelessly.\n");
                                        rat.changeRatInteraction();     //Makes it so that this interaction does not happen again
                                        enter = sc.nextLine();
                                        break;
                                    } else if (answer1 == 2) {      //If the player punched the rat, triggers infectionRoute
                                        System.out.println("You punch the rat!\nThe surprised rat does not have time to dodge, \nhowever, it manages to attack back with its teeth before fleeing, \nmaking you start bleeding a little.\n");
                                        rat.changeToInfectionRoute();   //Opens up for ending 2
                                        rat.changeRatInteraction();     //Makes it so that this interaction does not happen again
                                        enter = sc.nextLine();
                                        break;
                                    } else {                        //If the player wrote something that was not an option
                                        System.out.println("Please write one of the possible options.\n");
                                    }
                                }

                                //AFTER RAT INTERACTION

                            System.out.println("What do you want to do?\n1. Inspect Bookshelf\n2. Inspect Desk\n3. Inspect Picture\n4. Go to the cat\n5. Go back\n");
                            answer = sc.nextLine();
                            switch (answer) {

                                //Bookshelf
                                case "1":
                                    System.out.println("You walk over to the bookshelf and look at the books.\n");

                                    while(true) {
                                        System.out.println("Which book do you want to open?\n1. \"Notebook\"\n2. \"Dancing in the rain\"\n3. \"Echoes of the Void\"\n4. \"The Hollow crown\"\n5. Leave bookshelf\n");
                                         answer = sc.nextLine();

                                        if (answer.equalsIgnoreCase("1")) { //Book 1 (Notebook for story elements)

                                            while(true) {
                                                System.out.println("It seems to be a notebook from some experiment.\nDo you want to read it? (y/n)\n");
                                                answer = sc.nextLine();

                                                if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {
                                                    System.out.println("\"Laboratory Notebook Entry:\nDate: September 13, 2027\nResearcher: Dr. " + player.getName() + "\nProject Title: \"Creation of Life\"\nLab: Helix Corporation Research Facility\nEntry #: 21\n\nObservations:\nDay 1:\n- No immediate signs of life\n\nDay 9:\n- Noticeable movements\n\nDay 17:\n- The entity is expressing aggression towards humans\n- Moves well\n\nDay 28:\n- Very aggressive\n- Attacks on sight\n- Obtained ability to experience emotion\n\nDay 34:\n- Able to act similar to a parasite and take control of someones mind\"\n\nThat was the last page.\n");
                                                    break;
                                                } else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n")) {
                                                    System.out.println("You chose not to read the notebook and put it back in the bookshelf.\n");
                                                    break;
                                                } else {
                                                    System.out.println("Please write one of the options.\n");
                                                }
                                            }

                                        } else if (answer.equalsIgnoreCase("2")) {  //Book 2 (Normal book)
                                            System.out.println("\"Dancing in the Rain\" Looks like a normal romance book.\n");

                                        } else if (answer.equalsIgnoreCase("3")) {  //Book 3 (Key inside for desk)
                                            if(!bookshelf1.contains.items.isEmpty()) {           //If there is items in the bookcase
                                                player.backpack.pickUp(player, bookshelf1);

                                            }else{
                                                System.out.println("You open the book, and finds it empty.\n");
                                            }

                                        } else if (answer.equalsIgnoreCase("4")) {  //Book 4 (Normal book)
                                            System.out.println("\"The Hollow Crown\" Looks like a normal a fantasy book.\n");

                                        } else if (answer.equalsIgnoreCase("5")) {  //Walk away from the bookcase
                                            System.out.println("you walk away from the bookcase.\n");
                                            break;
                                        } else {                                                //If user writes something that is not an option
                                            System.out.println("Please write one of the options.\n");
                                        }
                                    }
                                    break;

                                    
                                //Desk    
                                case "2":
                                    if(desk1.locked) {
                                        System.out.println("You walk over to the desk, and find a locked drawer.\n");
                                        String text2 = "You take the desk key, and open up the drawer";
                                        key1.use(player, desk1, text2);
                                    }else{
                                        System.out.println("You found:\n");
                                        desk1.contains.displayInventory();

                                    }

                                    break;
                                    
                                //Picture    
                                case "3":
                                    System.out.println("OPTION 3");

                                    break;
                                    
                                //Cat    
                                case "4":
                                    
                                    break;
                                    
                                //Back to Room 1    
                                case "5":
                                    System.out.println("You go back to the first room\n");
                                    stage = 1;

                                    break;
                            }
                            rat.infectionRateIncrease(player, rat, rat.isInfectionRoute()); //Happens after every choice in main menu
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
