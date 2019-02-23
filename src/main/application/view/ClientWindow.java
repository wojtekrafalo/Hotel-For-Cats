package main.application.view;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class of a window provided for clients.
 *
 * @author wojtekrafalo
 * @version 1.0
 * @since 1.0
 */
public class ClientWindow extends HumanWindow {

    private static final int WIDTH = 600, HEIGHT = 600;
    //    private JLabel leftLabel = new JLabel();
    private JList list;

    private JButton logOUT = new JButton("LOG OUT");

    private JLabel infoOwnerName = new JLabel();
    private JLabel infoOwnerPesel = new JLabel();

    private JLabel infoCatName = new JLabel();
    private JLabel infoRoom = new JLabel();
    private JLabel infoDataOfMoveIn = new JLabel();
    private JLabel infoDataOfMoveOut = new JLabel();
    private JLabel infoPrice = new JLabel();

    private ArrayList<String> catList;
    private ArrayList<String> roomList;
    private ArrayList<String> moveINList;
    private ArrayList<String> moveOUTList;
    private ArrayList<String> priceList;

    private MenuItem menuInfo = new MenuItem("INFO"), menuExit=new MenuItem("EXIT");

    private int chosenCat = 0;
    private String[] data = {};
    private ResultSet catTable;

    private ArrayList<String> ownersCats;

    ClientWindow(){
        super("ClientWindow");

        list = new JList();
//        setData(data);

        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        list.setVisibleRowCount(4);
        list.setLayoutOrientation(JList.VERTICAL);


        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(null);

        infoOwnerName.setBounds(0,0,300,50);
        rightPanel.add(infoOwnerName);
        infoOwnerPesel.setBounds(0,50,300,50);
        rightPanel.add(infoOwnerPesel);
        infoCatName.setBounds(0,100,300,50);
        rightPanel.add(infoCatName);
        infoRoom.setBounds(0,150,300,50);
        rightPanel.add(infoRoom);
        infoDataOfMoveIn.setBounds(0,250,300,50);
        rightPanel.add(infoDataOfMoveIn);
        infoDataOfMoveOut.setBounds(0,300,300,50);
        rightPanel.add(infoDataOfMoveOut);
        infoPrice.setBounds(0,200,300,50);
        rightPanel.add(infoPrice);

        logOUT.setBounds(100,500,150,30);
        rightPanel.add(logOUT);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new JScrollPane(list), new JScrollPane(rightPanel));
        splitPane.setDividerLocation(WIDTH/3);

        Menu menu1 = new Menu("Menu");
        menu1.add(menuInfo);
        menu1.addSeparator();
        menu1.add(menuExit);

        MenuBar myMenu = new MenuBar();
        myMenu.add(menu1);
        this.setMenuBar(myMenu);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WIDTH, HEIGHT);

        this.add(splitPane);
        System.out.println("ClientWindow created");
    }


    /**
     * This method adds an Action Listener to buttons and MouseInputListener to labels, to make it choose a specific action.
     * @param listener an Action Listener of buttons.
     * @param mouseInputListener a Mouse Listener, which reacts on clicks of labels.
     */
    void addListener(ActionListener listener, MouseInputListener mouseInputListener){
        logOUT.addActionListener(listener);
        menuInfo.addActionListener(listener);
        menuExit.addActionListener(listener);
        list.addMouseListener(mouseInputListener);
    }

    /**
     * Default getter of a menu item of detailed information.
     * @return reference to a info menu item.
     */
    public MenuItem getMenuInfo () {
        return menuInfo;
    }

    /**
     * Default getter of a list of detailed information.
     * @return list of detailed information.
     */
    public JList getList () {
        return list;
    }

    /**
     * This method puts data about specific cat at labels.
     * @param i number of row.
     */
    public void setInfoAboutCat (int i) {
        infoCatName.setText("Cat's name:                                   " + catList.get(i));
        infoRoom.setText("Room:                          " + roomList.get(i));
        infoDataOfMoveIn.setText("Moved_in:          " + moveINList.get(i));
        infoDataOfMoveOut.setText("Move_out:        " + moveOUTList.get(i));
        infoPrice.setText("Price:        " + priceList.get(i));
        chosenCat = i;
    }

    /**
     * This method puts data about specific cats at labels.
     * @param catData list of a names of a cats.
     * @param numberData list of a number of a room occupied by specific cats.
     * @param moveINData list of a data of a moving in by specific cats.
     * @param moveOUTData list of a data of a moving out by specific cats.
     * @param priceData list of a data about cost of stays.
     */
    public void setInfoAboutCats (String catData, String numberData, String moveINData, String moveOUTData, String priceData) {
        catList = new ArrayList<String>(Arrays.asList(catData.split(",")));
        roomList = new ArrayList<String>(Arrays.asList(numberData.split(",")));
        moveINList = new ArrayList<String>(Arrays.asList(moveINData.split(",")));
        moveOUTList = new ArrayList<String>(Arrays.asList(moveOUTData.split(",")));
        priceList = new ArrayList<String>(Arrays.asList(priceData.split(",")));

        data = new String[catList.size()];

        for (int i=0; i<catList.size(); i++) {
            data[i] = catList.get(i);
        }
        this.list.setListData(data);
    }

    /**
     * Default getter of a cats' data.
     * @return array of cats' data
     */
    public String[] getData() {                          //send selected field of List
        return data;
    }

    /**
     * Default getter of a Log OUT button.
     * @return reference to a Log OUT button.
     */
    public JButton getLogOUT() {                          //send selected field of List
        return logOUT;
    }

    /**
     * This method sets data about specific client at labels.
     * @param name name of a specific client.
     * @param pesel PESEL number of a specific client.
     */
    public void setOwnerData(String name, String pesel) {
        infoOwnerName.setText(name);
        infoOwnerPesel.setText(pesel);
    }

    /**
     * Method used to show message about this window.
     */
    public void displayInfo(){
        String infoMessage = "INFO\n" +
                "INFO";
        JOptionPane.showMessageDialog(this, infoMessage);
    }
}