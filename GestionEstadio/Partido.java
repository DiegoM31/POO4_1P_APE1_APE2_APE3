package GestionEstadio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Partido {
    private String codigo;
    private String seleccionLocal;
    private String seleccionVisitante;
    private Date fecha;
    private String estadio;
    private String ciudad;
    private int capacidad;

    private int entradasGeneral;
    private int entradasPreferencial;
    private int entradasVIP; 
    private String fase;
    private double precioGeneral = 50.0;
    private double precioPreferencial = 100.0;
    private double precioVIP = 200.0;


    public Partido(String codigo,String seleccionLocal,String seleccionVisitante,Date fecha,String estadio,String ciudad,int capacidad,int entradasGeneral,int entradasPreferencial,int entradasVIP,String fase){
        
      this.codigo=codigo;
      this.seleccionLocal=seleccionLocal;
      this.seleccionVisitante=seleccionVisitante;
      this.fecha=fecha;
      this.estadio=estadio;
      this.ciudad=ciudad;
      this.capacidad=capacidad;
      this.entradasGeneral=entradasGeneral;
      this.entradasPreferencial=entradasPreferencial;
      this.entradasVIP=entradasVIP;
      this.fase=fase;
    }
    ////getters 
    public String getCodigo(){
        return codigo;
    }
    public String getSeleccionLocal(){
        return seleccionLocal;
    }
    public String getSeleccionVisitante(){
        return seleccionVisitante;
    }
    public Date getFecha(){
        return fecha;
    }
    public String GetEstadio(){
        return estadio;
    }
    public String getCiudad(){
        return ciudad;
    }
    public int getCapacidad(){
        return capacidad;
    }

    public int getEntradasGeneral(){
        return entradasGeneral;
    }
    public int getEntradasPreferencial(){
        return entradasPreferencial;
    }
    
    public int getEntradasVIP(){
        return entradasVIP;
    }
    public String getFase(){
        return fase;
    }
    public double getPrecioGeneral(){
        return precioGeneral;
    }
    public double getPrecioPreferencial(){
        return precioPreferencial;
    }
    public double getPrecioVIP(){
        return precioVIP;
    }
    ///setters
    public void setCodigo(String codigo){
        this.codigo=codigo;
    }
    public void setSeleccionLocal(String seleccionLocal){
        this.seleccionLocal=seleccionLocal;
    }
    public void setSeleccionVisitante(String seleccionVisitante){
        this.seleccionVisitante=seleccionVisitante;
    }
    public void setFecha(Date fecha){
        this.fecha=fecha;
    }
    public void setEstadio(String estadio){
        this.estadio=estadio;
    }
    public void seCiudad(String ciudad){
        this.ciudad=ciudad;
    }
    public void setCapacidad(int capacidad){
        this.capacidad=capacidad;
    }
    public void setEntradasGeneral(int entradasGeneral){
        this.entradasGeneral=entradasGeneral;
    }
    public void setEntradasPreferencial(int entradasPreferencial){
        this.entradasPreferencial=entradasPreferencial;
    }
    public void setEntradasVIP(int entradasVIP){
        this.entradasVIP=entradasVIP;
    }
    public void setFase(String fase){
        this.fase=fase;
    }

    public static ArrayList<Partido> cargarpartidos(String archivo){
        ArrayList<Partido> partidos = new ArrayList<>();

        try{ 
            BufferedReader br= new BufferedReader(new FileReader(archivo));

            String linea;
            
            br.readLine(); //saltar el encabezado
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

        while ((linea = br.readLine()) != null) {

            String[] datos = linea.split("\\|");

            Partido partido = new Partido(
                    datos[0].trim(),                         // Código
                    datos[1].trim(),                         // Selección local
                    datos[2].trim(),                         // Selección visitante
                    formato.parse(datos[3].trim()),          // Fecha
                    datos[4].trim(),                         // Estadio
                    datos[5].trim(),                         // Ciudad
                    Integer.parseInt(datos[6].trim()),       // Capacidad
                    Integer.parseInt(datos[7].trim()),       // General
                    Integer.parseInt(datos[8].trim()),       // Preferencial
                    Integer.parseInt(datos[9].trim()),        // VIP
                    datos[10].trim()                          // datos[10] = Fase
            );

            partidos.add(partido);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return partidos;
}
    }
