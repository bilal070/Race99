package com.hypeofpipe.racegame.utilities.serialization;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Json;
/**
 * Created by Volodymyr on 5/12/2017.
 */

public class Converter {

    private Json json;
    private FileHandle fileHandle;

    public Converter(){
        json = new Json();
    }

    public String stageToTxt(Stage stage, String name){
        String txt = json.prettyPrint(stage);
        fileHandle = new FileHandle(name);
        fileHandle.writeString(txt, true);
        return txt;
    }
}
