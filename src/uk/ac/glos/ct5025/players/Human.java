package uk.ac.glos.ct5025.players;

public class Human {
    private String name;

    public Human(String name) {
        this.setName(name);
    }

    //Encapsulate name field
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}