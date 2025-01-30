/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package farmmanagementsystem.db;

import farmmanagementsystem.model.Activity;
import farmmanagementsystem.model.Claim;
import farmmanagementsystem.model.Deduction;
import farmmanagementsystem.model.Employee;
import farmmanagementsystem.model.Expenses;
import farmmanagementsystem.model.GrossProfit;
import farmmanagementsystem.model.Location;
import farmmanagementsystem.model.Log;
import farmmanagementsystem.model.Salary;
import farmmanagementsystem.model.User;
import farmmanagementsystem.util.FileEditor;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import javax.imageio.ImageIO;

/**
 *
 * @author Aldrin
 */
public class DBQuery {

    private static double totalGross;
    private static double totalShare;
    private static String startDate;
    private static String endDate;
    static DBConnection c = new DBConnection();

    public static ArrayList<Log> getLog(int category, String val, Date from, Date to) throws FileNotFoundException {
        try {
//User ID
//Name
//Activity
            val = val.replace("'", "\\'");
            ArrayList<Log> list = new ArrayList<>();
            ResultSet rst;
            String txt = "", txt1 = "";
            switch (category) {
                case 0:
                    txt = "u.user_id like '%" + val + "%' ";
                    break;
                case 1:
                    txt = "concat(Lname,', ',Fname,' ',LEFT(Mname,1),'.') like '%" + val + "%' ";
                    break;
                case 2:
                    txt = "u.Activity like '%" + val + "%' ";
                    break;
            }
            if (!txt.isEmpty()) {
                txt1 = " AND ";
            }
            String d1 = String.format("%tF\n", from), d2 = String.format("%tF\n", to);
            String Range = " DATE(log_date)>= '" + d1 + "' AND DATE(log_date)<= '" + d2 + "' ";
            String sql = "SELECT u.* FROM _log u, _user d WHERE u.user_id = d.user_id AND  " + txt + txt1 + Range + "ORDER BY log_id DESC";
            c.getDBConn();
            java.sql.Statement st = c.getCon().createStatement();
            rst = st.executeQuery(sql);
            while (rst.next()) {
                Log temp = new Log(getUser(rst.getString("user_id")));
                temp.setActivity(rst.getString("Activity"));
                temp.setLog_date(new Date(rst.getTimestamp("log_date").getTime()));
                temp.setLog_id(rst.getInt("log_id"));
                list.add(temp);
            }
            rst.close();
            st.close();
            c.closeConnection();
            return list;
        } catch (SQLException ex) {
            String err = ex.getMessage();
            System.out.println(err);
            FileEditor.toError("Database Error", err);
        }
        return null;
    }

    public static void changePW(User user) {
        try {
            String sql = "UPDATE _user SET "
                    + "_password = '" + user.getPassword().replace("'", "\\'") + "' "
                    + "WHERE user_id = '" + user.getUser_id().replace("'", "\\'") + "';";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            st.executeUpdate(sql);
            st.close();
            c.closeConnection();
        } catch (Exception ex) {
            String err = ex.getMessage();
            System.out.println(err);
            FileEditor.toError("Database Error", err);
        }
    }

    public static User getUser(String userID) {
        try {
            ResultSet rst;
            String query = "SELECT * FROM _user u WHERE user_id = '" + userID.replace("'", "\\'") + "';";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            rst = st.executeQuery(query);
            if (rst.next()) {
                User temp = new User();
                temp.setActive(rst.getBoolean("is_active"));
                temp.setAddress(rst.getString("Address"));
                temp.setFname(rst.getString("Fname"));
                temp.setLname(rst.getString("Lname"));
                temp.setMname(rst.getString("Mname"));
                temp.setPassword(rst.getString("_password"));
                temp.setUserType(rst.getString("user_type"));
                temp.setUser_id(rst.getString("user_id"));
                return temp;
            }
            rst.close();
            st.close();
            c.closeConnection();
        } catch (Exception ex) {
            String err = ex.getMessage();
            System.out.println(err);
            FileEditor.toError("Database Error", err);
        }
        return null;
    }

    public static int generateClaimID() {
        try {
            ResultSet rst;
            String query = "SELECT 11100+count(*) AS ID FROM claim;";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            rst = st.executeQuery(query);
            if (rst.next()) {
                return rst.getInt("ID");
            }
            rst.close();
            st.close();
            c.closeConnection();
        } catch (Exception ex) {
            String err = ex.getMessage();
            System.out.println(err);
            FileEditor.toError("Database Error", err);
        }
        return -1;
    }

    public static int generateDeductionID() {
        try {
            ResultSet rst;
            String query = "SELECT 110101+count(*) AS ID FROM deduction;";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            rst = st.executeQuery(query);
            if (rst.next()) {
                return rst.getInt("ID");
            }
            rst.close();
            st.close();
            c.closeConnection();
        } catch (Exception ex) {
            String err = ex.getMessage();
            System.out.println(err);
            FileEditor.toError("Database Error", err);
        }
        return -1;
    }

    public static int generateGrossProfitID() {
        try {
            ResultSet rst;
            String query = "SELECT 10101+count(*) AS ID FROM gross_profit;";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            rst = st.executeQuery(query);
            if (rst.next()) {
                return rst.getInt("ID");
            }
            rst.close();
            st.close();
            c.closeConnection();
        } catch (Exception ex) {
            String err = ex.getMessage();
            System.out.println(err);
            FileEditor.toError("Database Error", err);
        }
        return -1;
    }

    public static int generateActID() {
        try {
            ResultSet rst;
            String query = "SELECT 11001+count(*) AS ID FROM activity;";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            rst = st.executeQuery(query);
            if (rst.next()) {
                return rst.getInt("ID");
            }
            rst.close();
            st.close();
            c.closeConnection();
        } catch (Exception ex) {
            String err = ex.getMessage();
            System.out.println(err);
            FileEditor.toError("Database Error", err);
        }
        return -1;
    }

    public static int generateLocID() {
        try {
            ResultSet rst;
            String query = "SELECT 101+count(*) AS ID FROM location;";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            rst = st.executeQuery(query);
            if (rst.next()) {
                return rst.getInt("ID");
            }
            rst.close();
            st.close();
            c.closeConnection();
        } catch (Exception ex) {
            String err = ex.getMessage();
            System.out.println(err);
            FileEditor.toError("Database Error", err);
        }
        return -1;
    }

