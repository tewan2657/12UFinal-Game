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
    
    // x and y coordinates of the collision block 
    float x,y;
    // width and height of the collision block 
    int width, height;
    
    /**
     * Constructor of the CollisionBlock class
     * @param x
     * @param y
     * @param width
     * @param height 
     */
    public CollisionBlock(float x, float y, int width, int height){
       //initialize the x and y coordinates 
        this.x = x;
        this.y = y;
        
        //initialize the width and height of the collision block; 
        this.width = width;
        this.height = height;
    }
    
    /**
     * Method to move the collision to follow other objects 
     * @param x
     * @param y 
     */
    public void move(float x, float y){
        //initialize the x and y coordinates of the other objects being passed through 
        this.x = x;
        this.y = y;
    }
    /**
     * collision method with two or more collisionBlocks 
     * @param block
     * @return true if both blocks collide 
     */
    public boolean collidesWith (CollisionBlock block){
            // if the blocks collide, return true 
            if(( x + block.width > block.x)&&
            (x <= block.x + block.width)&&
            (y + block.height >= block.y)&&    
            (y <= block.y + block.height)){   
          return true;
    }
      // return false if there is no collision 
      return false;    
}
   
}
