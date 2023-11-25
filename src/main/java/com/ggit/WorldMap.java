package com.ggit;

import java.util.*;

public class WorldMap extends AbstractWorldMap {
    private Map<Vector2D, Plant> plants;
    private Map<Vector2D, Animal> animalsMap;
    private List<Animal> animals;
    private static final int noOfPlants = 25;
    private static final int noOfAnimals = 5;
    private Random random = new Random();

    public WorldMap(int width, int height) {
        super(width, height);
        animals = new LinkedList<>();
        animalsMap = new HashMap<>();
        plants = new HashMap<>();
        for (int i = 0; i < noOfPlants; i++) addPlant();
        for (int i = 0; i < noOfAnimals; i++) addAnimal();
    }

    private void addAnimal() {
        Animal animal = new Animal(getRandomPosition());
        animals.add(animal);
        animalsMap.put(animal.getPosition(), animal);
    }

    private void addPlant() {
        if (width * height <= plants.size()) return;

        Vector2D position = getRandomPosition();
        while (isOccupiedByPlant(position)) {
            position = getRandomPosition();
        }
        plants.put(position, new Plant(position));
    }

    private boolean isOccupiedByPlant(Vector2D position) {
        return plants.containsKey(position);
    }

    private Vector2D getRandomPosition() {
        return new Vector2D(random.nextInt(width), random.nextInt(height));
    }

    @Override
    public void run() {
        animalsMap.clear();
        for (Animal animal : animals) {
            animal.move(MapDirection.values()[random.nextInt(MapDirection.values().length)]);
            animalsMap.put(animal.getPosition(), animal);
        }
    }

    @Override
    public void eat() {
        for (Map.Entry<Vector2D, Animal> animalOnPosition : animalsMap.entrySet()) {
            Vector2D position = animalOnPosition.getKey();
            if (isOccupiedByPlant(position)) {
                System.out.printf("Zwierzę %d zjadło roślinę%n", animalOnPosition.getValue().getId());
                plants.remove(position);
                addPlant();
            }
        }
    }
}
