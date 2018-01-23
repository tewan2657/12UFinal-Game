/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.finalgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

/**
 *
 * @author Adars
 */
public class Player {

    //Width and Height of the Player
    public static final int WIDTH = 20;
    public static final int HEIGHT = 86;

    // x and y coordinate locations
    private float x;
    private float y;

    //
    private float dx;
    private float dy;

    //animation time; 
    private float elapsed;

    //Run animation 
    private Animation<TextureRegion> run;
    private Animation<TextureRegion> runL;

    //Stand Texture
    private TextureRegion stand;
    private TextureRegion standL;

    //Texture atlas 
    private TextureAtlas atlas;

    //Rectangle collision
    private Rectangle col;

    /**
     * Constructor for the player class
     *
     * @param x coordinate of player
     * @param y coordinate of player
     */
    public Player(float x, float y) {

        // initialize the x and y coordinate locations
        this.x = x;
        this.y = y;

        //
        this.dx = 0;
        this.dy = 0;

        //initialize the elapsed time for animation
        this.elapsed = 0;

        //initialize the Texture atlas
        this.atlas = new TextureAtlas("packed/player.atlas");

        //initialize the Stand texture region image
        this.stand = atlas.findRegion("stand");

        //initialize the run animation(Frame
        run = new Animation(1f / 10f, atlas.findRegions("run"));

        Array<AtlasRegion> runLFrames = atlas.findRegions("run");
        for (int i = 0; i < runLFrames.size; i++) {
            runLFrames.get(i).flip(true, false);
        }
        runL = new Animation(1f / 10f, runLFrames);

        //collision rectangle for player 
        this.col = new Rectangle(x, y, stand.getRegionWidth(), stand.getRegionHeight());
    }

    /**
     * returns the x axis location variable for player
     *
     * @return x
     */
    public float getX() {
        return x;
    }

    /**
     * returns the y axis location variable for player
     *
     * @return y
     */
    public float getY() {
        return y;
    }

    public void update(float deltaTime) {
        //if user presses SPACEBAR then player moves vertically upwards.
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            //speed  
            this.dy = +5;
            //update the elapsed time 
            this.elapsed = this.elapsed + deltaTime;
            // if SPACEBAR is not being pressed then player comes back down. 
        } else {
            //speed  
            this.dy = -4;
            //update the elapsed time
            this.elapsed = this.elapsed + deltaTime;
        }

        //update the y coordinate to make player move up 
        this.y = this.y + this.dy;

        //Rectangle block set at player x and y coordinates
        this.col.setX(this.x);
        this.col.setY(this.y);

    }

    /**
     *
     * @param block check for collisions
     */
    public void fixCollision(Rectangle block) {
        //WORLD BARRIER COLLISIONS 
        if (col.overlaps(block)) {
            float width = Math.min(col.x + col.width, block.x + block.width) - Math.max(col.x, block.x);
            float height = Math.min(col.y + col.height, block.y + block.height) - Math.max(col.y, block.y);
            if (width < height) {

                if (this.x < block.x) {
                    // move player to the left
                    this.x = this.x - width;
                } else {
                    // move player to the right 
                    this.x = this.x + width;
                }
            } else {
                if (this.y < block.y) {
                    // move the player down
                    this.y = this.y - height;

                } else {

                    // move player up 
                    this.y = this.y + height;
                }
            }
            //update the collision rectangle to equal the player coordinates
            col.setX(this.x);
            col.setY(this.y);
        }

    }

    public void render(SpriteBatch batch) {

        //if player is standing 
        if (this.dx == 0) {
            //draw the stand image
            batch.draw(stand, x, y);
            //if player is running 
        } else if (this.dx > 0) {
            //draw the run animation
            batch.draw(run.getKeyFrame(elapsed, true), x, y);

        }
    }

    /**
     * Return the width of the player
     * @return WIDTH 
     */
    public int getWidth() {
        return WIDTH;
    }
    
    /**
     * Return the height of the player
     * @return HEIGHT
     */
    public int getHeight() {
        return HEIGHT;
    }

    public void dispose() {
        atlas.dispose();
    }

}
