package Lesson_10;

class Animal {
    private static int animalCount = 0;

    public Animal() {
        animalCount++;
    }

    public static int getAnimalCount() {
        return animalCount;
    }

    public void run(int distance) {
        System.out.println("Животное пробежало " + distance + " м.");
    }

    public void swim(int distance) {
        System.out.println("Животное проплыло " + distance + " м.");
    }
}

class Cat extends Animal {
    private static int catCount = 0;
    private boolean isFull = false;
    private int foodBowl;

    public Cat(int foodBowl) {
        super();
        catCount++;
        this.foodBowl = foodBowl;
    }

    public static int getCatCount() {
        return catCount;
    }

    @Override
    public void run(int distance) {
        if (distance <= 200) {
            System.out.println("Кот пробежал " + distance + " м.");
        } else {
            System.out.println("Кот не может пробежать " + distance + " м.");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println("Кот не умеет плавать.");
    }

    public void eat(int amount) {
        if (amount <= foodBowl && amount > 0) {
            foodBowl -= amount;
            isFull = true;
            System.out.println("Кот поел и теперь сыт.");
        } else if (amount > foodBowl) {
            System.out.println("Недостаточно еды в миске, кот не может поесть.");
        } else {
            System.out.println("Количество еды должно быть положительным.");
        }
    }

    public boolean isFull() {
        return isFull;
    }

    public void addFood(int amount) {
        if (amount > 0) {
            foodBowl += amount;
            System.out.println("В миску добавлено " + amount + " единиц еды.");
        } else {
            System.out.println("Количество добавляемой еды должно быть положительным.");
        }
    }
}

class Dog extends Animal {
    private static int dogCount = 0;

    public Dog() {
        super();
        dogCount++;
    }

    public static int getDogCount() {
        return dogCount;
    }

    @Override
    public void run(int distance) {
        if (distance <= 500) {
            System.out.println("Собака пробежала " + distance + " м.");
        } else {
            System.out.println("Собака не может пробежать " + distance + " м.");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance <= 10) {
            System.out.println("Собака проплыла " + distance + " м.");
        } else {
            System.out.println("Собака не может проплыть " + distance + " м.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Cat[] cats = new Cat[3];
        cats[0] = new Cat(20);
        cats[1] = new Cat(15);
        cats[2] = new Cat(10);

        for (Cat cat : cats) {
            cat.eat(10);
        }

        for (int i = 0; i < cats.length; i++) {
            System.out.println("Кот " + (i + 1) + " сыт: " + cats[i].isFull());
        }
        cats[0].addFood(5);
        System.out.println("Общее количество животных: " + Animal.getAnimalCount());
        System.out.println("Количество котов: " + Cat.getCatCount());
        System.out.println("Количество собак: " + Dog.getDogCount());

        Dog dogBobik = new Dog();
        dogBobik.run(150);
        dogBobik.swim(5);

        Cat catMurzik = new Cat(10);
        catMurzik.run(100);
        catMurzik.swim(5);
    }
}