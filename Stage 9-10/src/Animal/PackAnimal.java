package Animal;

public class PackAnimal extends Animal {
    String animalClass;
//    ArrayList<Animal> packAnimals;
    public PackAnimal(String name, int day, int month, int year) {
        super(name, day, month, year);
        animalClass = "Вьючные животные";
    }
    public void setCommand(String command) {
        super.setCommand(command);
    }
    public String getAnimalClass() {
        return animalClass;
    }
}
