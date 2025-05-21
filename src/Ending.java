public class Ending {

    public void ending1(){                          //First ending (Immediate give up)
        System.out.println("                      ENDING 1:\nYou decided to stay inside this room, that you found yourself trapped in. \nWithout really knowing why, you feel that you have a responsibility to remain inside.\n");
        System.exit(0);                      //Ends the program
    }

    public void ending2(){                          //Second ending (Dies to infected rat)
        System.out.println("                      ENDING 2:\n           YOU DIED BY THE RAT!");
        System.exit(0);                      //Ends the program
    }

    public void ending34(User player){
        if(player.getKnowledge() < 5){              //Third ending (If the player figures out part of the story worth, less than five knowledge, and chooses to stay locked inside)
            System.out.println("                      ENDING 3:\nTrusting the note on the table and your instincts, you chose to remain trapped inside. \nBelieving it is the best option for everyone.\n");
        }else{                                      //Fourth ending (Figures out most of the story, more than four knowledge, and chooses to stay locked inside)
            System.out.println("                      ENDING 4:\n");
        }
        System.exit(0);                      //Ends the program
    }

    public void ending56(User player){
        if(player.getKnowledge() < 5) {             //Fifth ending (Escape without knowing parts of the truth, less than 5 knowledge)
            System.out.println("                      ENDING 5:\n");
        }else{                                      //Sixth ending (Escape with most knowledge of story, more than 4 knowledge)
            System.out.println("                      ENDING 6:\n");
        }
        System.exit(0);                      //Ends the program
    }
}