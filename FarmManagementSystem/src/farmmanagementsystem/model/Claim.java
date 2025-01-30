/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package farmmanagementsystem.model;

import farmmanagementsystem.db.DBQuery;
import java.util.Date;

/**
 *
 * @author Administrator
 */
public class Claim {
    private int claim_id;
    private int emp_id;
    private Date date;
    private double total_salary;
    private double total_deduction;

    public Claim() {
    }

    public int getClaim_id() {
        return claim_id;
    }

    public void setClaim_id(int claim_id) {
        this.claim_id = claim_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public double getTotal_deduction() {
        return total_deduction;
    }

    public void setTotal_deduction(double total_deduction) {
        this.total_deduction = total_deduction;
    }

    public double getTotal_salary() {
        return total_salary;
    }

    public void setTotal_salary(double total_salary) {
        this.total_salary = total_salary;
    }

    public double getNet(){
        return total_salary - total_deduction;
    }

    public Employee getEmployee(){
        return DBQuery.getEmployee(emp_id);
    }
}
