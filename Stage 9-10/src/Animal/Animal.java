package Animal;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Animal {
    int id;
    String name;
    Date birthDate;
    ArrayList<String> commands;
    String animalType;
    String animalClass;

    public Animal() {
    }

    public Animal(String name, int day, int month, int year) {

        commands = new ArrayList<>();
        this.name = name;
        setBirthDate(day, month, year);
    }

    public String getName() {
//        System.out.println("Меня зовут: " + name);
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
//        System.out.println("Я родился: " + birthDate);
        return birthDate;
    }

    public Date getDate() {
        return birthDate;
    }

    public void setBirthDate(int day, int month, int year) {
        month--;
        Calendar calendar = new GregorianCalendar(year, month, day);
        birthDate = calendar.getTime();
    }

    public void setCommand(String command) {
        commands.add(command);
    }

    public ArrayList<String> getCommands() {
        return commands;
//        System.out.println("Я знаю команды:");
//        for (int i = 0; i < commands.size(); i++) {
//            System.out.println("        " + commands.get(i));
//        }
    }

    public String getType() {
        return animalType;
    }

    public String getAnimalClass() {
        return animalClass;
    }
}
