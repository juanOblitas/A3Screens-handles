package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
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
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		imgGoku=new Texture("goku.png");
		imgSpiderman=new Texture("spiderman.png");
		height=Gdx.graphics.getHeight();
		width=Gdx.graphics.getWidth();
		regionImgGoku=new TextureRegion(imgGoku);
		regionImgSpiderman=new TextureRegion(imgSpiderman);
		//256x256 dimensiones badlogic.jpg vamos a recortarlo de manera que se vea los ojos y la sonrisa
		//43,53 hasta 200,179
		regionImgBadlogic=new TextureRegion(img,43,53,157,126);

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();

		batch.draw(regionImgBadlogic, 0, 0);
		//426x568
		batch.draw(imgGoku,width/3,height/3,223,284);
		//1778x2700
		batch.draw(imgSpiderman,width/4,height/2,88.9f,135);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
