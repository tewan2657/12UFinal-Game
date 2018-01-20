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
    
    Texture image;
    float x1, x2;
    float imageScale;
    
    public Background (){
        image = new Texture("cart_background.jpg");
        
        x1 = 0;
        x2 = image.getHeight();
        imageScale = finalgame.WIDTH / image.getWidth();
    }
    
    public void updateAndRender (float deltaTime, SpriteBatch batch){
      batch.draw(image, 0, x1, finalgame.WIDTH, image.getHeight() * imageScale);
      batch.draw(image, 0, x2, finalgame.WIDTH, image.getHeight() * imageScale);
    }
}
