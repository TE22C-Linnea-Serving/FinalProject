import java.util.ArrayList;

public class Room {

    //Attributes
    ArrayList<InteractibleFurniture> furniture = new ArrayList<>();

    //Creates Interactable furniture to have in the rooms
    InteractibleFurniture door = new InteractibleFurniture("Door", "The door that lead to another room", true,3);
    InteractibleFurniture cabinet = new InteractibleFurniture("Cabinet", "A small cabinet", false,0);
    InteractibleFurniture wardrobe = new InteractibleFurniture("Wardrobe", "A big wardrobe with a mystery", true,1);
    InteractibleFurniture bookshelf = new InteractibleFurniture("Bookcase", "A small bookcase with four books", false, 0);
    InteractibleFurniture desk = new InteractibleFurniture("Desk", "A normal desk", true, 4);
    InteractibleFurniture exitDoor = new InteractibleFurniture("Exit door", "The door leads to the outside", true, 5);



    //Constructor
    Room(){
        //Adds the furniture to the array list
        furniture.add(door);
        furniture.add(cabinet);
        furniture.add(wardrobe);
        furniture.add(bookshelf);
        furniture.add(desk);
        furniture.add(exitDoor);

        //Adds items to the Interactable furniture's inventory
        cabinet.getContains().items.add(new Key("Screwdriver", "A normal screwdriver", 1));
        wardrobe.getContains().items.add(new Clue("A paper", "A contract, seems to be about some kind of biological experiment", "\"...Contract stuff...\"", 0));
        wardrobe.getContains().items.add(new Key("Door key", "It seems to be the key that unlocks the door!", 3));
        bookshelf.getContains().items.add(new Key("Desk key", "It seems to be the key that unlocks the desk drawer!", 4));
        desk.getContains().items.add(new Key("Exit key", "It is the key to the exit door!!", 5));
        desk.getContains().items.add(new Key("Letter opener", "A small knife used to open letters", 6));

    }
}
