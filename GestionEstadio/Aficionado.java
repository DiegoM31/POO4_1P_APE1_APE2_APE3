package GestionEstadio;

import java.util.ArrayList;
import java.util.Date;
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

    public void consultarPartidos(ArrayList<Partido> partidos){
        System.out.println("Partidos encontrados:\n");
        int contador=1;

        for(Partido p: partidos){
            System.out.println(contador + ". Código: " + p.getCodigo());
            System.out.println("Partido: " + p.getSeleccionLocal() + " vs " + p.getSeleccionVisitante());
            System.out.println("Fecha: " + p.getFecha());
            System.out.println("Estadio: " + p.GetEstadio());
            System.out.println("Ciudad: " + p.getCiudad());
            System.out.println("Fase: " + p.getFase());

            System.out.println("Zonas disponibles:");
            System.out.println("- GENERAL      | Dis ponibles: " + p.getEntradasGeneral() + " | Precio: $"  );
            System.out.println("- PREFERENCIAL | Disponibles: " + p.getEntradasPreferencial() + " | Precio: $" );
            System.out.println("- VIP          | Disponibles: " + p.getentradasVIP() + " | Precio: $" );
            System.out.println("--------------------------------------------------");
            contador++;
        }
    }

    public void COMPRAR(ArrayList<Partido> listaPartidos, ArrayList<Compra> listaCompras, Scanner sc){

    System.out.println("Ingrese el código del partido:");
    String codPartido = sc.nextLine();
    
    Partido p = null;
    for (Partido part : listaPartidos) {
        if (part.getCodigo().equalsIgnoreCase(codPartido)) {
            p = part;
            break;
        }
    }
    
    if (p == null) {
        System.out.println("Partido no encontrado.");
        return;
    }

    System.out.println("Elija la zona (a. GENERAL, b. PREFERENCIAL, c. VIP):");
    String opcionZona = sc.nextLine().toLowerCase();
    int stockDisponible = 0;
    double precioUnitario = 0.0;
    String nombreZona = "";

    if (opcionZona.equals("a")) {
        stockDisponible = p.getEntradasGeneral();
        nombreZona = "GENERAL";
        precioUnitario = 45.00; //Precio de ejemplo
    } else if (opcionZona.equals("b")) {
        stockDisponible = p.getEntradasPreferencial();
        nombreZona = "PREFERENCIAL";
        precioUnitario = 85.00; //Precio de ejemplo
    } else if (opcionZona.equals("c")) {
        stockDisponible = p.getentradasVIP();
        nombreZona = "VIP";
        precioUnitario = 150.00; //Precio de 
    }

    System.out.println("Ingrese la cantidad de entradas (Disponibles: " + stockDisponible + "):");
    int cantidad = Integer.parseInt(sc.nextLine());

    if (cantidad > stockDisponible) {
        System.out.println("Stock insuficiente.");
        return;
    }

    double total = cantidad * precioUnitario;
    System.out.println("Total a pagar: $" + total);

    System.out.println("Ingrese número de tarjeta:");
    sc.nextLine(); 
    System.out.println("Pago exitoso. Gracias por su compra.");

    Compra nuevaCompra = new Compra("ENTRADA", p.getCodigo(), new Date(), cantidad, total, this.getCodigoUnico());
    listaCompras.add(nuevaCompra);
    Archivos.guardarCompra(nuevaCompra);

    if (nombreZona.equals("GENERAL")) p.setEntradasGeneral(stockDisponible - cantidad);
    else if (nombreZona.equals("PREFERENCIAL")) p.setEntradasPreferencial(stockDisponible - cantidad);
    else p.setEntradasVIP(stockDisponible - cantidad);

    System.out.println("Se ha enviado una notificación a su correo electrónico.");

    }

    public void COMPRAR(ArrayList<Kit> listaKits, ArrayList<Partido> listaPartidos){
        System.out.println("===== KITS DISPONIBLES =====");
            for (int i = 0; i < listaKits.size(); i++) {
                System.out.println((i + 1) + ". " + listaKits.get(i).toString());
            }
        }

    @Override
    public void consultarEntrada(ArrayList<Compra> listaTotal){
    System.out.println("Mis compras realizadas:");
        for (Compra c : listaTotal) {
            if (c.getCodigoAficionado().equals(this.codigoUnico)) {
                System.out.println(c.toString());
            }
        }
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