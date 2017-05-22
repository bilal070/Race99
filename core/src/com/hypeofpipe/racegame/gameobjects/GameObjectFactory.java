package com.hypeofpipe.racegame.gameobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.physics.box2d.World;
import com.hypeofpipe.racegame.utilities.box2d.BodyCreator;

/**
 * Created by Volodymyr on 5/15/2017.
 */

public class GameObjectFactory {

    public static GameObject createGameObjectWithBox2DBody(Vector2 gameObjectPos, Texture texture, Vector3 densityFrictionRestitution,
                                       BodyDef.BodyType bodyType, Shape.Type shapeType,
                                       World world) {
        GameObject gameObject = new GameObject();
        gameObject.setPosition(gameObjectPos.x, gameObjectPos.y);
        gameObject.setTexture(texture);
        gameObject.setSprite(new Sprite(texture));
        gameObject.getSprite().setOriginCenter();
        gameObject.setWorld(world);
        BodyCreator bodyCreator = new BodyCreator();
        gameObject.setBody(bodyCreator.createBody(new Vector2(gameObject.getX(), gameObject.getY()), texture, bodyType, world, shapeType, densityFrictionRestitution));
        bodyCreator = null;
        return gameObject;
    }

    public static GameObjectBodyless createGameObject(Vector2 gameObjectPos, Texture texture){
        GameObjectBodyless gameObject = new GameObjectBodyless(texture);
        gameObject.setPosition(gameObjectPos.x, gameObjectPos.y);
        return gameObject;
    }


}
