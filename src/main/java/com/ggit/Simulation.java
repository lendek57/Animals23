package com.ggit;

public class Simulation {
    private static final int width = 10;
    private static final int height = 10;
    private static final IWorldMap worldMap = new WorldMap(width, height);

    public static void simulateDay() {
        System.out.println("New day!");
        worldMap.run();
        worldMap.eat();
    }

    public static IWorldMap getWorldMap() {
        return worldMap;
    }
}
