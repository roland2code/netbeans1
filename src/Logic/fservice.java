/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.vservice;
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
public class fservice {
    private final conexion mysql=new conexion();
    private final Connection cn=mysql.conectar();
    private String sSQL="";
    public Integer totalregistros;
    
    
    public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos = {"ID","Type_service","Service_price","Formula","Notes"};
        
        String [] registro =new String [5];
        
        totalregistros=0;
        modelo = new DefaultTableModel(null,titulos);
        
        sSQL="select * from service where type_service like '%"+ buscar + "%' order by idservice";
        
        try {
            Statement st= cn.createStatement();
            ResultSet rs=st.executeQuery(sSQL);
            
            while(rs.next()){
                registro [0]=rs.getString("idservice");
                registro [1]=rs.getString("type_service");
                registro [2]=rs.getString("service_price");
                registro [3]=rs.getString("formula");
                registro [4]=rs.getString("notes");
                
                
                totalregistros=totalregistros+1;
                modelo.addRow(registro);
                
            }
            return modelo;
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
        
        
        
    }
    
    public DefaultTableModel mostrarvista(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos = {"ID","Type_service","Service_price","Formula","Notes"};
        
        String [] registro =new String [5];
        
        totalregistros=0;
        modelo = new DefaultTableModel(null,titulos);
        
        sSQL="select * from service where type_service like '%"+ buscar + "%' order by idservice";
        
        try {
            Statement st= cn.createStatement();
            ResultSet rs=st.executeQuery(sSQL);
            
            while(rs.next()){
                registro [0]=rs.getString("idservice");
                registro [1]=rs.getString("type_service");
                registro [2]=rs.getString("service_price");
                registro [3]=rs.getString("formula");
                registro [4]=rs.getString("notes");
                
                
                totalregistros=totalregistros+1;
                modelo.addRow(registro);
                
            }
            return modelo;
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
        
        
        
    }
    public boolean insertar (vservice dts){
        sSQL="insert into service (type_service,service_price,formula,notes)" +
                "values (?,?,?,?)";
        try {
            
            PreparedStatement pst=cn.prepareStatement(sSQL);
            pst.setString(1, dts.getType_service());
            pst.setString(2, dts.getService_price());
            pst.setString(3, dts.getFormula());
            pst.setString(4, dts.getNotes());
            
            
            int n=pst.executeUpdate();
            
            return n!=0;
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
   
    }
    
     public boolean editar (vservice dts){
       sSQL="Update service set type_service=?,service_price=?,formula=?,notes=?"+
              " where idservice=?";
       
         
        try {
            PreparedStatement pst=cn.prepareStatement(sSQL);
            pst.setString(1, dts.getType_service());
            pst.setString(2, dts.getService_price());
            pst.setString(3, dts.getFormula());
            pst.setString(4, dts.getNotes());
           
            pst.setInt(5, dts.getIdservice());
            
            int n=pst.executeUpdate();
            
           return n!=0;
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
   
    }
     
      public boolean eliminar (vservice dts){
          sSQL="delete from service where idservice=?";
          
          
        try {
            
            PreparedStatement pst=cn.prepareStatement(sSQL);
            
            pst.setInt(1, dts.getIdservice());
            
            int n=pst.executeUpdate();
            
              return n!=0;
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
   
    }
    
}
