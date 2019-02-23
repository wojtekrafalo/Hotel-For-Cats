package main.application.view;

import javax.swing.event.MouseInputListener;
import java.awt.event.ActionListener;

/**
 * Class managing a view of all windows in the Project.
 *
 * @author wojtekrafalo
 * @version 1.0
 * @since 1.0
 */
public class View {
    private static final int DEF_WIDTH = 600, DEF_HEIGHT = 600,
            FIRST_WIDTH= 260, FIRST_HEIGHT=200,
            LOGIN_WIDTH= 500, LOGIN_HEIGHT=200,
            NEW_WIDTH = 300, NEW_HEIGHT = 600;

    private FirstWindow firstWindow = new FirstWindow(FIRST_WIDTH, FIRST_HEIGHT);
    private LoginWindow loginWindow;

    private ClientWindow clientWindow;
    private EmployeeWindow employeeWindow;
    private EditEmployeeWindow editEmployeeWindow;
    private AdminWindow adminWindow;

    /**
     * Default constructor. Creates all windows and sets visibility of the First One.
     */
    public View() {
        System.out.println("theView created");
        firstWindow.setVisible(true);
        loginWindow = new LoginWindow(LOGIN_WIDTH, LOGIN_HEIGHT);
        clientWindow = new ClientWindow();
        adminWindow = new AdminWindow();
        employeeWindow = new EmployeeWindow();
        editEmployeeWindow = new EditEmployeeWindow();
    }

    /**
     * This method sets Action Listener to all windows and a Mouse Listener to client window.
     * @param listener Action Listener, which provides all actions related with clicking buttons.
     * @param mouseListListener Listener, which provides all actions related with clicking mouse button at Panels.
     */
    public void addListener(ActionListener listener, MouseInputListener mouseListListener){
        firstWindow.addListener(listener);
        loginWindow.addListener(listener);
        employeeWindow.addListener(listener);
        clientWindow.addListener(listener, mouseListListener);
        editEmployeeWindow.addListener(listener);
        adminWindow.addListener(listener);
    }

    /**
     * This method sets visibility of the window provided for a signing in.
     */
    public void hideShow1 () {
        firstWindow.setVisible(false);
        loginWindow.setVisible(true);
    }

    /**
     * This method sets visibility of the specific Human Window (Client or Employee).
     * @param window reference to the specific Window.
     */
    public void hideShow2 (HumanWindow window) {
        loginWindow.setVisible(false);                                                                                  //set a chosen window as visible now
        window.setVisible(true);
    }

    /**
     * This method sets visibility of the first Window and hides a specific Human Window (Client or Employee).
     * @param window reference to the specific Window.
     */
    public void logOutShow (HumanWindow window) {
        System.out.println("LOGout Clicked");
        window.setVisible(false);
        firstWindow.setVisible(true);
    }

    /**
     * Default getter of a First Window.
     * @return reference to a First Window.
     */
    public FirstWindow getFirstWindow () {
        return firstWindow;
    }

    /**
     * Default getter of a Login Window.
     * @return reference to a Login Window.
     */
    public LoginWindow getLoginWindow() {
        return loginWindow;
    }

    /**
     * Default getter of a Client Window.
     * @return reference to a Client Window.
     */
    public ClientWindow getClientWindow() {
        return clientWindow;
    }

    /**
     * Default getter of a Admin Window.
     * @return reference to a Admin Window.
     */
    public AdminWindow getAdminWindow () {
        return adminWindow;
    }

    /**
     * Default getter of a Employee Window.
     * @return reference to a Employee Window.
     */
    public EmployeeWindow getEmployeeWindow () {
        return employeeWindow;
    }

    /**
     * Default getter of a Edit Employee Window.
     * @return reference to a Edit Employee Window.
     */
    public EditEmployeeWindow getEditEmployeeWindow () {
        return editEmployeeWindow;
    }
}