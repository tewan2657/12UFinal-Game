/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.finalgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Adars
 */
public class MainGame implements Screen {
    //MAX AND MIN time to spawn in a missile 
    private static final float MIN_MISSILE_SPAWN_TIME = 0.3f;
    private static final float MAX_MISSILE_SPAWN_TIME = 0.6f;
    
    //GAME MANAGER
    private finalgame game;
    //PlAYER
    private Player p1;
    //BATCH
    private SpriteBatch batch;
    //WORLD
    private World world;
    
    //Timer to spawn in missiles 
    //float missileSpawnTimer;
    
   // Random random;
    
    //DIMENSIONS
    private final int HEIGHT = 600;
    private final int WIDTH = 1000;
    
    ArrayList<Missile> missiles;

    public MainGame(finalgame game) {
        //initialize the game  
        this.game = game;
//        missiles = new ArrayList<Missile>();
//        random = new Random();
//        missileSpawnTimer = random.nextFloat() * (MAX_MISSILE_SPAWN_TIME - MIN_MISSILE_SPAWN_TIME) + MIN_MISSILE_SPAWN_TIME;
//        
        
        //initialize the player and its location
        p1 = new Player(10, 10);
        //initialize the world;
        world = new World();
        //initialize the sprite batch 
        this.batch = game.getBatch();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float deltaTime) {

        p1.update(deltaTime);

        for (Rectangle col : world.getBarrier()) {
            p1.fixCollision(col);
        }

//        missileSpawnTimer -= deltaTime;
//        //if time is less than zero 
//        //randomly create new spwan time;
//        if(missileSpawnTimer <= 0){
//      missileSpawnTimer = random.nextFloat() * (MAX_MISSILE_SPAWN_TIME - MIN_MISSILE_SPAWN_TIME) + MIN_MISSILE_SPAWN_TIME;
//       missiles.add(new Missile(random.nextInt(Gdx.graphics.getWidth() - Missile.WIDTH)));
//        }
////        
////        //UPDATE THE MISSILES
////        ArrayList<Missile> removeMissile = new ArrayList<Missile>();
////        for(Missile missile : missiles){
////            missile.update(deltaTime);
//            if(missile.remove)
//                removeMissile.add(missile);
//        }
//        missiles.removeAll(removeMissile);
        
        
//        for(Missile missile : missiles){
//            missile.render(game.getBatch());
//        }
        
        
        
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();

        p1.render(batch);
        batch.end();
        world.render();

    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
    }

}
