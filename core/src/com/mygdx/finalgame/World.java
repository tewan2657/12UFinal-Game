/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.finalgame;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

/**
 *
 * @author Adars
 */
public class World {
    private Rectangle [] lasers;
    private ShapeRenderer shape;
  
    public World(){
        lasers = new Rectangle[4];
        lasers[0]= new Rectangle(100,100,20,100);
        lasers[1]=new Rectangle(110,110,30,110);
        lasers[2]=new Rectangle(120,10,50,110);
        lasers[3]=new Rectangle(50,300,60,130);   
        shape = new ShapeRenderer();
    }
    public void render(){
        shape.begin(ShapeRenderer.ShapeType.Filled);
        for (int i = 0; i <lasers.length; i++) {
            shape.rect(lasers[i].x, lasers[i].y, lasers[i].width, lasers[i].height);
        }
        shape.end();
        
    }
    public Rectangle[] getLasers(){
        return lasers;
}
}

