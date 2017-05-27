package com.hypeofpipe.racegame.components;

import com.badlogic.ashley.core.Component;

/**
 * Created by Volodymyr on 5/27/2017.
 */

public class VelocityComponent implements Component {

    private float x = 0.0f;
    private float y = 0.0f;
    private float velocity = 0.0f;

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

    public float getVelocity() {
        return velocity;
    }

    public void setVelocity(float velocity) {
        this.velocity = velocity;
    }
}
