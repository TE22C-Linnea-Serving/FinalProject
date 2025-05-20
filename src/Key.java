public class Key extends InteractibleItem{

    //Attributes
    private int id;
    private boolean used;
    Room room1 = new Room();

    //Constructor
    public Key(String name, String description, int id, boolean used){
        super(name, description, id);
        this.name = name;
        this.description = description;
        this.id = id;
        this.used = used;
    }

    public Key() {
        super();
    }

    //Methods
    public void use(User player, int i){      //Override
        System.out.println(player.backpack.items.get(i).id);

        for (int j=0; j <= (room1.furnitures.size()-1); j++){     //Looks through all interactable furniture
              if (room1.furnitures.get(j).id == player.backpack.items.get(i).id) {              //If furniture has the same id as the key item
                room1.furnitures.get(j).locked = false;         //Unlocks
                player.backpack.items.remove(i);
                break;
            }else if(j == room1.furnitures.size()-1){           //If the player does not have the required item
                System.out.println("WRONG!!");
                break;
            }
        }
    }
}
