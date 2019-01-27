package com.asus.platformer;

import com.badlogic.gdx.graphics.OrthographicCamera;

public abstract class GameMAp {
        public abstract void render( OrthographicCamera camera );
        public abstract void update (float delta);
        public abstract void dispose();



    /**
     * Documentation: This method gets a tile ddepending on layers
     * @param layers
     * @param x
     * @param y
     * @return
     */
    public TileType getTileTypeByLayers(int layers,float x, float y)
    {
        return this.getTileTypeByCoordinate ( layers, (int) (x/TileType.TILESIZE), (int) (y/TileType.TILESIZE));
    }

    /**
     * Documentation: MEthod gets tile depending on coordinate
     * @param layer
     * @param col
     * @param row
     * @return
     */
    public abstract TileType getTileTypeByCoordinate(int layer, int col, int row);



        public abstract int getHeight();
        public abstract int getWidth();
        public abstract int getLayers();

}
