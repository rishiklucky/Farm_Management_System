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
public class Deduction {
    private int deduction_id;
    private Date date;
    private double amount;
    private int claim_id;
    private int emp_id;

    public Deduction() {
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
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

    public int getDeduction_id() {
        return deduction_id;
    }

    public void setDeduction_id(int deduction_id) {
        this.deduction_id = deduction_id;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public Employee getEmployee(){
        return DBQuery.getEmployee(emp_id);
    }
}