    public static int generateEmpID() {
        try {
            ResultSet rst;
            String query = "SELECT 100000+count(*) AS ID FROM employee;";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            rst = st.executeQuery(query);
            if (rst.next()) {
                return rst.getInt("ID");
            }
            rst.close();
            st.close();
            c.closeConnection();
        } catch (Exception ex) {
            String err = ex.getMessage();
            System.out.println(err);
            FileEditor.toError("Database Error", err);
        }
        return -1;
    }

    public static boolean isExistName(String Name) {
        try {
            ResultSet rst;
            String query = "SELECT * FROM employee WHERE name = '" + Name.replace("'", "\\'") + "';";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            rst = st.executeQuery(query);

            return rst.next();
        } catch (Exception ex) {
            String err = ex.getMessage();
            System.out.println(err);
            FileEditor.toError("Database Error", err);
        }
        c.closeConnection();
        return false;
    }

    public static boolean isExistLocation(String add) {
        try {
            ResultSet rst;
            String query = "SELECT * FROM location l WHERE address = '" + add.replace("'", "\\'") + "';";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            rst = st.executeQuery(query);

            return rst.next();

        } catch (Exception ex) {
            String err = ex.getMessage();
            System.out.println(err);
            FileEditor.toError("Database Error", err);
        }
        c.closeConnection();
        return false;
    }

    public static boolean isExistActivity(int loc_id) {
        try {
            ResultSet rst;
            String query = "SELECT * FROM activity WHERE _status = false AND loc_id = " + loc_id + ";";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            rst = st.executeQuery(query);

            return rst.next();

        } catch (SQLException ex) {
            String err = ex.getMessage();
            System.out.println(err);
            FileEditor.toError("Database Error", err);
        }
        c.closeConnection();
        return false;
    }

    public static void addClaim(Claim cl) {
        try {
            String sql = "INSERT INTO claim VALUES("
                    + cl.getClaim_id() + ",'"
                    + String.format("%tF\n", cl.getDate()) + "',"
                    + cl.getTotal_salary() + ","
                    + cl.getTotal_deduction() + ","
                    + cl.getEmp_id() + ");";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            st.executeUpdate(sql);
            st.close();
            c.closeConnection();
        } catch (Exception ex) {
            String err = ex.getMessage();
            System.out.println(err);
            FileEditor.toError("Database Error", err);
        }
    }

    public static void addEmployee(Employee e) {
        try {
            String sql = "INSERT INTO employee VALUES("
                    + e.getEmp_id() + ",'"
                    + e.getName().replace("'", "\\'") + "','"
                    + e.getAddress().replace("'", "\\'") + "','"
                    + e.getComments().replace("'", "\\'") + "','"
                    + e.getGender() + "','"
                    + String.format("%tF\n", e.getbDate()) + "','"
                    + e.getContactNo() + "','"
                    + String.format("%tF\n", e.gethDate()) + "');";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            st.executeUpdate(sql);
            st.close();
            c.closeConnection();
        } catch (Exception ex) {
            String err = ex.getMessage();
            System.out.println(err);
            FileEditor.toError("Database Error", err);
        }
    }

    public static boolean isExistUserID(String userID) {
        try {
            ResultSet rst;
            String query = "SELECT * FROM _user u WHERE user_id = '" + userID.replace("'", "\\'") + "';";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            rst = st.executeQuery(query);
            if (rst.next()) {
                return true;
            }
            rst.close();
            st.close();
            c.closeConnection();
        } catch (Exception ex) {
            String err = ex.getMessage();
            System.out.println(err);
            FileEditor.toError("Database Error", err);
        }
        return false;
    }

    public static User getUser(String userID, String Password) {
        try {
            ResultSet rst;
            String query = "SELECT * FROM _user u WHERE user_id = '" + userID.replace("'", "\\'") + "' AND _password = '" + Password.replace("'", "\\'") + "' AND is_active = true;";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            rst = st.executeQuery(query);
            if (rst.next()) {
                User temp = new User();
                temp.setActive(rst.getBoolean("is_active"));
                temp.setAddress(rst.getString("Address"));
                temp.setFname(rst.getString("Fname"));
                temp.setLname(rst.getString("Lname"));
                temp.setMname(rst.getString("Mname"));
                temp.setPassword(rst.getString("_password"));
                temp.setUserType(rst.getString("user_type"));
                temp.setUser_id(rst.getString("user_id"));
                return temp;
            }
            rst.close();
            st.close();
            c.closeConnection();
        } catch (Exception ex) {
            String err = ex.getMessage();
            System.out.println(err);
            FileEditor.toError("Database Error", err);
        }
        return null;
    }

    public static void addUser(User user) {
        try {
            String sql = "INSERT INTO _user VALUES('"
                    + user.getUser_id().replace("'", "\\'") + "','"
                    + user.getFname().replace("'", "\\'") + "','"
                    + user.getMname().replace("'", "\\'") + "','"
                    + user.getLname().replace("'", "\\'") + "','"
                    + user.getAddress().replace("'", "\\'") + "','"
                    + user.getUserType() + "',"
                    + user.isActive() + ",'"
                    + user.getPassword().replace("'", "\\'") + "');";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            st.executeUpdate(sql);
            st.close();
        } catch (Exception ex) {
            String err = ex.getMessage();
            System.out.println(err);
            FileEditor.toError("Database Error", err);
        }
    }

    public static void insertLog(String user_ID, String Activity) {
        try {
            String sql = "INSERT INTO _log (Activity,user_id,log_date) VALUES('"
                    + Activity.replace("'", "\\'") + "','"
                    + user_ID.replace("'", "\\'") + "',now());";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            st.executeUpdate(sql);
            st.close();
            c.closeConnection();
        } catch (Exception ex) {
            String err = ex.getMessage();
            System.out.println(err);
            FileEditor.toError("Database Error", err);
        }
    }

    public static ArrayList<User> getUsers() {
        try {
            ArrayList<User> list = new ArrayList<>();
            ResultSet rst;
            String query = "SELECT * FROM _user u;";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            rst = st.executeQuery(query);
            while (rst.next()) {
                User temp = new User();
                temp.setActive(rst.getBoolean("is_active"));
                temp.setAddress(rst.getString("Address"));
                temp.setFname(rst.getString("Fname"));
                temp.setLname(rst.getString("Lname"));
                temp.setMname(rst.getString("Mname"));
                temp.setPassword(rst.getString("_password"));
                temp.setUserType(rst.getString("user_type"));
                temp.setUser_id(rst.getString("user_id"));
                list.add(temp);
            }
            rst.close();
            st.close();
            c.closeConnection();
            return list;
        } catch (Exception ex) {
            String err = ex.getMessage();
            System.out.println(err);
            FileEditor.toError("Database Error", err);
        }
        return null;
    }

