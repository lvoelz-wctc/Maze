package edu.wctc;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Player p = new Player();
        Maze m = new Maze(p);
        Scanner scanner = new Scanner(System.in);
        ArrayList<Character> listOfMovements = new ArrayList<>();
        listOfMovements.add('n');
        listOfMovements.add('s');
        listOfMovements.add('e');
        listOfMovements.add('w');
        listOfMovements.add('u');
        listOfMovements.add('d');

        ArrayList<Character> listOfActions = new ArrayList<>();
        listOfActions.add('i');
        listOfActions.add('l');
        listOfActions.add('x');
        listOfActions.add('v');

        boolean runMaze = true;

        /**Begin maze run loop here**/
        do {
            System.out.println(m.getCurrentRoomDescription());
            System.out.println("Possible exits are: " + m.getCurrentRoomExits());
            System.out.println("Enter a command. To move, enter 'n' to move north, 's' to move south, 'e' to move east," +
                    "'w' to move west, 'u' to move up, or 'd' to move down.");
            System.out.println("To interact with the room, enter 'i'.");
            System.out.println("To loot the room, enter 'l'.");
            System.out.println("To attempt to exit the room and finish the maze, enter 'x'.");
            System.out.println("To show your inventory, enter 'v'.");
            char response = scanner.nextLine().charAt(0);
            if (!listOfActions.contains(response) && !listOfMovements.contains(response)) {
                System.out.println("Response is invalid.");
            }
            else if (listOfMovements.contains(response)){
                if (m.move(response)) {
                    System.out.println("You move to " + m.getCurrentRoomName());
                }
                else {
                    System.out.println("You can't move that way.");
                }
            }
            else if (response == 'i'){
                System.out.println(m.interactWithCurrentRoom());
            }
            else if (response == 'l'){
                System.out.println(m.lootCurrentRoom());
            }
            else if (response == 'x'){
                System.out.println(m.exitCurrentRoom());
            }
            else if (response == 'v'){
                System.out.println(m.getPlayerInventory());
            }

            if (m.isFinished() == true){
                runMaze = false;
                System.out.println("Your score is: " + m.getPlayerScore());
            }
        }

        while (runMaze == true);
    }
}
