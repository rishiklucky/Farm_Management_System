/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package farmmanagementsystem.db;

/**
 *
 * @author Aldrin
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {


    private static Connection con;

    public void getDBConn() {
        synchronized ("") {
            try {
                if (this.getCon() == null || this.getCon().isClosed()) {
                    try {
                        String url = "jdbc:mysql://localhost:3306/fms";//jdbc:mysql://127.0.0.1:3306/?user=root
                        Class.forName("com.mysql.jdbc.Driver");
                        setCon(DriverManager.getConnection(url, "root", "mysql@123"));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * @return the con
     */
    public static Connection getCon() {
        return con;
    }

    /**
     * @param aCon the con to set
     */
    public static void setCon(Connection aCon) {
        con = aCon;
    }

    public static void closeConnection() {
        try {
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
