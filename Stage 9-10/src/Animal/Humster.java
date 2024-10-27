package Animal;

public class Humster extends Pet {
    public Humster(String name,int day,int month,int year) {
        super(name, day, month, year);
        animalType = "Хомяк";
    }
    public void setCommand(String command) {
        super.setCommand(command);
    }
    public String getType() {
        return animalType;
    }
}
