package GestionEstadio;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
    public class Archivos {
        /*lee lor txt */
    public static ArrayList<String> leerArchivo(String nombrearchivo) {
        ArrayList<String> lineas = new ArrayList<>();
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            archivo = new File(nombrearchivo);
            fr = new FileReader(archivo, StandardCharsets.UTF_8);
            br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea); // Mantiene tu print por consola
                lineas.add(linea);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return lineas;
    }


        /*añade mas lenas a mi txt */
        public static void guardarLinea(String nombrearchivo, String linea) {
         try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombrearchivo, true))) {
            bw.write(linea);
            bw.newLine();
        } catch (Exception e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }   
}        


   