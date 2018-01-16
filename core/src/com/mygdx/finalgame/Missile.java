/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.finalgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 *
 * @author Adars
 */
public class Missile {

    private static final int SPEED = 500;
    public static final int WIDTH = 16;
    public static final int HEIGHT = 16;
    private static Texture texture;

    float x, y;
    public boolean remove = false;

    public Missile(float x) {
        this.x = x;
        this.y = Gdx.graphics.getHeight();

        if (texture == null) 
            texture = new Texture("figure_8.png");
        
    }

    public void update(float deltaTime) {
        y -= SPEED * deltaTime;
        if(y < -HEIGHT){
            remove = true;
        }
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, x, y);
    }
}
