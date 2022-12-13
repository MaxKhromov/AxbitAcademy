package hw3.oop;

import hw3.oop.domain.Animal;
import hw3.oop.domain.MeatEatingAnimal;
import hw3.oop.domain.PlantEatingAnimal;

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal("Морская свинка",4, 10,10);
        MeatEatingAnimal meatEatingAnimal = new MeatEatingAnimal("Волк",4, 50, 50);
        PlantEatingAnimal plantEatingAnimal = new PlantEatingAnimal("Олень", 4, 100,50);

        if (animal.checkHunger()) {
            animal.eat();
        }
        animal.checkHunger();

        if (meatEatingAnimal.checkHunger()) {
            meatEatingAnimal.eat();
        }
        meatEatingAnimal.checkHunger();

        if (plantEatingAnimal.checkHunger()) {
            plantEatingAnimal.eat();
        }
        plantEatingAnimal.checkHunger();

        meatEatingAnimal.setHungry(true);
        meatEatingAnimal.checkHunger();
        meatEatingAnimal.eatAnimal(plantEatingAnimal);
        meatEatingAnimal.isAlive();
        plantEatingAnimal.isAlive();
    }
}