    public static void updateUser(User old, User NEW) {
        try {
            String sql = "UPDATE _user SET "
                    + "user_id = '" + NEW.getUser_id().replace("'", "\\'") + "',"
                    + "Fname = '" + NEW.getFname().replace("'", "\\'") + "',"
                    + "Mname = '" + NEW.getMname().replace("'", "\\'") + "',"
                    + "Lname = '" + NEW.getLname().replace("'", "\\'") + "',"
                    + "Address = '" + NEW.getAddress().replace("'", "\\'") + "',"
                    + "user_type = '" + NEW.getUserType() + "',"
                    + "is_active = " + NEW.isActive() + ","
                    + "_password = '" + NEW.getPassword().replace("'", "\\'") + "' "
                    + "WHERE user_id = '" + old.getUser_id().replace("'", "\\'") + "';";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            st.executeUpdate(sql);
            st.close();
            c.closeConnection();
        } catch (Exception ex) {
            String err = ex.getMessage();
            System.out.println(err);
            FileEditor.toError("Database Error", err);
        }
    }

    public static void addLocation(Location loc) {
        try {
            String sql = "INSERT INTO location VALUES("
                    + loc.getLoc_id() + ",'"
                    + loc.getAddress().replace("'", "\\'") + "',"
                    + loc.getCareTaker().getEmp_id() + ","
                    + loc.getMaintenance_share() + ",'"
                    + loc.getDescription().replace("'", "\\'") + "');";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            st.executeUpdate(sql);
            st.close();
            c.closeConnection();
        } catch (Exception ex) {
            String err = ex.getMessage();
            System.out.println(err);
            FileEditor.toError("Database Error", err);
        }
    }

    public static void addDeduction(Deduction dec) {
        try {
            String sql = "INSERT INTO deduction VALUES("
                    + dec.getDeduction_id() + ",'"
                    + String.format("%tF\n", dec.getDate()) + "',"
                    + dec.getAmount() + ","
                    + dec.getClaim_id() + ","
                    + dec.getEmp_id() + ");";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            st.executeUpdate(sql);
            st.close();
        } catch (Exception ex) {
            String err = ex.getMessage();
            System.out.println(err);
            FileEditor.toError("Database Error", err);
        }
    }

    public static void deleteDeduction(int deductionID) {
        try {
            String sql = "DELETE FROM deduction WHERE deduction_id = " + deductionID + ";";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            st.executeUpdate(sql);
            st.close();
            c.closeConnection();
        } catch (Exception ex) {
            String err = ex.getMessage();
            System.out.println(err);
            FileEditor.toError("Database Error", err);
        }
    }

    public static void deleteExpenses(int expID) {
        try {
            String sql = "DELETE FROM expenses WHERE exp_id = " + expID + ";";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            st.executeUpdate(sql);
            st.close();
            c.closeConnection();
        } catch (Exception ex) {
            String err = ex.getMessage();
            System.out.println(err);
            FileEditor.toError("Database Error", err);
        }
    }

    public static void addActivity(Activity act) {
        try {
            String sql = "INSERT INTO activity VALUES("
                    + act.getAct_id() + ","
                    + act.getLocation().getLoc_id() + ","
                    + act.getAct_share() + ",'"
                    + String.format("%tF\n", act.getDate()) + "',"
                    + act.isPosted() + ");";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            st.executeUpdate(sql);
            st.close();
            c.closeConnection();
        } catch (SQLException ex) {
            String err = ex.getMessage();
            System.out.println(err);
            FileEditor.toError("Database Error", err);
        }
    }

    public static void addWorker(int act, int emp_id) {
        try {
            String sql = "INSERT INTO emp_act VALUES(" + act + "," + emp_id + ");";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            st.executeUpdate(sql);
            st.close();
            c.closeConnection();
        } catch (Exception ex) {
            String err = ex.getMessage();
            System.out.println(err);
            FileEditor.toError("Database Error", err);
        }
    }

    public static void addSalary(Salary salary) {
        try {
            String sql = "INSERT INTO salary VALUES(" + salary.getEmpID() + "," + salary.getGp_id() + "," + salary.getAmount() + "," + salary.getClaim_id() + ",'" + salary.getRemarks().replace("'", "\\'") + "');";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            st.executeUpdate(sql);
            st.close();
        } catch (Exception ex) {
            String err = ex.getMessage();
            System.out.println(err);
            FileEditor.toError("Database Error", err);
        }
    }

    public static void addExpense(Expenses expenses) {
        try {
            String sql = "INSERT INTO expenses VALUES(0," + expenses.getLoc_id() + "," + expenses.getAmount() + ",'"
                    + expenses.getReference().replace("'", "\\'") + "','"
                    + String.format("%tF", expenses.getDate()) + "','" + expenses.getRemarks().replace("'", "\\'") + "',"
                    + expenses.isPosted() + "," + expenses.getGp_id() + ");";
            System.out.println(sql);
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            st.executeUpdate(sql);
            st.close();
            c.closeConnection();
        } catch (Exception ex) {
            String err = ex.getMessage();
            System.out.println(err);
            FileEditor.toError("Database Error", err);
        }
    }

    public static void addGrossProfit(GrossProfit gp) {
        try {
            String sql = "INSERT INTO gross_profit VALUES("
                    + gp.getGp_id() + ","
                    + gp.getLocation().getLoc_id() + ","
                    + gp.getGross_amount() + ","
                    + gp.getMaintainer_share() + ","
                    + gp.getActivity_share() + ","
                    + gp.getOwner_share() + ",'"
                    + String.format("%tF\n", gp.getDate()) + "','"
                    + gp.getRemarks().replace("'", "\\'") + "',"
                    + gp.getActivity().getAct_id() + ");";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            st.executeUpdate(sql);
            st.close();
            c.closeConnection();
        } catch (Exception ex) {
            String err = ex.getMessage();
            System.out.println(err);
            FileEditor.toError("Database Error", err);
        }
    }

