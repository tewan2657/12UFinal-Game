/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.finalgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.utils.Align;

/**
 *
 * @author Adars
 */
public class GameOverScreen implements Screen{
    //Final game 
    finalgame game;
    //score 
    int score;
    //game over image
    Texture gameOver;
    
    BitmapFont scoreFont;
    
   
    
    /**
     * Constructor for the GameOverScreen
     * @param game 
     * @param score 
     */
    public GameOverScreen (finalgame game, int score){
        //initialize the final game class
        this.game = game;
        //initialize the score 
        this.score = score; 
        //initialize the game over image
        gameOver = new Texture("dead.png");
        
       // scoreFont = new BitmapFont(Gdx.files.internal("advanced.ttf"));
        
    }
    
    @Override
    public void show() {
    }

    /**
     * 
     * @param deltaTime
     */
    @Override
    public void render(float deltaTime) {
        //Clear the background and colour it black 
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        //Beginning of the sprite Batch
        game.getBatch().begin();
        
//        GlyphLayout scoreFormat = new GlyphLayout(scoreFont, "Score: \n", Color.WHITE,0,Align.left, false);
//        scoreFont.draw(game.batch, scoreFormat, finalgame.WIDTH / 2, finalgame.HEIGHT /2);
        //draw the Game Over texture image
        game.batch.draw(gameOver, finalgame.WIDTH / 2 - 175, finalgame.HEIGHT / 2, 350, 100);
        
       
        //end of the sprite batch 
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
