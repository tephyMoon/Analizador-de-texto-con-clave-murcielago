/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import static alert.InsertSeach.txt_inserach;
import static alert.Replace.txt_inreplace;
import static alert.Replace.txt_inreplace1;
import java.awt.Color;
import java.awt.List;
import java.text.Normalizer;
import java.util.ArrayList;

/**
 *
 * @author Maritza Vargas
 */
public class Functions {
    
     public static void Repa(String valor, String letra){
        
        String cadenaNormalize = Normalizer.normalize(valor, Normalizer.Form.NFD);   
        String valor2 = cadenaNormalize.replaceAll("[^\\p{ASCII}]", "");
       String s= valor2.toLowerCase();
    
       int times =0;
       for (int i = 0; i < s.length(); i++){
           if (s.substring(i).startsWith(letra)){
               times++;
           }
       }
       frm_start.lbl_rep_A.setText(Integer.toString(times));
       
   }
      public static void Repe(String valor, String letra){
        
        String cadenaNormalize = Normalizer.normalize(valor, Normalizer.Form.NFD);   
        String valor2 = cadenaNormalize.replaceAll("[^\\p{ASCII}]", "");
       String s= valor2.toLowerCase();

       
       
       int times =0;
       for (int i = 0; i < s.length(); i++){
           if (s.substring(i).startsWith(letra)){
               times++;
           }
       }

       frm_start.lbl_rep_E.setText(Integer.toString(times));
       
   }
      
       public static void Repi(String valor, String letra){
        
        String cadenaNormalize = Normalizer.normalize(valor, Normalizer.Form.NFD);   
        String valor2 = cadenaNormalize.replaceAll("[^\\p{ASCII}]", "");

       String s= valor2.toLowerCase();
      
       
       int times =0;
       for (int i = 0; i < s.length(); i++){
           if (s.substring(i).startsWith(letra)){
               times++;
           }
       }
       frm_start.lbl_rep_I.setText(Integer.toString(times));
       
   }
       
        public static void Repo(String valor, String letra){
        
        String cadenaNormalize = Normalizer.normalize(valor, Normalizer.Form.NFD);   
        String valor2 = cadenaNormalize.replaceAll("[^\\p{ASCII}]", "");

       String s= valor2.toLowerCase();     
       
       
       int times =0;
       for (int i = 0; i < s.length(); i++){
           if (s.substring(i).startsWith(letra)){
               times++;
           }
       }

       frm_start.lbl_rep_O.setText(Integer.toString(times));
       
   }
        
         public static void Repu(String valor, String letra){
        
        String cadenaNormalize = Normalizer.normalize(valor, Normalizer.Form.NFD);   
        String valor2 = cadenaNormalize.replaceAll("[^\\p{ASCII}]", "");

       String s= valor2.toLowerCase();

       
       int times =0;
       for (int i = 0; i < s.length(); i++){
           if (s.substring(i).startsWith(letra)){
               times++;
           }
       }

       frm_start.lbl_rep_U.setText(Integer.toString(times));
       
   }
         
         public static void PAR(String valor){
             String[] valorarray = valor.split(" ");
             int sumPar=0;
             int sumImp=0;
             
             
             for (int i = 0; i < valorarray.length; i++){
            String palabra = valorarray[i];
 
            int cont = palabra.length();
 
            
            if (cont % 2 == 0 ){
                sumPar = sumPar + 1;
                
            }else {
                sumImp = sumImp + 1;
            }
            
        }
            
             frm_start.lbl_cantidad_par.setText(Integer.toString(sumPar));
             frm_start.lbl_cantidad_impar.setText(Integer.toString(sumImp));
         }
         
         
          public static void Buscar(){
              
              String valor = frm_start.txt_entrada.getText();
        String cadenaNormalize = Normalizer.normalize(valor, Normalizer.Form.NFD);   
        String valor2 = cadenaNormalize.replaceAll("[^\\p{ASCII}]", "");

       String s= valor2.toLowerCase();
       
       String find = txt_inserach.getText();
      
       
       
       int times =0;
       for (int i = 0; i < s.length(); i++){
           if (s.substring(i).startsWith(find)){
               times++;
               
           }
       }
       System.out.println(times);
       alert.InsertSeach.lbl_conc.setText(Integer.toString(times));
       


          }
          
          public static void replace(){
       
   
   String valor = frm_start.txt_entrada.getText();
        String cadenaNormalize = Normalizer.normalize(valor, Normalizer.Form.NFD);   
        String valor2 = cadenaNormalize.replaceAll("[^\\p{ASCII}]", "");

       String s= valor2.toLowerCase();
       
       String find = txt_inreplace.getText();
       String rep = txt_inreplace1.getText();
       
    
       
       for (int i = 0; i <find.length(); i++){
 
           s = s.replace(find, rep);
       }
       frm_start.txt_entrada.setText(s);
    
   }
         
         
    
}
