package com.hypeofpipe.racegame.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by Volodymyr on 5/27/2017.
 */

public class ActorComponent implements Component {

    private Actor actor;

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }
}
