package main.application.controller;

import main.MySQLJDBCUtil;
import main.application.view.*;

import javax.swing.event.MouseInputListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class of a Controller and Model of a MVC pattern related with project.
 * Provides reactions on clicking buttons and actions connected with database.
 * It has several inner classes like Listeners.
 * @author wojtekrafalo
 * @version 1.0
 * @since 1.0
 */
public class Controller {
    private View theView;

    private HumanWindow chosenFrame = null;

    private String pesel;
    private String access="Client";

    private String operation="", table="";
    private ArrayList<String> values;

    /**
     * Default constructor. Creates the View and sets listeners.
     */
    public Controller() {
        System.out.println("theController created");

        this.theView = new View();
        this.theView.addListener(new MyActionListener(), new MouseListListener());
    }

    /**
     * Inner class of a ActionListener. Reacts on actions like clicking buttons.
     *
     * @author wojtekrafalo
     * @version 1.0
     * @since 1.0
     */
    class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            FirstWindow firstWindow = theView.getFirstWindow();
            LoginWindow loginWindow = theView.getLoginWindow();
            AdminWindow adminWindow = theView.getAdminWindow();
            ClientWindow clientWindow = theView.getClientWindow();
            EmployeeWindow employeeWindow = theView.getEmployeeWindow();
            EditEmployeeWindow editEmployeeWindow = theView.getEditEmployeeWindow();

            if (e.getSource().equals(firstWindow.getAdminButton())) {
                System.out.println("\nAdmin");
                chosenFrame = adminWindow;
                theView.hideShow1();
                access = "Admin";
            }
            if (e.getSource().equals(firstWindow.getClientButton())) {
                System.out.println("\nClient");
                chosenFrame = clientWindow;
                theView.hideShow1();
                access = "Client";
            }
            if (e.getSource().equals(firstWindow.getEmployeeButton())) {
                System.out.println("\nEmployee");
                chosenFrame = employeeWindow;
                theView.hideShow1();
                access = "Employee";
            }
            if (e.getSource().equals(firstWindow.getEditEmployeeButton())) {
                System.out.println("\nEditEmployee");
                chosenFrame = editEmployeeWindow;
                theView.hideShow1();
                access = "Editemployee";
            }

            if (e.getSource().equals(employeeWindow.getRefreshButton())) {
                drawLabelsAboutRooms(employeeWindow);
            }

            if (e.getSource().equals(loginWindow.getOK())) {
                pesel = loginWindow.getPesel();
                char[] password = loginWindow.getPassword();


                boolean t = true;
                char[] pass = MySQLJDBCUtil.getPassword(access);

                for (char pas : pass) System.out.print(pas);
                System.out.println();
                for (char aPassword : password) System.out.print(aPassword);
                if (pass.length != password.length) t = false;
                else
                    for (int i = 0; i< password.length; i++) {
                        if (password[i] != pass[i]) t = false;
                    }

                if (t) {

                    theView.hideShow2(chosenFrame);

                    if (chosenFrame.equals(employeeWindow)) {
                        drawLabelsAboutRooms(employeeWindow);
                    }
                    if (chosenFrame.equals(clientWindow)) {
                        drawLabelsAboutCats(clientWindow);
                    }
                }
            }

            if (e.getSource().equals(editEmployeeWindow.getCATS()))     table="koty";
            if (e.getSource().equals(editEmployeeWindow.getSTAY()))     table="pobyty";
            if (e.getSource().equals(editEmployeeWindow.getPEOPLE()))   table="ludzie";

            if (e.getSource().equals(editEmployeeWindow.getSELECT())) operation="SELECT";
            if (e.getSource().equals(editEmployeeWindow.getINSERT())) operation="INSERT";
            if (e.getSource().equals(editEmployeeWindow.getDELETE())) operation="DELETE";


            if (e.getSource().equals(adminWindow.getCATS()))     table="koty";
            if (e.getSource().equals(adminWindow.getSTAY()))     table="pobyty";
            if (e.getSource().equals(adminWindow.getPEOPLE()))   table="ludzie";
            if (e.getSource().equals(adminWindow.getEMPLOYEE()))   table="pracownicy";
            if (e.getSource().equals(adminWindow.getPROFESSION()))   table="stanowisko";
            if (e.getSource().equals(adminWindow.getROOM()))   table="pokoj";
            if (e.getSource().equals(adminWindow.getSTANDARD()))   table="standard";

            if (e.getSource().equals(adminWindow.getSELECT())) operation="SELECT";
            if (e.getSource().equals(adminWindow.getINSERT())) operation="INSERT";
            if (e.getSource().equals(adminWindow.getDELETE())) operation="DELETE";


