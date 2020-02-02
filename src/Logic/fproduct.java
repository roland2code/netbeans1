/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.vproduct;
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
public class fproduct {
    private final conexion mysql=new conexion();
    private final Connection cn=mysql.conectar();
    private String sSQL="";
    public Integer totalregistros;
    
    
    public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos = {"ID","Name","Description","Unit","Sale Price"};
        
        String [] registro =new String [5];
        
        totalregistros=0;
        modelo = new DefaultTableModel(null,titulos);
        
        sSQL="select * from product where name like '%"+ buscar + "%' order by idproduct";
        
        try {
            Statement st= cn.createStatement();
            ResultSet rs=st.executeQuery(sSQL);
            
            while(rs.next()){
                registro [0]=rs.getString("idproduct");
                registro [1]=rs.getString("name");
                registro [2]=rs.getString("description");
                registro [3]=rs.getString("unit");
                registro [4]=rs.getString("sale_price");
              
                
                
                totalregistros=totalregistros+1;
                modelo.addRow(registro);
                
            }
            return modelo;
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
        
        
        
    }
    
    public boolean insertar (vproduct dts){
        sSQL="insert into product (name,description,unit,sale_price)" +
                "values (?,?,?,?)";
        try {
            
            PreparedStatement pst=cn.prepareStatement(sSQL);
            pst.setString(1, dts.getName());
            pst.setString(2, dts.getDescription());
            pst.setString(3, dts.getUnit());
            pst.setDouble(4, dts.getSale_price());
           
            
            
            int n=pst.executeUpdate();
            
            return n!=0;
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
   
    }
    
     public boolean editar (vproduct dts){
       sSQL="Update product set name=?,description=?,unit=?,sale_price=?"+
              " where idproduct=?";
       
         
        try {
            PreparedStatement pst=cn.prepareStatement(sSQL);
            pst.setString(1, dts.getName());
            pst.setString(2, dts.getDescription());
            pst.setString(3, dts.getUnit());
            pst.setDouble(4, dts.getSale_price());
           
            pst.setInt(5, dts.getIdproduct());
            
            int n=pst.executeUpdate();
            
           return n!=0;
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
   
    }
     
      public boolean eliminar (vproduct dts){
          sSQL="delete from product where idproduct=?";
          
          
        try {
            
            PreparedStatement pst=cn.prepareStatement(sSQL);
            
            pst.setInt(1, dts.getIdproduct());
            
            int n=pst.executeUpdate();
            
              return n!=0;
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
   
    }
    
}
