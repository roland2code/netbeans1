/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.sql.Date;

/**
 *
 * @author rolae
 */
public class vappointment {
    private int idappointment;
    private int idservice;
    private int idclient;
    private int idemployee;
    private Date service_date;
    private Double service_price;
    private String product;
    private Double product_price;
    private String stylist;
    private String formulas;
    private String notes;

    public vappointment() {
    }

    public vappointment(int idappointment, int idservice, int idclient, int idemployee, Date service_date, Double service_price, String product, Double product_price, String stylist, String formulas, String notes) {
        this.idappointment = idappointment;
        this.idservice = idservice;
        this.idclient = idclient;
        this.idemployee = idemployee;
        this.service_date = service_date;
        this.service_price = service_price;
        this.product = product;
        this.product_price = product_price;
        this.stylist = stylist;
        this.formulas = formulas;
        this.notes = notes;
    }

    public int getIdappointment() {
        return idappointment;
    }

    public void setIdappointment(int idappointment) {
        this.idappointment = idappointment;
    }

    public int getIdservice() {
        return idservice;
    }

    public void setIdservice(int idservice) {
        this.idservice = idservice;
    }

    public int getIdclient() {
        return idclient;
    }

    public void setIdclient(int idclient) {
        this.idclient = idclient;
    }

    public int getIdemployee() {
        return idemployee;
    }

    public void setIdemployee(int idemployee) {
        this.idemployee = idemployee;
    }

    public Date getService_date() {
        return service_date;
    }

    public void setService_date(Date service_date) {
        this.service_date = service_date;
    }

    public Double getService_price() {
        return service_price;
    }

    public void setService_price(Double service_price) {
        this.service_price = service_price;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Double getProduct_price() {
        return product_price;
    }

    public void setProduct_price(Double product_price) {
        this.product_price = product_price;
    }

    public String getStylist() {
        return stylist;
    }

    public void setStylist(String stylist) {
        this.stylist = stylist;
    }

    public String getFormulas() {
        return formulas;
    }

    public void setFormulas(String formulas) {
        this.formulas = formulas;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
    
    
    
}
