package GestionEstadio;

import java.util,Date;

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


    public partido(String codigo,String seleccionLocal,String seleccionVisitante,Date fecha,String estadio,String ciudad,int capacidad,int entradasGeneral,int entradasPreferencial,int entradasVIP){
        
      this.codigo=codigo
      this.seleccionLocal=seleccionLocal
      this.seleccionVisitante=seleccionVisitante
      this.fecha=fecha
      this.estadio=estadio
      this.ciudad=ciudad
      this.capacidad=capacidad
      this.entradasGeneral=entradasGeneral
      this.entradasPreferencial=entradasPreferencial
      this.entradasVIP=entradasVIP
    }
    ////getters
    public String getCodigo(){
        return codigo;
    }
    public String getSeleccionLocal(){
        return seleccionLocal;
    }
    public String getSeleleccionVisitante(){
        return seleccionVisitante;
    }
    public Date getFecha(){
        return fecha;
    }
    public String GetEstadio(){
        return estadio;
    }public String getCiudad(){
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
    
    public int getentradasVIP(){
        return entradasVIP;
    }
    ///setters
    public void setCodigo(String codigo){
        this.codigo=codigo
    }
    public void setSeleccionLocal(String seleccionLocal){
        this.seleccionLocal=seleccionLocal
    }
    public void setSeleccionVisitante(String seleccionVisitante){
        this.seleccionVisitante=seleccionVisitante
    }
    public void setFecha(Date fecha){
        this.fecha=fecha
    }
    public void setEstadio(String estadio){
        this.estadio=estadio
    }
    public void seCiudad(String ciudad){
        this.ciudad=ciudad
    }
    public void setCapacidad(int capacidad){
        this.capacidad=capacidad
    }
    public void setEntradasGeneral(int entradasGeneral){
        this.entradasGeneral=entradasGeneral
    }
    public void setEntradasPreferencial(int entradasPreferencial){
        this.entradasPreferencial=entradasPreferencial
    }
    public void setEntradasVIP(int entradasVIP){
        this.entradasVIP=entradasVIP
    }
}