            if (e.getSource().equals(editEmployeeWindow.getOK())) {
                if (!table.equals("") && !operation.equals("")) {
                    String query = operation;
                    if (operation.equals("SELECT")) {
                        query = query + "* FROM " + table;
                        selectLabelsForEditEmployee(query);
                    }

                    if (operation.equals("INSERT")) {
                        ArrayList<String> insertParameters = new ArrayList<>(Arrays.asList(editEmployeeWindow.getInsertData().split(",")));

                        for (String s : insertParameters) System.out.println(s);

                        try {
                            if (table.equals("ludzie")) {
                                long peselNumber = Long.parseLong(insertParameters.get(0));
                            }
                            insertIntoFirstTables(insertParameters, table);
                        } catch (NumberFormatException ex) {
                            editEmployeeWindow.showErrorWindow();
                        }

                    }

                    if (operation.equals("DELETE")) {
                        String keyValie = editEmployeeWindow.getInsertData();

                        deleteFromFirstTables(keyValie, table);
                    }
                }
            }

            if (e.getSource().equals(adminWindow.getOK())) {
                if (!table.equals("") && !operation.equals("")) {
                    String query = operation;
                    if (operation.equals("SELECT")) {
                        query = query + "* FROM " + table;
                        selectLabelsForAdmin(query);
                    }
                }

                if (operation.equals("INSERT")) {
                    ArrayList<String> insertParameters = new ArrayList<>(Arrays.asList(adminWindow.getInsertData().split(",")));
                    for (String s : insertParameters) System.out.println(s);
                    try {
                        if (table.equals("ludzie")) {
                            long peselNumber = Long.parseLong(insertParameters.get(0));
                        }
                        insertIntoSecondTables(insertParameters, table);
                    } catch (NumberFormatException ex) {
                        System.out.println("WROCG_CAST_PESEL_TO_INTEGER");
                        adminWindow.showErrorWindow();
                    }
                }

                if (operation.equals("DELETE")) {
                    String keyValue = adminWindow.getInsertData();
                    deleteFromSecondTables(keyValue, table);
                }
            }

            if (e.getSource().equals(editEmployeeWindow.getSelectForFreeButton())) {
                selectForFreeRooms(editEmployeeWindow.getTextDateIN(), editEmployeeWindow.getTextDateOUT(), editEmployeeWindow.getTextStandard());
            }

            if (e.getSource().equals(adminWindow.getBackUP())) {
                executeBackUp();
            }

