package main.application.view;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class of a window provided for editing data employees.
 *
 * @author wojtekrafalo
 * @version 1.0
 * @since 1.0
 */
public class EditEmployeeWindow extends HumanWindow {
    private final static int width = 700, height=700;

    private JButton peopleButton = new JButton("PEOPLE");
    private JButton catsButton = new JButton("CATS");
    private JButton stayButton = new JButton("STAY");
    private JButton logOUT = new JButton("LOG OUT");
    private JButton OK = new JButton("OK");
    private JButton selectButton = new JButton("SELECT");
    private JButton insertButton = new JButton("INSERT");
    private JButton deleteButton = new JButton("DELETE");
    private JButton selectForFreeButton = new JButton("SEARCH_ROOMS");

    private JTextField textDateIN = new JTextField();
    private JTextField textDateOUT= new JTextField();
    private JTextField textStandard = new JTextField();

    private JTextField textInsertData = new JTextField();

    private JLabel[][] selectLabels;
    private int columnsNumber, rowsNumber;
    private JPanel selectPanel;

    private String infoMessage= "You can Edit data here." +
            "\nFirst choose, which table, you want to edit." +
            "\nThen Choose, which operation, you want to perform." +
            "\nThen insert data to this operation";

    EditEmployeeWindow() {
        super("EditEmployeeWindow");

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(null);
        buttonsPanel.setOpaque(false);
        buttonsPanel.setBounds(0,0,width,60);
        buttonsPanel.setVisible(true);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(width, height);
        this.setResizable(false);

        JLabel additionLabel = new JLabel("Please, type which table, you want to edit.");
        buttonsPanel.add(additionLabel);

        textDateIN.setBounds(500,10,50,20);
        textDateOUT.setBounds(500,40,50,20);
        textStandard.setBounds(500,70,50,20);

        textInsertData.setBounds(90,70,200,20);

        peopleButton.setBounds(10,10,80,20);
        catsButton.setBounds(90,10,80,20);
        stayButton.setBounds(170,10,80,20);
        selectButton.setBounds(10,40,80,20);
        insertButton.setBounds(90,40,80,20);
        deleteButton.setBounds(170,40,80,20);


        selectForFreeButton.setBounds(500,90,160,20);
        logOUT.setBounds(380,10,100,20);
        OK.setBounds(300,10,80,20);

        buttonsPanel.add(peopleButton);
        buttonsPanel.add(catsButton);
        buttonsPanel.add(stayButton);
        buttonsPanel.add(selectButton);
        buttonsPanel.add(insertButton);
        buttonsPanel.add(deleteButton);

        buttonsPanel.add(textDateIN);
        buttonsPanel.add(textDateOUT);
        buttonsPanel.add(textStandard);

        buttonsPanel.add(selectForFreeButton);
        buttonsPanel.add(logOUT);
        buttonsPanel.add(OK);

        this.add(buttonsPanel);
        this.add(peopleButton);
        this.add(catsButton);
        this.add(stayButton);
        this.add(selectButton);
        this.add(insertButton);
        this.add(deleteButton);

        this.add(textDateIN);
        this.add(textDateOUT);
        this.add(textStandard);

        this.add(textInsertData);

        this.add(selectForFreeButton);
        this.add(logOUT);
        this.add(OK);
    }


    /**
     * This method adds an Action Listener to buttons, to make it choose a specific action.
     * @param listener an Action Listener of buttons.
     */
    void addListener(ActionListener listener){
        logOUT.addActionListener(listener);
        OK.addActionListener(listener);
        selectForFreeButton.addActionListener(listener);

        selectButton.addActionListener(listener);
        insertButton.addActionListener(listener);
        deleteButton.addActionListener(listener);
        peopleButton.addActionListener(listener);
        catsButton.addActionListener(listener);
        stayButton.addActionListener(listener);
    }


    /**
     * Default getter of a Log OUT button.
     * @return reference to a Log OUT button.
     */
    public JButton getLogOUT() {                                                                                        //send selected field of List
        return logOUT;
    }

    /**
     * Default getter of a OK button.
     * @return reference to a OK button.
     */
    public JButton getOK() {                                                                                            //send selected field of List
        return OK;
    }

    /**
     * Default getter of a SELECT button.
     * @return reference to a SELECT button.
     */
    public JButton getSELECT() {
        return selectButton;
    }

    /**
     * Default getter of an INSERT button.
     * @return reference to an INSERT button.
     */
    public JButton getINSERT() {
        return insertButton;
    }

