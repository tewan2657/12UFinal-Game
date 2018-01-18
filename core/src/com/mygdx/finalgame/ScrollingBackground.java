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
public class ScrollingBackground {
    
    public static final int SPEED = 80;
    public static final int ACCELERATION = 50;
    public static final int MAX_ACCELERATION = 200;
    
    Texture image;
    float y1, y2;
    int speed;
    int maxSpeed;
    float imageScale;
    
    
    public ScrollingBackground(){
        image = new Texture("unnamed.png");
        
        y1 = 0;
        y2 = image.getHeight();
        speed = 0;
        maxSpeed = SPEED;
        imageScale = finalgame.WIDTH / image.getWidth();
        
    }
    
    public void updateAndRender(float deltaTime, SpriteBatch batch){
     if(speed < maxSpeed){
         speed += MAX_ACCELERATION * deltaTime;
         if(speed > maxSpeed)
             speed = maxSpeed;
     }else if(speed > maxSpeed){
         speed -= MAX_ACCELERATION * deltaTime;
         if(speed < maxSpeed)
             speed = maxSpeed;
     }
     //Update the speed
     y1 -= speed * deltaTime;
     y2 -= speed * deltaTime;
     
     //if Image leaves the screen
     if(y1 + image.getHeight() * imageScale <= 0)
         y1 = y2 + image.getHeight() * imageScale;
     
      if(y2 + image.getHeight() * imageScale <= 0)
         y2 = y1 + image.getHeight() * imageScale;
      
      //RENDER
      batch.draw(image, 0, y1, finalgame.WIDTH, image.getHeight() * imageScale);
      batch.draw(image, 0, y2, finalgame.WIDTH, image.getHeight() * imageScale);
     
    }
  
    
}
