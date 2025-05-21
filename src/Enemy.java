public class Enemy extends Character{

    //Attributes
    private int infectionRate;
    private boolean infectionRoute ;
    private final int id;
    private boolean ratInteraction = true;
    private int infectionIncreaseHappens = 0;

    //Constructor
    public Enemy(int infectionRate, boolean infectionRoute, int id) {
        this.infectionRate = infectionRate;
        this.infectionRoute = infectionRoute;
        this.id = id;
    }


    //Methods

    public void infectionRateIncrease(User player, Enemy enemy, boolean infectionRoute) {

            if (infectionRoute) {                //This only happens if the player triggered the starting event, if not, nothing happens
                infectionIncreaseHappens++;

                if (infectionIncreaseHappens % 2 == 0) {    //If infectionIncreaseHappens is an even number

                    if (infectionRate == 1) {
                    System.out.println("\nOnce again, you can see the rat in the corner of the room. \nYou make sure to stay away from it, just to be safe.\n");
                    infectionRate++;
                } else if (infectionRate == 2) {  //If the rat is on the second stage of the
                    System.out.println("\nSuddenly, the rat appears again!\nThis time, you get the feeling that the rat is staring you down, \ncontemplating about something.\n");
                    infectionRate++;
                } else if (infectionRate == 3) {
                    System.out.println("\nJust when, the rat can be seen again in the corner of your eyes.\nHowever, this time, there is something that is not quite right about it.\nIt...moves differently. Almost intelligently...as if it is someone else behind it's movements.\n");
                    infectionRate++;
                } else if (infectionRate == 4) {
                    System.out.println("\nThe rat suddenly leaps out from nowhere, attacking you!\n");

                    for (int i = 0; i <= player.getBackpack().items.size() - 1; i++) {         //Check if player has the right item in their backpack
                        if (player.getBackpack().items.get(i).id == enemy.id) {
                            System.out.println("You hastily pull out the " + player.getBackpack().items.get(i).name + " from your backpack, \nand manage to defend yourself with it by killing the rat!\n");

                        } else if (i == player.getBackpack().items.size() - 1) {              //If the for-loop did not find a weapon in player backpack
                            new Ending().ending2();

                        }
                    }

                }

            }
        }
    }

        public void changeToInfectionRoute(){
        infectionRate = 1;
        infectionRoute = true;

        }

    public boolean isInfectionRoute() {
        return infectionRoute;
    }

    public void changeRatInteraction(){
        ratInteraction = false;
    }

    public boolean isRatInteraction() {
        return ratInteraction;
    }
}
