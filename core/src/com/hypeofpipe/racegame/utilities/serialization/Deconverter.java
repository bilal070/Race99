package com.hypeofpipe.racegame.utilities.serialization;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Json;

/**
 * Created by Volodymyr on 5/12/2017.
 */

public class Deconverter {
    private Json json;
    private FileHandle fileHandle;

    public Deconverter() {
        json = new Json();
    }

    public Stage txtToStage(String name) {
        Stage stage;
        fileHandle = new FileHandle(name);
        stage = json.fromJson(Stage.class, fileHandle);
        return stage;
    }
}
