/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author omeryasironal
 */

// Malzeme nesnesi oluşturulur
public class Material {

    public int id;
    public String name;
    public String type;
    public int stock;
    public int date;

    public Material(String materialName, String materialType, int stockStatus, int date) {

        this.name = materialName;
        this.type = materialType;
        this.stock = stockStatus;
        this.date = date;
    }

    public Material() {
        this.id = 0;
        this.name = "";
        this.type = "";
        this.stock = 0;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getId() {
        return this.id;
    }

    public String getMaterialName() {
        return this.name;
    }

    public String getMaterialType() {
        return this.type;
    }

    public int getStockStatus() {
        return this.stock;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMaterialName(String materialName) {
        this.name = materialName;
    }

    public void setMaterialType(String materialType) {
        this.type = materialType;
    }

    public void setStockStatus(int stockStatus) {
        this.stock = stockStatus;
    }
}
