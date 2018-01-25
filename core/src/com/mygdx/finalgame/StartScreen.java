/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.finalgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;

/**
 *
 * @author vandl4973
 */
public class StartScreen implements Screen {
private static final int playButtonWidth =100;  
private static final int playButtonHeight =100;
private static final int playBtny =230;
 finalgame game;
 
 Texture playButton; 
 
 public StartScreen(finalgame game){
 this.game = game;
 playButton = new Texture("Pbutt.jpg");
 
 }
     
    @Override
    public void show() {
        
         }

    @Override
    public void render(float f) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.getBatch().begin();
        int x =finalgame.WIDTH/2-playButtonWidth/2;
        game.batch.draw(playButton, x,playBtny, playButtonWidth,playButtonHeight); 
        if(Gdx.input.isTouched()){
            this.dispose();
            game.setScreen(new MainGame(game));
        }
        //}
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
