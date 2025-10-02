/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metodosDepa;

import Departamentos.Departamentos;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MetodosDepa {
     Vector vPrincipal = new Vector();
    
    public void agregarDepa(Departamentos unDepartamento) {
        vPrincipal.addElement(unDepartamento);
    }
    
    public void guardarArchivoDepa(Departamentos departamento){
        try {
            FileWriter fw = new FileWriter("Departamentos.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.print("|"+departamento.getId());
            pw.println("|"+departamento.getNombre());
            pw.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public DefaultTableModel listaDepartamentos() {
        Vector cabeceras = new Vector();
        cabeceras.addElement("ID");
        cabeceras.addElement("Nombre");
        
        DefaultTableModel MdlTabla = new DefaultTableModel(cabeceras, 0);
        
        try {
            FileReader fr = new FileReader("Departamentos.txt");
            BufferedReader br = new BufferedReader(fr);
            String d;
            while ((d=br.readLine()) != null){
                StringTokenizer dato = new StringTokenizer(d,"|");
                Vector x = new Vector();
                while (dato.hasMoreTokens()){
                    x.addElement(dato.nextToken());
                }
                MdlTabla.addRow(x);
            }
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return MdlTabla;
    }
}
