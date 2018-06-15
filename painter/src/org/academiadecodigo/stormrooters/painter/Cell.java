package org.academiadecodigo.stormrooters.painter;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;



public class Cell {


    private Canvas canvas;
    Rectangle rectangle;

    private int color;

    public String getRepresentation (){

        if (rectangle.isFilled()&&color==1){
            return  "1";

        }
        if (rectangle.isFilled()&&color==2){
            return  "2";
        }
        if (rectangle.isFilled()&&color==3){
            return  "3";
        }
        return "0";

    }


    public Cell(Canvas canvas, int col, int row) {
        rectangle = new Rectangle(canvas.columnToX(col), canvas.rowToY(row), canvas.getCellSize(), canvas.getCellSize());
        rectangle.setColor(Color.RED);
        rectangle.draw();
        this.canvas = canvas;
    }

    public void paint() {

        rectangle.setColor(Color.BLACK);
        rectangle.fill();
        color=1;
        //rectangle.isFilled();
    }

    public void paintRED() {

        rectangle.setColor(Color.RED);
        rectangle.fill();
        color=2;
        //rectangle.isFilled();
    }


    public void paintGREEN () {
        rectangle.setColor(Color.GREEN);
        rectangle.fill();
        color=3;

    }



    public void clear() {
        rectangle.draw();
        rectangle.setColor(Color.RED);
    }

}
