package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MyGdxGame extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture img;
	private Texture imgGoku;
	private Texture imgSpiderman;
	private int height, width;
	private TextureRegion regionImgGoku;
	private TextureRegion regionImgSpiderman;
	private TextureRegion regionImgBadlogic;

	private Sprite badlogig;
	private Sprite goku;
	private Sprite horse;

	private static final int ANCHO=410, ALTO=66;
	private Texture imgHorses;
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

		//256x256 dimensiones badlogic.jpg vamos a recortarlo de manera que se vea los ojos y la sonrisa
		//43,53 hasta 200,179
		img = new Texture("badlogic.jpg");
		regionImgBadlogic=new TextureRegion(img);
		badlogig=new Sprite(regionImgBadlogic,43,53,157,126);//regionImgBadlogic=new TextureRegion(img,43,53,157,126);
		badlogig.setPosition(0,0);

		//Vamos a rotar a Goku
		imgGoku=new Texture("goku.png");
		regionImgGoku=new TextureRegion(imgGoku);
		goku=new Sprite(regionImgGoku);
		goku.setSize(223,284);
		goku.setPosition(width-340,height/2);
		goku.rotate(45);

		//Dibujamos a spiderman sin sprite
		imgSpiderman=new Texture("spiderman.png");
		regionImgSpiderman=new TextureRegion(imgSpiderman);

		//Por último cortaremos un sprite de imagenes y crearemos una animación.
		//410x66
		imgHorses=new Texture("horse_run_cycle.png");
		regionImgHorses=new TextureRegion(imgHorses);
		TextureRegion[][]temp  =regionImgHorses.split(ANCHO/5,ALTO);
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
		badlogig.draw(batch);
		goku.draw(batch);

		//Spiderman sin sprite, las posiciones y tamaño se deben dar aquí.
		batch.draw(regionImgSpiderman,width/6-100,height-150,88.9f,135);

		//HORSE EN MOVIMIENTO

		horse=new Sprite(frame);
		horse.setPosition(0,height/2);
		horse.draw(batch);

		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
		imgGoku.dispose();
		imgSpiderman.dispose();
		imgHorses.dispose();
	}
}
