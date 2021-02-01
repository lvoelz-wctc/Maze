package edu.wctc;

public class Maze  {

    public Room currentRoom;
    public Player player;
    public boolean isFinished = false;
    public String notLootable = "This room isn't lootable.";
    public String notInteractable = "This room isn't interactable.";
    public String notExitable = "This room doesn't have an exit.";

    //maze constructor
    public Maze(Player player){
        //create all room objects in game and connects via setters.
        //player begins in currentRoom field.
        this.player = player;
        Entrance e = new Entrance("Entrance");
        Possum p = new Possum("Possum");
        LastRoom l = new LastRoom("Last Room");

        currentRoom = e;
        e.setNorth(p);
        p.setNorth(l);
        p.setSouth(e);
        l.setSouth(p);
    }

    public String exitCurrentRoom(){
        if (currentRoom instanceof Exit){
            isFinished = true;
            return ((Exit)currentRoom).exit(player);
        }
        else {
            return notExitable;
        }
    }

    public String interactWithCurrentRoom(){ //cast currentRoom to interactable. then you won't need interface extension
        if (currentRoom instanceof Interactable) {
            return ((Interactable)currentRoom).interact(player); //know it's a room variable, but treat like interactable
        }
        else {
            return notInteractable;
        }
    }

    public String lootCurrentRoom(){
        if (currentRoom instanceof Lootable) {
            return ((Lootable)currentRoom).loot(player);
        }
        else {
            return notLootable;
        }
    }

    public boolean move(char direction){
        if (this.currentRoom.isValidDirection(direction))
        {
            currentRoom = currentRoom.getAdjoiningRoom(direction);
            return true;
        }
        else {
            return false;
        }
    }

    public String getCurrentRoomDescription(){
        return currentRoom.getDescription();
    }

    public String getCurrentRoomExits(){
        return currentRoom.getExits();
    }

    public String getCurrentRoomName(){
        return currentRoom.getName();
    }

    public int getPlayerScore(){
        return player.getScore();
    }

    public String getPlayerInventory(){
        return player.getInventory();
    }

    public boolean isFinished(){
        return isFinished;
    }
}
