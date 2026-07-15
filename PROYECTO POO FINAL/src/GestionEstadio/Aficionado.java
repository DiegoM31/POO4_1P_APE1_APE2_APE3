package GestionEstadio;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;



public class Aficionado extends Usuario {
    private String celular;
    private String paisFavorito;
    Scanner sc = new Scanner(System.in);

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
    public int mostrarMenu() {
        System.out.println("Menú de Aficionado: \r\n" + //
            "1. Consultar partidos \r\n" + //
            "2. Comprar entrada \r\n" + //
            "3. Comprar kit de entradas \r\n" + //
            "4. Consultar compras \r\n" + //
            "5. Salir \r\n"); //
            Scanner sc = new Scanner(System.in);
            System.out.print("Seleccione una opción: ");
            int opcion = sc.nextInt();
            return opcion;

    }

    public void consultarPartidos(ArrayList<Partido> partidos){
        System.out.println("Partidos encontrados:");
        int contador=1;

        for(Partido p: partidos){
            System.out.println( "\n " + contador++ + ". Código: " + p.getCodigo());
            System.out.println("Partido: " + p.getSeleccionLocal() + " vs " + p.getSeleccionVisitante());
            System.out.println("Fecha: " + p.getFecha());
            System.out.println("Estadio: " + p.GetEstadio());
            System.out.println("Ciudad: " + p.getCiudad());
            System.out.println("Fase: " + p.getFase());

            System.out.println("Zonas disponibles:");
            System.out.println("- GENERAL      | Dis ponibles: " + p.getEntradasGeneral() + " | Precio: $" + p.getPrecioGeneral());
            System.out.println("- PREFERENCIAL | Disponibles: " + p.getEntradasPreferencial() + " | Precio: $" + p.getPrecioPreferencial());
            System.out.println("- VIP          | Disponibles: " + p.getEntradasVIP() + " | Precio: $" + p.getPrecioVIP());
            System.out.println("--------------------------------------------------");
        }
    }

    // Dentro de Aficionado.java, reemplaza tu método actual por esta estructura
public void comprarEntrada(ArrayList<Partido> partidos, Sistema sistema) {
    System.out.println("Seleccione el código del partido:");
    String codSeleccionado = sc.nextLine();
    Partido pElegido = null;
    for (Partido p : partidos) {
        if (p.getCodigo().equalsIgnoreCase(codSeleccionado)) {
            pElegido = p;
            break;
        }
    }
    if (pElegido == null) {
        System.out.println("Partido no encontrado.");
        return;
    }
    System.out.println("Elija la zona: 1. General, 2. Preferencial, 3. VIP");
    int opcion = Integer.parseInt(sc.nextLine());

    double precio = 0;
    String nombreZona = "";
    int stockDisponible = 0;

    switch (opcion) {
        case 1:
            precio = pElegido.getPrecioGeneral();
            nombreZona = "General";
            stockDisponible = pElegido.getEntradasGeneral();
            break;
        case 2:
            precio = pElegido.getPrecioPreferencial();
            nombreZona = "Preferencial";
            stockDisponible = pElegido.getEntradasPreferencial();
            break;
        case 3:
            precio = pElegido.getPrecioVIP();
            nombreZona = "VIP";
            stockDisponible = pElegido.getEntradasVIP();
            break;
        default:
            System.out.println("Opción inválida.");
            return;
    }

    System.out.println("Ingrese cantidad:");
    int cantidad = Integer.parseInt(sc.nextLine());

    if (cantidad > 0 && cantidad <= stockDisponible) {
        double total = cantidad * precio;
        if (nombreZona.equals("General")) {
            pElegido.setEntradasGeneral(stockDisponible - cantidad);
        } else if (nombreZona.equals("Preferencial")) {
            pElegido.setEntradasPreferencial(stockDisponible - cantidad);
        } else if (nombreZona.equals("VIP")) {
            pElegido.setEntradasVIP(stockDisponible - cantidad);
        }
        System.out.println("Total a pagar: $" + total);
        System.out.println("Ingrese número de tarjeta:");
        String tarjeta = sc.nextLine();
        System.out.println("Pago exitoso. Gracias por su compra.");
        Compra c1Compra = new Compra("ENTRADA", pElegido.getCodigo(), new Date(), cantidad, total, this.getCodigoUnico());
        sistema.getCompras().add(c1Compra);
        Archivos.guardarLinea("compras.txt", c1Compra.formatToLineaArchivo()); 
        Sistema.notificar(this, c1Compra);
        } else {
        System.out.println("Stock insuficiente o cantidad no válida.");
    }
    
    }




    public void comprarKit(ArrayList<Kit> listaKits, ArrayList<Partido> listaPartidos, Sistema sistema) {
    System.out.println("===== KITS DISPONIBLES =====");
    for (int i = 0; i < listaKits.size(); i++) {
        Kit k = listaKits.get(i);
     
        System.out.println((i + 1) + ". " + k.getNombre());
        System.out.println("Incluye:");
    
        for (String codPartido : k.getPartidosIncluidos()) {
            Partido p = buscarPartido(listaPartidos, codPartido);
            if (p != null) {
                System.out.println("- " + p.getSeleccionLocal() + " vs " + p.getSeleccionVisitante() + " (" + p.getCodigo() + ")");
            }
        }

        System.out.println("Precio: $" + k.getPrecio());
        System.out.println("Disponibles: " + k.getDisponibles());
        System.out.println("---------------------------");
    }
    System.out.println("Seleccione el número del kit que desea comprar:");
    int opcion = Integer.parseInt(sc.nextLine());
    if (opcion >= 1 && opcion <= listaKits.size()) {
        Kit kitSeleccionado = listaKits.get(opcion - 1);
        System.out.println("Ingrese cantidad:");
        int cantidad = Integer.parseInt(sc.nextLine());
        if (cantidad > 0 && cantidad <= kitSeleccionado.getDisponibles()) {
            double total = cantidad * kitSeleccionado.getPrecio();
            kitSeleccionado.setDisponibles(kitSeleccionado.getDisponibles() - cantidad);
            
            System.out.println("Total a pagar: $" + total);
            System.out.println("Ingrese número de tarjeta:");
            String tarjeta = sc.nextLine();
            System.out.println("Procesando compra...");
            Compra c1Compra = new Compra("KIT", kitSeleccionado.getNombre(), new Date(), cantidad, total, this.getCodigoUnico());
            sistema.getCompras().add(c1Compra);
            Archivos.guardarLinea("compras.txt", c1Compra.formatToLineaArchivo()); 
            Sistema.notificar(this, c1Compra, kitSeleccionado);
            System.out.println("Pago exitoso. Gracias por su compra.");
        } else {
            System.out.println("Stock insuficiente o cantidad no válida.");
        }
    } else {
        System.out.println("Opción inválida.");
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

    public Partido buscarPartido(ArrayList<Partido> listaPartidos, String codigo) {
        for (Partido partido : listaPartidos) {
            if (partido.getCodigo().equals(codigo)) {
                return partido;
            }
        }
        return null; // Retorna null si no se encuentra el partido
    }

    
}