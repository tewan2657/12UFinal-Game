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

    float x, y;
    private float elapsedTime;
    private Animation<TextureRegion> bomb;

    private TextureAtlas atlas;

    public Explosion(float x, float y) {

        this.x = x;
        this.y = y;
        
        this.elapsedTime = 0;
        this.atlas = new TextureAtlas("racked/bomb.atlas");
       
        bomb = new Animation(1f /10f, atlas.findRegion("bomb"));
        
        Array<AtlasRegion> bombFrames = atlas.findRegions("bomb");
        for (int i = 0; i < bombFrames.size; i++) {
            bombFrames.get(i).flip(true, false);
            
        }
        
        
    }
    
   
    public void render(SpriteBatch batch){
    batch.draw(bomb.getKeyFrame(elapsedTime, true), x, y);
    
    }
    
    public void dispose(){
     atlas.dispose();
    }
}
