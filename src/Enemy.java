public class Enemy extends Character{

    //Attributes
    private int HP;
    private int attackPower;
    private int infectionRate = 0;
    private boolean infectionRoute ;
    private int id;
    private boolean ratInteraction;

    //Constructor
    public Enemy(int infectionRate, boolean infectionRoute, int id) {
        this.infectionRate = infectionRate;
        this.infectionRoute = infectionRoute;
        this.id = id;
    }


    //Methods
    public int fight(int attack, int HP){
        int number = -1;

        return number;
    }

    public void infectionRateIncrease(User player, Enemy enemy, boolean infectionRoute){

        if(infectionRoute) {                //This only happens if the player triggered the starting event, if not, nothing happens
            if (infectionRate == 1) {
                System.out.println("");
                infectionRate++;
            } else if (infectionRate == 2) {  //If the rat is on the second stage of the
                System.out.println("Just when, the rat can be seen again in the corner of your eyes.\nHowever, this time, there is something that is not quite right about it.\nIt...moves differently. Almost intelligently, as if it is someone else behind it's movements.\n");
                infectionRate++;
            } else if (infectionRate == 3) {
                System.out.println("");
                infectionRate++;
            } else if (infectionRate == 4) {
                System.out.println("The rat suddenly leaps out from nowhere, attacking you!");

                for(int i = 0; i<=player.backpack.items.size()-1; i++) {         //Check if player has weapon in backpack
                    if(player.backpack.items.get(i).id == enemy.id) {
                        System.out.println("You hastily pull out the " + player.backpack.items.get(i).name + " from your backpack, \nand manage to defend yourself with it by killing the rat!\n");

                    }else if(i == player.backpack.items.size()-1){              //If the for-loop did not find a weapon in player backpack
                        player.death();
                        new Ending().ending2();

                    }
                }

                }

            }
        }

        public void changeToInfectionRoute(){
        infectionRoute = true;

        }

    public boolean isInfectionRoute() {
        return infectionRoute;
    }

    public int getInfectionRate() {
        return infectionRate;
    }

    public void changeRatInteraction(){
        ratInteraction = false;
    }

    public boolean isRatInteraction() {
        return ratInteraction;
    }
}
