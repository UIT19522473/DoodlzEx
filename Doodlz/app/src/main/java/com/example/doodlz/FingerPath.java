package com.example.doodlz;

import android.graphics.Path;

public class FingerPath {

    private int color;
    private int strokeWith;
    private Path path;

    public FingerPath(int color, int strokeWith, Path path) {
        this.color = color;
        this.strokeWith = strokeWith;
        this.path = path;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getStrokeWith() {
        return strokeWith;
    }

    public void setStrokeWith(int strokeWith) {
        this.strokeWith = strokeWith;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }
}
