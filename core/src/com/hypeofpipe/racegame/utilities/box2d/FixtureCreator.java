package com.hypeofpipe.racegame.utilities.box2d;

import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.Shape;

/**
 * Created by Volodymyr on 5/11/2017.
 */

public class FixtureCreator {

    public static Fixture createFixture(Body body, Shape shape, Vector3 densityRestitutionFriction) {
        Fixture fixture = body.createFixture(FixtureCreator.createFixtureDef(shape, densityRestitutionFriction.x, densityRestitutionFriction.y, densityRestitutionFriction.z));
        return fixture;
    }

    private static FixtureDef createFixtureDef(Shape shape, float density, float restitution, float friction) {
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = density;
        fixtureDef.restitution = restitution;
        fixtureDef.friction = friction;
        return fixtureDef;
    }

}
