package com.ggit;

public class Animal {
    private Vector2D position;

    public Animal(Vector2D position) {
        this.position = position;
    }

    public Vector2D getPosition() {
        return position;
    }

    public void move(MapDirection direction) {
        position = pbc(position.add(direction.getUnitVector()));
        System.out.println("New position: " + position);
    }

    private Vector2D pbc(Vector2D vector) {
        int width = Simulation.getWorldMap().getWidth();
        int height = Simulation.getWorldMap().getHeight();
        if (vector.getX() < 0) return vector.add(new Vector2D(width, 0));
        if (vector.getY() < 0) return vector.add(new Vector2D(0, height));
        if (vector.getX() >= width) return vector.subtract(new Vector2D(width, 0));
        if (vector.getY() >= height) return vector.subtract(new Vector2D(0, height));
        return vector;
    }
}
