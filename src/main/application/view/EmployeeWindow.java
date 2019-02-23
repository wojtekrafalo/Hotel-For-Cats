package main.application.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class of a window provided for employees.
 *
 * @author wojtekrafalo
 * @version 1.0
 * @since 1.0
 */
public class EmployeeWindow extends HumanWindow {
    private static final int WIDTH = 600, HEIGHT = 600;

    private JPanel panel = new JPanel();

    private ResultSet roomTable;

    private JButton logOUT = new JButton("LOG OUT");
    private JButton refreshButton = new JButton("Refresh");


    private MenuItem menuInfo = new MenuItem("INFO"), menuExit=new MenuItem("EXIT");


    EmployeeWindow() {
        super("EmployeeWindow");

        this.setLayout(null);

        logOUT.setBounds(300,0,100,30);
        refreshButton.setBounds(400,0,100,30);
//        setting roomTable into JLabel[][] table and adding JLabel[][] into  panel. try use 'setInfoAboutRooms()' method

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(panel);

        Menu menu1 = new Menu("Menu");
        menu1.add(menuInfo);
        menu1.addSeparator();
        menu1.add(menuExit);

        panel.add(logOUT);
        panel.add(refreshButton);

        MenuBar myMenu = new MenuBar();
        myMenu.add(menu1);
        this.setMenuBar(myMenu);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WIDTH, HEIGHT);

        this.add(scrollPane);
        this.add(panel);

        this.add(logOUT);
        this.add(refreshButton);
    }

    /**
     * Shows information about rooms by placing it at labels and displaying at panel.
     * @param numberData list of numbers of the rooms placed into one String.
     * @param standardData list of standard data of the rooms placed into one String.
     */
    public void setInfoAboutRooms (String numberData, String standardData) {
        ArrayList<String> numberList = new ArrayList<>(Arrays.asList(numberData.split(",")));
        ArrayList<String> standardList = new ArrayList<>(Arrays.asList(standardData.split(",")));

        ArrayList<JLabel> roomLabelList = new ArrayList<>();
        ArrayList<JLabel> standardLabelList = new ArrayList<>();

        int height=0;
        for (String s : numberList) {
            JLabel label = new JLabel(s);
            label.setBounds(0,height,100,30);
            height+=30;

            roomLabelList.add(label);
            panel.add(label);
            this.add(label);
        }

        height=0;
        for (String s : standardList) {
            JLabel label = new JLabel(s);
            label.setBounds(100,height,100,30);
            height+=30;

            standardLabelList.add(label);
            panel.add(label);
            this.add(label);
        }
    }

    /**
     * This method adds an Action Listener to buttons, to make it choose a specific action.
     * @param listener an Action Listener of buttons.
     */
    void addListener(ActionListener listener){
        logOUT.addActionListener(listener);
        refreshButton.addActionListener(listener);
        menuInfo.addActionListener(listener);
        menuExit.addActionListener(listener);
    }

    /**
     * Default getter of a menu item of detailed information.
     * @return reference to a info menu item.
     */
    public MenuItem getMenuInfo () {
        return menuInfo;
    }

    /**
     * Default getter of a Log OUT button.
     * @return reference to a Log OUT button.
     */
    public JButton getLogOUT() {                          //send selected field of List
        return logOUT;
    }

    /**
     * Default getter of a Refresh button.
     * @return reference to a Refresh button.
     */
    public JButton getRefreshButton() {                                                                                 //send selected field of List
        return refreshButton;
    }


    public void setTitle(String pesel) {

    }

    /**
     * This method shows details about this window and its possibilities.
     */
    public void displayInfo(){
        String infoMessage = "INFO\n" +
                "INFO";
        JOptionPane.showMessageDialog(this, infoMessage);
    }
}