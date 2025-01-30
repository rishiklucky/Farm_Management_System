/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package farmmanagementsystem.model;

import java.util.Date;

/**
 *
 * @author Administrator
 */
public class GrossProfit {
    private int gp_id;
    private Location location;
    private double gross_amount;
    private double maintainer_share;
    private double activity_share;
    private double owner_share;
    private Date date;
    private String remarks;
    private Activity activity;

    public GrossProfit() {
        remarks = "";
    }

    public double getActivity_share() {
        return activity_share;
    }

    public void setActivity_share(double activity_share) {
        this.activity_share = activity_share;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getGp_id() {
        return gp_id;
    }

    public void setGp_id(int gp_id) {
        this.gp_id = gp_id;
    }

    public double getGross_amount() {
        return gross_amount;
    }

    public void setGross_amount(double gross_amount) {
        this.gross_amount = gross_amount;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public double getMaintainer_share() {
        return maintainer_share;
    }

    public void setMaintainer_share(double maintainer_share) {
        this.maintainer_share = maintainer_share;
    }

    public double getOwner_share() {
        return owner_share;
    }

    public void setOwner_share(double owner_share) {
        this.owner_share = owner_share;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }
   
}
