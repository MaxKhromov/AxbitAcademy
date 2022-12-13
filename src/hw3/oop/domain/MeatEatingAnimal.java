package hw3.oop.domain;

public class MeatEatingAnimal extends Animal implements AnimalEater {

    public MeatEatingAnimal(String name, int legs, int weight, int height) {
        super(name, legs, weight, height);
    }

    @Override
    public void eat(){
        System.out.println("Животное '"   + this.name + "' кушает МЯСО...");
        this.isHungry = false;
    }

    @Override
    public void eatAnimal(Animal animal) {
        System.out.println("Животное '" + this.name + "' съело животное '" + animal.name + "' :(");
        animal.setAlive(false);
    }
}
