/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.vappointment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rolae
 */
public class fappointment {
    private final conexion mysql=new conexion();
    private final Connection cn=mysql.conectar();
    private String sSQL="";
    public Integer totalregistros;
    
    
    public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos = {"ID","Idservice","Type_service","Idclient","Client","Idemployee","Employee","Service_date","Service_price","Product","Product_price","Stylist","Formulas","Notes"};
        
        String [] registro =new String [14];
        
        totalregistros=0;
        modelo = new DefaultTableModel(null,titulos);
        
        sSQL="select a.idappointment,a.idservice,s.type_service,a.idclient,"+
                "(select name from person where idperson=a.idclient)as clientn,"+
                "(select lastname from person where idperson=a.idclient)as clientl,"+
                "a.idemployee, (select name from person where idperson=a.idemployee)as employeen,"+
                "(select lastname from person where idperson=a.idemployee)as employeel,"+
                "a.service_date,a.service_price,a.product,a.product_price,a.stylist,a.formulas,a.notes from appointment a inner join service s on a.idservice=s.idservice where a.stylist like '%"+ buscar + "%' order by idappointment desc";
        
        try {
            Statement st= cn.createStatement();
            ResultSet rs=st.executeQuery(sSQL);
            
            while(rs.next()){
                registro [0]=rs.getString("idappointment");
                registro [1]=rs.getString("idservice");
                registro [2]=rs.getString("type_service");
                registro [3]=rs.getString("idclient");
                registro [4]=rs.getString("clientn") + " " + rs.getString("clientl");
                registro [5]=rs.getString("idemployee");
                registro [6]=rs.getString("employeen") + " " + rs.getString("employeel");
                registro [7]=rs.getString("service_date");
                registro [8]=rs.getString("service_price");
                registro [9]=rs.getString("product");
                registro [10]=rs.getString("product_price");
                registro [11]=rs.getString("stylist");
                registro [12]=rs.getString("formulas");
                registro [13]=rs.getString("notes");
                
                totalregistros=totalregistros+1;
                modelo.addRow(registro);
                
            }
            return modelo;
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
        
        
        
    }
    
    public boolean insertar (vappointment dts){
        sSQL="insert into appointment (idservice,idclient,idemployee,service_date,service_price,product,product_price,stylist,formulas,notes)" +
                "values (?,?,?,?,?,?,?,?,?,?)";
        try {
            
            PreparedStatement pst=cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdservice());
            pst.setInt(2, dts.getIdclient());
            pst.setInt(3, dts.getIdemployee());
            pst.setDate(4, dts.getService_date());
            pst.setDouble(5, dts.getService_price());
            pst.setString(6, dts.getProduct());
            pst.setDouble(7, dts.getProduct_price());
            pst.setString(8, dts.getStylist());
            pst.setString(9, dts.getFormulas());
            pst.setString(10, dts.getNotes());
            
            int n=pst.executeUpdate();
            
            return n!=0;
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
   
    }
    
     public boolean editar (vappointment dts){
       sSQL="Update appointment set idservice=?,idclient=?,idemployee=?,service_date=?,service_price=?,product=?,product_price=?,stylist=?,formulas=?,notes=?"+
              " where idappointment=?";
       
         
        try {
            PreparedStatement pst=cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdservice());
            pst.setInt(2, dts.getIdclient());
            pst.setInt(3, dts.getIdemployee());
            pst.setDate(4, dts.getService_date());
            pst.setDouble(5, dts.getService_price());
            pst.setString(6, dts.getProduct());
            pst.setDouble(7, dts.getProduct_price());
            pst.setString(8, dts.getStylist());
            pst.setString(9, dts.getFormulas());
            pst.setString(10, dts.getNotes());
           
            pst.setInt(11, dts.getIdappointment());
            
            int n=pst.executeUpdate();
            
           return n!=0;
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
   
    }
     
      public boolean eliminar (vappointment dts){
          sSQL="delete from appointment where idappointment=?";
          
          
        try {
            
            PreparedStatement pst=cn.prepareStatement(sSQL);
            
            pst.setInt(1, dts.getIdappointment());
            
            int n=pst.executeUpdate();
            
              return n!=0;
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
   
    }
    
}