    public static ArrayList<Deduction> getAvailableDeduction(int emp_id) {
        try {
            ArrayList<Deduction> list = new ArrayList<>();
            ResultSet rst;
            String query = "SELECT * FROM deduction WHERE emp_id = " + emp_id + " AND claim_id = 0;";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            rst = st.executeQuery(query);
            while (rst.next()) {
                Deduction a = new Deduction();
                a.setAmount(rst.getDouble("amount"));
                a.setClaim_id(rst.getInt("claim_id"));
                a.setDate(new Date(rst.getDate("_date").getTime()));
                a.setDeduction_id(rst.getInt("deduction_id"));
                a.setEmp_id(rst.getInt("emp_id"));
                list.add(a);
            }
            rst.close();
            st.close();
            c.closeConnection();
            return list;
        } catch (Exception ex) {
            String err = ex.getMessage();
            System.out.println(err);
            FileEditor.toError("Database Error", err);
        }
        return null;
    }

    public static ArrayList<Claim> getClaim() {
        try {
            ArrayList<Claim> list = new ArrayList<>();
            ResultSet rst;
            String query = "SELECT * FROM claim c WHERE claim_id != 0;";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            rst = st.executeQuery(query);
            while (rst.next()) {
                Claim a = new Claim();
                a.setClaim_id(rst.getInt("claim_id"));
                a.setDate(new Date(rst.getDate("_date").getTime()));
                a.setEmp_id(rst.getInt("emp_id"));
                a.setTotal_deduction(rst.getDouble("total_deduction"));
                a.setTotal_salary(rst.getDouble("total_salary"));
                list.add(a);
            }
            rst.close();
            st.close();
            c.closeConnection();
            return list;
        } catch (Exception ex) {
            String err = ex.getMessage();
            System.out.println(err);
            FileEditor.toError("Database Error", err);
        }
        return null;
    }

    public static ArrayList<Deduction> getDeduction() {
        try {
            ArrayList<Deduction> list = new ArrayList<>();
            ResultSet rst;
            String query = "SELECT * FROM deduction d;";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            rst = st.executeQuery(query);
            while (rst.next()) {
                Deduction a = new Deduction();
                a.setAmount(rst.getDouble("amount"));
                a.setClaim_id(rst.getInt("claim_id"));
                a.setDate(new Date(rst.getDate("_date").getTime()));
                a.setDeduction_id(rst.getInt("deduction_id"));
                a.setEmp_id(rst.getInt("emp_id"));
                list.add(a);
            }
            rst.close();
            st.close();
            c.closeConnection();
            return list;
        } catch (Exception ex) {
            String err = ex.getMessage();
            System.out.println(err);
            FileEditor.toError("Database Error", err);
        }
        return null;
    }
    public static int POSTED = 1;
    public static int NOT_POSTED = 2;
    public static int ALL = 3;

    public static ArrayList<Activity> getActivityOnLocation(Location l, int status) {
        try {
            ArrayList<Activity> list = new ArrayList<>();
            ResultSet rst;
            String txt = "";
            switch (status) {
                case 0:
                    break;
                case 1:
                    txt += " AND _status = true";
                    break;
                case 2:
                    txt += " AND _status = false";
                    break;
            }
            String query = "SELECT * FROM activity a WHERE loc_id = " + l.getLoc_id() + txt + ";";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            rst = st.executeQuery(query);
            while (rst.next()) {
                Activity a = new Activity();
                a.setAct_id(rst.getInt("act_id"));
                a.setAct_share(rst.getDouble("act_share"));
                a.setDate(new Date(rst.getDate("_date").getTime()));
                a.setLocation(getLocation(rst.getInt("loc_id")));
                a.setPosted(rst.getBoolean("_status"));
                list.add(a);
            }
            rst.close();
            st.close();
            c.closeConnection();
            return list;
        } catch (Exception ex) {
            String err = ex.getMessage();
            System.out.println(err);
            FileEditor.toError("Database Error", err);
        }
        return null;
    }

    public static ArrayList<Activity> getActivity() {
        try {
            ArrayList<Activity> list = new ArrayList<>();
            ResultSet rst;
            String query = "SELECT * FROM activity a;";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            rst = st.executeQuery(query);
            while (rst.next()) {
                Activity a = new Activity();
                a.setAct_id(rst.getInt("act_id"));
                a.setAct_share(rst.getDouble("act_share"));
                a.setDate(new Date(rst.getDate("_date").getTime()));
                a.setLocation(getLocation(rst.getInt("loc_id")));
                a.setPosted(rst.getBoolean("_status"));
                list.add(a);
            }
            rst.close();
            st.close();
            c.closeConnection();
            return list;
        } catch (SQLException ex) {
            String err = ex.getMessage();
            System.out.println(err);
            FileEditor.toError("Database Error", err);
        }
        return null;
    }

    public static ArrayList<Expenses> getExpenses(int loc_id) {
        try {
            ArrayList<Expenses> list = new ArrayList<>();
            ResultSet rst;
            String query = "SELECT * FROM expenses e WHERE loc_id = " + loc_id + ";";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            rst = st.executeQuery(query);
            while (rst.next()) {
                Expenses e = new Expenses();
                e.setAmount(rst.getDouble("amount"));
                e.setDate(new Date(rst.getDate("_date").getTime()));
                e.setExp_id(rst.getInt("exp_id"));
                e.setGp_id(rst.getInt("gp_id"));
                e.setLoc_id(rst.getInt("loc_id"));
                e.setPosted(rst.getBoolean("_status"));
                e.setReference(rst.getString("reference"));
                e.setRemarks(rst.getString("remarks"));
                list.add(e);
            }
            rst.close();
            st.close();
            return list;
        } catch (Exception ex) {
            String err = ex.getMessage();
            System.out.println(err);
            FileEditor.toError("Database Error", err);
        }
        return null;
    }

    public static ArrayList<Expenses> getExpensesByGP_ID(int gp_id) {
        try {
            ArrayList<Expenses> list = new ArrayList<>();
            ResultSet rst;
            String query = "SELECT * FROM expenses e WHERE gp_id = " + gp_id + ";";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            rst = st.executeQuery(query);
            while (rst.next()) {
                Expenses e = new Expenses();
                e.setAmount(rst.getDouble("amount"));
                e.setDate(new Date(rst.getDate("_date").getTime()));
                e.setExp_id(rst.getInt("exp_id"));
                e.setGp_id(rst.getInt("gp_id"));
                e.setLoc_id(rst.getInt("loc_id"));
                e.setPosted(rst.getBoolean("_status"));
                e.setReference(rst.getString("reference"));
                e.setRemarks(rst.getString("remarks"));
                list.add(e);
            }
            rst.close();
            st.close();
            return list;
        } catch (Exception ex) {
            String err = ex.getMessage();
            System.out.println(err);
            FileEditor.toError("Database Error", err);
        }
        return null;
    }

