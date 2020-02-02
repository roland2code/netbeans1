/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author rolae
 */
public class vproduct {
    private int idproduct;
    private String name;
    private String description;
    private String unit;
    private Double sale_price;

    public vproduct() {
    }

    public vproduct(int idproduct, String name, String description, String unit, Double sale_price) {
        this.idproduct = idproduct;
        this.name = name;
        this.description = description;
        this.unit = unit;
        this.sale_price = sale_price;
    }

    public int getIdproduct() {
        return idproduct;
    }

    public void setIdproduct(int idproduct) {
        this.idproduct = idproduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getSale_price() {
        return sale_price;
    }

    public void setSale_price(Double sale_price) {
        this.sale_price = sale_price;
    }
    
    
    
}
