
class Animal{
    String name;
    long birthDate;
    String commands;
}

class Pets extends Animal{}

class Cat extends Pets{}
class Dog extends Pets{}
class Hamster extends Pets{}

class PackAnimals extends Animal{}

class Horse extends PackAnimals{}
class Camel extends PackAnimals{}
class Donkey extends PackAnimals{}