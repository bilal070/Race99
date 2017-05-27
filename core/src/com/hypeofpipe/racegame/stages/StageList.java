package com.hypeofpipe.racegame.stages;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ArrayMap;

/**
 * Created by Volodymyr on 5/14/2017.
 */

public class StageList {

    private ArrayMap<String, Stage> stageArrayMap;

    public StageList() {
        stageArrayMap = new ArrayMap<String, Stage>(50);
    }

    public void addStage(Stage stage, String name) {
        stageArrayMap.put(name, stage);
    }


    public Stage getStageByName(String name) {
        return stageArrayMap.get(name);
    }

    public Stage getStageByIndex(int index) {
        return stageArrayMap.getValueAt(index);
    }

    public void removeStageByName(Stage stage, String name) {
        stageArrayMap.removeValue(stage, false);
    }

    public String[] getAllKeys() {
        return stageArrayMap.keys;
    }
}
