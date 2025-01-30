/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package farmmanagementsystem.util;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author AzaShem
 */
public class DateConverter {

    /**
     * Convert SQL date to UTIL date
     * @param _date java.sql.Date date
     * @return java.util.Date date
     */
    public static Date SQLtoUTIL(java.sql.Date _date){
        return new Date(_date.getTime());
    }

    /**
     * Convert UTIL date to SQL date
     * @param _date java.util.Date date
     * @return java.sql.Date date
     */
    public static java.sql.Date UTILtoSQL(Date _date){
        return new java.sql.Date(_date.getTime());
    }

    /**
     * Trim UTIL time
     * @param _date date
     * @return String TIME HH:MM:AM/PM
     */
    public static String TrimTime(Date UTIL_date){
        String time = toStringTimeValue((UTIL_date.getHours())%12)+":";
        time += toStringTimeValue(UTIL_date.getMinutes())+":";
        time += getStamp(UTIL_date.getHours());
        return time;
    }

    /**
     * Trim SQL time
     * @param _date date
     * @return String TIME HH:MM:AM/PM
     */
    public static String TrimTime(java.sql.Date SQL_date){
        String time = toStringTimeValue((SQL_date.getHours())%12)+":";
        time += toStringTimeValue(SQL_date.getMinutes())+":";
        time += getStamp(SQL_date.getHours());
        return time;
    }

    private static String toStringTimeValue(int val){
        return (val<10)? "0"+val:""+val;
    }

    private static String getStamp(int hour){
        return (hour>12)? "PM":"AM";
    }

    /**
     * Trim Date
     * @param _date date with time
     * @return Date with default time.
     */
    public static Date TrimDate(Date date){
        return new Date(date.getYear(), date.getMonth(), date.getDate());
    }

    public static Date SQLtoUTIL(Timestamp t){
        return new Date(t.getTime());
    }

    public static String UTILtoDB(Date date){
        //2013-9-5 17:22:13
        String _date ="";
        _date += (date.getYear()+1900)+"-";
        _date += ((date.getMonth()+1)<10)?"0"+(date.getMonth()+1)+"-":(date.getMonth()+1)+"-";
        _date += (date.getDate()<10)?"0"+date.getDate()+"-":date.getDate()+" ";
        _date += ((date.getHours())<10)?"0"+(date.getHours())+"-":(date.getHours())+":";
        _date += ((date.getMinutes())<10)?"0"+(date.getMinutes())+"-":(date.getMinutes())+":";
        _date += "00";
        return _date;
    }

    public static String UTILtoDB_DateOnly(Date date){
        //2013-9-5 00:00:00
        String _date ="";
        _date += (date.getYear()+1900)+"-";
        _date += ((date.getMonth()+1)<10)?"0"+(date.getMonth()+1)+"-":(date.getMonth()+1)+"-";
        _date += (date.getDate()<10)?"0"+date.getDate()+"-":date.getDate()+" ";
        _date += "00:";
        _date += "00:";
        _date += "00";
        return _date;
    }

    public static String UTILtoDB_TimeOnly(Date date){
        //17:22:13
        String time ="";
        if(date.getHours() != 12)
        time += ((date.getHours()%12)<10)?"0"+(date.getHours()%12)+":":(date.getHours()%12)+":";
        else
        time += (date.getHours())+":";
        time += ((date.getMinutes())<10)?"0"+(date.getMinutes())+" ":(date.getMinutes())+" ";
        time += (date.getHours() < 12)?"AM":"PM";
        return time;
    }

    public static String getDay(Date date){
        int day = date.getDay();
        switch(day){
            case 0: return "Sunday";
            case 1: return "Monday";
            case 2: return "Tuesday";
            case 3: return "Wednesday";
            case 4: return "Thursday";
            case 5: return "Friday";
            case 6: return "Saturday";
        }
        return "";
    }

    public static String getMonth(Date date){
        int month = date.getMonth();
        switch(month){
            case 0: return "January";
            case 1: return "February";
            case 2: return "March";
            case 3: return "April";
            case 4: return "May";
            case 5: return "June";
            case 6: return "July";
            case 7: return "August";
            case 8: return "September";
            case 9: return "October";
            case 10: return "November";
            case 11: return "December";
        }
        return "";
    }

    public static int getYear(Date date){
        return date.getYear()+1900;
    }

}
