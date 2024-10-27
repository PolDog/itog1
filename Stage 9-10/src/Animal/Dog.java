package Animal;

public class Dog extends Pet {
    public Dog(String name,int day,int month,int year) {
        super(name, day, month, year);
        animalType = "Собака";
    }
    public void setCommand(String command) {
        super.setCommand(command);
    }
    public String getType() {
        return animalType;
    }
}
