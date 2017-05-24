package com.hypeofpipe.racegame.gameobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * Created by Volodymyr on 5/22/2017.
 */

public class GameObjectBodyless extends Actor {

    private Texture texture;
    private Sprite sprite;

    public GameObjectBodyless(Texture texture){
        this.texture = texture;
        sprite = new Sprite(texture);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        sprite.draw(batch);
    }

    @Override
    public void setX(float x) {
        super.setX(x);
        sprite.setX(x);
    }

    @Override
    public void setY(float y) {
        super.setY(y);
        sprite.setY(y);
    }

    @Override
    public void setPosition(float x, float y) {
        super.setPosition(x, y);
        sprite.setPosition(x, y);
    }

    @Override
    public void setPosition(float x, float y, int alignment) {
        super.setPosition(x, y, alignment);
        sprite.setPosition(x, y);
    }

    @Override
    public void moveBy(float x, float y) {
        super.moveBy(x, y);
        sprite.setPosition(this.getX() + x, this.getY() + y);
    }

    @Override
    public void setWidth(float width) {
        super.setWidth(width);
        sprite.setScale(width, this.getScaleY());
    }

    @Override
    public void setHeight(float height) {
        super.setHeight(height);
        sprite.setScale(this.getScaleX(), height);
    }

    @Override
    public void setSize(float width, float height) {
        super.setSize(width, height);
        sprite.setSize(width, height);
    }

    @Override
    public void sizeBy(float size) {
        super.sizeBy(size);
        sprite.setSize(this.getWidth() + size, this.getHeight() + size);
    }

    @Override
    public void sizeBy(float width, float height) {
        super.sizeBy(width, height);
        sprite.setSize(this.getWidth() + width, this.getHeight() + height);
    }

    @Override
    public void setScaleX(float scaleX) {
        super.setScaleX(scaleX);
        sprite.setScale(scaleX, this.getScaleY());
    }

    @Override
    public void setScaleY(float scaleY) {
        super.setScaleY(scaleY);
        sprite.setScale(this.getScaleX(), scaleY);
    }

    @Override
    public void setScale(float scaleXY) {
        super.setScale(scaleXY);
        sprite.setScale(scaleXY);
    }

    @Override
    public void setScale(float scaleX, float scaleY) {
        super.setScale(scaleX, scaleY);
        sprite.setScale(scaleX, scaleY);
    }

    @Override
    public void scaleBy(float scale) {
        super.scaleBy(scale);
    }

    @Override
    public void scaleBy(float scaleX, float scaleY) {
        super.scaleBy(scaleX, scaleY);
    }

    @Override
    public void setRotation(float degrees) {
        super.setRotation(degrees);
    }

    @Override
    public void rotateBy(float amountInDegrees) {
        super.rotateBy(amountInDegrees);
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }
}
