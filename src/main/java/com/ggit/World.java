package com.ggit;

import java.util.Random;

public class World {

    private static final int daysNumber = 10;
    public static void main(String[] args) {
        for (int i = 0; i < daysNumber; i++) {
            Simulation.simulateDay();
        }
    }
}
