package com.hypeofpipe.racegame.utilities;

import com.badlogic.ashley.core.Entity;
import com.hypeofpipe.racegame.components.ActorComponent;
import com.hypeofpipe.racegame.components.PositionComponent;
import com.hypeofpipe.racegame.components.SpriteComponent;

/**
 * Created by Volodymyr on 5/27/2017.
 */

public class EntityCreator {

    public enum EntityType {
        Image, Car
    }

    public Entity createEntity(EntityType entityType) {
        Entity entity = new Entity();
        switch (entityType) {
            case Image:
                entity.add(new SpriteComponent());
                entity.add(new PositionComponent());
                entity.add(new ActorComponent());
                break;
        }
        return entity;
    }
}
