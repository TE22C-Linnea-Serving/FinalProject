import java.util.Scanner;

public class Program {

    public void program() {

        Scanner sc = new Scanner(System.in);

        boolean test1 = true;
        boolean test2 = true;
        int answer1 = 0;
        String answer = "";
        int stage = 0;

        Room room = new Room();
        User player = new User();
        Key key1 = new Key();

        player.getBackpack().items.add(new InteractibleItem("Name tag", "Name: " + player.giveName() + ", \"Researcher at Helix Corporation\"",0));
        Clue note1 = new Clue("Note", "A note with some text written on it", "\"If you are seeing this, please do not attempt to escape. \nYou will endanger everyone if you manage to do so because of...\" \nThe ink is smudged, and it is too dark to try to make out what it says.\n", 0);
        Enemy rat = new Enemy(0, false, 6);

        System.out.println("Backstory...");
        System.out.println("You find yourself trapped in a small, dark lit room.\n\n");


        while(stage == 0) {
            System.out.println("What is your goal?\n1. To escape this room and obtain freedom.\n2. To remain, and live out the rest of your life here.");
            try {
                answer1 = sc.nextInt();

                if (answer1 == 1) {
                    stage = 1;
                    break;
                } else if (answer1 == 2) {
                    new Ending().ending1();
                } else {
                    System.out.println("Please choose one of the options.\n");
                }
            } catch (Exception e) {
                System.out.println("please choose one of the options.\n");
            }
        }
        sc.nextLine();  //Enter


        while(player.isAlive() && stage == 1) {
            while (stage == 1) {
                while (true) {
                    System.out.println("What do you want to do?\n1. Inspect wardrobe\n2. Inspect right door\n3. Inspect cabinet\n4. inspect table\n5. Show Inventory\n");
                    answer = sc.nextLine();
                    System.out.println();       //Space
                    if (answer.equals("1") || answer.equals("2") || answer.equals("3") || answer.equals("4") || answer.equals("5")) {
                        break;
                    } else {
                        System.out.println("Please write one of the option.");
                        sc.nextLine();  //Enter
                    }
                }

                switch (answer) {

                    //Wardrobe
                    case "1":

                        System.out.println("You walk over to the wardrobe and open it.\n");

                        if (room.wardrobe.isLocked()) {

                            System.out.println("Inside, you find a hatch at the bottom of the wardrobe, but it seems stuck.\n");

                            String text = "You take the screwdriver and rotate it 360 degrees multiple times, till the screw comes loose. \nYou do this for each screw, until the door hatch is completely detached.\n";
                            key1.use(player, room.wardrobe, text);
                        } else {
                            System.out.println("Inside, you find what seems to be an endless dark pit.\n");
                            System.out.println("What do you want to do?\n1. Reach your hand down\n2. Don't do anything\n");

                            while (true) {
                                answer = sc.nextLine();
                                if (answer.equalsIgnoreCase("1")) {
                                    player.getBackpack().pickUp(player, room.wardrobe);

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

                        if (room.door.isLocked()) {       //If the door is locked

                            System.out.println("You try opening the door, but it won’t move.");

                            String text1 = "You put the door key into the key hole and turn it slowly.\nThe door that was once closed has now opened, revealing another room, this time a bit brighter.\nHowever, the key used to open the door, is now stuck in the keyhole, \nand refuses to let go, without you locking the door again.\n";
                            key1.use(player, room.door, text1);

                        } else {                  //If the door is unlocked
                            System.out.println("What do you want to do?\n1. Walk through the door\n2. Lock the door again\n");
                            answer = sc.nextLine();

                            while (true) {
                                if (answer.equalsIgnoreCase("1")) {
                                    System.out.println("You walk through the door.\n");
                                    stage = 2;

                                    break;
                                } else if (answer.equalsIgnoreCase("2")) {
                                    new Ending().ending34(player);         //Activates an ending

                                } else {
                                    System.out.println("Pleas write \"1\" or \"2\".\n");
                                }
                            }
                        }
                        break;

                    //Cabinet
                    case "3":
                        player.getBackpack().pickUp(player, room.cabinet);       //Directs to the pickUp method in the Inventory class

                        break;

                    //Table
                    case "4":

                        System.out.println("A normal table with a note on it. Do you want to read the note? (y/n)\n");
                        answer = sc.nextLine();

                        while (true) {
                            if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {
                                note1.use();
                                if(test1) {         //Makes it only happens per time the program is started
                                    player.increaseKnowledge();
                                    test1 = false;
                                }
                                System.out.println(player.getKnowledge());
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
                        player.showInventory();
                        break;
                }
                rat.infectionRateIncrease(player, rat, rat.isInfectionRoute()); //Happens after every choice in main menu
            }

            //SECOND ROOM CODE
            while (stage == 2) {
                while (rat.isRatInteraction()) {        //Happens if the interaction has not been triggered before
                    System.out.println("As you are walking into the second room, a rat appears!\nThe rat immediately starts running towards you, ands starts climbing your leg.\nWhat do you want to do?\n1. Nothing\n2. Punch it");

                    while(true) {
                        try {
                            answer1 = sc.nextInt();
                            break;
                        } catch (Exception e) {
                            System.out.println("Please write a number.\n");
                        }
                    }

                    if (answer1 == 1) {       //If the player does nothing, only text
                        System.out.println("You choose to do nothing while the rat is about to attack.\nJust when you think everything is over, a cat suddenly jumps out and attack the rat.\nThe rat that was once alive and moving, is now in the cat's mouth, hanging lifelessly.\n");
                        rat.changeRatInteraction();     //Makes it so that this interaction does not happen again
                        sc.nextLine();  //Enter
                        break;
                    } else if (answer1 == 2) {      //If the player punched the rat, triggers infectionRoute
                        System.out.println("You punch the rat!\nThe surprised rat does not have time to dodge, \nhowever, it manages to attack back with its teeth before fleeing, \nmaking you start bleeding a little.\n");
                        rat.changeToInfectionRoute();   //Opens up for ending 2
                        rat.changeRatInteraction();     //Makes it so that this interaction does not happen again
                        sc.nextLine();  //Enter
                        break;
                    } else {                        //If the player wrote something that was not an option
                        System.out.println("Please write one of the possible options.\n");
                    }
                }

                //AFTER RAT INTERACTION

                System.out.println("What do you want to do?\n1. Inspect Bookshelf\n2. Inspect Desk\n3. Go to the cat\n4. Show inventory\n5. Inspect Exit door\n6. Go back");
                answer = sc.nextLine();

                switch (answer) {

                    //Bookshelf
                    case "1":
                        System.out.println("You walk over to the bookshelf and look at the books.\n");

                        while (true) {
                            System.out.println("Which book do you want to open?\n1. \"Notebook\"\n2. \"Dancing in the rain\"\n3. \"Echoes of the Void\"\n4. \"The Hollow crown\"\n5. Leave bookshelf\n");
                            answer = sc.nextLine();

                            if (answer.equalsIgnoreCase("1")) { //Book 1 (Notebook for story elements)

                                while (true) {
                                    System.out.println("It seems to be a notebook from some experiment.\nDo you want to read it? (y/n)\n");
                                    answer = sc.nextLine();

                                    if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {
                                        System.out.println("\"Laboratory Notebook Entry:\nDate: September 13, 2027\nResearcher: Dr. " + player.getName() + "\nProject Title: \"Creation of Life\"\nLab: Helix Corporation Research Facility\nEntry #: 21\n\nObservations:\nDay 1:\n- No immediate signs of life\n\nDay 9:\n- Noticeable movements\n\nDay 17:\n- The entity is expressing aggression towards humans\n- Moves well\n\nDay 28:\n- Very aggressive\n- Attacks on sight\n- Obtained ability to experience emotion\n\nDay 34:\n- Able to act similar to a parasite and take control of someones mind\n\nDay 36:\n- The entity has escaped it's enclosure and is on the run\n\nDay37:\n- Due to sudden illness and involuntary movements of " + player.getName() + ", the project is ended immediately.\"\n\nThat was the last page...\nAm I...a parasite?");
                                        if(test2) {         //Makes it only happens per time the program is started
                                            for(int i = 0; i<5; i++) {      //Gains four knowledge from seeing the notebook (Only happens once)
                                                player.increaseKnowledge();
                                            }
                                                test2 = false;
                                        }
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
                                System.out.println("You open the book and find out there is a secret pocket inside it!\n");
                                if (!room.bookshelf.getContains().items.isEmpty()) {           //If there is items in the bookcase
                                    player.getBackpack().pickUp(player, room.bookshelf);

                                } else {
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
                        if (room.desk.isLocked()) {
                            System.out.println("You walk over to the desk, and find a locked drawer.\n");
                            String text2 = "You take the desk key, and open up the drawer";
                            key1.use(player, room.desk, text2);
                        } else {
                            player.getBackpack().pickUp(player, room.desk);

                        }

                        break;

                    //Cat
                    case "3":

                        break;

                    //Inventory show
                    case "4":
                        player.showInventory();
                        break;

                        //Exit door
                    case "5":

                        while(room.exitDoor.isLocked()) {        //While exit door is locked
                            System.out.println("You walk over to the exit door, but it is locked");
                            String text = "";
                            key1.use(player, room.exitDoor, text);
                            if(!room.exitDoor.isLocked()){       //If the player unlocked the exit door
                                new Ending().ending56(player);
                            }else{                      //If the player did not unlock the exit door
                                break;
                            }
                        }
                        break;

                    //Back to Room 1
                    case "6":
                        System.out.println("You go back to the first room\n");
                        stage = 1;

                        break;
                }
                rat.infectionRateIncrease(player, rat, rat.isInfectionRoute()); //Happens after every choice in main menu
            }
        }
    }
}
