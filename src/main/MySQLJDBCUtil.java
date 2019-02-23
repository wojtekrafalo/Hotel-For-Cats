package main;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


/**
 * A class used to create a connection to database and get specific data from it.
 * @author wojtekrafalo
 * @version 1.0
 * @since 1.0
 */
public class MySQLJDBCUtil {
    private static String pathToSRC = "C:\\Users\\wojte\\OneDrive\\Desktop\\files\\git\\Hotel-For-Cats\\Hotel-For-Cats\\src\\main\\db.properties";

    /**
     * A method used to get a connection to database.
     * @param access a name of specific table.
     * @return a Connection object.
     * @throws SQLException an exception in case of getConnection method.
     */
    public static Connection getConnection(String access) throws SQLException {
        Connection conn = null;

        String pathToSpecific = pathToSRC + access + ".txt";
        try (FileInputStream f = new FileInputStream(pathToSpecific)) {

            // load the properties file
            Properties pros = new Properties();
            pros.load(f);

            // assign db parameters
            String url = pros.getProperty("url");
            String user = pros.getProperty("user");
            String password = pros.getProperty("password");


            // create a connection to the database
            conn = DriverManager.getConnection(url, user, password);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    /**
     * A method used to get a login of a specific user from the database.
     * @param access a name of specific table.
     * @return a login of specific user.
     */
    public static String getLogin(String access) {
        String user = null;

        String pathToSpecific = pathToSRC + access + ".txt";
        try (FileInputStream f = new FileInputStream(pathToSpecific)) {

            Properties pros = new Properties();
            pros.load(f);

            user = pros.getProperty("user");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return user;
    }

    /**
     * A method used to get a password of a specific user from the database.
     * @param access a name of specific table.
     * @return a password of specific user.
     */
    public static char[] getPassword(String access) {
        String password=null;
        char[] pass = null;

        String pathToSpecific = pathToSRC + access + ".txt";
        try (FileInputStream f = new FileInputStream(pathToSpecific)) {

            Properties pros = new Properties();
            pros.load(f);

            password = pros.getProperty("password");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            assert password != null;
            pass = new char[password.length()];

            for (int i=0; i < password.length(); i++) {
                pass[i] = password.charAt(i);
            }
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
        return pass;
    }


    /**
     * A method used to get a url of a specific table from the database.
     * @param access a name of specific table.
     * @return a url of a specific table.
     */
    public static String getUrl(String access) {
        String url=null;

        String pathToSpecific = pathToSRC + access + ".txt";
        try (FileInputStream f = new FileInputStream(pathToSpecific)) {

            Properties pros = new Properties();
            pros.load(f);

            url = pros.getProperty("url");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return url;
    }
}