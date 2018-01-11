package com.mygdx.finalgame.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import com.badlogic.gdx.tools.texturepacker.TexturePacker.Settings;
import com.mygdx.finalgame.finalgame;

public class DesktopLauncher {
	public static void main (String[] arg) {
            
         
             // TexturePacker.process("raw", "packed", "player");

		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new finalgame(), config);
                
                
                
	}
}
