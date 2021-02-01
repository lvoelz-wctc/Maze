package edu.wctc;
import java.util.ArrayList;

public abstract class Room {

    public String roomName;
    public Room north;
    public Room south;
    public Room east;
    public Room west;
    public Room up;
    public Room down;
;
    //room constructor
    //remember we're passing name from an outside source.
    public Room(String name){
        roomName = name;
    }

    //displayed to player when they enter room; shows what's in room
    public abstract String getDescription();


    public String getExits(){
        ArrayList<String> showExits = new ArrayList<String>();
        //list of all directions player could exit from current room
        if (north != null){
            showExits.add("North");
        }
        if (south != null){
            showExits.add("South");
        }
        if (east != null){
            showExits.add("East");
        }
        if (west != null){
            showExits.add("West");
        }
        if (up != null){
            showExits.add("Up");
        }
        if (down != null){
            showExits.add("Down");
        }
        return showExits.toString();
    }

    public String getName(){
        return roomName;
    }

    public Boolean isValidDirection(char direction){
        if (north != null && direction == 'n'){
            return true;
        }
        else if (south != null && direction == 's'){ //add other else ifs for future proofing.
            return true;
        }
        else {return false;}
    }

    //this accepts n, s, e, w, u, d
    public Room getAdjoiningRoom(char direction){
        //if connected to another room, return that Room, otherwise null
        if (north != null && direction == 'n'){
            return this.north;      //remember, this.north points to a room. i.e., Possum for Entrance.
        }
        else if (south != null && direction == 's'){
            return this.south;
        }
        else {return null;}
    }

    //6 setter methods
    public void setNorth(Room northRoom){
        this.north = northRoom;
    }

    public void setSouth(Room southRoom){
        this.south = southRoom;
    }

    public void setEast(Room eastRoom){
        this.east = eastRoom;
    }

    public void setWest(Room westRoom){
        this.west = westRoom;
    }

    public void setUpRoom (Room upRoom){
        this.up = upRoom;
    }

    public void setDownRoom (Room downRoom){
        this.down = downRoom;
    }
}
