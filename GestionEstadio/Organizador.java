package GestionEstadio;
import java.util.ArrayList;
import java.util.Date;

public class Organizador extends Usuario {
    private String empresa;
    private String cargo;

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

    @Override
    public void mostrarMenu() {
        System.out.println("Menú de Organizador: \r\n" + //
            "1. Generar reporte de ventas \r\n" + //
            "2. Salir \r\n" + //
            "Seleccione una opción: ");
    }

    @Override
    public void consultarEntrada(ArrayList<Compra> listaTotal){
    System.out.println("----------Lista de todas las compras----------");
        for (Compra c : listaTotal) {
            System.out.println(c.toString());              
       }
    }

    public void generarReporte(ArrayList<Compra> listaTotal){
    int totalCompras = listaTotal.size();
    int contEntradas = 0;
    int contKits = 0;
    double totalRecaudado = 0.0;
    
    for (Compra c : listaTotal) {
        
        if (c.getTipo().equalsIgnoreCase("ENTRADA")) {
            contEntradas++;
        } else if (c.getTipo().equalsIgnoreCase("KIT")) {
            contKits++;
        }
        totalRecaudado += c.getValorPagado();
    }

    // Mostrar el reporte en consola
    System.out.println("=====GENERAR REPORTE DE VENTAS=====");
    System.out.println("Resumen de ventas registradas:");
    System.out.println("Total de compras: " + totalCompras);
    System.out.println("Compras por tipo:");
    System.out.println("Compras por tipo: "+"Entradas: "+ contEntradas +"Kits: "+ contKits );
    System.out.println("Monto total recaudado: "+ String.format("%.2f", totalRecaudado));
    }

    public void salir(){


  }

    //Metodos Getters y Setters  
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

}
    

