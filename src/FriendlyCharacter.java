import java.util.Scanner;

public class FriendlyCharacter extends Character{


    //Attributes
    int friendlyness;   //Level of friendlyness (Changes interaction)


    //Constructor
    public FriendlyCharacter(String name, int friendlyness){
        friendlyness = 0;

    }

    //Methods
    public void interact(){

        if(friendlyness==0){;

        }else if(friendlyness <= 2){

        } else if (friendlyness <=5) {

        }else if (friendlyness <=9){

        }else if(friendlyness > 9){

        }
    }

    public void pet(){
        System.out.println("Do you want to pet the cat?\n");
        Scanner sc = new Scanner(System.in);
    }
}
