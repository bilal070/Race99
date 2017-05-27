package com.hypeofpipe.racegame.screens;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.hypeofpipe.racegame.components.ActorComponent;
import com.hypeofpipe.racegame.components.SpriteComponent;
import com.hypeofpipe.racegame.stages.StageManager;
import com.hypeofpipe.racegame.utilities.EntityCreator;

/**
 * Created by Volodymyr on 10.04.2017.
 */

public class Screen implements com.badlogic.gdx.Screen {

    private FitViewport viewport;
    private Camera camera;
    private StageManager stageManager;
    private SpriteBatch batch;
    private World world;
    private Engine engine;
    private Entity testEntity;
    private Box2DDebugRenderer box2DDebugRenderer;

    public Screen() {
        batch = new SpriteBatch();
        viewport = new FitViewport(1024, 768);
        camera = new OrthographicCamera(viewport.getScreenWidth(), viewport.getScreenHeight());
        camera.position.set(viewport.getScreenWidth(), viewport.getScreenHeight(), 0.0f);
        viewport.setCamera(camera);
        stageManager = StageManager.getInstance(viewport, world);
        world = new World(new Vector2(0, -10), false);
        engine = new Engine();
        testEntity = new EntityCreator().createEntity(EntityCreator.EntityType.Image);
        testEntity.getComponent(ActorComponent.class).setActor(new Actor(){
            @Override
            public void draw(Batch batch, float parentAlpha) {
                super.draw(batch, parentAlpha);
                testEntity.getComponent(SpriteComponent.class).getSprite().draw(batch);
            }
        });
        testEntity.getComponent(SpriteComponent.class).setSprite(new Sprite(new Texture("car_prototype.png")));
        engine.addEntity(testEntity);
        stageManager.getActiveStage().addActor(testEntity.getComponent(ActorComponent.class).getActor());
        box2DDebugRenderer = new Box2DDebugRenderer();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        stageManager.act();
        world.step(1 / 60f, 6, 2);
        engine.update(delta);
        camera.update();

        batch.setProjectionMatrix(camera.combined);
        box2DDebugRenderer.render(world, camera.combined);

        batch.begin();
        stageManager.draw(batch, 0);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
        camera.update();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

}
