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
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import java.util.ArrayList;

/**
 *
 * @author Adars
 */
public class MainGame implements Screen {

    private finalgame gameMan;

    private Player p1;

    private SpriteBatch batch;
    
    private Texture startbtn;
    
    private World world;
    private final int HEIGHT = 600;
    private final int WIDTH = 1000;

    public MainGame(finalgame game) {
        this.gameMan = game;
        
       // startbtn = new Texture("start.png");
        
        p1 = new Player(10, 40);
        world = new World();
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

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        p1.render(batch);
        //batch.draw(startbtn, , deltaTime);
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
