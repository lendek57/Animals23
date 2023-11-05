package com.ggit;

public abstract class AbstractWorldMap implements IWorldMap {
    private int width;
    private int height;

    public AbstractWorldMap(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getWidth() {
        return width;
    }
}
