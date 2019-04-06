package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;


public class MyGdxGame extends ApplicationAdapter {
	private SpriteBatch batch;
	private int height, width;
	private TextureRegion regionImgGoku;

	private Sprite goku;
	private Sprite horse;

	private TextureRegion regionImgHorses;
	private TextureRegion []arrayHorses;
	/** Atlas que guarda los recursos. */
	private TextureAtlas atlas;
	private Animation horseAnimation;
	private float duracion = 0;
	TextureRegion frame;
	@Override
	public void create () {
		batch = new SpriteBatch();
		height=Gdx.graphics.getHeight();
		width=Gdx.graphics.getWidth();

		atlas=new TextureAtlas("atlas.atlas");
		regionImgGoku=atlas.findRegion("goku");
		regionImgHorses=atlas.findRegion("horse_run_cycle");

		//rotamos a goku
		goku=new Sprite(regionImgGoku);
		goku.setSize(atlas.findRegion("goku").originalWidth/2,atlas.findRegion("goku").originalHeight/2);
		goku.setPosition(width-340,height/2);
		goku.rotate(45);

		//Animación del caballo
        TextureRegion[][]temp  =regionImgHorses.split
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
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		//Animación caballo
		duracion+=1;
		frame = (TextureRegion) horseAnimation.getKeyFrame(duracion, true);
		batch.begin();
		goku.draw(batch);

		//HORSE EN MOVIMIENTO
		horse=new Sprite(frame);
		horse.setPosition(0,height/2);
		horse.draw(batch);

		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
