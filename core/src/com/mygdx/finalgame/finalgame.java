package com.mygdx.finalgame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class finalgame extends Game {

    //Dimensions of the game 
    public static final int HEIGHT = 600;
    public static final int WIDTH = 1000;
    
    //sprite Batch 
    public SpriteBatch batch;
    
    //Background 
    public Background background;
    
    //IMAGE
    Texture img;
    
    private Music music;

    /**
     * 
     */
    @Override
    public void create() {
        //initialize the sprite batch
        batch = new SpriteBatch();
        //initialize the background 
        this.background = new Background();
        //initialize the Main Game
        MainGame game = new MainGame(this);
        //Set the background image
        img = new Texture("cart_background.jpg");
        //set the screen 
        this.setScreen(game);
        
        music = Gdx.audio.newMusic(Gdx.files.internal("Beats.mp3"));
        music.setLooping(true);
        music.setVolume(0.6f);
        music.play();
    }

    /**
     * Render the game
     */
    @Override
    public void render() {
        super.render();
      
    }

    /**
     * dispose the batch and image
     */
    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
        music.dispose();

    }
    /**
     * 
     * @param width
     * @param height 
     */
    @Override
    public void resize(int width, int height){
        super.resize(width, height);
    }

    /**
     * get the spriteBatch
     * @return batch
     */
    public SpriteBatch getBatch() {
        return batch;
    }
}
