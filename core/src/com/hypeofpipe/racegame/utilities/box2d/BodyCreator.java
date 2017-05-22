package com.hypeofpipe.racegame.utilities.box2d;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.physics.box2d.World;

import java.util.ArrayList;

/**
 * Created by Volodymyr on 5/9/2017.
 */

public class BodyCreator {

    private BodyDef bodyDef;
    private Body body;
    private Texture texture;

    public Body createBody(Vector2 position, Texture texture, BodyDef.BodyType bodyType, World world, Shape.Type shape, Vector3 densityRestitutionFriction) {
        this.texture = texture;
        bodyDef = createBodyDef(bodyType, position);
        body = world.createBody(bodyDef);
        FixtureCreator.createFixture(body, createShape(shape), densityRestitutionFriction);
        return body;
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
                shape.setAsBox(texture.getWidth() / 2, texture.getHeight() / 2, new Vector2(texture.getWidth() / 2, texture.getHeight() / 2), 0);
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

}