    public static ArrayList<Expenses> getExpensesByRef(String ref) {
        try {
            ArrayList<Expenses> list = new ArrayList<>();
            ResultSet rst;
            String query = "SELECT * FROM expenses a WHERE reference = '" + ref.replace("'", "\\'") + "';";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            rst = st.executeQuery(query);
            while (rst.next()) {
                Expenses e = new Expenses();
                e.setAmount(rst.getDouble("amount"));
                e.setDate(new Date(rst.getDate("_date").getTime()));
                e.setExp_id(rst.getInt("exp_id"));
                e.setGp_id(rst.getInt("gp_id"));
                e.setLoc_id(rst.getInt("loc_id"));
                e.setPosted(rst.getBoolean("_status"));
                e.setReference(rst.getString("reference"));
                e.setRemarks(rst.getString("remarks"));
                list.add(e);
            }
            rst.close();
            st.close();
            c.closeConnection();
            return list;
        } catch (Exception ex) {
            String err = ex.getMessage();
            System.out.println(err);
            FileEditor.toError("Database Error", err);
        }
        return null;
    }

    public static ArrayList<String> getExpensesRef(int loc_id) {
        try {
            ArrayList<String> list = new ArrayList<>();
            ResultSet rst;
            String query = "SELECT DISTINCT(reference) FROM expenses e WHERE loc_id = " + loc_id + ";";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            rst = st.executeQuery(query);
            while (rst.next()) {
                list.add(rst.getString("reference"));
            }
            rst.close();
            st.close();
            c.closeConnection();
            return list;
        } catch (Exception ex) {
            String err = ex.getMessage();
            System.out.println(err);
            FileEditor.toError("Database Error", err);
        }
        return null;
    }

    public static Activity getActivity(int act_id) {
        try {
            ResultSet rst;
            String query = "SELECT * FROM activity a WHERE act_id = " + act_id + ";";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            rst = st.executeQuery(query);
            if (rst.next()) {
                Activity a = new Activity();
                a.setAct_id(rst.getInt("act_id"));
                a.setAct_share(rst.getDouble("act_share"));
                a.setDate(new Date(rst.getDate("_date").getTime()));
                a.setLocation(getLocation(rst.getInt("loc_id")));
                a.setPosted(rst.getBoolean("_status"));
                return a;
            }
            rst.close();
            st.close();
            c.closeConnection();
        } catch (Exception ex) {
            String err = ex.getMessage();
            System.out.println(err);
            FileEditor.toError("Database Error", err);
        }
        return null;
    }

    public static ArrayList<Employee> getEmployeeOnActivity(int act_id) {
        try {
            ArrayList<Employee> list = new ArrayList<>();
            ResultSet rst;
            String query = "SELECT * FROM emp_act WHERE act_id = " + act_id + ";";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            rst = st.executeQuery(query);
            while (rst.next()) {
                list.add(getEmployee(rst.getInt("emp_id")));
            }
            rst.close();
            st.close();
            c.closeConnection();
            return list;

        } catch (SQLException ex) {
            String err = ex.getMessage();
            System.out.println(err);
            FileEditor.toError("Database Error", err);
        }
        return null;
    }

    public static Employee getEmployee(int empID) {
        try {
            ResultSet rst;
            String query = "SELECT * FROM employee WHERE emp_id = " + empID + ";";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            rst = st.executeQuery(query);
            if (rst.next()) {
                Employee e = new Employee();
                e.setAddress(rst.getString("address"));
                e.setComments(rst.getString("comments"));
                e.setEmp_id(rst.getInt("emp_id"));
                e.setGender(rst.getString("Gender"));
                e.setName(rst.getString("name"));
                e.setbDate(new Date(rst.getDate("bDate").getTime()));
                e.setContactNo(rst.getString("contactNo"));
                return e;
            }
            rst.close();
            st.close();
            c.closeConnection();
        } catch (SQLException ex) {
            String err = ex.getMessage();
            System.out.println(err);
            FileEditor.toError("Database Error", err);
        }
        return null;
    }

    public static ArrayList<GrossProfit> getGrossProfit() {
        try {
            double totalGross1 = 0.00;
            double totalShare1 = 0.00;
            ArrayList<GrossProfit> list = new ArrayList<>();
            ResultSet rst;
            String query = "SELECT * FROM gross_profit a";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            rst = st.executeQuery(query);
            while (rst.next()) {
                GrossProfit tmp = new GrossProfit();
                tmp.setDate(new Date(rst.getDate("_date").getTime()));
                tmp.setGp_id(rst.getInt("gp_id"));
                tmp.setActivity_share(rst.getDouble("activity_share"));
                tmp.setGross_amount(rst.getDouble("gross_amount"));
                tmp.setLocation(getLocation(rst.getInt("loc_id")));
                tmp.setMaintainer_share(rst.getDouble("maintainer_share"));
                tmp.setOwner_share(rst.getDouble("owners_share"));
                tmp.setRemarks(rst.getString("remarks"));
                tmp.setActivity(getActivity(rst.getInt("act_id")));
                totalGross1 = totalGross1 + tmp.getGross_amount();
                setTotalGross(totalGross1);
                totalShare1 = totalShare1 + tmp.getOwner_share();
                setTotalShare(totalShare1);
                list.add(tmp);

            }
            rst.close();
            st.close();
            c.closeConnection();
            return list;
        } catch (Exception ex) {
            String err = ex.getMessage();
            System.out.println(err);
            FileEditor.toError("Database Error", err);
        }
        return null;
    }

    public static ArrayList<GrossProfit> getGrossProfitWithDate() {
        try {
            double totalGross1 = 0.00;
            double totalShare1 = 0.00;
            ArrayList<GrossProfit> list = new ArrayList<>();
            ResultSet rst;
            String query = "SELECT * FROM gross_profit where _date between '" + getStartDate() + " 00:00:00' and '" + getEndDate() + " 00:00:00';";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            rst = st.executeQuery(query);
            while (rst.next()) {
                GrossProfit tmp = new GrossProfit();
                tmp.setDate(new Date(rst.getDate("_date").getTime()));
                tmp.setGp_id(rst.getInt("gp_id"));
                tmp.setActivity_share(rst.getDouble("activity_share"));
                tmp.setGross_amount(rst.getDouble("gross_amount"));
                tmp.setLocation(getLocation(rst.getInt("loc_id")));
                tmp.setMaintainer_share(rst.getDouble("maintainer_share"));
                tmp.setOwner_share(rst.getDouble("owners_share"));
                tmp.setRemarks(rst.getString("remarks"));
                tmp.setActivity(getActivity(rst.getInt("act_id")));
                totalGross1 = totalGross1 + tmp.getGross_amount();
                setTotalGross(totalGross1);
                totalShare1 = totalShare1 + tmp.getOwner_share();
                setTotalShare(totalShare1);
                list.add(tmp);
                rst.close();
                st.close();
            }
            return list;
        } catch (Exception ex) {
            String err = ex.getMessage();
            System.out.println(err);
            FileEditor.toError("Database Error", err);
        }
        return null;
    }