    /**
     * Default getter of a DELETE button.
     * @return reference to a DELETE button.
     */
    public JButton getDELETE() {
        return deleteButton;
    }

    /**
     * Default getter of a PEOPLE button.
     * @return reference to a PEOPLE button.
     */
    public JButton getPEOPLE() {
        return peopleButton;
    }

    /**
     * Default getter of a CATS button.
     * @return reference to a CATS button.
     */
    public JButton getCATS() {
        return catsButton;
    }

    /**
     * Default getter of a STAY button.
     * @return reference to a STAY button.
     */
    public JButton getSTAY() {
        return stayButton;
    }

    /**
     * Default getter of a SELECT_FOR_FREE_BUTTON button.
     * @return reference to a SELECT_FOR_FREE_BUTTON button.
     */
    public JButton getSelectForFreeButton() {
        return selectForFreeButton;
    }


    /**
     * Default getter of a text typed in a text field called TEXT_DATE_IN.
     * @return reference to a text typed in a text field.
     */
    public String getTextDateIN() {
        return textDateIN.getText();
    }

    /**
     * Default getter of a text typed in a text field called TEXT_DATE_OUT.
     * @return reference to a text typed in a text field.
     */
    public String getTextDateOUT() {
        return textDateOUT.getText();
    }

    /**
     * Default getter of a text typed in a text field called STANDARD.
     * @return reference to a text typed in a text field.
     */
    public String getTextStandard() {
        return textStandard.getText();
    }

    /**
     * This method show data about specific table. It gives a possibility to display specific rows and columns.
     * @param selectedData list of data labels selected from a database
     * @param columnsNumber number of columns to write at panel.
     * @param rowsNumber number of rows to write at panel.
     */
    public void setTextOnLabel(ArrayList<String> selectedData, int columnsNumber, int rowsNumber) {
        this.columnsNumber = columnsNumber;
        this.rowsNumber = rowsNumber;
        if (selectPanel != null) this.remove(selectPanel);
        this.selectPanel = null;
        this.selectPanel = new JPanel();

        if (rowsNumber == selectedData.size()) System.out.println(rowsNumber + " " + columnsNumber);
        selectLabels =  null;
        selectLabels = new  JLabel[rowsNumber][columnsNumber];

        this.selectPanel.setLayout(null);
        this.selectPanel.setBounds(0,0,width,height);
        this.selectPanel.setVisible(true);

        for (int i=0; i<rowsNumber; i++) {
            ArrayList<String> row = new ArrayList<>(Arrays.asList(selectedData.get(i).split(",")));

            for (int j=0; j<columnsNumber; j++) {

                if (selectLabels[i][j] == null) selectLabels[i][j] = new JLabel(row.get(j));
                else selectLabels[i][j].setText(row.get(j));

                this.selectPanel.add(selectLabels[i][j]);
                selectLabels[i][j].setBounds(10 + j*80, 120 + i*20, 80, 20);
            }
        }

        this.add(this.selectPanel);
     }

    /**
     * This method sets information about free rooms at label.
     * @param infoAboutFreeRooms list of labels about free rooms represented by one String.
     */
    public void setInfoAboutFreeRooms(String infoAboutFreeRooms) {
        ArrayList<String> freeRooms = new ArrayList<String>(Arrays.asList(infoAboutFreeRooms.split(",")));

        if (selectPanel != null) this.remove(selectPanel);
        this.selectPanel = null;
        this.selectPanel = new JPanel();

        selectLabels =  null;
        this.selectLabels = new JLabel[freeRooms.size()][1];

        this.selectPanel.setLayout(null);

        this.selectPanel.setBounds(0,0,width,height);
        this.selectPanel.setVisible(true);

        for (int i=0; i<freeRooms.size(); i++) {

            if (selectLabels[i][0] == null) selectLabels[i][0] = new JLabel(freeRooms.get(i));
            else selectLabels[i][0].setText(freeRooms.get(i));

            this.selectPanel.add(selectLabels[i][0]);
            selectLabels[i][0].setBounds(10, 80 + i*20, 80, 20);
        }

        this.add(this.selectPanel);
    }


    /**
     * Default getter of a text typed in a text field called INSERT_DATA.
     * @return reference to a text typed in a text field.
     */
    public String getInsertData() {
        return textInsertData.getText();
    }

    /**
     * Method used to show error Message, when user typed incorrect data.
     */
    public void showErrorWindow() {
        String errorMessage = "Please, type correct data";
        JOptionPane.showMessageDialog(this, errorMessage);
    }
}
