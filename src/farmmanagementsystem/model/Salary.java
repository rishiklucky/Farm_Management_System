/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package farmmanagementsystem.model;

import farmmanagementsystem.db.DBQuery;


/**
 *
 * @author Administrator
 */
public class Salary {
    private int empID;
    private int gp_id;
    private double amount;
    private int claim_id;
    private String remarks;

    public Salary() {
        claim_id = 0;
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

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public int getGp_id() {
        return gp_id;
    }

    public void setGp_id(int gp_id) {
        this.gp_id = gp_id;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    public Employee getEmployee(){
        return DBQuery.getEmployee(empID);
    }
    public GrossProfit getGrossProfit(){
        return DBQuery.getGrossProfit(gp_id);
    }

    public String toString() {
        return  gp_id+"";
    }
    

}
