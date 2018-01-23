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

    // INSTANCE Variables
    
    // Speed of the missile
    private static final int SPEED = 400;
    // Width of the missile
    public static final int WIDTH = 300;
    // Height of the missile 
    public static final int HEIGHT = 25;
    // Texture image
    private static Texture texture;

    // CollisionBlock for missile
    CollisionBlock block;

    // x and y coordinates of missile 
    float x, y;
    // Remove missile when they leave screen 
    public boolean remove = false;

    public Missile(float y) {
        //initialize the x and y coordinates
        this.x = Gdx.graphics.getWidth();
        this.y = y;
        //initialize the collision with missile coordinates 
        this.block = new CollisionBlock(x, y, WIDTH, HEIGHT);

        //initialize the texture image;
        if (texture == null) {
            texture = new Texture("missle.png");
        }
    }

    public void update(float deltaTime) {
        //update thier movement
        x -= SPEED * deltaTime;
        //if they go off screen then remove them.  
        if (x < -HEIGHT) {
            remove = true;
        }
        //move the collision block to follow the missile
        block.move(x, y);
    }

    /**
     * render the image
     *
     * @param batch
     */
    public void render(SpriteBatch batch) {
        //draw the missile. 
        batch.draw(texture, x, y);
    }

    /**
     * get the x coordinate of the missile
     *
     * @return x
     */
    public float getX() {
        return x;
    }

    /**
     * get the y coordinate of the missile
     *
     * @return y
     */
    public float getY() {
        return y;
    }

    /**
     * get the collisionBlock of the missile
     *
     * @return block
     */
    public CollisionBlock getBlock() {
        return block;

    }

}
