package com.hypeofpipe.racegame.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2D;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.hypeofpipe.racegame.enums.GameObjectENum;
import com.hypeofpipe.racegame.gameobjects.GameObject;
import com.hypeofpipe.racegame.utilities.StageManager;

/**
 * Created by Volodymyr on 10.04.2017.
 */

public class Screen implements com.badlogic.gdx.Screen {

    private FitViewport viewport;
    private Camera camera;
    private StageManager stageManager;
    private SpriteBatch batch;
    private World world;
    private Box2DDebugRenderer box2DDebugRenderer;
    private GameObject gameObject;

    public Screen() {
        batch = new SpriteBatch();
        viewport = new FitViewport(1024, 768);
        camera = new OrthographicCamera(viewport.getScreenWidth(), viewport.getScreenHeight());
        camera.position.set(viewport.getScreenWidth(), viewport.getScreenHeight(), 0.0f);
        viewport.setCamera(camera);
        stageManager = StageManager.getInstance(viewport, world);
        world = new World(new Vector2(0, -10), false);
        Box2D.init();
        box2DDebugRenderer = new Box2DDebugRenderer();
    }

    @Override
    public void show() {
        gameObject = new GameObject(new Texture("null_texture.png"), 0.5f, 0.5f, 0.5f, GameObjectENum.Dynamic, Shape.Type.Polygon, world);
        gameObject.setPosition(300, 300);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        world.step(1 / 60f, 6, 2);
        camera.update();

        batch.setProjectionMatrix(camera.combined);
        box2DDebugRenderer.render(world, camera.combined);

        batch.begin();
        gameObject.draw(batch, 0);
        //stageManager.draw(batch, 0);
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
