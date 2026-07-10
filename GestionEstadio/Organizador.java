package GestionEstadio;
import java.util.ArrayList;


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

    @Override
    public void mostrarMenu() {
        System.out.println("Menú de Organizador: \r\n" + //
            "1. Generar reporte de ventas \r\n" + //
            "2. Salir \r\n" + //
            "Seleccione una opción: ");
    }

    @Override
    public void consultarEntrada(){
        System.out.println();
        System.out.println("----------Lista de todas las compras----------");
    //     for (Compra c : listacompras) {
    //         System.out.println(c.getCodigoCompra(), 
    //         c.getTipo(), 
    //         c.getCodigoReferencia(), 
    //         c.getFecha(), 
    //         c.getCantidad(), 
    //         c.getValorPagado(), 
    //         c.getEstado(), 
    //         c.getCodigoAficionado());               
    //    }
    }

    public void generarReporteDeVentas(){
    // int totalCompras = listaCompras.size();
    // int contEntradas = 0;
    // int contKits = 0;
    // double totalRecaudado = 0.0;

    // 
    // for (Compra c : listaCompras) {
    //     // Asumiendo que Compra tiene un método getTipo() que devuelve "ENTRADA" o "KIT"
    //     if (c.getTipo().equalsIgnoreCase("ENTRADA")) {
    //         contEntradas++;
    //     } else if (c.getTipo().equalsIgnoreCase("KIT")) {
    //         contKits++;
    //     }
    //     totalRecaudado += c.getValorPagado();
    // }

    // // Mostrar el reporte en consola
    // System.out.println("=====GENERAR REPORTE DE VENTAS=====");
    // System.out.println("Resumen de ventas registradas:");
    // System.out.println("Total de compras: " + totalCompras);
    // System.out.println("Compras por tipo:");
    // System.out.println("Compras por tipo: "+"Entradas: "+ contEntradas +"Kits: "+ contKits +);
    // System.out.println("Monto total recaudado: "+ totalRecaudado +);
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
    

