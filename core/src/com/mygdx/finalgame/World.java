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
    private Rectangle [] barrier;
    private Rectangle [] lasers;
    private ShapeRenderer shape;
  
    public World(){
        //initialize the barriers
        barrier = new Rectangle[2];
        //ROOF
        barrier[0]= new Rectangle(0, 600, 1000, 10);
        //GROUND
        barrier[1]= new Rectangle(0, 0, 1000, 5);
        
        //random Generator for y location of lasers
        Random Generator = new Random();
        
        int randY = Generator.nextInt(900 + 1 - 0)+ 0;
        
        //Initialize the lasers 
        lasers = new Rectangle[2];
        
        lasers[0] = new Rectangle(598, randY, 100, 200); 
        lasers[1] = new Rectangle(567, randY, 10, 100);
       
        shape = new ShapeRenderer();
    }
    public void render(){
        shape.begin(ShapeRenderer.ShapeType.Filled);
        for (int i = 0; i < barrier.length; i++) {
            shape.rect(barrier[i].x, barrier[i].y, barrier[i].width, barrier[i].height);
        }
        for (int i = 0; i < lasers.length; i++) {
            shape.rect(lasers[i].x, lasers[i].y, lasers[i].width, lasers[i].height);
        }
        shape.end();
        
    }
    public Rectangle[] getBarrier(){
        return barrier;
}
    public Rectangle[] getLasers(){
        return lasers;
    }
}

