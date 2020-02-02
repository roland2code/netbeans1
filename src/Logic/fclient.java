/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.vclient;
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
public class fclient {

    private final conexion mysql = new conexion();
    private final Connection cn = mysql.conectar();
    private String sSQL = "";
    private String sSQL2 = "";
    public Integer totalregistros;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "Name", "Lastname", "Address", "Phone", "Email", "Birthday", "Code_client"};

        String[] registro = new String[8];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select p.idperson,p.name,p.lastname,p.address,p.phone,p.email,p.birthday,"
                + "c.code_client from person p inner join client c "
                + "on p.idperson=c.idperson where lastname like '%"
                + buscar + "%' order by idperson desc";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("idperson");
                registro[1] = rs.getString("name");
                registro[2] = rs.getString("lastname");
                registro[3] = rs.getString("address");
                registro[4] = rs.getString("phone");
                registro[5] = rs.getString("email");
                registro[6] = rs.getString("birthday");
                registro[7] = rs.getString("code_client");

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }

    public boolean insertar(vclient dts) {
        sSQL="insert into person (name,lastname,address,phone,email,birthday)"
                + "values (?,?,?,?,?,?)";
        sSQL2="insert into client (idperson,code_client)"
                + "values ((select idperson from person order by idperson desc limit 1),?)";
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);

            pst.setString(1, dts.getName());
            pst.setString(2, dts.getLastname());
            pst.setString(3, dts.getAddress());
            pst.setString(4, dts.getPhone());
            pst.setString(5, dts.getEmail());
            pst.setDate(6, dts.getBirthday());

            pst2.setString(1, dts.getCode_client());

            int n=pst.executeUpdate();

            if (n!=0) {
                int n2=pst2.executeUpdate();

                if (n2!=0) {
                    return true;

                } else {
                    return false;
                }
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }

    }

    public boolean editar(vclient dts) {
        sSQL = "Update person set name=?,lastname=?,address=?,phone=?,"
                + " email=?,birthday=? where idperson=?";
        
        sSQL2 = "Update client set code_client=?"
                + " where idperson=?";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);

            pst.setString(1, dts.getName());
            pst.setString(2, dts.getLastname());
            pst.setString(3, dts.getAddress());
            pst.setString(4, dts.getPhone());
            pst.setString(5, dts.getEmail());
            pst.setDate(6, dts.getBirthday());
            pst.setInt(7, dts.getIdperson());

            pst2.setString(1, dts.getCode_client());
            pst2.setInt(2, dts.getIdperson());

            int n = pst.executeUpdate();

            if (n != 0) {
                int n2 = pst2.executeUpdate();

                if (n2 != 0) {
                    return true;

                } else {
                    return false;
                }
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }

    }

    public boolean eliminar(vclient dts) {
        sSQL = "delete from client where idperson=?";
         sSQL2 = "delete from person where idperson=?";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);

            
            pst.setInt(1, dts.getIdperson());

            
            pst2.setInt(1, dts.getIdperson());

            int n = pst.executeUpdate();

            if (n != 0) {
                int n2 = pst2.executeUpdate();

                if (n2 != 0) {
                    return true;

                } else {
                    return false;
                }
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }  

}
