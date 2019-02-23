package main.application.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Class of a window used to choose type of a user.
 *
 * @author wojtekrafalo
 * @version 1.0
 * @since 1.0
 */
public class FirstWindow extends JFrame {

    private JButton adminButton = new JButton("ADMIN");
    private JButton clientButton = new JButton("CLIENT");
    private JButton employeeButton = new JButton("EMPLOYEE");
    private JButton editEmployeeButton = new JButton("EDIT_EMPLOYEE");

    /**
     * Constructor to a First Window. Sets its size and creates all items, like text fields, labels.
     * @param width width of a window.
     * @param height height of a window.
     */
    FirstWindow(int width, int height){
        super("FirstWindow");
        JPanel firstPanel = new JPanel();
        firstPanel.setLayout(new FlowLayout());
        firstPanel.setSize(new Dimension(width,height));
        firstPanel.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(width, height);
        this.setResizable(false);

        JLabel additionLabel = new JLabel("Please, choose your statement");
        firstPanel.add(additionLabel);
        adminButton.setSize(new Dimension(50,50));
        clientButton.setSize(new Dimension(50,50));
        employeeButton.setSize(new Dimension(50,50));
        editEmployeeButton.setSize(new Dimension(50,50));
        firstPanel.add(clientButton);
        firstPanel.add(employeeButton);
        firstPanel.add(editEmployeeButton);
        firstPanel.add(adminButton);

        this.add(firstPanel);
    }


    /**
     * Default getter of an Admin button.
     * @return reference to an admin button.
     */
    public JButton getAdminButton() {
        return adminButton;
    }

    /**
     * Default getter of an Employee button.
     * @return reference to an Employee button.
     */
    public JButton getEmployeeButton() {
        return employeeButton;
    }

    /**
     * Default getter of an Edit Employee button.
     * @return reference to an Edit Employee button.
     */
    public JButton getEditEmployeeButton() {
        return editEmployeeButton;
    }

    /**
     * Default getter of an Client button.
     * @return reference to an Client button.
     */
    public JButton getClientButton() {
        return clientButton;
    }

    /**
     * This method adds an Action Listener to buttons, to make it redirect to another window.
     * @param listener an Action Listener of buttons.
     */
    void addListener(ActionListener listener){
        adminButton.addActionListener(listener);
        clientButton.addActionListener(listener);
        employeeButton.addActionListener(listener);
        editEmployeeButton.addActionListener(listener);
    }
}