/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package farmmanagementsystem.util;
import java.io.*;
import java.util.*;
/**
 *
 * @author AzaShem
 */
public class FileEditor {
    

    public static final String file_db = "DB";
    public static final String file_error = "Error";
    public static final String file_driver = "DRIVER";
    public static final String file_pw = "PW";
    public static final String file_server = "SERVER";
    public static final String file_url = "URL";
    public static final String file_user = "USER";

   private static FileOutputStream createtextfile ;
    public static void toError(String errorType, String message){
    Date date = new Date();
        try {
            createtextfile = new FileOutputStream("config\\Error.db", true);
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
                new PrintStream(createtextfile).printf(date.toGMTString()+"\n"
                        + "\tError Type" +errorType+"\n"
                        + "\tMessage" +message+"\n-->");
        try {
            createtextfile.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

     public static String getDATABASE() throws FileNotFoundException {
     Scanner scan = new Scanner(new FileInputStream("CONFIG\\DB.db"));
     String temp = (scan.nextLine());
     scan.close();
     return temp;
    }

    public static String getPASSWORD() throws FileNotFoundException {
    Scanner scan = new Scanner(new FileInputStream("CONFIG\\PW.db"));
     String temp = (scan.nextLine());
     scan.close();
     return temp;
    }

    public static String getSERVER() throws FileNotFoundException {
     Scanner scan = new Scanner(new FileInputStream("CONFIG\\SERVER.db"));
     String temp = (scan.nextLine());
     scan.close();
     return temp;
    }

    public static String getURL() throws FileNotFoundException {
     Scanner scan = new Scanner(new FileInputStream("CONFIG\\URL.db"));
     String temp = (scan.nextLine());
     scan.close();
     return temp;
    }

    public static String getUSER() throws FileNotFoundException {
   Scanner scan = new Scanner(new FileInputStream("CONFIG\\USER.db"));
     String temp = (scan.nextLine());
     scan.close();
     return temp;
    }

    public static String getDRIVER() throws FileNotFoundException {
    Scanner scan = new Scanner(new FileInputStream("CONFIG\\DRIVER.db"));
     String temp = (scan.nextLine());
     scan.close();
     return temp;
    } 

    public static void toFile(String type,String value) throws FileNotFoundException, IOException
    {
         createtextfile= new FileOutputStream("CONFIG\\"+type+".db",false);
         new PrintStream(createtextfile).printf(value);
         createtextfile.close();

    }   
}
