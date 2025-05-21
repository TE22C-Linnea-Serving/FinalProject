public class Ending {

    public void ending1(){                          //First ending (Immediate give up)
        System.out.println("                      ENDING 1:\nYou decided to stay inside this room, that you found yourself trapped in. \nWithout really knowing why, you feel that you have a responsibility to remain inside.\n");
        System.exit(0);                      //Ends the program
    }

    public void ending2(){                          //Second ending (Dies to infected rat)
        System.out.println("                      ENDING 2:\nYou have fallen victim to the rat! The rat that was once a normal rat, \nis now something much more. It is an entity, created to evolve over time.\nAnd now that it has a way smaller body, it will be much easier to escape the building, \nand take over all lifeforms!");
        System.exit(0);                      //Ends the program
    }

    public void ending34(User player, FriendlyCharacter cat){

        if(player.getKnowledge() < 5){              //Third ending (If the player figures out part of the story worth, less than five knowledge, and chooses to stay locked inside)
            System.out.println("                      ENDING 3:\nTrusting your instincts, you chose to remain trapped inside. \nBelieving that it is the best choice for everyone.");
            if(cat.isCatCompanion()) {
                System.out.println("At least you still have your best friend by your side");
            }
        }else{                                      //Fourth ending (Figures out most of the story, more than four knowledge, and chooses to stay locked inside)
            System.out.println("                      ENDING 4:\nNot wanting to put every other life form in immediate danger, \nyou choose to lock yourself in for the rest of eternity.\nIt's not like you will need any food from now on anyway.");
        if(cat.isCatCompanion()){
            System.out.println("But at least you have your cat friend to keep you company!");
        }
        }
        System.exit(0);                      //Ends the program
    }

    public void ending56(User player, FriendlyCharacter cat){
        if(player.getKnowledge() < 5) {             //Fifth ending (Escape without knowing parts of the truth, less than 5 knowledge)
            System.out.println("                      ENDING 5:\nWhile escaping the building, all you can feel is happiness.\nFinally, you are free again! You can finally live four own life!\nHowever, something does not seem right. While walking towards the city, \nyou don't realize when something falls of of you, duplicating and spreading out all around you.");
        if(cat.isCatCompanion()){
            System.out.println("At least you have you cat friend to help you on your journey!!");
        }
        }else{                                      //Sixth ending (Escape with most knowledge of story, more than 4 knowledge)
            System.out.println("                      ENDING 6:\nThe decision of choosing your own happiness, over every other life on the planet might not be the brightest decision.\nHowever, these last few moments will be the best of your life, as everything around you turns into destruction.\n");
        if(cat.isCatCompanion()){
            System.out.println("However, with your cat companion by your side, there is no reason to be afraid!");
        }
        }
        System.exit(0);                      //Ends the program
    }
}