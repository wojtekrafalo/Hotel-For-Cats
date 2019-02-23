package main.application.view;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class of a window provided for admin.
 *
 * @author wojtekrafalo
 * @version 1.0
 * @since 1.0
 */
public class AdminWindow extends HumanWindow{
    private final static int width = 700, height=700;

    private JButton peopleButton = new JButton("PEOPLE");
    private JButton catsButton = new JButton("CATS");
    private JButton stayButton = new JButton("STAY");
    private JButton employeeButton = new JButton("EMPLOYEE");
    private JButton professionButton = new JButton("JOB");
    private JButton roomButton = new JButton("ROOM");
    private JButton standardButton = new JButton("STANDARD");

    private JButton backUP = new JButton("BackUP");
    private JButton loadBackUP = new JButton("LoadBackUP");

    private JButton logOUT = new JButton("LOG OUT");
    private JButton OK = new JButton("OK");

    private JButton selectButton = new JButton("SELECT");
    private JButton insertButton = new JButton("INSERT");
    private JButton deleteButton = new JButton("DELETE");

    private JTextField textInsertData = new JTextField();

    private int columnsNumber, rowsNumber;

    private JPanel selectPanel;

    private String infoMessage= "You can Edit data here." +
            "\nFirst choose, which table, you want to edit." +
            "\nThen Choose, which operation, you want to perform." +
            "\nThen insert data to this operation";

    AdminWindow() {
        super("AdminWindow");

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(null);
        buttonsPanel.setOpaque(false);
        buttonsPanel.setBounds(0,0,width,60);
        buttonsPanel.setVisible(true);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(width, height);
        this.setResizable(false);

        JLabel additionLabel = new JLabel("Please, choose which table, you want to edit.");
        buttonsPanel.add(additionLabel);

//        textDateIN.setBounds(500,10,50,20);
//        textDateOUT.setBounds(500,40,50,20);
//        textStandard.setBounds(500,70,50,20);

        textInsertData.setBounds(90,70,200,20);

        peopleButton.setBounds(10,10,70,15);
        catsButton.setBounds(80,10,70,15);
        stayButton.setBounds(150,10,70,15);
        employeeButton.setBounds(220,10,70,15);
        professionButton.setBounds(290,10,70,15);
        roomButton.setBounds(360,10,70,15);
        standardButton.setBounds(430,10,70,15);

        selectButton.setBounds(10,40,80,20);
        insertButton.setBounds(90,40,80,20);
        deleteButton.setBounds(170,40,80,20);

//        selectForFreeButton.setBounds(500,90,160,20);
        OK.setBounds(300,30,80,20);
        logOUT.setBounds(380,30,100,20);
        backUP.setBounds(300,50,80,20);
        loadBackUP.setBounds(380,50,100,20);

        buttonsPanel.add(peopleButton);
        buttonsPanel.add(catsButton);
        buttonsPanel.add(stayButton);
        buttonsPanel.add(employeeButton);
        buttonsPanel.add(professionButton);
        buttonsPanel.add(roomButton);
        buttonsPanel.add(standardButton);

        buttonsPanel.add(selectButton);
        buttonsPanel.add(insertButton);
        buttonsPanel.add(deleteButton);

//        buttonsPanel.add(textDateIN);
//        buttonsPanel.add(textDateOUT);
//        buttonsPanel.add(textStandard);

//        buttonsPanel.add(selectForFreeButton);
        buttonsPanel.add(logOUT);
        buttonsPanel.add(OK);
        buttonsPanel.add(backUP);
        buttonsPanel.add(loadBackUP);

        this.add(buttonsPanel);

        this.add(peopleButton);
        this.add(catsButton);
        this.add(stayButton);
        this.add(employeeButton);
        this.add(professionButton);
        this.add(roomButton);
        this.add(standardButton);

        this.add(selectButton);
        this.add(insertButton);
        this.add(deleteButton);

//        this.add(textDateIN);
//        this.add(textDateOUT);
//        this.add(textStandard);

        this.add(textInsertData);

//        this.add(selectForFreeButton);
        this.add(logOUT);
        this.add(backUP);
        this.add(loadBackUP);
        this.add(OK);
    }


    /**
     * This method adds an Action Listener to buttons, to make it choose a specific action.
     * @param listener an Action Listener of buttons.
     */
    void addListener(ActionListener listener){
        logOUT.addActionListener(listener);
        OK.addActionListener(listener);
        backUP.addActionListener(listener);
        loadBackUP.addActionListener(listener);
//        selectForFreeButton.addActionListener(listener);

        peopleButton.addActionListener(listener);
        catsButton.addActionListener(listener);
        stayButton.addActionListener(listener);
        employeeButton.addActionListener(listener);
        professionButton.addActionListener(listener);
        roomButton.addActionListener(listener);
        standardButton.addActionListener(listener);

        selectButton.addActionListener(listener);
        insertButton.addActionListener(listener);
        deleteButton.addActionListener(listener);
    }


