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
public class Activity {
    private int act_id;
    private Location location;
    private double act_share;
    private Date date;
    private boolean posted;

    public Activity() {
        posted =false;
    }

    public int getAct_id() {
        return act_id;
    }

    public void setAct_id(int act_id) {
        this.act_id = act_id;
    }

    public double getAct_share() {
        return act_share;
    }

    public void setAct_share(double act_share) {
        this.act_share = act_share;
    }
    public Double getAct_share(Double GrossProfit){
        return GrossProfit*(act_share/100);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }



    public boolean isPosted() {
        return posted;
    }

    public void setPosted(boolean posted) {
        this.posted = posted;
    }
    
}
