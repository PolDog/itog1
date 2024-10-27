package Animal;

public class Cat extends Pet {
    static String animalType;
    public Cat(String name,int day,int month,int year) {
        super(name, day, month, year);
        animalType = "Кошка";
    }
    public void setCommand(String command) {
        super.setCommand(command);
    }
    public String getType() {
        return animalType;
    }
}
