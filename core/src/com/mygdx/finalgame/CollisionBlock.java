/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.finalgame;

import com.badlogic.gdx.math.Rectangle;

/**
 *
 * @author Adars
 */
public class CollisionBlock {
    
    
    float x,y;
    int width, height;
    
    public CollisionBlock(float x, float y, int width, int height){
        
        
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    public void move(float x, float y){
        this.x = x;
        this.y = y;
    }
    
    public boolean collidesWith (CollisionBlock block){
            if(( x + block.width > block.x)&&
            (x <= block.x + block.width)&&
            (y + block.height >= block.y)&&    
            (y <= block.y + block.height)){   
          return true;
    }
      return false;
    
}
    
    
}
