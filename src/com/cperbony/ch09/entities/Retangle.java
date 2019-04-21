package com.cperbony.ch09.entities;

import com.cperbony.ch09.enums.Color;

public class Retangle extends Shape {

    private Double width;
    private Double height;

    public Retangle() {
        super();
    }

    public Retangle(Color color, Double width, Double height) {
        super(color);
        this.width = width;
        this.height = height;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }
}
