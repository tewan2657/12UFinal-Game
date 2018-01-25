/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.finalgame;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 *
 * @author Adars
 */
public class Background {
    // Background Texture Image 
    Texture image; 
    // x coordinates of the image
    float x, x2;
    //ImageScale to fix the background and resize with game dimensions 
    float imageScale;
    
    /**
     * constructor for the background class
     */
    public Background (){
        //initialize the background texture image 
        image = new Texture("cart_background.jpg");
        
        // initilaize the x coordinates
        x = image.getHeight();
        x2 = 0;
        //initialize the image Scale 
        imageScale = finalgame.WIDTH / image.getWidth();
    }
    
    /** 
     * Draw the background image 
     * @param deltaTime
     * @paruam batch 
     */
    public void updateAndRender (float deltaTime, SpriteBatch batch){
        //draw image
      batch.draw(image, 0, x, finalgame.WIDTH, image.getHeight() * imageScale);
      batch.draw(image, 0, x2, finalgame.WIDTH, image.getHeight() * imageScale);

    }
}
