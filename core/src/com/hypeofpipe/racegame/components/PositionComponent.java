package com.hypeofpipe.racegame.components;

import com.badlogic.ashley.core.Component;

/**
 * Created by Volodymyr on 5/27/2017.
 */

public class PositionComponent implements Component {

    private float x = 0.0f;
    private float y = 0.0f;
    private float degree = 0.0f;
    private static final float fullCircle = 360.0f;

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getDegree() {
        return degree;
    }

    public void setDegree(float degree) {
        if (degree < fullCircle) {
            this.degree = degree;
        }
        int k = (int) (degree / fullCircle);
        this.degree = k * fullCircle - degree;
    }
}
