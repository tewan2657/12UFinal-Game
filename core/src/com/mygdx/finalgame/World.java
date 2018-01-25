/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.finalgame;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import java.util.Random;

/**
 *
 * @author Adars
 */
public class World {
    //World Barriers where player can not go 
    private Rectangle [] barrier;

    //Shape Rendering
    private ShapeRenderer shape;
  
    public World(){
        //initialize the barriers
        barrier = new Rectangle[2];
        //ROOF barrier
        barrier[0]= new Rectangle(0, 600, 1000, 10);
        //GROUND barrier
        barrier[1]= new Rectangle(0, 0, 1000, 5);
        
        //initialize the shape renderer.
        shape = new ShapeRenderer();
    }
    /**
     * render method to render the shapes created
     */
    public void render(){
        //Render the shapes 
        shape.begin(ShapeRenderer.ShapeType.Filled);
        for (int i = 0; i < barrier.length; i++) {
            shape.rect(barrier[i].x, barrier[i].y, barrier[i].width, barrier[i].height);
        }
        shape.end();   
    }
    
    /**
     * get the barriers 
     * @return barrier
     */
    public Rectangle[] getBarrier(){
        return barrier;
}

}

