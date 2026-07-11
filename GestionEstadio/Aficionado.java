package GestionEstadio;
import java.util.ArrayList;
import java.util.Scanner;

public class Aficionado extends Usuario {
    private String celular;
    private String paisFavorito;

    public Aficionado(String codigoUnico, String cedula, String nombre, String apellido, String usuario, String contraseña, String correo, Rol rol, String celular, String paisFavorito) {
        super(codigoUnico, cedula, nombre, apellido, usuario, contraseña, correo, rol);
        this.celular=celular;
        this.paisFavorito=paisFavorito;
    }

    public Aficionado(String codigoUnico, String cedula, String nombre, String apellido, String celular, String paisFavorito) {
        super(codigoUnico, cedula, nombre, apellido, null, null, null, Rol.A);
        this.celular = celular;
        this.paisFavorito = paisFavorito;
    }

    @Override
    public void mostrarMenu() {
        System.out.println("Menú de Aficionado: \r\n" + //
            "1. Consultar partidos \r\n" + //
            "2. Comprar entrada \r\n" + //
            "3. Comprar kit de entradas \r\n" + //
            "4. Consultar entradas \r\n" + //
            "5. Salir \r\n" + //
            "Seleccione una opción: ");
    }

    public void consultarPartidos(ArrayList<Partido> listaPartidos){
        System.out.println("Partidos encontrados:\n");
        int contador=1;

        for(Partido p: listaPartidos){
            System.out.println(contador + ". Código: " + p.getCodigo());
            System.out.println("Partido: " + p.getSeleccionLocal() + " vs " + p.getSeleleccionVisitante());
            System.out.println("Fecha: " + p.getFecha());
            System.out.println("Estadio: " + p.GetEstadio());
            System.out.println("Ciudad: " + p.getCiudad());
            System.out.println("Fase: ");

            System.out.println("Zonas disponibles:");
            // System.out.println("- GENERAL      | Disponibles: " + p.getEntradasGeneral() + " | Precio: $" + /* precio aquí */);
            // System.out.println("- PREFERENCIAL | Disponibles: " + p.getEntradasPreferencial() + " | Precio: $" + /* precio aquí */);
            // System.out.println("- VIP          | Disponibles: " + p.getentradasVIP() + " | Precio: $" + /* precio aquí */);
            System.out.println("--------------------------------------------------");
            contador++;
        }
    }

    public void comprarEntrada(){

        // System.out.println("Ingrese el código del partido:");
        // String codPartido = sc.nextLine();
        // Partido p = buscarPartido(listaPartidos, codPartido); 
        // if (p == null) {
        //     System.out.println("Partido no encontrado.");
        //     return;
        // }
        // System.out.println("Elija la zona (a. GENERAL, b. PREFERENCIAL, c. VIP):");
        // String opcionZona = sc.nextLine();

        // System.out.println("Ingrese la cantidad de entradas:");
        // int cantidad = Integer.parseInt(sc.nextLine());
        
        // double total = cantidad * precioSeleccionado;
        // System.out.println("Total a pagar: $" + total);
        // System.out.println("Ingrese número de tarjeta:");
        // String tarjeta = sc.nextLine();

        // System.out.println("Pago exitoso. Gracias por su compra.");

        // Compra nuevaCompra = new Compra("ENTRADA", p.getCodigo(), new Date(), cantidad, total, this.getCodigoUnico());
        
        // p.setEntradasGeneral(p.getEntradasGeneral() - cantidad);
    }

    public void comprar(Partido partido,String zona,int cantidad){
        
    }

    public void comprar(Kit kit, int candidad){

        // if (kit.getDisponibles() > 0) {
        //     System.out.println("Incluye: " + kit.getPartidos());
        //     System.out.println("Precio total: $" + kit.getPrecio());
        //     Scanner sc = new Scanner(System.in);
        //     System.out.println("Ingrese número de tarjeta:");
        //     String tarjeta = sc.nextLine();
        // } else {
        //     System.out.println("Kit no disponible.");
        // }
    }

    @Override
    public void consultarEntrada(){

    // boolean tieneCompras = false;
    // for (Compra c : listaTotal) {
    //     if (c.getCodigoAficionado().equals(this.codigoUnico)) { 
    //             c.getCodigoCompra(), 
    //             c.getTipo(), 
    //             c.getFechaCompra(), 
    //             c.getCodigoReferencia(), 
    //             c.getValorPagado());
    //         tieneCompras = true;
    //     }
    //     
    //} if (!tieneCompras) {
    //     System.out.println("No registra compras realizadas hasta el momento.");
    }

    //Metodos Getters y Setters
     public void setCelular(String celular){
        this.celular= celular;
    }
    public String getCelular(){
        return this.celular;
    }

    public void setPaisFavorito(String paisFavorito){
        this.paisFavorito= paisFavorito;
    }
    public String getPaisFavorito(){
        return this.paisFavorito;
    }

}