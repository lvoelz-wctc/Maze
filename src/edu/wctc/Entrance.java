package edu.wctc;

/**Entrance room. Contains the lootable table with three items. Two rooms are to the north.**/
//Remember that the room abstract needs a constructor for this one to extend it correctly.

public class Entrance extends Room implements Lootable{

    public String getLoot = "You loot: A Steak, a Carrot, and a Cup of Metafiction.";
    public String alreadyLooted = "You've already looted the room.";
    public String description = "The room contains a table where someone was preparing food. The table contains" +
            " a Steak, a Carrot, and a Cup of Metafiction. You may loot the table.";
    public String steak = "Steak";
    public String carrot = "Carrot";
    public String cup = "Cup of Metafiction";
    public boolean looted = false;
    public String roomName = "Entrance";

    public Entrance(String name) {
        super(name);
    }

    /**Inherited abstracts here.**/
    @Override
    public String loot(Player player) {
        if (looted == false){
            player.addToInventory(steak);
            player.addToInventory(carrot);
            player.addToInventory(cup);
            player.addToScore(5);
            looted = true;
            return getLoot;
        }
        else {
            return alreadyLooted;
        }
    }

    @Override
    public String getDescription() {
        return description;
    }
}
