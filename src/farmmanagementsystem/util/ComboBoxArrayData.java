package farmmanagementsystem.util;

import java.util.ArrayList;


public class ComboBoxArrayData {

    private int id;
    private String description;

    public ComboBoxArrayData(){
    }

    public ComboBoxArrayData(int id, String description){
        this.id = id;
        this.description = description;
    }


    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int Id) {
        this.id = Id;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }


    public void setSelectedID(ArrayList<ComboBoxArrayData> Comboboxs, int Id, javax.swing.JComboBox cbo){
        for(ComboBoxArrayData it : Comboboxs){
            if(it.getId() == Id){
                cbo.setSelectedItem(it);
            }
         }
       }

    public void setSelectedDescription(ArrayList<ComboBoxArrayData> Comboboxs, String desc, javax.swing.JComboBox cbo) {
        for (ComboBoxArrayData it : Comboboxs) {
            if (it.getDescription().trim().equals(desc.trim())) {
                cbo.setSelectedItem(it);
            }
        }
    }


    public String toString(){
        return this.description;
    }

}