    public static GrossProfit getGrossProfit(int gp_id) {
        try {
            double totalGross1 = 0.00;
            double totalShare1 = 0.00;
            ArrayList<GrossProfit> list = new ArrayList<>();
            ResultSet rst;
            String query = "SELECT * FROM gross_profit g WHERE gp_id = " + gp_id + ";";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            rst = st.executeQuery(query);
            if (rst.next()) {
                GrossProfit tmp = new GrossProfit();
                tmp.setDate(new Date(rst.getDate("_date").getTime()));
                tmp.setGp_id(rst.getInt("gp_id"));
                tmp.setActivity_share(rst.getDouble("activity_share"));
                tmp.setGross_amount(rst.getDouble("gross_amount"));
                tmp.setLocation(getLocation(rst.getInt("loc_id")));
                tmp.setMaintainer_share(rst.getDouble("maintainer_share"));
                tmp.setOwner_share(rst.getDouble("owners_share"));
                tmp.setRemarks(rst.getString("remarks"));
                tmp.setActivity(getActivity(rst.getInt("act_id")));
                totalGross1 = totalGross1 + tmp.getGross_amount();
                setTotalGross(totalGross1);
                totalShare1 = totalShare1 + tmp.getOwner_share();
                setTotalShare(totalShare1);
                return (tmp);

            }
            rst.close();
            st.close();
            c.closeConnection();
        } catch (Exception ex) {
            String err = ex.getMessage();
            System.out.println(err);
            FileEditor.toError("Database Error", err);
        }
        return null;
    }

    public static ArrayList getGrossProfitbyLocation(Location l) {
        try {
            double totalGross1 = 0.00;
            double totalShare1 = 0.00;
            ArrayList<GrossProfit> list = new ArrayList<>();
            ResultSet rst;
            String query = "SELECT * FROM gross_profit g WHERE loc_id = " + l.getLoc_id() + ";";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            rst = st.executeQuery(query);
            while (rst.next()) {
                GrossProfit tmp = new GrossProfit();
                tmp.setDate(new Date(rst.getDate("_date").getTime()));
                tmp.setGp_id(rst.getInt("gp_id"));
                tmp.setActivity_share(rst.getDouble("activity_share"));
                tmp.setGross_amount(rst.getDouble("gross_amount"));
                tmp.setLocation(getLocation(rst.getInt("loc_id")));
                tmp.setMaintainer_share(rst.getDouble("maintainer_share"));
                tmp.setOwner_share(rst.getDouble("owners_share"));
                tmp.setRemarks(rst.getString("remarks"));
                tmp.setActivity(getActivity(rst.getInt("act_id")));
                totalGross1 = totalGross1 + tmp.getGross_amount();
                setTotalGross(totalGross1);
                totalShare1 = totalShare1 + tmp.getOwner_share();
                setTotalShare(totalShare1);
                list.add(tmp);
                rst.close();
                st.close();
                c.closeConnection();
            }
            return list;
        } catch (Exception ex) {
            String err = ex.getMessage();
            System.out.println(err);
            FileEditor.toError("Database Error", err);
        }
        return null;
    }

    public static ArrayList getGrossProfitbyLocationWithDatePar(Location l) {
        try {
            double totalGross1 = 0.00;
            double totalShare1 = 0.00;
            ArrayList<GrossProfit> list = new ArrayList<>();
            ResultSet rst;
            String query = "SELECT * FROM gross_profit g WHERE loc_id = " + l.getLoc_id() + " and  _date between '" + getStartDate() + " 00:00:00' and '" + getEndDate() + " 00:00:00';";;
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            rst = st.executeQuery(query);
            while (rst.next()) {
                GrossProfit tmp = new GrossProfit();
                tmp.setDate(new Date(rst.getDate("_date").getTime()));
                tmp.setGp_id(rst.getInt("gp_id"));
                tmp.setActivity_share(rst.getDouble("activity_share"));
                tmp.setGross_amount(rst.getDouble("gross_amount"));
                tmp.setLocation(getLocation(rst.getInt("loc_id")));
                tmp.setMaintainer_share(rst.getDouble("maintainer_share"));
                tmp.setOwner_share(rst.getDouble("owners_share"));
                tmp.setRemarks(rst.getString("remarks"));
                tmp.setActivity(getActivity(rst.getInt("act_id")));
                totalGross1 = totalGross1 + tmp.getGross_amount();
                setTotalGross(totalGross1);
                totalShare1 = totalShare1 + tmp.getOwner_share();
                setTotalShare(totalShare1);
                list.add(tmp);
                rst.close();
                st.close();
            }
            return list;
        } catch (SQLException ex) {
            String err = ex.getMessage();
            System.out.println(err);
            FileEditor.toError("Database Error", err);
        }
        return null;
    }

    public static ArrayList<Employee> getEmployee() {
        try {
            ArrayList<Employee> list = new ArrayList<>();
            ResultSet rst;
            String query = "SELECT * FROM employee WHERE emp_id != 0;";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            rst = st.executeQuery(query);
            while (rst.next()) {
                Employee e = new Employee();
                e.setAddress(rst.getString("address"));
                e.setComments(rst.getString("comments"));
                e.setEmp_id(rst.getInt("emp_id"));
                e.setGender(rst.getString("Gender"));
                e.setName(rst.getString("name"));
                e.setbDate(new Date(rst.getDate("bDate").getTime()));
                e.setContactNo(rst.getString("contactNo"));
                e.sethDate(new Date(rst.getDate("hDate").getTime()));
                list.add(e);

            }
            rst.close();
            st.close();
            c.closeConnection();
            return list;
        } catch (Exception ex) {
            String err = ex.getMessage();
            System.out.println(err);
            FileEditor.toError("Database Error", err);
        }
        return null;
    }

