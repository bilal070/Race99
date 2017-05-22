package com.hypeofpipe.racegame.stages;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.hypeofpipe.racegame.gameobjects.GameObjectFactory;

/**
 * Created by Volodymyr on 5/15/2017.
 */

public class StageFactory {

    private Viewport viewport;

    public enum StageType{
        startStage, loadingStage, menuStage, gameStage, scoreStage;
    }

    public StageFactory(Viewport viewport){
        this.viewport = viewport;
    }

    public Stage createStartStage(){
        Stage stage = createStage();
        stage.setViewport(viewport);
        stage.addActor(GameObjectFactory.createGameObject(new Vector2(0, 0),
                new Texture("background.png")));
        return stage;
    }

    public Stage createLoadingStage(){
        Stage stage = createStage();
        stage.setViewport(viewport);
        return stage;
    }

    public Stage createMenuStage(){
        Stage stage = createStage();
        stage.setViewport(viewport);
        return stage;
    }

    public Stage gameStage(){
        Stage stage = createStage();
        stage.setViewport(viewport);
        return stage;
    }

    public Stage createScoreStage(){
        Stage stage = createStage();
        stage.setViewport(viewport);
        return stage;
    }

    private Stage createStage(){
        return new Stage(viewport);
    }

}
