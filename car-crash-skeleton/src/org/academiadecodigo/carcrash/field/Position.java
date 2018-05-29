package org.academiadecodigo.carcrash.field;


public class Position {

    private int col;
    private int row;


    public Position() {
        this.col = (int) (Math.random() * Field.getWidth());
        this.row = (int) (Math.random() * Field.getHeight());
    }


    public void moveRight() {


        if (col < Field.getWidth() - 1) {
            this.col += 1;
        }

    }

    public void moveLeft() {
        if (col > 0) {
            this.col -= 1;
        }
    }

    public void moveDown() {
        if (row < Field.getHeight() - 1) {
            this.row += 1;
        }
    }

    public void moveUp() {
        if (row > 0) {
            this.row -= 1;
        }
    }

    public boolean equals(Position p) {

        if (this.col == p.getCol() && this.row == p.getRow()) {
            return true;
        }

        return false;
    }

    public int getCol() {

        return col;
    }




    public int getRow() {
        return row;
    }
}
