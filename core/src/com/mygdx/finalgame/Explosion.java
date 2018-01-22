/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.finalgame;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

/**
 *
 * @author Adars
 */
public class Explosion {
    // x and y coordinate locations
    float x, y;
    //animation time
    private float elapsedTime;
    //Texture region for the explosion
    private Animation<TextureRegion> bomb;

    private TextureAtlas atlas;

    public Explosion(float x, float y) {
        //initialize the x and y coordinate locations for the explosion
        this.x = x;
        this.y = y;
        
        //initialize animation time
        this.elapsedTime = 0;
        
        //initialize the Texture atlas
        this.atlas = new TextureAtlas("racked/explosion.atlas");
       
        //Initialize the animation(frames)
        bomb = new Animation(1f / 10f, atlas.findRegions("bomb"));
        
        Array<AtlasRegion> bombFrames = atlas.findRegions("bomb");
        for (int i = 0; i < bombFrames.size; i++) {
            bombFrames.get(i).flip(true, false);      
        }
        
        
    }
    /**
     * update the elapsed time
     * @param deltaTime 
     */
    public void update(float deltaTime){   
     elapsedTime += deltaTime;   
    }
    
   
    /**
     * Render the Bomb animation 
     * @param batch 
     */
    public void render(SpriteBatch batch){
    //Draw the animation
     batch.draw(bomb.getKeyFrame(elapsedTime, true), x, y);
    
    }
    
    /**
     * 
     */
    public void dispose(){
     atlas.dispose();
    }
}
