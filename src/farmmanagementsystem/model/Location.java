/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package farmmanagementsystem.model;

import java.util.Objects;

/**
 *
 * @author Administrator
 */
public class Location {

    private int loc_id;
    private String address;
    private String description;
    private Employee careTaker;
    private double maintenance_share;

    public Location() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Employee getCareTaker() {
        return careTaker;
    }

    public void setCareTaker(Employee careTaker) {
        this.careTaker = careTaker;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLoc_id() {
        return loc_id;
    }

    public void setLoc_id(int loc_id) {
        this.loc_id = loc_id;
    }

    public double getMaintenance_share() {
        return maintenance_share;
    }

    public void setMaintenance_share(double maintenance_share) {
        this.maintenance_share = maintenance_share;
    }
    public Double getMaintenance_Share(Double GrossProfit){
        return GrossProfit*(maintenance_share/100);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Location other = (Location) obj;
        if (this.loc_id != other.loc_id) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.careTaker, other.careTaker)) {
            return false;
        }
        if (Double.doubleToLongBits(this.maintenance_share) != Double.doubleToLongBits(other.maintenance_share)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hash = 5;
        return hash;
    }

    public String toString() {
        return loc_id+"";
    }

}
