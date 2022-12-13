package hw3.oop.domain;

public class PlantEatingAnimal extends Animal{

    public PlantEatingAnimal(String name, int legs, int weight, int height) {
        super(name, legs, weight, height);
    }

    @Override
    public void eat(){
        System.out.println("Животное '"   + this.name + "' кушает РАСТЕНИЕ...");
        this.isHungry = false;
    }
}
