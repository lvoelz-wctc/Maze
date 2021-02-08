package edu.wctc;
import java.util.Scanner;

/**Player fights the direpossum in this room**/

public class Possum extends Room implements Interactable{
    public String interact = "You give the Direpossum your inventory. He seems uninterested in the steak and carrot,\n but" +
            " drinks the cup of metafiction. He realizes that he's a character in a program. This validates his\n" +
            "feelings of existential anxiety, which he thanks you for.";
    public String description = "The room appears to be a dungeon. A Direpossum sits in the center. Interact with the room" +
            " to use your inventory on it.";
    public String roomName = "The Possum Room";

    /**Constructor**/
    public Possum(String name) {
        super(name);
    }

    /**Inherited abstracts**/
    @Override
    public String interact(Player player) {
        player.addToScore(1);
        player.inventory.clear();
        description = "The room appears to be a dungeon. The Direpossum has left the room.";
        return interact;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
