package org.academiadecodigo.bootcamp.gfx.simplegfx;

import org.academiadecodigo.bootcamp.grid.Grid;
import org.academiadecodigo.bootcamp.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class SimpleGfxGrid implements Grid {

    public static final int PADDING = 10;
    private int gridCols;
    private int gridRows;
    //private int cellSize = 10;
    private Rectangle rectangle;


    public SimpleGfxGrid(int cols, int rows) {
        //throw new UnsupportedOperationException();
        this.gridCols = cols;
        this.gridRows = rows;

    }

    /**
     * @see Grid#init()
     */
    @Override
    public void init() {
        rectangle = new Rectangle(PADDING, PADDING, getWidth(), getHeight());
        rectangle.draw();
        rectangle.setColor(Color.BLUE);
        // throw new UnsupportedOperationException();
    }

    /**
     * @see Grid#getCols()
     */
    @Override
    public int getCols() {
        return gridCols;
    }

    /**
     * @see Grid#getRows()
     */
    @Override
    public int getRows() {
        return gridRows;
    }

    /**
     * Obtains the width of the grid in pixels
     *
     * @return the width of the grid
     */
    public int getWidth() {
        return gridCols * getCellSize();
        //throw new UnsupportedOperationException();
    }

    /**
     * Obtains the height of the grid in pixels
     *
     * @return the height of the grid
     */
    public int getHeight() {
        return gridRows * getCellSize();
        //throw new UnsupportedOperationException();
    }

    /**
     * Obtains the grid X position in the SimpleGFX canvas
     *
     * @return the x position of the grid
     */
    public int getX() {
        return PADDING;
        //throw new UnsupportedOperationException();
    }

    /**
     * Obtains the grid Y position in the SimpleGFX canvas
     *
     * @return the y position of the grid
     */
    public int getY() {
        return PADDING;
        //throw new UnsupportedOperationException();
    }

    /**
     * Obtains the pixel width and height of a grid position
     *
     * @return
     */
    public int getCellSize() {
        int cellSize = 10;
        return cellSize;
        //throw new UnsupportedOperationException();
    }

    /**
     * @see Grid#makeGridPosition()
     */
    @Override
    public GridPosition makeGridPosition() {
        return new SimpleGfxGridPosition(this);
        //throw new UnsupportedOperationException();
    }

    /**
     * @see Grid#makeGridPosition(int, int)
     */
    @Override
    public GridPosition makeGridPosition(int col, int row) {
        return  new SimpleGfxGridPosition(col,row, this);
    }

    /**
     * Auxiliary method to compute the y value that corresponds to a specific row
     *
     * @param row index
     * @return y pixel value
     */
    public int rowToY(int row) {
        return row * getCellSize()+PADDING;
       // throw new UnsupportedOperationException();
    }

    /**
     * Auxiliary method to compute the x value that corresponds to a specific column
     *
     * @param column index
     * @return x pixel value
     */
    public int columnToX(int column) {
        return column * getCellSize()+PADDING;
        //throw new UnsupportedOperationException();
    }
}
