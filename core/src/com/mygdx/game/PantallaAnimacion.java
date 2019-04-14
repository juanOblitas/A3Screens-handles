package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

class PantallaAnimacion extends Pantalla{

    private TextureAtlas atlas;
    private TextureRegion regionImgHorse;
    private Sprite horse;
    private TextureRegion []arrayHorses;
    private Animation horseAnimation;
    private TextureRegion frame;
    private float duracion = 0;


    public PantallaAnimacion(MyGdxGame game) {
        super(game);
    }

    @Override
    public void show() {
        atlas=new TextureAtlas("atlas.atlas");

        regionImgHorse=atlas.findRegion("horse_run_cycle");
        TextureRegion[][]temp  =regionImgHorse.split
                (atlas.findRegion("horse_run_cycle").originalWidth/5,
                        atlas.findRegion("horse_run_cycle").originalHeight);

        arrayHorses=new TextureRegion[temp.length*temp[0].length];
        int cont=0;
        for(int i=0; i<temp.length;i++){
            for(int j=0; j<temp[i].length;j++){
                arrayHorses[cont++]=temp[i][j];
            }
        }
        horseAnimation=new Animation(0.8f,arrayHorses);

    }

    @Override
    public void render(float delta) {


        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //Gdx.gl.glClear(GL20.GL_COLOR_WRITEMASK); Esto lo he comentado porque queria que cambie el color de pantalla
        //cuando cambie de pantalla, pero esto no es posible, por tanto debemos tener el mismo color entre pantallas

        //Animación caballo
        duracion+=7;
        frame = (TextureRegion) horseAnimation.getKeyFrame(duracion, true);
        game.getBatch().begin();
        //HORSE EN MOVIMIENTO
        horse=new Sprite(frame);
        horse.setPosition(getWidth()/2,30);
        horse.draw(game.getBatch());
        font.draw(game.getBatch(),"Pantalla 2",getWidth()/2,getHeight()-100);
        if(Gdx.input.isKeyPressed(Input.Keys.S)){
            game.setScreen(game.getImagen());
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