    /**
     * Default getter of specific button.
     * @return reference to a specific button.
     */
    public JButton getLogOUT() {                          //send selected field of List
        return logOUT;
    }
    /**
     * Default getter of specific button.
     * @return reference to a specific button.
     */
    public JButton getBackUP() {
        return backUP;
    }
    /**
     * Default getter of specific button.
     * @return reference to a specific button.
     */
    public JButton getLoadBackUP() {
        return loadBackUP;
    }
    /**
     * Default getter of specific button.
     * @return reference to a specific button.
     */
    public JButton getOK() {                          //send selected field of List
        return OK;
    }
    /**
     * Default getter of specific button.
     * @return reference to a specific button.
     */
    public JButton getSELECT() {
        return selectButton;
    }
    /**
     * Default getter of specific button.
     * @return reference to a specific button.
     */
    public JButton getINSERT() {
        return insertButton;
    }
    /**
     * Default getter of specific button.
     * @return reference to a specific button.
     */
    public JButton getDELETE() {
        return deleteButton;
    }
    /**
     * Default getter of specific button.
     * @return reference to a specific button.
     */
    public JButton getPEOPLE() {
        return peopleButton;
    }
    /**
     * Default getter of specific button.
     * @return reference to a specific button.
     */
    public JButton getCATS() {
        return catsButton;
    }
    /**
     * Default getter of specific button.
     * @return reference to a specific button.
     */
    public JButton getSTAY() {
        return stayButton;
    }
    /**
     * Default getter of specific button.
     * @return reference to a specific button.
     */
    public JButton getEMPLOYEE() {
        return employeeButton;
    }
    /**
     * Default getter of specific button.
     * @return reference to a specific button.
     */
    public JButton getPROFESSION() {
        return professionButton;
    }
    /**
     * Default getter of specific button.
     * @return reference to a specific button.
     */
    public JButton getROOM() {
        return roomButton;
    }
    /**
     * Default getter of specific button.
     * @return reference to a specific button.
     */
    public JButton getSTANDARD() {
        return standardButton;
    }


    /**
     * This method puts data about specific table at labels.
     * @param selectedData list of a data got from a database to put at labels.
     * @param columnsNumber number of columns provided in a table.
     * @param rowsNumber number of rows provided in a table.
     */
    public void setTextOnLabel(ArrayList<String> selectedData, int columnsNumber, int rowsNumber) {
        this.columnsNumber = columnsNumber;
        this.rowsNumber = rowsNumber;
        if (selectPanel != null) this.remove(selectPanel);
        this.selectPanel = null;
        this.selectPanel = new JPanel();

        if (rowsNumber == selectedData.size()) System.out.println(rowsNumber + " " + columnsNumber);
        JLabel[][] selectLabels = null;
        selectLabels = new  JLabel[rowsNumber][columnsNumber];

        this.selectPanel.setLayout(null);
//        selectPanel.setOpaque(false);
        this.selectPanel.setBounds(0,0,width,height);
        this.selectPanel.setVisible(true);

        for (int i=0; i<rowsNumber; i++) {
            ArrayList<String> row = new ArrayList<String>(Arrays.asList(selectedData.get(i).split(",")));

            for (int j=0; j<columnsNumber; j++) {

                if (selectLabels[i][j] == null) selectLabels[i][j] = new JLabel(row.get(j));
                else selectLabels[i][j].setText(row.get(j));

                this.selectPanel.add(selectLabels[i][j]);
                selectLabels[i][j].setBounds(10 + j*80, 120 + i*20, 80, 20);

                System.out.println(selectLabels[i][j].getText());
//                this.buttonsPanel.add(selectLabels[i][j]);
//                selectLabels[i][j].setBounds(10 + j*80, 80 + i*20, 80, 20);
//                this.add(selectLabels[i][j]);
            }
        }

        this.add(this.selectPanel);
    }

    /**
     * Default getter of a text typed in a text field.
     * @return reference to a text typed in a text field.
     */
    public String getInsertData() {
        return textInsertData.getText();
    }

    /**
     * Method used to show error Message, when user typed incorrect data.
     */
    public void showErrorWindow() {
        String errorMessage = "Please, insert correct data";
        JOptionPane.showMessageDialog(this, errorMessage);
    }
}