package org.academiadecodigo;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.gui.GUIScreen;
import com.googlecode.lanterna.gui.Window;

public class HelloWorld {
    public static void main(String[] args) {

        GUIScreen gui = TerminalFacade.createGUIScreen();
        gui.getScreen().startScreen();

        Window window = new Window("hello Wolrd");
        gui.showWindow(window);

        gui.getScreen().stopScreen();
    }
}
