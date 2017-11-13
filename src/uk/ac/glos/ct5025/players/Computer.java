package uk.ac.glos.ct5025.players;

import java.util.ArrayList;

public class Computer {
    //Set name for computer player, assigned randomly
    private final String NAME = this.generateName();

    //Generate list of potential names for computer to use
    private ArrayList<String> createNameArray() {
        ArrayList<String> nameList = new ArrayList<>();

        nameList.add("Kerry (Computer)");
        nameList.add("Winston (Computer)");
        nameList.add("Mohammed (Computer)");
        nameList.add("Eva (Computer)");
        nameList.add("Dennis (Computer)");

        return nameList;
    }

    //Randomly select name based on name arraylist
    private String generateName() {
        ArrayList<String> nameList = this.createNameArray();

        //Generate random number within bounds of arraylist size
        java.util.Random rnd = new java.util.Random();
        int selector = rnd.nextInt(nameList.size());

        //Pass selected name back to attribute
        return nameList.get(selector);
    }

    //Encapsulate name field
    public String getName() {
        return this.NAME;
    }
}
