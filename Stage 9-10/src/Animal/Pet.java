package Animal;

public class Pet extends Animal {
    String animalClass;

    public Pet(String name, int day, int month, int year) {
        super(name, day, month, year);
        animalClass = "Домашние животные";
    }
    public void setCommand(String command) {
        super.setCommand(command);
    }
    public String getAnimalClass() {
        return animalClass;
    }
}
