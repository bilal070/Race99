package com.hypeofpipe.racegame.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.hypeofpipe.racegame.utilities.StageManager;

/**
 * Created by Volodymyr on 10.04.2017.
 */

public class Screen implements com.badlogic.gdx.Screen {

    private FitViewport viewport;
    private Camera camera;
    private StageManager stageManager;
    private SpriteBatch batch;
    private Texture texture = new Texture("test.png");

    public Screen() {
        batch = new SpriteBatch();
        viewport = new FitViewport(1024, 768);
        camera = new OrthographicCamera(viewport.getScreenWidth(), viewport.getScreenHeight());
        camera.position.set(viewport.getScreenWidth(), viewport.getScreenHeight(), 0.0f);
        viewport.setCamera(camera);
        stageManager = StageManager.getInstance(viewport);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        camera.update();

        batch.setProjectionMatrix(camera.combined);

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stageManager.draw(batch);
        batch.begin();
        batch.draw(texture, 0, 0);
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
