package org.academiadecodigo.stormrooters.painter;


import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;


public class Cursor {

    private Rectangle cursor;
    private int col;
    private int row;
    private Canvas canvas;


    public Cursor(Canvas canvas, int col, int row) {
        this.cursor = new Rectangle(canvas.columnToX(col), canvas.rowToY(row), canvas.getCellSize(), canvas.getCellSize());
        this.col = col;
        this.row = row;
        this.canvas = canvas;
        cursor.fill();
        cursor.setColor(Color.BLUE);

    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }


    public void moveRight() {
        if (col != canvas.getPaintCols() - 1) {
            this.col += 1;
            cursor.translate(canvas.getCellSize(), 0);
        }

    }

    public void moveLeft() {
        if (col != 0) {
            this.col -= 1;
            cursor.translate(-canvas.getCellSize(), 0);
        }


    }

    public void moveDown() {
        if (row != canvas.getPaintRows() - 1) {
            this.row += 1;
            cursor.translate(0, canvas.getCellSize());
        }
    }

    public void moveUp() {
        if (row > 0) {
            this.row -= 1;
            cursor.translate(0, -canvas.getCellSize());
        }
    }


}