    public static ArrayList<Employee> getEmployeebyName(String txt) {
        try {
            ArrayList<Employee> list = new ArrayList<>();
            ResultSet rst;
            String query = "SELECT * FROM employee e WHERE name LIKE '%" + txt + "%' AND emp_id != 0;";
            System.out.print(query);
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            rst = st.executeQuery(query);
            while (rst.next()) {
                Employee e = new Employee();
                e.setAddress(rst.getString("address"));
                e.setComments(rst.getString("comments"));
                e.setEmp_id(rst.getInt("emp_id"));
                e.setGender(rst.getString("Gender"));
                e.setName(rst.getString("name"));
                e.setbDate(new Date(rst.getDate("bDate").getTime()));
                e.setContactNo(rst.getString("contactNo"));
                list.add(e);

            }
            rst.close();
            st.close();
            c.closeConnection();
            return list;
        } catch (Exception ex) {
            String err = ex.getMessage();
            System.out.println(err);
            FileEditor.toError("Database Error", err);
        }
        return null;
    }

    public static Location getLocation(int loc_id) {
        try {
            ResultSet rst;
            String query = "SELECT * FROM location l WHERE loc_id = " + loc_id + ";";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            rst = st.executeQuery(query);
            if (rst.next()) {
                Location l = new Location();
                l.setAddress(rst.getString("address"));
                l.setCareTaker(getEmployee(rst.getInt("emp_id")));
                l.setDescription(rst.getString("description"));
                l.setLoc_id(rst.getInt("loc_id"));
                l.setMaintenance_share(rst.getDouble("maintenance_share"));
                return l;
            }
            rst.close();
            st.close();
            c.closeConnection();
        } catch (SQLException ex) {
            String err = ex.getMessage();
            System.out.println(err);
            FileEditor.toError("Database Error", err);
        }
        return null;
    }

    public static ArrayList<Location> getLocation() {
        try {
            ArrayList<Location> list = new ArrayList<>();
            ResultSet rst;
            String query = "SELECT * FROM location l;";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            rst = st.executeQuery(query);
            while (rst.next()) {
                Location l = new Location();
                l.setAddress(rst.getString("address"));
                l.setCareTaker(getEmployee(rst.getInt("emp_id")));
                l.setDescription(rst.getString("description"));
                l.setLoc_id(rst.getInt("loc_id"));
                l.setMaintenance_share(rst.getDouble("maintenance_share"));
                list.add(l);

            }
            rst.close();
            st.close();
            c.closeConnection();
            return list;
        } catch (Exception ex) {
            String err = ex.getMessage();
            System.out.println(err);
            FileEditor.toError("Database Error", err);
        }
        return null;
    }

    public static ArrayList<Location> getLocationForGP() {
        try {
            ArrayList<Location> list = new ArrayList<>();
            ResultSet rst;
            String query = "SELECT l.* FROM location l,activity a WHERE a.loc_id = l.loc_id AND a._status = false;";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            rst = st.executeQuery(query);
            while (rst.next()) {
                Location l = new Location();
                l.setAddress(rst.getString("address"));
                l.setCareTaker(getEmployee(rst.getInt("emp_id")));
                l.setDescription(rst.getString("description"));
                l.setLoc_id(rst.getInt("loc_id"));
                l.setMaintenance_share(rst.getDouble("maintenance_share"));
                list.add(l);

            }
            rst.close();
            st.close();
            c.closeConnection();
            return list;
        } catch (Exception ex) {
            String err = ex.getMessage();
            System.out.println(err);
            FileEditor.toError("Database Error", err);
        }
        return null;
    }

    public static void updateEmployee(Employee e) {
        try {

            String sql = "UPDATE employee SET "
                    + "name = '" + e.getName().replace("'", "\\'") + "',"
                    + "address = '" + e.getAddress().replace("'", "\\'") + "',"
                    + "comments = '" + e.getComments().replace("'", "\\'") + "',"
                    + "Gender = '" + e.getGender() + "',"
                    + "bDate = '" + String.format("%tF\n", e.getbDate()) + "',"
                    + "contactNo = '" + e.getContactNo() + "',"
                    + "hDate = '" + String.format("%tF\n", e.gethDate()) + "' WHERE emp_id = '" + e.getEmp_id() + "';";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            st.executeUpdate(sql);
            st.close();
            c.closeConnection();
        } catch (Exception ex) {
            String err = ex.getMessage();
            System.out.println(err);
            ex.printStackTrace();
            FileEditor.toError("Database Error", err);
        }
    }

    public static void insertProfileImage(int emp_ID, BufferedImage img) {
        try {
            File tmp = new File("temp.jpg");
            ImageIO.write(img, "jpg", tmp);
            c.getDBConn();
            java.sql.PreparedStatement psmnt = c.getCon().prepareStatement("INSERT INTO emp_img(emp_id, image) VALUES(?,?);");
            psmnt.setInt(1, emp_ID);
            FileInputStream fis = new FileInputStream(tmp);
            psmnt.setBinaryStream(2, (InputStream) fis, (int) (tmp.length()));
            psmnt.executeUpdate();
            tmp.delete();
            psmnt.close();
            c.closeConnection();
        } catch (Exception ex) {
            String err = ex.getMessage();
            System.out.println(err);
            FileEditor.toError("Database Error", err);
        }
    }

