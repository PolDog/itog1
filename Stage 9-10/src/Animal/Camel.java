package Animal;

public class Camel extends PackAnimal {
    static String animalType;

    public Camel(String name, int day, int month, int year) {
        super(name, day, month, year);
        animalType = "Верблюд";
    }

    public void setCommand(String command) {
        super.setCommand(command);
    }

    public String getType() {
        return animalType;
    }
}
