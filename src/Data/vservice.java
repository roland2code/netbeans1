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
public class vservice {
    private int idservice;
    private String type_service;
    private String service_price;
    private String formula;
    private String notes;

    public vservice() {
    }

    public vservice(int idservice, String type_service, String service_price, String formula, String notes) {
        this.idservice = idservice;
        this.type_service = type_service;
        this.service_price = service_price;
        this.formula = formula;
        this.notes = notes;
    }

    public int getIdservice() {
        return idservice;
    }

    public void setIdservice(int idservice) {
        this.idservice = idservice;
    }

    public String getType_service() {
        return type_service;
    }

    public void setType_service(String type_service) {
        this.type_service = type_service;
    }

    public String getService_price() {
        return service_price;
    }

    public void setService_price(String service_price) {
        this.service_price = service_price;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    
    
    
    
}