    public static BufferedImage getProfileImage(int empID) {
        try {
            BufferedImage image;
            ResultSet rst;
            String query = "SELECT * FROM emp_img i WHERE emp_id = " + empID + ";";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            rst = st.executeQuery(query);
            if (rst.next()) {
                Blob b = rst.getBlob("image");
                byte[] imgbyte = b.getBytes(1, (int) b.length());
                InputStream is = new ByteArrayInputStream(imgbyte);
                image = ImageIO.read(is);
                return image;

            }
            rst.close();
            st.close();
            c.closeConnection();
        } catch (SQLException ex) {
            String err = ex.getMessage();
            System.out.println(err);
            FileEditor.toError("Database Error", err);
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
            FileEditor.toError("Database Error", ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            FileEditor.toError("Database Error", ex.getMessage());
        }
        return null;
    }

    public static void updateProfileImage(int emp_ID, BufferedImage img) {
        try {
            String sql = "DELETE FROM emp_img WHERE emp_id = '" + emp_ID + "';";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            st.executeUpdate(sql);
            st.close();
            if (img != null) {
                insertProfileImage(emp_ID, img);
            }

        } catch (SQLException ex) {
            String err = ex.getMessage();
            System.out.println(err);
            FileEditor.toError("Database Error", err);
        }
    }

    public static void updateLocation(Location l) {
        try {
            String sql = "UPDATE location SET "
                    + "address = '" + l.getAddress().replace("'", "\\'") + "',"
                    + "description = '" + l.getDescription().replace("'", "\\'") + "',"
                    + "emp_id = " + l.getCareTaker().getEmp_id() + ","
                    + "maintenance_share = " + l.getMaintenance_share() + "  WHERE loc_id = " + l.getLoc_id() + ";";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            st.executeUpdate(sql);
            st.close();
            c.closeConnection();
        } catch (SQLException ex) {
            String err = ex.getMessage();
            System.out.println(err);
            FileEditor.toError("Database Error", err);
        }
    }

    public static void updateActivity(Activity act) {
        try {
            String sql = "UPDATE activity SET "
                    + "loc_id = " + act.getLocation().getLoc_id() + ","
                    + "act_share = " + act.getAct_share() + ","
                    + "_date = '" + String.format("%tF\n", act.getDate()) + "',"
                    + "_status = " + act.isPosted() + "  WHERE act_id = " + act.getAct_id() + ";";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            st.executeUpdate(sql);
            st.close();
            c.closeConnection();
        } catch (Exception ex) {
            String err = ex.getMessage();
            System.out.println(err);
            FileEditor.toError("Database Error", err);
        }
    }

    public static void RemoveActivityWorker(Activity act) {
        try {
            String sql = "DELETE FROM emp_act WHERE act_id = " + act.getAct_id() + ";";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            st.executeUpdate(sql);
            st.close();
            c.closeConnection();
        } catch (SQLException ex) {
            String err = ex.getMessage();
            System.out.println(err);
            FileEditor.toError("Database Error", err);
        }
    }

    public static void updateGrossProfitRemarks(String remarks, int gp_id) {
        try {
            String sql = "UPDATE gross_profit SET "
                    + "remarks = '" + remarks.replace("'", "\\'") + "'  WHERE gp_id = " + gp_id + ";";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            st.executeUpdate(sql);
            st.close();
            c.closeConnection();
        } catch (Exception ex) {
            String err = ex.getMessage();
            System.out.println(err);
            FileEditor.toError("Database Error", err);
        }
    }

    public static void updateSalary_Claim(Salary salary) {
        try {
            String sql = "UPDATE salary SET "
                    + "claim_id = " + salary.getClaim_id() + "  WHERE gp_id = " + salary.getGp_id() + " AND emp_id = " + salary.getEmpID() + ";";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            st.executeUpdate(sql);
            st.close();
            c.closeConnection();
        } catch (SQLException ex) {
            String err = ex.getMessage();
            System.out.println(err);
            FileEditor.toError("Database Error", err);
        } 
    }

    public static ArrayList<Salary> getSalary() {
        try {
            ArrayList<Salary> list = new ArrayList<>();
            ResultSet rst;
            String query = "SELECT * FROM salary s;";
           c.getDBConn();
            Statement st =c.getCon().createStatement();
            rst = st.executeQuery(query);
            while (rst.next()) {
                Salary tmp = new Salary();
                tmp.setAmount(rst.getDouble("amount"));
                tmp.setClaim_id(rst.getInt("claim_id"));
                tmp.setEmpID(rst.getInt("emp_id"));
                tmp.setGp_id(rst.getInt("gp_id"));
                tmp.setRemarks(rst.getString("remarks"));
                list.add(tmp);

            }
            rst.close();
            st.close();
            c.closeConnection();
            return list;
        } catch (Exception ex) {
            String err = ex.getMessage();
            System.out.println(err);
            FileEditor.toError("Database Error", err);
        }
        return null;
    }

    public static ArrayList<Salary> getAvailableSalary(int empID) {
        try {
            ArrayList<Salary> list = new ArrayList<>();
            ResultSet rst;
            String query = "SELECT * FROM salary WHERE emp_id = " + empID + " AND claim_id =0;";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            rst = st.executeQuery(query);
            while (rst.next()) {
                Salary tmp = new Salary();
                tmp.setAmount(rst.getDouble("amount"));
                tmp.setClaim_id(rst.getInt("claim_id"));
                tmp.setEmpID(rst.getInt("emp_id"));
                tmp.setGp_id(rst.getInt("gp_id"));
                tmp.setRemarks(rst.getString("remarks"));
                list.add(tmp);
                rst.close();
                st.close();
            }
            c.closeConnection();
            return list;

        } catch (Exception ex) {
            String err = ex.getMessage();
            System.out.println(err);
            FileEditor.toError("Database Error", err);
        } 
        return null;
    }

    public static boolean isGP_Claimed(int gp_id) {
        try {
            ResultSet rst;
            String query = "SELECT * FROM salary s WHERE gp_id = " + gp_id + " AND claim_id != 0;";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            rst = st.executeQuery(query);
            return rst.next();

        } catch (Exception ex) {
            String err = ex.getMessage();
            System.out.println(err);
            FileEditor.toError("Database Error", err);
        }
        return false;
    }

    public static void updatePW(String pw) {
        try {
            String sql = "UPDATE _user SET _password = '" + pw.replace("'", "\\'") + "';";
            c.getDBConn();
            Statement st = c.getCon().createStatement();
            st.executeUpdate(sql);
            st.close();
        } catch (Exception ex) {
            String err = ex.getMessage();
            System.out.println(err);
            FileEditor.toError("Database Error", err);
        }
    }

    /**
     * @return the totalGross
     */
    public static double getTotalGross() {
        return totalGross;
    }

    /**
     * @param aTotalGross the totalGross to set
     */
    public static void setTotalGross(double aTotalGross) {
        totalGross = aTotalGross;
    }

    /**
     * @return the totalShare
     */
    public static double getTotalShare() {
        return totalShare;
    }

    /**
     * @param aTotalShare the totalShare to set
     */
    public static void setTotalShare(double aTotalShare) {
        totalShare = aTotalShare;
    }

    /**
     * @return the startDate
     */
    public static String getStartDate() {
        return startDate;
    }

    /**
     * @param aStartDate the startDate to set
     */
    public static void setStartDate(String aStartDate) {
        startDate = aStartDate;
    }

    /**
     * @return the endDate
     */
    public static String getEndDate() {
        return endDate;
    }

    /**
     * @param aEndDate the endDate to set
     */
    public static void setEndDate(String aEndDate) {
        endDate = aEndDate;
    }
}
