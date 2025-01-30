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
public class User {

    private String user_id;
    private String fname;
    private String mname;
    private String lname;
    private String address;
    private String userType;
    private boolean Active;
    private String password;

    public User() {
    }

    public boolean isActive() {
        return Active;
    }

    public void setActive(boolean Active) {
        this.Active = Active;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getName(){
        return lname+", "+fname+" "+mname.charAt(0)+".";
    }

    public String getStatus(){
        return (Active)?"Active":"In-Active";
    }

    public Object[] toArray(){
        return new Object[]{user_id,getName(),userType,getStatus()};
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.user_id, other.user_id)) {
            return false;
        }
        if (!Objects.equals(this.fname, other.fname)) {
            return false;
        }
        if (!Objects.equals(this.mname, other.mname)) {
            return false;
        }
        if (!Objects.equals(this.lname, other.lname)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.userType, other.userType)) {
            return false;
        }
        if (this.Active != other.Active) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hash = 5;
        return hash;
    }

    public String getChangesFrom(Object obj) {
        String txt = "";

        final User other = (User) obj;
        if (!Objects.equals(this.user_id, other.user_id)) {
            txt += "["+other.user_id+" -> "+this.user_id+"] ";
        }
        if (!Objects.equals(this.fname, other.fname)) {
            txt += "["+other.fname+" -> "+this.fname+"] ";
        }
        if (!Objects.equals(this.mname, other.mname)) {
            txt += "["+other.mname+" -> "+this.mname+"] ";
        }
        if (!Objects.equals(this.lname, other.lname)) {
            txt += "["+other.lname+" -> "+this.lname+"] ";
        }
        if (!Objects.equals(this.address, other.address)) {
            txt += "["+other.address+" -> "+this.address+"] ";
        }
        if (!Objects.equals(this.userType, other.userType)) {
            txt += "["+other.userType+" -> "+this.userType+"] ";
        }
        if (this.Active != other.Active) {
            txt += "["+other.getStatus()+" -> "+this.getStatus()+"] ";
        }
        if (!Objects.equals(this.password, other.password)) {
            txt += "["+other.password+" -> "+this.password+"] ";
        }
        return txt;
    }
}
