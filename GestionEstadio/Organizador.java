package GestionEstadio;

import java.util.ArrayList;
import java.util.Scanner;

public class Organizador extends Usuario {
    //Se definen sus atributos propias
    private String empresa;
    private String cargo;

    //Se define sus constructor
    public Organizador(String codigoUnico, String cedula, String nombre, String apellido, String usuario, String contraseña, String correo, Rol rol, String empresa, String cargo) {
        super(codigoUnico, cedula, nombre, apellido, usuario, contraseña, correo, rol);
        this.empresa=empresa;
        this.cargo=cargo;
    }


    public Organizador(String codigoUnico, String cedula, String nombre, String apellido, String empresa, String cargo) {
        super(codigoUnico, cedula, nombre, apellido, null, null, null, Rol.O);
        this.empresa = empresa;
        this.cargo = cargo;
    }


    public String getEmpresa() {
        return empresa;
    }
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }


    @Override
    public int mostrarMenu() {
                System.out.println("Menú de Organizador: \r\n" + //
                                    "1. Generar reporte de ventas \r\n" + //
                                    "2. Salir \r\n" + //
                                    "Seleccione una opción: ");
        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();
        return opcion;
    }

    @Override
    public void consultarEntrada(ArrayList<Compra> listaTotal){
    System.out.println("----------Lista de todas las compras----------");
        for (Compra c : listaTotal) {
            System.out.println(c.toString());              
       }
    }

    public void generarReporte(ArrayList<Compra> listaTotal) {
    int totalCompras = listaTotal.size();
    int contEntradas = 0;
    int contKits = 0;
    double montoTotal = 0.0;
    
    // Calculamos los totales
    for (Compra c : listaTotal) {
        if (c.getTipo().equalsIgnoreCase("ENTRADA")) {
            contEntradas++;
        } else if (c.getTipo().equalsIgnoreCase("KIT")) {
            contKits++;
        }
        montoTotal += c.getValorPagado();
    }
    
    Sistema.notificar(this, totalCompras, contEntradas, contKits, montoTotal);
}

}
    

