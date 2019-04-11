package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends Game {
	private SpriteBatch batch;
	private Pantalla imagen;
	private Pantalla animacion;

	@Override
	public void create () {
		batch = new SpriteBatch();
		imagen=new PantallaImagen(this);
		imagen.setFont(new BitmapFont());
		animacion=new PantallaAnimacion(this);
		animacion.setFont(new BitmapFont());
		setScreen(imagen);
	}



	public Pantalla getImagen() {
		return imagen;
	}

	public void setImagen(Pantalla imagen) {
		this.imagen = imagen;
	}

	public Pantalla getAnimacion() {
		return animacion;
	}

	public void setAnimacion(Pantalla animacion) {
		this.animacion = animacion;
	}

	public SpriteBatch getBatch() {
		return batch;
	}

	public void setBatch(SpriteBatch batch) {
		this.batch = batch;
	}


}
