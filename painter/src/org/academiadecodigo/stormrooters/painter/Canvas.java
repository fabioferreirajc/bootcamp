package org.academiadecodigo.stormrooters.painter;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.sql.SQLOutput;

public class Canvas implements KeyboardHandler {


    public static final int PADDING = 10;
    private int paintCols;
    private int paintRows;
    private Cell[][] allCells;
    private int cellSize = 30;
    private Cursor cursor = new Cursor(this, 0, 0);

    private String toSaveString;
    private FileManager fileManager;


    public Canvas(int cols, int rows) {
        this.paintCols = cols;
        this.paintRows = rows;
        allCells = new Cell[paintCols][paintRows];
        controls();
        this.fileManager = new FileManager();
    }


    public int getPaintCols() {
        return paintCols;
    }

    public int getPaintRows() {
        return paintRows;
    }


    public void toSaveString() {
        toSaveString = "";

        for (int col = 0; col < paintCols; col++) {
            for (int row = 0; row < paintRows; row++) {

                toSaveString = toSaveString + allCells[col][row].getRepresentation();

            }

        }

    }

    public void clearCells() {
        for (int col = 0; col < paintCols; col++) {
            for (int row = 0; row < paintRows; row++) {
                allCells[col][row].clear();
            }

        }
    }

    public void loadDrawing() {

        String savedFile = fileManager.load();

        int i = 0;
        for (int col = 0; col < paintCols; col++) {
            for (int row = 0; row < paintRows; row++) {

                if (savedFile.charAt(i) == '1') {
                    allCells[col][row].paint();

                }
                if (savedFile.charAt(i) == '2') {
                    allCells[col][row].paintRED();

                }

                if (savedFile.charAt(i) == '3') {
                    allCells[col][row].paintGREEN();
                }

                i++;

            }
        }


    }


    public void createAllCells() {
        for (int col = 0; col < paintCols; col++) {

            for (int row = 0; row < paintRows; row++) {

                allCells[col][row] = new Cell(this, col, row);
            }
        }

    }


    public int getCellSize() {
        return cellSize;
    }


    public int rowToY(int row) {
        return row * cellSize + PADDING;
    }

    public int columnToX(int column) {
        return column * cellSize + PADDING;
    }


    public void controls() {
        Keyboard k = new Keyboard(this);

        int[] keys = {KeyboardEvent.KEY_D, KeyboardEvent.KEY_S, KeyboardEvent.KEY_L, KeyboardEvent.KEY_SPACE, KeyboardEvent.KEY_DOWN,
                KeyboardEvent.KEY_LEFT, KeyboardEvent.KEY_RIGHT, KeyboardEvent.KEY_UP, KeyboardEvent.KEY_Z, KeyboardEvent.KEY_R, KeyboardEvent.KEY_G
        };

        for (int key : keys) {
            KeyboardEvent event = new KeyboardEvent();
            event.setKey(key);
            event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            k.addEventListener(event);
        }

    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_DOWN:
                System.out.println("DOWN");
                cursor.moveDown();

                break;

            case KeyboardEvent.KEY_UP:
                System.out.println("UP");
                cursor.moveUp();
                break;

            case KeyboardEvent.KEY_LEFT:
                System.out.println("LEFT");
                cursor.moveLeft();
                break;

            case KeyboardEvent.KEY_RIGHT:
                System.out.println("RIGHT");
                cursor.moveRight();
                break;

            case KeyboardEvent.KEY_SPACE:
                System.out.println("SPACE");
                allCells[cursor.getCol()][cursor.getRow()].paint();
                break;

            case KeyboardEvent.KEY_R:
                System.out.println("PAINT RED");
                allCells[cursor.getCol()][cursor.getRow()].paintRED();
                break;
            case KeyboardEvent.KEY_G:
                System.out.println("PAINT GREEN");
                allCells[cursor.getCol()][cursor.getRow()].paintGREEN();
                break;

            case KeyboardEvent.KEY_S:
                System.out.println("SAVE");
                toSaveString();
                fileManager.save(toSaveString);
                break;

            case KeyboardEvent.KEY_Z:
                System.out.println("CLEAR");
                clearCells();
                break;

            case KeyboardEvent.KEY_L:
                System.out.println("LOAD");
                loadDrawing();
                break;


            case KeyboardEvent.KEY_D:
                System.out.println("DELETE");
                allCells[cursor.getCol()][cursor.getRow()].clear();
                break;

        }


    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }


}
