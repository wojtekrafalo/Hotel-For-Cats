package main.application.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Class of a window used to log in a user.
 *
 * @author wojtekrafalo
 * @version 1.0
 * @since 1.0
 */
public class LoginWindow extends JFrame{

    private String errorMessage = "Please, type correct nickName";
    private JLabel additionLabel = new JLabel("Please, insert your PESEL & password");
    private JTextField peselTextField = new JTextField(30);
    private JPasswordField passwordField = new JPasswordField(30);
    private JButton OK = new JButton("OK");

    /**
     * Constructor to a Login Window. Sets its size and creates all items, like text fields, labels.
     * @param width width of a window.
     * @param height height of a window.
     */
    LoginWindow (int width, int height) {
        super("LoginWindow");
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new FlowLayout());
        loginPanel.setSize(new Dimension(width,height));
        loginPanel.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(width, height);
        this.setResizable(false);

        additionLabel.setSize(new Dimension(width - 40, height/4));
        peselTextField.setSize(new Dimension(width - 40, height/4));
        passwordField.setSize(new Dimension(width - 40, height/4));

        loginPanel.add(additionLabel);
        loginPanel.add(peselTextField);
        loginPanel.add(passwordField);
        loginPanel.add(OK);

        this.add(loginPanel);
    }

    /**
     * This method adds an Action Listener to an OK button, to make it redirect to another window.
     * @param listener an Action Listener of buttons.
     */
    void addListener(ActionListener listener){
        OK.addActionListener(listener);
    }

    /**
     * Default getter of a Pesel number.
     * @return String of a Pesel number typed by a user to text field.
     */
    public String getPesel() {
        return peselTextField.getText();
    }

    /**
     * Default getter of a password.
     * @return Array of a chars that make up a password. It is captured from the password field.
     */
    public char[] getPassword() {
        return passwordField.getPassword();
    }

    /**
     * Default getter of a Pesel number.
     * @return String of a Pesel number typed by a user to text field.
     */
    public JButton getOK() {
        return OK;
    }
}
