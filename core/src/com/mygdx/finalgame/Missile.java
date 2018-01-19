/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.finalgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

/**
 *
 * @author Adars
 */
public class Missile {
    //INSTANCE Variables
    //Speed of the missile
    private static final int SPEED = 400;
    //width of the missile
    public static final int WIDTH = 400;
    //height of the missile 
    public static final int HEIGHT = 25;
    //Texture image
    private static Texture texture;

    // x and y coordinates of missile 
    float x, y;
    //Remove missile when they leave screen 
    public boolean remove = false;
    
    private Rectangle col;

    public Missile(float y) {
        //initialize the x and y coordinates
        this.x = Gdx.graphics.getWidth();
        this.y = y;

        
        if (texture == null) 
            texture = new Texture("missle.png");
        this.col = new Rectangle(x,y, texture.getWidth(), texture.getHeight());
    }

    public void update(float deltaTime) {
        //update thier movement
        x -= SPEED * deltaTime;
        //if they go off screen then remove them.  
        if(x < -HEIGHT){
            remove = true;
        }
    }
  
    public void render(SpriteBatch batch) {
        //draw the missile. 
        batch.draw(texture, x, y);
    }
}
