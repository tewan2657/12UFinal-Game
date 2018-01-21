/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.finalgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;

/**
 *
 * @author Adars
 */
public class GameOverScreen implements Screen{

    
    finalgame game;
    int score;
    Texture gameOver;
    
    public GameOverScreen (finalgame game, int score){
        this.game = game;
        this.score = score; 
        
        gameOver = new Texture("dead.png");    
    }
    
    @Override
    public void show() {
    }

    @Override
    public void render(float f) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.getBatch().begin();
        
        game.batch.draw(gameOver, finalgame.WIDTH / 2 - 175, finalgame.HEIGHT / 2, 350, 100);
        
        game.batch.end();
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
