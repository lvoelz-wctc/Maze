package edu.wctc;

public class LastRoom extends Room implements Interactable, Exit{

    public String description = "The room thrums with the unsettling aura of fell magick. The door to the surface is at " +
            "the end. A scroll is hung on one of the walls.";
    public String interact = "You read the scroll. It states: 'Thank you for navigating this dungeon.\nThe dungeon builder had" +
            "to reduce its scope due to magickal supply issues. You may exit here to return to the surface.";
    public String exit = "You leave the final room and return to the surface.";
    public String roomName = "The Last Room";


    /**Constructor**/
    public LastRoom(String name) {
        super(name);
    }

    /**Inherited abstracts**/
    @Override
    public String exit(Player player) {
        player.addToScore(10);
        return exit;
    }

    @Override
    public String interact(Player player) {
        player.addToScore(1);
        return interact;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
