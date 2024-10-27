package Animal;

public class Donkey extends PackAnimal {
    static String animalType;

    public Donkey(String name, int day, int month, int year) {
        super(name, day, month, year);
        animalType = "Осел";
    }

    public void setCommand(String command) {
        super.setCommand(command);
    }

    public String getType() {
        return animalType;
    }
}
