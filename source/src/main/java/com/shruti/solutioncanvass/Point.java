package com.shruti.solutioncanvass;

public class Point {
    public Point(int _x1, int _y1) {
        Utils.shouldAllNonNegative(_x1, _y1);
        this.x = _x1;
        this.y = _y1;
    }

    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public Point setX(int x) {
        this.x = x;
        return this;
    }

    public int getY() {
        return y;
    }

    public Point setY(int y) {
        this.y = y;
        return this;
    }
}