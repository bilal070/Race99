package com.hypeofpipe.racegame.stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.hypeofpipe.racegame.gameobjects.GameObject;
import com.hypeofpipe.racegame.gameobjects.GameObjectBodyless;
import com.hypeofpipe.racegame.gameobjects.GameObjectFactory;

import java.lang.reflect.InvocationTargetException;
import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Volodymyr on 5/15/2017.
 */

public class StageFactory extends Observable {

    private Viewport viewport;

    public enum StageType{
        startStage, loadingStage, menuStage, gameStage, scoreStage;
    }

    public StageFactory(Viewport viewport, StageManager stageManager){
        this.viewport = viewport;
        addObserver(stageManager);
    }

    public Stage createStartStage(){
        Stage stage = createStage();
        stage.setViewport(viewport);
        stage.addActor(new GameObjectBodyless(new Texture("splash_screen1.png")){

            private int i = 100;
            private int counter = 0;

            @Override
            public void act(float delta) {
                super.act(delta);
                if (i < 0){
                    i = 100;
                    counter++;
                    if (counter == 2){
                        remove();
                        setChanged();
                        notifyObservers("StartStageEnd");
                    }
                    setTexture(new Texture("splash_screen2.png"));
                    setSprite(new Sprite(getTexture()));
                } else if (i >= 0) {
                    i--;
                }
            }
        });
        return stage;
    }

    public Stage createLoadingStage(){
        Stage stage = createStage();
        stage.setViewport(viewport);
        stage.addActor(new GameObjectBodyless(new Texture("default_background.png")));
        GameObjectBodyless gameObjectBodyless = new GameObjectBodyless(new Texture("loading_screen_part1.png")){
            @Override
            public void act(float delta) {
                super.act(delta);
                getSprite().setOriginCenter();
                getSprite().rotate(3);
            }
        };
        gameObjectBodyless.setPosition(viewport.getScreenWidth() - gameObjectBodyless.getSprite().getWidth(),
                viewport.getScreenHeight() - gameObjectBodyless.getSprite().getHeight());
        stage.addActor(gameObjectBodyless);
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
