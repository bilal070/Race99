package com.hypeofpipe.racegame.gameobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.hypeofpipe.racegame.enums.GameObjectENum;

import java.util.ArrayList;

/**
 * Created by Volodymyr on 30.04.2017.
 */

public class GameObject extends Actor {

    private Texture texture;
    private BodyDef bodyDef;
    private Body body;
    private FixtureDef fixtureDef;
    private Fixture fixture;
    private GameObjectENum gameObjectENum;
    private World world;

    public GameObject(World world) {
        texture = new Texture("null_texture.png");
        setSize(texture.getWidth(), texture.getHeight());
        bodyDef = createBodyDef(BodyDef.BodyType.DynamicBody, new Vector2(getX(), getY()));
        body = world.createBody(bodyDef);
        fixture = body.createFixture(createFixtureDef(createShape(Shape.Type.Polygon), 0.5f, 0.5f, 0.5f));
    }

    public GameObject(Texture texture, float density, float friction, float restitution, GameObjectENum gameObjectENum, Shape.Type shapeType, World world) {
        this.texture = texture;
        this.gameObjectENum = gameObjectENum;
        this.world = world;
        switch (gameObjectENum) {
            case Dynamic:
                bodyDef = createBodyDef(BodyDef.BodyType.DynamicBody, new Vector2(getX(), getY()));
                body = world.createBody(bodyDef);
                fixture = body.createFixture(createFixtureDef(createShape(shapeType), density, restitution, friction));
                break;
            case Static:
                break;
            case Kinematic:
                break;
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        setPosition(body.getPosition().x, body.getPosition().y);
        batch.draw(texture, getX(), getY());
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        setPosition(body.getPosition().x, body.getPosition().y);
    }

    private BodyDef createBodyDef(BodyDef.BodyType bodyType, Vector2 position) {
        BodyDef bodyDef_ = new BodyDef();
        bodyDef_.type = bodyType;
        bodyDef_.position.set(position);
        return bodyDef_;
    }

    private Shape createShape(Shape.Type shapeType) {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        switch (shapeType) {
            case Edge:
            case Chain:
            case Polygon:
                PolygonShape shape;
                shape = new PolygonShape();
                shape.setAsBox(texture.getWidth(), texture.getHeight());
                arrayList.add(shape);
                break;
            case Circle:
                CircleShape circleShape;
                circleShape = new CircleShape();
                circleShape.setRadius((texture.getHeight() + texture.getWidth()) / 2);
                arrayList.add(circleShape);
                break;
        }
        return (Shape) arrayList.get(0);
    }

    private FixtureDef createFixtureDef(Shape shape, float density, float restitution, float friction) {
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = density;
        fixtureDef.restitution = restitution;
        fixtureDef.friction = friction;
        return fixtureDef;
    }
}
