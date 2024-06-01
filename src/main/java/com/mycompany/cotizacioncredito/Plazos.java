package com.mycompany.cotizacioncredito;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Plazos {

    int codigo;
    int plazo;
    double tazaNormal;
    double tazaPuntual;

    public int getCodigo() {
        return codigo;
    }

    public int getPlazo() {
        return plazo;
    }

    public double getTazaNormal() {
        return tazaNormal;
    }

    public double getTazaPuntual() {
        return tazaPuntual;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

    public void setTazaNormal(double tazaNormal) {
        this.tazaNormal = tazaNormal;
    }

    public void setTazaPuntual(double tazaPuntual) {
        this.tazaPuntual = tazaPuntual;
    }

    @Override
    public String toString() {
        return getPlazo() + " semanas";
    }

    public void InsertarPlazos(JTextField paramPlazo, JTextField paramTazaNormal, JTextField paramTazaPuntual) {
        System.out.println(paramPlazo.getText());
        System.out.println(paramTazaNormal.getText());
        System.out.println(paramTazaPuntual.getText());

        setPlazo(Integer.parseInt(paramPlazo.getText()));
        setTazaNormal(Double.parseDouble(paramTazaNormal.getText()));
        setTazaPuntual(Double.parseDouble(paramTazaPuntual.getText()));

        Conexion objetoConexion = new Conexion();

        String consulta = "insert into Plazos (plazo, tazaNormal, tazaPuntual) values(?, ?, ?);";

        try {
            CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta);

            cs.setInt(1, getPlazo());
            cs.setDouble(2, getTazaNormal());
            cs.setDouble(3, getTazaPuntual());

            cs.execute();
            JOptionPane.showMessageDialog(null, "Se incerto correctamente el Producto ");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se incerto correctamente el Producto, error: " + e.toString());
        }

    }
    //Metodo de eliminar 

    public void EliminarProductos(JTextField paramCodigo) {

        setCodigo(Integer.parseInt(paramCodigo.getText()));

        Conexion objetoConexion = new Conexion();

        String consulta = "DELETE FROM Productos WHERE productos.sku=1;";

        try {
            CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta);
            cs.setInt(1, getCodigo());
            cs.execute();

            JOptionPane.showMessageDialog(null, "Se ha eliminado correctamete el alumno");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar, error: " + e.toString());
        }
    }

    public ArrayList MostrarPlazos() {
        Conexion objetoConexion = new Conexion();
        //creamos el modelo de la tala
        DefaultTableModel modelo = new DefaultTableModel();
        ArrayList mListaPlazos = new ArrayList();
        Plazos mPlazos = null;

        String sql = "";

        sql = "select * from Plazos;";

        String[] datos = new String[4];
        Statement st;

        try {
            st = objetoConexion.estableceConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                mPlazos = new Plazos();
                mPlazos.setCodigo(rs.getInt("id"));
                mPlazos.setPlazo(rs.getInt("plazo"));
                mPlazos.setTazaNormal(rs.getDouble("tazaNormal"));
                mPlazos.setTazaPuntual(rs.getDouble("tazaPuntual"));
                mListaPlazos.add(mPlazos);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo mostrar los registros, error: " + e.toString());
        }

        return mListaPlazos;
    }

    public void MostrarPlazoss(JComboBox combo) {

        Conexion objetoConexion = new Conexion();
        DefaultTableModel modelo = new DefaultTableModel();
        String sql = "";

        sql = "select * from Plazos;";

        String[] datos = new String[4];
        Statement st;

        try {
            st = objetoConexion.estableceConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                combo.addItem(datos[1]);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo mostrar los registros, error: " + e.toString());
        }
    }
}
