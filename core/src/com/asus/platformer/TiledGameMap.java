package com.asus.platformer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

import static com.badlogic.gdx.maps.tiled.TiledMapTileLayer.*;


public class TiledGameMap extends GameMAp {

    OrthogonalTiledMapRenderer tiledMapRenderer;
    TiledMap tiledMap;

    public TiledGameMap () {
        tiledMap = new TmxMapLoader (  ).load ( Gdx.files.internal("android/assets/map.tmx").file().getAbsolutePath() );
        tiledMapRenderer = new OrthogonalTiledMapRenderer ( tiledMap );

    }

    @Override
    public void render ( OrthographicCamera camera ) {
        tiledMapRenderer.setView ( camera );
        tiledMapRenderer.render ();
    }

    @Override
    public void update ( float delta ) {

    }

    @Override
    public void dispose () {
        tiledMap.dispose ();

    }

    @Override
    public TileType getTileTypeByCoordinate ( int layer, int col, int row )
    {
        Cell cell = ((TiledMapTileLayer) tiledMap.getLayers ().get ( layer )).getCell(col, row);


        if(cell!= null)
        {
            TiledMapTile tile = cell.getTile ();
            if( tile  != null )
            {
                int id  = tile.getId ();
                return TileType.getTileTypeById ( id );
            }
        }

        return null;
    }

    @Override
    public int getHeight () {
        return ((TiledMapTileLayer) tiledMap.getLayers ().get(0)).getHeight ();
    }

    @Override
    public int getWidth ()
    {
        return ((TiledMapTileLayer) tiledMap.getLayers ().get(0)).getWidth();
    }

    @Override
    public int getLayers () {
        return tiledMap.getLayers ().getCount ();
    }
}
