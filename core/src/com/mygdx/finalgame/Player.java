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

    private float x;
    private float y;

    private float dx;
    private float dy;

    private boolean facingLeft;

    private float elapsed;

    private Animation<TextureRegion> run;
    private Animation<TextureRegion> runL;

    private TextureRegion stand;
    private TextureRegion standL;

    private TextureAtlas atlas;
    private Rectangle col; 
    
    public Player(float x, float y) {

        this.x = x;
        this.y = y;

        this.dx = 0;
        this.dy = 0;

        this.elapsed = 0;

        this.atlas = new TextureAtlas("packed/player.atlas");

        this.stand = atlas.findRegion("stand");
        this.standL = new TextureRegion(stand);
        this.standL.flip(true, false);

        run = new Animation(1f / 10f, atlas.findRegions("run"));

        Array<AtlasRegion> runLFrames = atlas.findRegions("run");
        for (int i = 0; i < runLFrames.size; i++) {
            runLFrames.get(i).flip(true, false);
        }
        runL = new Animation(1f / 10f, runLFrames);

        this.facingLeft = false;
        this.col = new Rectangle(x,y,stand.getRegionWidth(),stand.getRegionHeight());
    }

    /**
     * returns the x axis location variable for player 
     * @return x
     */
    public float getX() {
        return x;
    }
    /**
     * returns the y axis location variable for player
     * @return y 
     */
    public float getY() {
        return y;
    }

    public void update(float deltaTime) {
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            this.dy = +4;
            this.elapsed = this.elapsed + deltaTime;
            this.facingLeft = false;

        } else {
            this.dy = -4;
            this.elapsed = this.elapsed + deltaTime;
        }

        this.y = this.y + this.dy;
       
        this.col.setX(this.x);
        this.col.setY(this.y);
       
    }
    public void fixCollision(Rectangle block){
         //are they colliding
        if(col.overlaps(block)){
           float width = Math.min(col.x + col.width, block.x + block.width) -Math.max(col.x, block.x);
           float height = Math.min(col.y + col.height, block.y + block.height) -Math.max(col.y, block.y);
           if(width<height){
               //on left
               if (this.x < block.x){
                   
                   this.x = this.x - width;
           }else{
                   this.x = this.x + width;
               }
        }else{
               if (this.y<block.y){
                   this.y=this.y-height;
               }else{
                   this.y=this.y+height;
               }
           }
           col.setX(this.x);
           col.setY(this.y);
    }
    }
    public void render(SpriteBatch batch) {

        if (this.dx == 0) {
            if (facingLeft) {
                batch.draw(standL, x, y);
            } else {
                batch.draw(stand, x, y);
            }
        } else if (this.dx > 0) {
            batch.draw(run.getKeyFrame(elapsed, true), x, y);

        } else if (this.dx < 0) {
            batch.draw(runL.getKeyFrame(elapsed, true), x, y);
        }
    }

    public void dispose() {
        atlas.dispose();
    }

}
