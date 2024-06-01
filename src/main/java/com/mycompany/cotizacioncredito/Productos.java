package com.mycompany.cotizacioncredito;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Productos {

    int codigo;
    String nombre;
    String descrpcion;
    double precio;

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescrpcion() {
        return descrpcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescrpcion(String descrpcion) {
        this.descrpcion = descrpcion;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    //Incercion de datos 
    public void InsertarProductos(JTextField paramNombre, JTextField paramDescripcion, JTextField paramPrecio) {

        setNombre(paramNombre.getText());
        setDescrpcion(paramDescripcion.getText());
        setPrecio(Double.parseDouble(paramPrecio.getText()));

        Conexion objetoConexion = new Conexion();

        String consulta = "insert into Productos (nombre, descripcion, precio) values(?, ?, ?)";

        try {
            System.out.println("Llamando al servicio");
            CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta);

            cs.setString(1, getNombre());
            cs.setString(2, getDescrpcion());
            cs.setDouble(3, getPrecio());

            cs.execute();
            JOptionPane.showMessageDialog(null, "Se incerto correctamente el Producto ");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se incerto correctamente el Producto, error: " + e.toString());
        }

    }

    //Metodo Mostrar 
    public void MostrarProductos(JTable paramTablaTotal) {

        Conexion objetoConexion = new Conexion();
        //creamos el modelo de la tala
        DefaultTableModel modelo = new DefaultTableModel();

        TableRowSorter<TableModel> OrdenarTabla = new TableRowSorter<TableModel>(modelo);

        paramTablaTotal.setRowSorter(OrdenarTabla);

        String sql = "";

        modelo.addColumn("sku");
        modelo.addColumn("Nombre");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Precio");

        paramTablaTotal.setModel(modelo);

        sql = "select * from Productos;";

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
                modelo.addRow(datos);

            }
            paramTablaTotal.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo mostrar los registros, error: " + e.toString());
        }
    }

    public void BuscarProductos(JTable paramTablaTotal, JTextField query) {
        String queryString = query.getText();
        Conexion objetoConexion = new Conexion();
        DefaultTableModel modelo = new DefaultTableModel();

        TableRowSorter<TableModel> OrdenarTabla = new TableRowSorter<TableModel>(modelo);

        paramTablaTotal.setRowSorter(OrdenarTabla);

        String sql = "";

        modelo.addColumn("sku");
        modelo.addColumn("Nombre");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Precio");

        paramTablaTotal.setModel(modelo);

        sql = "SELECT * FROM Productos WHERE sku LIKE '%" + queryString + "%' OR nombre LIKE '%" + queryString + "%'";

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
                modelo.addRow(datos);

            }
            paramTablaTotal.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo mostrar los registros, error: " + e.toString());
        }

    }

    public void SeleccionProductos(JTable paramTableProductos, JTextField paramSku, JTextField paramNombre, JTextField paramDescripcion, JTextField paramPrecio) {

        try {
            int fila = paramTableProductos.getSelectedRow();

            if (fila >= 0) {
                paramSku.setText((paramTableProductos.getValueAt(fila, 0).toString()));
                paramNombre.setText((paramTableProductos.getValueAt(fila, 1).toString()));
                paramDescripcion.setText((paramTableProductos.getValueAt(fila, 2).toString()));
                paramPrecio.setText((paramTableProductos.getValueAt(fila, 3).toString()));
            } else {
                JOptionPane.showMessageDialog(null, "Fila no seleccionada");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de selecion: " + e.toString());
        }

    }

    //Metodo Modificar
    public void ModificarProductos(JTextField paramCodigo, JTextField paramNombre, JTextField paramDescripcion, JTextField paramPrecio) {

        setCodigo(Integer.parseInt(paramCodigo.getText()));
        setNombre(paramNombre.getText());
        setDescrpcion(paramDescripcion.getText());
        setPrecio(Double.parseDouble(paramPrecio.getText()));

        Conexion objetoConexion = new Conexion();

        String consulta = "UPDATE Productos SET productos.nombre = ?, productos.descripcion = ?, productos.precio = ? WHERE productos.sku = 1;";

        //Enlazamos la consulta 
        try {
            CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta);

            cs.setString(1, getNombre());
            cs.setString(2, getDescrpcion());
            cs.setInt(3, codigo);
            cs.setDouble(4, precio);

            cs.execute();
            JOptionPane.showMessageDialog(null, "Modificacion Exitosa");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se modifico, error: " + e.toString());
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

    public void SeleccionProducto(JTable paramTableAlumnos, JTextField paramId, JTextField paramNombres, JTextField paramApellidos) {

        try {
            int fila = paramTableAlumnos.getSelectedRow();//obtenemos sus pocicion 

            if (fila >= 0) {
//               paramId.setText((paramTableAlumnos.getValueAt(fila, 0)));
                paramId.setText((paramTableAlumnos.getValueAt(fila, 0).toString()));
                paramNombres.setText((paramTableAlumnos.getValueAt(fila, 1).toString()));
                paramApellidos.setText((paramTableAlumnos.getValueAt(fila, 2).toString()));
            } else {
                JOptionPane.showMessageDialog(null, "Fila no seleccionada");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de selecion: " + e.toString());
        }

    }
}
  
