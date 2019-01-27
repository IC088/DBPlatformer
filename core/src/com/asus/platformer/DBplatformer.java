package com.asus.platformer;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public class DBplatformer extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;

	OrthographicCamera camera;
	GameMAp gameMAp;


	@Override
	public void create () {
		batch = new SpriteBatch();
		//img = new Texture("badlogic.jpg");
		gameMAp = new TiledGameMap ();




		camera = new OrthographicCamera (  );
		camera.setToOrtho ( false, Gdx.graphics.getWidth (), Gdx.graphics.getHeight () );
		camera.update ();


	}

	/** Documentation
	 * render method to render the game map
	 */

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		if (Gdx.input.isTouched ())
		{
			camera.translate (-Gdx.input.getDeltaX (), Gdx.input.getDeltaY () );
			camera.update ();
		}

		if( Gdx.input.justTouched ())
		{
			Vector3 pos = camera.unproject ( new Vector3 ( Gdx.input.getX (), Gdx.input.getY (), 0  ) );
			TileType type =  gameMAp.getTileTypeByLayers (1, pos.x,  pos.y);

			if (type != null)
			{
				System.out.println(type.getId ());
			}

		}


		gameMAp.render ( camera );
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
