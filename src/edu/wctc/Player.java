package edu.wctc;

import java.util.ArrayList;

public class Player {
    public int score;
    ArrayList<String> inventory = new ArrayList<>();
    public int size = inventory.size();
    public String emptyInventory = "You have no items in your inventory.";

    public void addToInventory (String loot){
        inventory.add(loot);
    }

    public void addToScore (int points){
        score = score + points;
    }

    public String getInventory(){
        if (inventory.size() ==0){
            return emptyInventory;
        }
        else {
            return inventory.toString();
        }
    }

    public int getScore(){
        return score;
    }

}
