/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package farmmanagementsystem.model;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Administrator
 */
public class Employee {

    private int emp_id;
    private String name;
    private String address;
    private String gender;
    private String comments;
    private Date bDate;
    private String contactNo;
    private Date hDate;



    public Employee() {
        comments = "";
        contactNo = "";
        bDate = new Date(0,0,1);        
    }

    /**
     *
     * @return
     */
    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public Date getbDate() {
        return bDate;
    }

    public void setbDate(Date bDate) {
        this.bDate = bDate;
    }
    
    public int getAge(){
        if(bDate.getYear()==0)
            return -1;
        Date today = new Date();
        int age = today.getYear()-bDate.getYear();
        if(bDate.getMonth() > today.getMonth()){
            age--;
        }else if(bDate.getMonth() == today.getMonth() && bDate.getDate() > today.getDate())
            age--;
        return age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        if(!comments.isEmpty())
        this.comments = comments;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Employee other = (Employee) obj;
        if (this.emp_id != other.emp_id) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.gender, other.gender)) {
            return false;
        }
        if (!Objects.equals(this.comments, other.comments)) {
            return false;
        }
        if (!Objects.equals(this.bDate, other.bDate)) {
            return false;
        }
        if (!Objects.equals(this.contactNo, other.contactNo)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hash = 3;
        return hash;
    }

    public String toString() {
        return "["+emp_id+"] "+name;
    }    

    /**
     * @return the hDate
     */
    public Date gethDate() {
        return hDate;
    }

    /**
     * @param hDate the hDate to set
     */
    public void sethDate(Date hDate) {
        this.hDate = hDate;
    }
    
    
}
