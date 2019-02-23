package run;

import main.MySQLJDBCUtil;
import main.application.controller.Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * A class used to run the whole project.
 * @author wojtekrafalo
 * @version 1.0
 * @since 1.0
 */
public class RunClass {

    /**
     * Default main function. Runs the project
     * @param args default array of arguments
     */
    public static void main(String[] args) {

        new Controller();
        String sql = "SELECT * " +
                "FROM pobyty";

        try (Connection conn = MySQLJDBCUtil.getConnection("");
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {

                System.out.println(rs.getString(1) + "\t" +
                        rs.getString(2)  + "\t" +
                        rs.getString(3)  + "\t" +
                        rs.getString(4)  + "\t" +
                        rs.getString(5)  + "\t" +
                        rs.getString(6));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}