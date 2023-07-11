/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.util.ArrayList;

/**
 *
 * @author omeryasironal
 */

// Deney nesnesi oluşuturulur
public class Experiment {

    public int id;
    public String name;
    public int date;
    public ArrayList<Material> materialList = new ArrayList<>();

    public Experiment(String experimentName, int experimentDate, ArrayList<Material> materialList) {
        this.name = experimentName;
        this.date = experimentDate;
        this.materialList = materialList;
    }

    public Experiment() {
        this.id = 0;
        this.name = "";
        this.date = 0;

    }

    public Experiment(String experiment_name, int experiment_date) {
        this.name = experiment_name;
        this.date = experiment_date;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExperimentName() {
        return this.name;
    }

    public void setExperimentName(String experimentName) {
        this.name = experimentName;
    }

    public int getExperimentDate() {
        return this.date;
    }

    public void setExperimentDate(int experimentDate) {
        this.date = experimentDate;
    }

}
