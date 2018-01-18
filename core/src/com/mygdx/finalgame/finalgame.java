package com.mygdx.finalgame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class finalgame extends Game {

    //Dimensions
    public static final int HEIGHT = 600;
    public static final int WIDTH = 1000;
    
    //sprite Batch 
    public SpriteBatch batch;
    public ScrollingBackground scrollingbackground;
    //IMAGE
    Texture img;

    @Override
    public void create() {

        batch = new SpriteBatch();
        this.scrollingbackground = new ScrollingBackground();
        MainGame game = new MainGame(this);
        img = new Texture("cart_background.jpg");
        this.setScreen(game);
    }

    @Override
    public void render() {
        super.render();
//        Gdx.gl.glClearColor(0, 0, 0, 1);
//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//        batch.begin();
//        
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();

    }
    @Override
    public void resize(int width, int height){
        super.resize(width, height);
    }

    public SpriteBatch getBatch() {
        return batch;
    }
}
