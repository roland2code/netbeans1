/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.vemployee;
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
public class femployee {
    private final conexion mysql = new conexion();
    private final Connection cn = mysql.conectar();
    private String sSQL = "";
    private String sSQL2 = "";
    public Integer totalregistros;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "Name", "Lastname", "Address", "Phone", "Email", "Birthday", "Access", "Login", "Password", "Status"};

        String[] registro = new String[11];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select p.idperson,p.name,p.lastname,p.address,p.phone,p.email,p.birthday,"
                + "e.access,e.login,e.password,e.status from person p inner join employee e "
                + "on p.idperson=e.idperson where lastname like '%"
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
                registro[7] = rs.getString("access");
                registro[8] = rs.getString("login");
                registro[9] = rs.getString("password");
                registro[10] = rs.getString("status");

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }

    public boolean insertar(vemployee dts) {
        sSQL = "insert into person (name,lastname,address,phone,email,birthday)"
                + "values (?,?,?,?,?,?)";
        sSQL2 = "insert into employee (idperson,access,login,password,status)"
                + "values ((select idperson from person order by idperson desc limit 1),?,?,?,?)";
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);

            pst.setString(1, dts.getName());
            pst.setString(2, dts.getLastname());
            pst.setString(3, dts.getAddress());
            pst.setString(4, dts.getPhone());
            pst.setString(5, dts.getEmail());
            pst.setDate(6, dts.getBirthday());

            pst2.setString(1, dts.getAccess());
            pst2.setString(2, dts.getLogin());
            pst2.setString(3, dts.getPassword());
            pst2.setString(4, dts.getStatus());

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

    public boolean editar(vemployee dts) {
        sSQL = "Update person set name=?,lastname=?,address=?,phone=?,"
                + " email=?,birthday=? where idperson=?";
        
        sSQL2 = "Update employee set access=?,login=?,password=?,status=?"
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

            pst2.setString(1, dts.getAccess());
            pst2.setString(2, dts.getLogin());
            pst2.setString(3, dts.getPassword());
            pst2.setString(4, dts.getStatus());
            pst2.setInt(5, dts.getIdperson());

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

    public boolean eliminar(vemployee dts) {
        sSQL = "delete from employee where idperson=?";
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
    
    public DefaultTableModel login(String login,String password) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "Name", "Lastname", "Access", "Login", "Password", "Status"};

        String[] registro = new String[7];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select p.idperson,p.name,p.lastname,"
                + "e.access,e.login,e.password,e.status from person p inner join employee e "
                + "on p.idperson=e.idperson where e.login='"
                + login + "' and e.password='" + password + "' and e.status='A'";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("idperson");
                registro[1] = rs.getString("name");
                registro[2] = rs.getString("lastname");
               
                registro[3] = rs.getString("access");
                registro[4] = rs.getString("login");
                registro[5] = rs.getString("password");
                registro[6] = rs.getString("status");

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }
}
