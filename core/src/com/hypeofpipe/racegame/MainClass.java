package com.hypeofpipe.racegame;

import com.badlogic.gdx.Game;
import com.hypeofpipe.racegame.screens.Screen;

public class MainClass extends Game {

    private Screen screen;

    @Override
    public void create() {

        screen = new Screen();

        setScreen(screen);

    }
}
