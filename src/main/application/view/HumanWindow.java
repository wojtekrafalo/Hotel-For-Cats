package main.application.view;

import javax.swing.*;

/**
 * Abstract class of window. Extends JFrame, that's why it has all properties of a Java window.
 * Windows used to show data about specific persons extends this class.
 *
 * @author wojtekrafalo
 * @version 1.0
 * @since 1.0
 */
public abstract class HumanWindow extends JFrame {

    /**
     * Constructor used to set a name of a window.
     * @param title name of a window.
     */
    HumanWindow(String title) {
        super(title);
    }
}