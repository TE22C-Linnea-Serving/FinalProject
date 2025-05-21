public class Enemy extends Character{

    //Attributes
    private int HP;
    private int attackPower;
    private int infectionRate = 0;
    private boolean infectionRoute ;
    private int id;
    Enemy rat = new Enemy(0, false, 10);

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

    public void infectionRateIncrease(boolean infectionRoute, Enemy enemy, User player){

        if(infectionRoute) {                //This only happens if the player triggered the starting event
            if (infectionRate == 1) {
                System.out.println("");
            } else if (infectionRate == 2) {  //If the rat is on the second stage of the
                System.out.println("Just when, the rat can be seen again in the corner of your eyes.\nHowever, this time, there is something that is not quite right about it.\nIt...moves differently. Almost intelligently, as if it is someone else behind it's movements.\n");

            } else if (infectionRate == 3) {
                System.out.println("");
            } else if (infectionRate == 4) {
                System.out.println("The rat suddenly leaps out from nowhere, attacking you!");

                for(int i = 0; i<=player.backpack.items.size()-1; i++) {         //Check if player has weapon in backpack
                    if(true) {
                    }
                }

                }

            }
        }

    public int getInfectionRate() {
        return infectionRate;
    }

    public int getAttackPower() {
        return attackPower;
    }
}
