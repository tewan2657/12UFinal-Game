package com.mygdx.finalgame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class finalgame extends Game {

    private SpriteBatch batch;
   // Texture img;
    
    @Override
    public void create() {
        //lasers = new
       batch = new SpriteBatch();
      //  img = new Texture("cart_background.jpg");
        MainGame game = new MainGame(this);
        this.setScreen(game);
       // lasers = new Sprite()
    }

    @Override
    public void render() {
        super.render();

       
    }

    @Override
    public void dispose() {
        batch.dispose();
     

    }

    public SpriteBatch getBatch() {

        return batch;
    }
}
