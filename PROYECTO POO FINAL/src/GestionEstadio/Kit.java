package GestionEstadio;

import java.util.ArrayList;

public class Kit {
    private String codigo;
    private String nombre;
    private String descripcion;
    private ArrayList<String> partidosIncluidos;
    private double precio;
    private int disponibles;
    public Kit(){
    }

    /*constructor */
    public Kit(String codigo, String nombre, String descripcion, ArrayList<String> partidosIncluidos, double precio, int disponibles) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.partidosIncluidos = partidosIncluidos;
        this.precio = precio;
        this.disponibles = disponibles;

    }
    
    /*setters y getters */
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public ArrayList<String> getPartidosIncluidos() {
        return partidosIncluidos;
    }
    public void setPartidosIncluidos(ArrayList<String> partidosIncluidos) {
        this.partidosIncluidos = partidosIncluidos;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public int getDisponibles() {
        return disponibles;
    }
    public void setDisponibles(int disponibles) {
        this.disponibles = disponibles;
    }
    public String getPartidosComoString() {
        return String.join(",", this.partidosIncluidos);
    }
    public String formatToLineaArchivo() {
        return this.codigo + "|" + this.nombre + "|" + this.descripcion + "|" + 
               getPartidosComoString() + "|" + this.precio + "|" + this.disponibles;
    }


    /*sobrecarga */
    @Override
    public String toString(){
        return "-------------------"+
        "Kit: "+nombre+"\n"+
        "Descripcion: " + descripcion + "\n" +
        " Precio: "+precio+"\n"+
        " Disponibles: "+disponibles+"\n"+
        "Partidos incluidos: " + partidosIncluidos+"\n"+
        "-------------------";

    }
    


    
}



