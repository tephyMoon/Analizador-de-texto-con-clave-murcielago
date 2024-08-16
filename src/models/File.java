/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import static models.frm_start.txt_entrada;

/**
 *
 * @author Maritza Vargas
 */
public class File {
     private JFileChooser accion = null;
    private java.io.File archivo = null;
    private frm_start frm_start;
    public static String ruta = "C:\\Escritorio\\";
    
     static Path fileName = Path.of(
            "C:\\Escritorio\\");
    
    public static void insert(String s)
        throws IOException 
    {   
        String d = "\r\n";
        Files.writeString(fileName, d,StandardOpenOption.APPEND);
        //Files.writeString(fileName, s);
        Files.writeString(fileName, s,StandardOpenOption.APPEND);
        
    }
    
     public void LeerFichero(frm_start frm_start) {
        this.frm_start = frm_start;

        accion = new JFileChooser();
        accion.setFileSelectionMode(0);
        FileNameExtensionFilter filtroImagen = new FileNameExtensionFilter("TXT", "txt");
        accion.setFileFilter(filtroImagen);
        accion.setDialogTitle("Abrir archivo");
        if (accion.showOpenDialog(frm_start) == JFileChooser.APPROVE_OPTION) {
            archivo = accion.getSelectedFile();
            frm_start.lbl_nombre.setText(archivo.getName());
            ruta = accion.getSelectedFile().toString();
            try {
                /*Si existe el fichero*/
                if (archivo.exists()) {
                    /*Abre un flujo de lectura a el fichero*/
                    BufferedReader leeArchivo = new BufferedReader(new FileReader(archivo));
                    String Slinea, datos = "";
                    /*Lee el fichero linea a linea hasta llegar a la ultima*/
                    while ((Slinea = leeArchivo.readLine()) != null) {
                        /*Imprime la linea leida*/
                        datos = datos + Slinea + "\n";
                    }
                    frm_start.txt_entrada.setText("");
                    frm_start.txt_entrada.setText(datos);
                    frm_start.txt_entrada.setEditable(true);
                    frm_start.txt_entrada.requestFocus();
                    frm_start.txt_entrada.setForeground(Color.white);
                    /*Cierra el flujo*/
                    leeArchivo.close();
                    this.frm_start.abrioArchivo = true;
                    this.frm_start.creoNuevo = false;
                } else {
                    System.out.println("Fichero No Existe");
                }
            } catch (Exception ex) {
                /*Captura un posible error y le imprime en pantalla*/
                System.out.println(ex.getMessage());
            }
        }
    }
    
  public void CrearFicheroNuevo(frm_start frm_start, String SCadena, String nombre) {
        this.frm_start = frm_start;

        accion = new JFileChooser();
        accion.setFileSelectionMode(0);
        FileNameExtensionFilter filtroImagen = new FileNameExtensionFilter("TXT", "txt");
        accion.setFileFilter(filtroImagen);
        accion.setDialogTitle("Guardar archivo " + nombre);
        accion.setSelectedFile(new java.io.File(nombre));
        if (accion.showSaveDialog(frm_start) == JFileChooser.APPROVE_OPTION) {
            ruta = accion.getSelectedFile().toString();
            archivo = new java.io.File(ruta);
            frm_start.lbl_nombre.setText(archivo.getName());
            try {
                //Si Existe el fichero lo borra
                if (archivo.exists()) {
                    archivo.delete();
                }
                BufferedWriter wr = new BufferedWriter(new FileWriter(archivo));
                FileWriter escribirArchivo = new FileWriter(archivo, true);
                BufferedWriter buffer = new BufferedWriter(escribirArchivo);
                buffer.write(SCadena);
                buffer.newLine();
                buffer.close();
                wr.close();
                escribirArchivo.close();

                this.frm_start.abrioArchivo = true;
                this.frm_start.creoNuevo = false;
            } catch (Exception ex) {
            }
        }
    }
     
      public void GuardarFichero(String SCadena, String nombre) {

        System.out.println(ruta);
        archivo = new java.io.File(ruta);
        try {
            //Si Existe el fichero lo borra
            if (archivo.exists()) {
                archivo.delete();
            }
            BufferedWriter wr = new BufferedWriter(new FileWriter(archivo));
            FileWriter escribirArchivo = new FileWriter(archivo, true);
            BufferedWriter buffer = new BufferedWriter(escribirArchivo);
            buffer.write(SCadena);
            buffer.newLine();
            buffer.close();
            wr.close();
            escribirArchivo.close();
        } catch (Exception ex) {
            //Captura un posible error le imprime en pantalla 
            System.out.println(ex.getMessage());
        }
    }



    
}
