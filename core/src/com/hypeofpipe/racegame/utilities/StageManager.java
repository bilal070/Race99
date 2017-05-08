package com.hypeofpipe.racegame.utilities;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;

/**
 * Created by Volodymyr on 11.04.2017.
 */

public class StageManager implements Drawable, Logicable {

    private static StageManager stageManager;
    private Stage activeStage;
    private World world;

    private StageManager(FitViewport viewport) {
        activeStage = new Stage(viewport);
    }

    public static StageManager getInstance(FitViewport viewport, World world) {
        if (stageManager == null) {
            stageManager = new StageManager(viewport);
            stageManager.world = world;
        }
        return stageManager;
    }

    public Stage getActiveStage() {
        return activeStage;
    }

    public void setActiveStage(Stage activeStage) {
        this.activeStage = activeStage;
    }

    @Override
    public void act() {
        activeStage.act();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        activeStage.draw();
    }
}
