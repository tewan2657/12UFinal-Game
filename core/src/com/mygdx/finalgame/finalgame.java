package com.mygdx.finalgame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class finalgame extends Game {

    private SpriteBatch batch;
   // Texture img;

    @Override
    public void create() {
        
        batch = new SpriteBatch();
      //  img = new Texture("cart_background.jpg");
        MainGame game = new MainGame(this);
        this.setScreen(game);
    }

    @Override
    public void render() {
        super.render();
//        Gdx.gl.glClearColor(0, 0, 0, 1);
//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//        batch.begin();
//        batch.draw(img, 0, 0);
//        batch.end();
       
    }

    @Override
    public void dispose() {
        batch.dispose();
      //  img.dispose();

    }

    public SpriteBatch getBatch() {

        return batch;
    }
}
