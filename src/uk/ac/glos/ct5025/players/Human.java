package uk.ac.glos.ct5025.players;

public class Human extends Player {

    public Human(String name) {
        this.name = name;
    }

    //Encapsulate name field
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}