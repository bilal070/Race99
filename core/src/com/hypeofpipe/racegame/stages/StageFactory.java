package com.hypeofpipe.racegame.stages;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.Observable;

/**
 * Created by Volodymyr on 5/15/2017.
 */

public class StageFactory extends Observable {

    private Viewport viewport;

    public enum StageType {
        startStage, loadingStage, menuStage, gameStage, scoreStage
    }

    public StageFactory(Viewport viewport, StageManager stageManager) {
        this.viewport = viewport;
        addObserver(stageManager);
    }

    public Stage createStartStage() {
        Stage stage = createStage();
        stage.setViewport(viewport);
        return stage;
    }

    public Stage createLoadingStage() {
        Stage stage = createStage();
        stage.setViewport(viewport);
        return stage;
    }

    public Stage createMenuStage() {
        Stage stage = createStage();
        stage.setViewport(viewport);
        return stage;
    }

    public Stage gameStage() {
        Stage stage = createStage();
        stage.setViewport(viewport);
        return stage;
    }

    public Stage createScoreStage() {
        Stage stage = createStage();
        stage.setViewport(viewport);
        return stage;
    }

    private Stage createStage() {
        return new Stage(viewport);
    }

}
