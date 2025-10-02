/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metodos;

import Empleados.Empleados;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Metodos {
    Vector vPrincipal = new Vector();
    
    public void agregar(Empleados unEmpleado) {
        vPrincipal.addElement(unEmpleado);
    }
    
    public void guardarArchivo(Empleados empleado){
        try {
            FileWriter fw = new FileWriter("Empleados.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.print("|"+empleado.getId());
            pw.print("|"+empleado.getNombre());
            pw.print("|"+empleado.getApellido());
            pw.print("|"+empleado.getFecha_nacimiento());
            pw.print("|"+empleado.getCorreo());
            pw.print("|"+empleado.getTipo_empleado());
            pw.print("|"+empleado.getSalario());
            pw.println("|"+empleado.getCargo());
            pw.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public DefaultTableModel listaEmpleados() {
        Vector cabeceras = new Vector();
        cabeceras.addElement("ID");
        cabeceras.addElement("Nombre");
        cabeceras.addElement("Apellido");
        cabeceras.addElement("Fecha Nacimiento");
        cabeceras.addElement("Correo");
        cabeceras.addElement("Tipo empleado");
        cabeceras.addElement("Salario");
        cabeceras.addElement("Cargo");
        
        DefaultTableModel mdlTabla = new DefaultTableModel(cabeceras, 0);
        
        try {
            FileReader fr = new FileReader("Empleados.txt");
            BufferedReader br = new BufferedReader(fr);
            String d;
            while ((d=br.readLine()) != null){
                StringTokenizer dato = new StringTokenizer(d,"|");
                Vector x = new Vector();
                while (dato.hasMoreTokens()){
                    x.addElement(dato.nextToken());
                }
                mdlTabla.addRow(x);
            }
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return mdlTabla;
    }
}
