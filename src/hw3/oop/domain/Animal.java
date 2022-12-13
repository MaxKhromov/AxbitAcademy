package hw3.oop.domain;

public class Animal {
    public int legs;
    public int weight;
    public int height;
    public boolean isHungry;
    public String name;
    public boolean alive;

    public Animal(String name, int legs, int weight, int height) {
        this.legs = legs;
        this.weight = weight;
        this.height = height;
        this.name = name;
        this.isHungry = true;
        this.alive = true;
    }

    public void eat() {
        System.out.println("Животное '" + this.name + "' кушает...");
        this.isHungry = false;
    }

    public boolean checkHunger() {
        if (isHungry) {
            System.out.println("Животное '" + this.name + "' голодное.");
        } else {
            System.out.println("Животное '" + this.name + "' сытое.");
        }
        return isHungry;
    }

    public boolean isAlive() {
        if (this.alive) {
            System.out.println("Животное '" + this.name + "' живое.");
        } else {
            System.out.println("Животное '" + this.name + "' мертвое.");
        }
        return alive;
    }

    public void setHungry(boolean hungry) {
        isHungry = hungry;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public int getLegs() {
        return legs;
    }

    public int getWeight() {
        return weight;
    }

    public int getHeight() {
        return height;
    }

    public boolean isHungry() {
        return isHungry;
    }

    public String getName() {
        return name;
    }
}
