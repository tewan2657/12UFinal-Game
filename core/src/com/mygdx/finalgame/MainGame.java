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
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

/**
 *
 * @author Adars
 */
public class MainGame implements Screen {

    //MAX AND MIN time to spawn in a missile 
    public static final float MIN_MISSILE_SPAWN_TIME = 0.6f;
    public static final float MAX_MISSILE_SPAWN_TIME = 1f;

    //Final game 
    private finalgame game;

    //PlAYER
    private Player p1;

    //BATCH
    private SpriteBatch batch;

    //WORLD
    private World world;

    private Sound kaboom;
    private Sound failure;

    int life;

    //Score 
    int score;

    //Array List EXPLOSION
    ArrayList<Explosion> explos;

    //random Generator 
    Random random;

    //Collision block for player collisions with missiles 
    CollisionBlock playerBlock;

    //spawn time for missile
    float missileSpawnTimer;

    //ArrayList for the missiles
    ArrayList<Missile> missiles;

    public MainGame(finalgame game) {
        //initialize the game  
        this.game = game;

        //initialize the Explosion ArrayList
        explos = new ArrayList<Explosion>();

        //initialize the Missile ArrayList
        missiles = new ArrayList<Missile>();

        //initialize the random generator 
        random = new Random();

        //Use random generator to make random spawn times for missiles
        missileSpawnTimer = random.nextFloat() * (MAX_MISSILE_SPAWN_TIME - MIN_MISSILE_SPAWN_TIME) + MIN_MISSILE_SPAWN_TIME;

        //initialize the player and its location
        p1 = new Player(10, 10);

        //initialize the player block with player x and y coordinates and player height and width 
        playerBlock = new CollisionBlock(p1.getX(), p1.getY(), p1.getWidth(), p1.getHeight());

        //initialize the world;
        world = new World();

        //Initialize the Kaboom sound Effect 
        kaboom = Gdx.audio.newSound(Gdx.files.internal("kaboom.mp3"));

        //initialize the score 
        score = 0;

        //initialize the sprite batch 
        this.batch = game.getBatch();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float deltaTime) {
        //Update the player
        p1.update(deltaTime);

        //for each world barrier blocks and player block
        for (Rectangle col : world.getBarrier()) {
            //fix the collision(method from player class)
            p1.fixCollision(col);
        }

        //Missile Spawn Code 
        //update the spawn timer
        missileSpawnTimer -= deltaTime;
        //if timer less than zero 
        if (missileSpawnTimer <= 0) {
            //randomly make new spawn timer for missile. 
            missileSpawnTimer = random.nextFloat() * (MAX_MISSILE_SPAWN_TIME - MIN_MISSILE_SPAWN_TIME) + MIN_MISSILE_SPAWN_TIME;
            //add the missiles. 
            missiles.add(new Missile(random.nextInt(Gdx.graphics.getHeight() - Missile.HEIGHT)));
        }

        //update the MISSILE
        //new ArrayList to remove missiles that hit the player 
        ArrayList<Missile> removeMissile = new ArrayList<Missile>();
        // for each missiles 
        for (Missile missile : missiles) {
            //update 
            missile.update(deltaTime);
            if (missile.remove) {
                removeMissile.add(missile);
                score += 1;
            }
        }
        //remove the missiles that hit the player 
        missiles.removeAll(removeMissile);

        // move the player block with player x and y
        playerBlock.move(p1.getX(), p1.getY());

        // Player and Missile collision 
        // for each missile that hits player 
        for (Missile missile : missiles) {
            if (missile.getBlock().collidesWith(playerBlock)) {
                // add a missile to remove later 
                removeMissile.add(missile);
                //add an Explosion animation at the missiles x and y coordinates 
                explos.add(new Explosion(finalgame.WIDTH / 2 - 220, finalgame.HEIGHT / 2 - 200));
                //play the sound effect when missile hits player
                kaboom.play();
                //Pause Score when player is hit by missile 
                score += 0;
            }
        }
        // remove the missiles 
        missiles.removeAll(removeMissile);

        //Update the explosion
        ArrayList<Explosion> removeExp = new ArrayList<Explosion>();
        for (Explosion explosion : explos) {
            explosion.update(deltaTime);
            if (explosion.remove) {
                removeExp.add(explosion);
                // after the explosion animation is done display GAME OVER
                this.dispose();
                game.setScreen(new GameOverScreen(game, score));
                return;
            }

        }
        //Remove the missile 
        explos.removeAll(removeExp);

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //BEGINING OF THE SPRITE BATCH 
        batch.begin();

        //render the scrolling background
        game.background.updateAndRender(deltaTime, game.getBatch());

        //RENDER THE MISSILE
        for (Missile missile : missiles) {
            missile.render(game.getBatch());
        }

        //Render the explosion  
        for (Explosion explosion : explos) {
            explosion.render(batch);
        }

        //RENDER THE PLAYER
        p1.render(batch);

        //END OF THE SPRITE BATCH
        batch.end();

        //RENDER THE WORLD
        world.render();

    }

    public int getScore() {
        return score;
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
        kaboom.dispose();

    }

}
