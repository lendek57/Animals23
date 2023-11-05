package com.ggit;

import java.util.Random;

public class WorldMap extends AbstractWorldMap {
    private Animal animal;
    private Random random = new Random();
    public WorldMap(int width, int height) {
        super(width, height);
        animal = new Animal(new Vector2D(random.nextInt(width), random.nextInt(height)));
    }

    @Override
    public void run() {
        animal.move(MapDirection.values()[random.nextInt(MapDirection.values().length)]);
    }
}
