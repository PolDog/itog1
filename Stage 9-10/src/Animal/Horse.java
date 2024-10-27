package Animal;

public class Horse extends PackAnimal {
    static String animalType;
    public Horse(String name,int day,int month,int year) {
        super(name, day, month, year);
        animalType = "Лошадь";
    }
    public void setCommand(String command) {
        super.setCommand(command);
    }

    public String getType() {
        return animalType;
    }
}
