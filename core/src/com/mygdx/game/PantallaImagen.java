package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

class PantallaImagen extends Pantalla{

    /** Atlas que guarda los recursos. */
    private TextureAtlas atlas;
    private TextureRegion regionImgGoku;
    private Sprite goku;


    public PantallaImagen(MyGdxGame game) {
        super(game);

    }

    @Override
    public void show() {


        atlas=new TextureAtlas("atlas.atlas");
        regionImgGoku=atlas.findRegion("goku");

        //rotamos a goku
        goku=new Sprite(regionImgGoku);
        goku.setSize(atlas.findRegion("goku").originalWidth/2,atlas.findRegion("goku").originalHeight/2);
        goku.setPosition(0,getHeight()/4);
        goku.rotate(45);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.getBatch().begin();
        goku.draw(game.getBatch());
        font.draw(game.getBatch(),"Pantalla 1",getWidth()/2,getHeight()-100);
        if(Gdx.input.isKeyPressed(Input.Keys.A)){
            game.setScreen(game.getAnimacion());
        }
        game.getBatch().end();
    }



    @Override
    public void resize(int width, int height) {

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
        atlas.dispose();
    }
}
