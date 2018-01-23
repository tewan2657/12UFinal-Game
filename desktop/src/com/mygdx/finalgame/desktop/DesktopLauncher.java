package com.mygdx.finalgame.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;

import com.mygdx.finalgame.finalgame;
public class DesktopLauncher {

    public static void main(String[] arg) {

        //TexturePacker.process("raw", "packed", "player");
        //TexturePacker.process("bomb", "racked", "explosion");
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = 1000;
        config.height = 600;
        new LwjglApplication(new finalgame(), config);

    }
}
