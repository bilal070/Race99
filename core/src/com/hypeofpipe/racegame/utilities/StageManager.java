package com.hypeofpipe.racegame.utilities;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.hypeofpipe.racegame.gameobjects.test;

/**
 * Created by Volodymyr on 11.04.2017.
 */

public class StageManager implements Drawable, Logicable {

    private static StageManager stageManager;
    private Stage activeStage;

    private StageManager(FitViewport viewport) {
        activeStage = new Stage(viewport);
        activeStage.addActor(new test());
    }

    public static StageManager getInstance(FitViewport viewport) {
        if (stageManager == null) {
            stageManager = new StageManager(viewport);
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
    public void draw(Batch batch) {
        activeStage.draw();
    }
}
