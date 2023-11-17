package com.ggit;

import java.util.Random;

public class World {

    private static final int defaultDaysNumber = 10;
    public static void main(String[] args) {
        int daysNumber = args.length > 0 ? Integer.parseInt(args[0]) : defaultDaysNumber;
        for (int i = 0; i < daysNumber; i++) {
            Simulation.simulateDay();
        }
    }
}
