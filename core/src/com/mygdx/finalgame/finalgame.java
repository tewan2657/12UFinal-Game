package com.mygdx.finalgame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class finalgame extends Game {
	private SpriteBatch batch;
	
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		//this.setScreen(game);
	}

	@Override
	public void render () {
	super.render();
        }
	
	@Override
	public void dispose () {
		batch.dispose();
		
	}
        
        public SpriteBatch getBatch(){
            
            return batch;
        }
}
