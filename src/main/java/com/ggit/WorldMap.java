package com.ggit;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class WorldMap extends AbstractWorldMap {
    private List<Plant> plants;
    private List<Animal> animals;
    private static final int noOfPlants = 25;
    private static final int noOfAnimals = 5;
    private Random random = new Random();

    public WorldMap(int width, int height) {
        super(width, height);
        animals = new LinkedList<>();
        plants = new LinkedList<>();
        for (int i = 0; i < noOfPlants; i++) addPlant();
        for (int i = 0; i < noOfAnimals; i++) animals.add(new Animal(getRandomPosition()));
    }

    private void addPlant() {
        if (width * height <= plants.size()) return;

        Vector2D position = getRandomPosition();
        while (isOccupiedByPlant(position)) {
            position = getRandomPosition();
        }
        plants.add(new Plant(position));
    }

    private boolean isOccupiedByPlant(Vector2D position) {
        for (Plant plant : plants) {
            if (plant.getPosition().equals(position)) {
                return true;
            }
        }
        return false;
    }

    private Vector2D getRandomPosition() {
        return new Vector2D(random.nextInt(width), random.nextInt(height));
    }

    @Override
    public void run() {
        for (Animal animal : animals) {
            animal.move(MapDirection.values()[random.nextInt(MapDirection.values().length)]);
        }
    }

    @Override
    public void eat() {
        for (Animal animal : animals) {
            for (Plant plant : plants) {
                if (animal.getPosition().equals(plant.getPosition())) {
                    System.out.printf("Zwierzę %d zjadło roślinę%n", animal.getId());
                    plants.remove(plant);
                    addPlant();
                    break;
                }
            }
        }
    }
}