            if (e.getSource().equals(editEmployeeWindow.getLogOUT())) {
                theView.logOutShow(editEmployeeWindow);
            }
            if (e.getSource().equals(employeeWindow.getLogOUT())) {
                theView.logOutShow(employeeWindow);
            }
            if (e.getSource().equals(clientWindow.getLogOUT())) {
                theView.logOutShow(clientWindow);
            }
            if (e.getSource().equals(adminWindow.getLogOUT())) {
                theView.logOutShow(adminWindow);
            }
        }

        private void selectLabelsForEditEmployee (String sentence) {
            int columnsNumber = 0;
            int rowsNumber = 0;

            String query = "{ call procedureForEditEmployee(?) }";                                                      //query if we will use a procedure, this line should be replaced, and there is a name of the procedure.

            ArrayList<String> returnedData = new ArrayList<>();

            try (Connection conn = MySQLJDBCUtil.getConnection("Editemployee");
                 Statement stmt = conn.createStatement();
                 ResultSet selectedTable = stmt.executeQuery(sentence)) {

                ResultSetMetaData rsmd = selectedTable.getMetaData();

                columnsNumber = rsmd.getColumnCount();
                rowsNumber = 0;
                // loop through the result set
                while (selectedTable.next()) {
                    String row="";
                    for (int i=1; i<=columnsNumber; i++) {
                        row = row + selectedTable.getString(i) + ", ";
                    }

                    returnedData.add(row);
                    rowsNumber++;
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

            theView.getEditEmployeeWindow().setTextOnLabel(returnedData, columnsNumber, rowsNumber);
        }

        private void selectLabelsForAdmin (String sentence) {
            int columnsNumber = 0;
            int rowsNumber = 0;

            String query = "{ call procedureForEditEmployee(?) }";                                                      //query if we will use a procedure, this line should be replaced, and there is a name of the procedure.

            ArrayList<String> returnedData = new ArrayList<>();

            try (Connection conn = MySQLJDBCUtil.getConnection("Admin");
                 Statement stmt = conn.createStatement();
                 ResultSet selectedTable = stmt.executeQuery(sentence)) {

                ResultSetMetaData rsmd = selectedTable.getMetaData();

                columnsNumber = rsmd.getColumnCount();
                rowsNumber = 0;

                // loop through the result set
                while (selectedTable.next()) {
                    String row="";
                    for (int i=1; i<=columnsNumber; i++) {
                        row = row + selectedTable.getString(i) + ", ";
                    }

                    returnedData.add(row);
                    rowsNumber++;
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

            theView.getAdminWindow().setTextOnLabel(returnedData, columnsNumber, rowsNumber);
        }


        private void drawLabelsAboutCats (ClientWindow clientWindow) {
            String query = "{ call selectForClients(?) }";

            String catData = "";
            String numberData = "";
            String moveINData = "";
            String moveOUTData = "";
            String priceData = "";

            chosenFrame.setTitle(pesel);

            ResultSet roomTable;

            try (Connection conn = MySQLJDBCUtil.getConnection("Client");
                 CallableStatement stmt = conn.prepareCall(query)) {

                stmt.setString(1, pesel);

                roomTable = stmt.executeQuery();

                // loop through the result set
                while (roomTable.next()) {

                    String cat      = roomTable.getString(1);
                    String room     = roomTable.getString(2);
                    String moveIN = roomTable.getString(3);
                    String moveOUT = roomTable.getString(4);
                    String price = roomTable.getString(5);

                    catData = catData + cat + ",";
                    numberData = numberData + room + ",";
                    moveINData = moveINData + moveIN + ",";
                    moveOUTData = moveOUTData + moveOUT + ",";
                    priceData = priceData + price + ",";
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

            clientWindow.setInfoAboutCats(catData, numberData, moveINData, moveOUTData, priceData);
        }

        private void drawLabelsAboutRooms (EmployeeWindow employeeWindow) {
            String query = "{ call selectForWorkers() }";

            String numberData = "";
            String standardData = "";

            chosenFrame.setTitle(pesel);

            ResultSet roomTable;

            try (Connection conn = MySQLJDBCUtil.getConnection("Employee");
                 CallableStatement stmt = conn.prepareCall(query)) {

                    System.out.println(conn + " " + stmt);
                    roomTable = stmt.executeQuery();

                    // loop through the result set
                    while (roomTable.next()) {
                        String room     = roomTable.getString("numer");
                        String standard = roomTable.getString("standard");

                        numberData = numberData + room + ",";
                        standardData = standardData + standard + ",";
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }

            System.out.println(numberData + " " + standardData);

            employeeWindow.setInfoAboutRooms(numberData, standardData);

        }
    }

    /**
     * A method responsible for inserting data to a Stays Table.
     * @param insertParameters list of parameters required by a specific table.
     * @param table name of a specific table, in which data will be inserted.
     */
    private void insertIntoSecondTables(ArrayList<String> insertParameters, String table) {
        String query="";
        int i=insertParameters.size();

        if (table.equals("koty")) {query = "{ call insKoty(?,?) }"; if (i!=2) {theView.getEditEmployeeWindow().showErrorWindow(); return;}}
        if (table.equals("ludzie")) {
            query = "{ call insWlasciciel(?,?,?,?,?,?) }";
            if (i!=6) {
                theView.getEditEmployeeWindow().showErrorWindow(); return;
            }
        }
        if (table.equals("pobyty")) {query = "{ call insPobyty(?,?,?,?,?) }"; if (i!=5) {theView.getEditEmployeeWindow().showErrorWindow(); return;}}
        if (table.equals("pracownicy")) {query = "{ call insPracownicy(?,?,?) }"; if (i!=3) {theView.getEditEmployeeWindow().showErrorWindow(); return;}}
        if (table.equals("stanowisko")) {query = "{ call insStanowisko(?,?) }"; if (i!=2) {theView.getEditEmployeeWindow().showErrorWindow(); return;}}
        if (table.equals("pokoj")) {query = "{ call insPokoj(?,?) }"; if (i!=2) {theView.getEditEmployeeWindow().showErrorWindow(); return;}}
        if (table.equals("standard")) {query = "{ call insStandard(?,?) }"; if (i!=2) {theView.getEditEmployeeWindow().showErrorWindow(); return;}}


        try (Connection conn = MySQLJDBCUtil.getConnection("Admin");
             CallableStatement stmt = conn.prepareCall(query)) {

            for (int j=1; j<=i; j++) {
                stmt.setString(j, insertParameters.get(j-1));
            }

            System.out.println(stmt.toString());

            stmt.executeQuery();
            // loop through the result set
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * A method responsible for inserting data to a People Table.
     * @param insertParameters list of parameters required by a specific table.
     * @param table name of a specific table, in which data will be inserted.
     */
    private void insertIntoFirstTables(ArrayList<String> insertParameters, String table) {
        String query="";
        int i=insertParameters.size();

        if (table.equals("koty")) {query = "{ call insKoty(?,?) }"; if (i!=2) {theView.getEditEmployeeWindow().showErrorWindow(); return;}}
        if (table.equals("ludzie")) {query = "{ call insWlasciciel(?,?,?,?,?,?) }"; if (i!=6) {theView.getEditEmployeeWindow().showErrorWindow(); return;}}
        if (table.equals("pobyty")) {query = "{ call insPobyty(?,?,?,?,?) }"; if (i!=5) {theView.getEditEmployeeWindow().showErrorWindow(); return;}}


        try (Connection conn = MySQLJDBCUtil.getConnection("Editemployee");
             CallableStatement stmt = conn.prepareCall(query)) {

            for (int j=1; j<=i; j++) {
                stmt.setString(j, insertParameters.get(j-1));
            }

            System.out.println(stmt.toString());

            stmt.executeQuery();
            // loop through the result set
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * A method responsible for deletion data to a People Table.
     * @param keyValue name of a key field.
     * @param table name of a specific table, from which data will be deleted.
     */
    private void deleteFromFirstTables(String keyValue, String table) {
        String query="";

        if (table.equals("koty")) query = "{ call delKoty(?) }";
        if (table.equals("ludzie")) query = "{ call delWlasciciel(?) }";
        if (table.equals("pobyty")) query = "{ call delPobyty(?) }";


        try (Connection conn = MySQLJDBCUtil.getConnection("Editemployee");
             CallableStatement stmt = conn.prepareCall(query)) {

            stmt.setString(1, keyValue);

            System.out.println(stmt.toString());

            stmt.executeQuery();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * A method responsible for deletion data to a Stays Table.
     * @param keyValue name of a key field.
     * @param table name of a specific table, from which data will be deleted.
     */
    private void deleteFromSecondTables(String keyValue, String table) {
        String query="";

        if (table.equals("koty")) query = "{ call delKoty(?) }";                    //
        if (table.equals("ludzie")) query = "{ call delWlasciciel(?) }";            //
        if (table.equals("pobyty")) query = "{ call delPobyty(?) }";                //
        if (table.equals("pracownicy")) query = "{ call delPracownicy(?) }";        //
        if (table.equals("stanowisko")) query = "{ call delStanowisko(?) }";        //
        if (table.equals("pokoj")) query = "{ call delPokoj(?) }";                  //
        if (table.equals("standard")) query = "{ call delStandard(?) }";            //


        try (Connection conn = MySQLJDBCUtil.getConnection("Admin");
             CallableStatement stmt = conn.prepareCall(query)) {

            stmt.setString(1, keyValue);

            System.out.println(stmt.toString());

            stmt.executeQuery();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void executeBackUp(){
        try {
            Runtime.getRuntime().exec("Cmd /c \"C:/Program Files/MySQL/MySQL Server 5.7/bin/mysqldump\" -u root -pW8R10oahi9 hotel > "+"C:/Users/WojciechKarol/Desktop/backup.sql");
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    private void selectForFreeRooms(String dateIN, String dateOUT, String standard) {
        String query = "{ call findRoom(?,?,?) }";

        ResultSet roomTable;
        String room = "";

        try (Connection conn = MySQLJDBCUtil.getConnection("Editemployee");
             CallableStatement stmt = conn.prepareCall(query)) {

            stmt.setString(1, dateIN);
            stmt.setString(2, dateOUT);
            stmt.setString(3, standard);

            roomTable = stmt.executeQuery();
            // loop through the result set
            while (roomTable.next()) {
                room = room + roomTable.getString(1) + ",";
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println(room);

        theView.getEditEmployeeWindow().setInfoAboutFreeRooms(room);
    }


    /**
     * Inner class of a MouseListener. Reacts on actions like
     * clicking specific row in a table to show more details about it.
     *
     * @author wojtekrafalo
     * @version 1.0
     * @since 1.0
     */
    class MouseListListener implements MouseInputListener{
        @Override
        public void mouseClicked(MouseEvent e) {
            if (theView.getClientWindow().getData() != null) {
                int index = theView.getClientWindow().getList().locationToIndex(e.getPoint());
                System.out.println("Clicked on Item " + index);
                theView.getClientWindow().setInfoAboutCat(index);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {}
        @Override
        public void mouseReleased(MouseEvent e) {}
        @Override
        public void mouseEntered(MouseEvent e) {}
        @Override
        public void mouseExited(MouseEvent e) {}
        @Override
        public void mouseDragged(MouseEvent e) {}
        @Override
        public void mouseMoved(MouseEvent e) {}
    }

}

//97011401111,Wojciech,Rafalowski,19970114,wojtekrafalo@wp.pl,789357505