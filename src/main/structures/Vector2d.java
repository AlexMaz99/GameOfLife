package structures;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Vector2d {
    public final int x;
    public final int y;
    public static int VECTOR_WIDTH = 24;

    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Vector2d(int x, int y, boolean multiplyByWidth) {
        this.x = x * VECTOR_WIDTH;
        this.y = y * VECTOR_WIDTH;
    }


    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }

    public boolean precedes(Vector2d other) {
        return this.x <= other.x && this.y <= other.y;
    }

    public boolean follows(Vector2d other) {
        return this.x >= other.x && this.y >= other.y;
    }

    public Vector2d upperRight(Vector2d other) {
        int newX, newY;
        newX = max(this.x, other.x);
        newY = max(this.y, other.y);
        return new Vector2d(newX, newY);
    }

    public Vector2d lowerLeft(Vector2d other) {
        int newX, newY;
        newX = min(this.x, other.x);
        newY = min(this.y, other.y);
        return new Vector2d(newX, newY);
    }

    public Vector2d add(Vector2d other) {
        return new Vector2d(this.x + other.x, this.y + other.y);
    }

    public Vector2d subtract(Vector2d other) {
        return new Vector2d(this.x - other.x, this.y - other.y);
    }

    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof Vector2d)) return false;
        Vector2d that = (Vector2d) other;
        return this.x == that.x && this.y == that.y;
    }

    public Vector2d opposite() {
        return new Vector2d(-this.x, -this.y);
    }

    @Override
    public int hashCode() {
        int hash = 13;
        hash += this.x * 31;
        hash += this.y * 17;
        return hash;
    }

    public static void setVectorWidth(int vectorWidth) throws Exception {
        if (vectorWidth <= 0)
            throw new Exception("Vector width must be positive");
        VECTOR_WIDTH = vectorWidth;
    }

    public List<Vector2d> neighbours() {
        List<Vector2d> neighbours = new ArrayList<>();

        neighbours.add(new Vector2d(this.x + VECTOR_WIDTH, this.y + VECTOR_WIDTH));
        neighbours.add(new Vector2d(this.x + VECTOR_WIDTH, this.y));
        neighbours.add(new Vector2d(this.x, this.y + VECTOR_WIDTH));
        neighbours.add(new Vector2d(this.x - VECTOR_WIDTH, this.y + VECTOR_WIDTH));
        neighbours.add(new Vector2d(this.x + VECTOR_WIDTH, this.y - VECTOR_WIDTH));
        neighbours.add(new Vector2d(this.x - VECTOR_WIDTH, this.y));
        neighbours.add(new Vector2d(this.x, this.y - VECTOR_WIDTH));
        neighbours.add(new Vector2d(this.x - VECTOR_WIDTH, this.y - VECTOR_WIDTH));

        return neighbours;
    }
}