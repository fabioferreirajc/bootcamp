package org.academiadecodigo.carcrash.cars;

import org.academiadecodigo.carcrash.field.Field;
import org.academiadecodigo.carcrash.field.Position;

abstract public class Car {

    /**
     * The position of the car on the grid
     */
    private Position pos;
    private boolean crashed=false;

    public void changePosition() {


        int direction = (int) (Math.random() * 4);

        switch (direction) {
            case 0:
                pos.moveRight();
                break;
            case 1:
                pos.moveDown();
                break;
            case 2:
                pos.moveLeft();
                break;
            case 3:
                pos.moveUp();
                break;
        }

    }


    public Car(Position pos) {
        this.pos = pos;
    }

    public Position getPos() {
        return pos;
    }

    public boolean isCrashed() {

        return crashed;
    }

    public void setCrashed(boolean crashed) {
        this.crashed = crashed;
    }
}
