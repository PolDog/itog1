import Animal.Animal;
import Animal.Horse;
import Animal.Cat;
import Animal.Dog;
import Animal.Humster;
import Animal.Camel;
import Animal.Donkey;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    static Scanner scanner;
    static ArrayList<Animal> animals;

    public static void main(String[] args) {
        animals = new ArrayList<>();
        showMenu();
    }

    private static void showMenu() {
        clrscr();
        System.out.println("В базе есть "+animals.size()+" животных.");
        System.out.println("1 добавить животное");
        System.out.println("2 вывести список комманд");
        System.out.println("3 научить новой комманде");
        System.out.println("4 Вывести всех животных");
        System.out.println("");
        System.out.println("");
        System.out.println("9 Создать тестовые записи");
        System.out.println("0 Закрыть программу");
        String userInput = scanner.nextLine();

        switch (userInput) {
            case "1":
                selectType();
                break;
            case "2":
                showCommands();
                break;
            case "3":
                addCommand();
                break;
            case "4":
                showAllAnimals();
            case "9":
                createTestRecords();
                break;
            case "0":
                System.exit(1);
                break;
            default:
                System.out.println("Нет такого пункта");
        }
    }

    private static void addCommand() {
        clrscr();
        System.out.println("Кого научить новым командам. Введите номер");
        for (int i = 0; i < animals.size(); i++) {
            System.out.println(i + "). " + animals.get(i).getType() + " " + animals.get(i).getName()+", знает "+animals.get(i).getCommands().size()+" ком.");
        }
        int animalNumber = scanner.nextInt();
        System.out.println("Введите новую комманду:");
        scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        animals.get(animalNumber).getCommands().add(command);
        System.out.println("Press Enter key to continue...");
        scanner.nextLine();
        showMenu();
    }

    private static void showCommands() {
        System.out.println("Чъи команды показать. Введите номер");
        for (int i = 0; i < animals.size(); i++) {
            System.out.println(i + "). " + animals.get(i).getType() + " " + animals.get(i).getName()+", знает "+animals.get(i).getCommands().size()+" ком.");
        }
        int userInput = scanner.nextInt();
        clrscr();
        System.out.println(animals.get(userInput).getName()+ " знает команды:");
        for (int i = 0; i < animals.get(userInput).getCommands().size(); i++) {
            System.out.println("        " + animals.get(userInput).getCommands().get(i));
        }
        System.out.println("Press Enter key to continue...");
        scanner.nextLine();
        showMenu();
    }

    private static void createTestRecords() {

        Cat cat = new Cat("Мурзик", 10, 10, 2023);
        cat.setCommand("ко мне");
        cat.setCommand("брысь");
        animals.add(cat);
        cat = new Cat("Мурка", 12, 8, 2022);
        animals.add(cat);
        cat = new Cat("Франт", 29, 5, 2024);
        animals.add(cat);
        Horse horse = new Horse("Быстрый", 10, 10, 2018);
        animals.add(horse);
        showMenu();
    }

    private static void showAllAnimals() {
        clrscr();
        ArrayList<Animal> all = new ArrayList<>();
        all.addAll(animals);
        Comparator<Animal> compareByDate = Comparator
                .comparing(Animal::getDate);
        ArrayList<Animal> sortedPets = all.stream()
                .sorted(compareByDate)
                .collect(Collectors.toCollection(ArrayList::new));

        System.out.println("--------------------");
        for (Animal a : sortedPets) {
            System.out.println(a.getAnimalClass() + ", " + a.getType());
            System.out.println("Меня зовут: " + a.getName());
            System.out.println("Я родился: " + a.getBirthDate());
            System.out.println("Я знаю команды:");
            for (int i = 0; i < a.getCommands().size(); i++) {
                System.out.println("        " + a.getCommands().get(i));
            }
            System.out.println("--------------------");
        }
        System.out.println();

        System.out.println("Press Enter key to continue...");
        scanner.nextLine();
        showMenu();
    }

    public static void clrscr() {

        for(int clear = 0; clear < 1000; clear++)
        {
            System.out.println("\b") ;
        }

        scanner = new Scanner(System.in);
    }

    private static void selectType() {
        clrscr();
        System.out.println("1 Домашнее животное");
        System.out.println("2 Въючное животное");
        String userInput = scanner.nextLine();
        switch (userInput) {
            case "1":
                selectTypePet(1);
                break;
            case "2":
                selectTypePet(2);
                break;
            default:
                System.out.println("Нет такого пункта");
        }
    }

    private static void selectTypePet(int idType) {
        clrscr();
        if (idType == 1) {
            System.out.println("1 Кошка");
            System.out.println("2 Собака");
            System.out.println("3 Хомяк");
        } else {
            System.out.println("1 Лошадь");
            System.out.println("2 Верблюд");
            System.out.println("3 Осел");
        }
        String userInput = scanner.nextLine();
        switch (userInput) {
            case "1":
                enterInfo(idType, 1);
                break;
            case "2":
                enterInfo(idType, 2);
                break;
            case "3":
                enterInfo(idType, 3);
                break;
            case "4":
            default:
                System.out.println("Нет такого пункта");
        }
    }

    private static void enterInfo(int idType, int id) {
        clrscr();
        String userInput;
        System.out.println("Введите имя:");
        String name = scanner.nextLine();
        System.out.println("Введите год рождения");
        int year = scanner.nextInt();
        System.out.println("Введите месяц роджения");
        int month = scanner.nextInt();
        System.out.println("Введите дату рождения");
        int day = scanner.nextInt();
        String animalID = String.valueOf(idType) + String.valueOf(id);
        switch (animalID) {
            case "11":
                animals.add(new Cat(name, day, month, year));
                break;
            case "12":
                animals.add(new Dog(name, day, month, year));
                break;
            case "13":
                animals.add(new Humster(name, day, month, year));
                break;
            case "21":
                animals.add(new Horse(name, day, month, year));
                break;
            case "22":
                animals.add(new Camel(name, day, month, year));
                break;
            case "23":
                animals.add(new Donkey(name, day, month, year));
                break;
            default:
        }
        showMenu();
    }

}