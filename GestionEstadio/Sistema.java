package GestionEstadio;

import GestionEstadio.Aficionado;
import GestionEstadio.Organizador;  
import GestionEstadio.Usuario;

import java.util.Scanner;
import java.util.ArrayList;

public class Sistema {
    private  ArrayList<Usuario> usuarios;
    private ArrayList<Partido> partidos;
    private ArrayList<Kit> kits;
    private ArrayList<Compra> compras;
    private Scanner sc;


    public Sistema() {
        // Inicializamos las listas vacías de forma segura sin ignorar parámetros
        this.usuarios = new ArrayList<>();
        this.partidos = new ArrayList<>();
        this.kits = new ArrayList<>();
        this.compras = new ArrayList<>();
        this.sc = new Scanner(System.in);
        cargarUsuariosDesdeArchivo();
    }

    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        sistema.iniciarSecion();
        sistema.sc.close(); // Cerramos el Scanner al final del programa
    }




    public void iniciarSecion() {
        System.out.println("\n\n\n\n\n");
        System.out.println("---- Iniciar Sesión --");
        System.out.println("Ingrese su usuario:");
        String usuarioI = sc.nextLine();
        System.out.println("Ingrese su contraseña:");
        String contraseñaI = sc.nextLine();
        boolean usuarioEncontrado = false;
        for (Usuario u : this.usuarios) {
            if (u.getUsuario().equals(usuarioI) && u.getContraseña().equals(contraseñaI)) {
                usuarioEncontrado = true;
                System.out.println("¡Inicio de sesión exitoso!");
                


                Rol rol = u.getRol();
                if (rol == Rol.A) {
                    System.out.println("Su rol es: Aficionado.");
                    System.out.println("Bienvenido/a " + u.getNombre() + " " + u.getApellido());
                    Aficionado a1 =(Aficionado) u; // Downcasting de Usuario a Aficionado
                    System.out.println("Su numero de celular es: " + a1.getCelular());
                    System.out.println("¿Este número de celular es correcto? (S/N): S para sí, N para no: ");
                    String Celular= sc.nextLine();



                    if(Celular.equals("S")){
                        int opcion = 0;
                    // Bucle que mantiene el menú activo
                    while (opcion != 5) { // Suponiendo que 5 es Salir
                        opcion = a1.mostrarMenu(); // Esto imprime el menú y pide la opción
            
                         switch (opcion) {
                    case 1:
                        a1.consultarPartidos(partidos); // llama a consultarPartidos()
                        break;
                    case 2:
                        a1.comprarEntrada(partidos); // llama a comprarEntrada()
                        break;
                    case 3:
                        a1.comprarKit(kits, partidos); // llama a comprarKit()
                        break;
                    case 4:
                        a1.consultarEntrada(compras);// llama a consultarEntradas()
                        break;
                    case 5:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opción no válida");
                        }
                    }
                } else if (rol == Rol.O) {
                    System.out.println("Su rol es: Organizador.");
                    System.out.println("Bienvenido/a " + u.getNombre() + " " + u.getApellido());
                    Organizador o1 =(Organizador) u; // Downcasting de Usuario a Organizador
                    System.out.println("Empresa asignada: " + o1.getEmpresa());
                    System.out.print("¿Esta empresa es correcta? (S/N): ");
                    String Empresa= sc.nextLine();
                    if(Empresa.equals("S")){
                        o1.mostrarMenu();
                    String opcion = sc.nextLine();
                    } else {
                        System.out.println("Verificación fallida.   \r\n" + //
                                            "Por motivos de seguridad se cerrará la sesión. \r\n" + //
                                            "Saliendo del sistema... ");

                    }
                break; // Salimos del método si encontramos al usuario
            } 
            
        }
        }
        }
        if(!usuarioEncontrado) {
            System.out.println("Usuario o contraseña incorrectos. Intente nuevamente.");
            }
    }








    public static void notificar(Aficionado a, Compra c) {
        System.out.println("--- Notificación de Compra ---");
        System.out.println("Estimado/a " + a.getNombre() + ", su compra de entrada ha sido registrada.");
        System.out.println("Detalles: " + c.toString());
    }







    public static void notificar(Aficionado a, Compra c, Kit k) {
        System.out.println("--- Notificación de Compra de Kit ---");
        System.out.println("Estimado/a " + a.getNombre() + ", su kit '" + k.getNombre() + "' ha sido adquirido con éxito.");
        System.out.println("Total pagado: $" + c.getValorPagado());
    }
















    public void mostrarMenu(){

    }









private void cargarUsuariosDesdeArchivo() {
    // 1. Cargamos cada archivo UNA SOLA VEZ en memoria RAM al iniciar el método
    ArrayList<String> lineasUsuarios = Archivos.cargarUsuarios("usuarios.txt");
    ArrayList<String> lineasAficionados = Archivos.cargarUsuarios("aficionados.txt");
    ArrayList<String> lineasOrganizadores = Archivos.cargarUsuarios("organizadores.txt");
    this.partidos = Partido.cargarpartidos("partidos.txt");

    // 2. Recorremos las líneas de usuarios saltando la cabecera
    for (int i = 1; i < lineasUsuarios.size(); i++) {
        String linea = lineasUsuarios.get(i);
        String[] datos = linea.split("\\|");

        String codigoUnico = datos[0]; 
        String cedula = datos[1];
        String nombre = datos[2];
        String apellido = datos[3];
        String usuario = datos[4];       
        String contraseña = datos[5];       
        String correo = datos[6];
        Rol rol = Rol.valueOf(datos[7].trim());  
        
        if (rol == Rol.A) {
            // Buscamos los datos en la lista de aficionados que YA tenemos en memoria
            String celular = "No asignado";
            String paisFavorito = "No asignado";

            for (int j = 1; j < lineasAficionados.size(); j++) {
                String[] datosAficionado = lineasAficionados.get(j).split("\\|");
                if (datosAficionado[0].equals(codigoUnico)) {
                    celular = datosAficionado[4];      // Índice del celular
                    paisFavorito = datosAficionado[5]; // Índice del país favorito
                    break; // Salimos del bucle interno al encontrar la coincidencia
                }
            }
            
            Aficionado aficionado = new Aficionado(codigoUnico, cedula, nombre, apellido, usuario, contraseña, correo, rol, celular, paisFavorito);
            this.usuarios.add(aficionado); 
            
        } else if (rol == Rol.O) {
            // Buscamos los datos en la lista de organizadores que YA tenemos en memoria
            String empresa = "No asignada";
            String cargo = "No asignado";

            for (int k = 1; k < lineasOrganizadores.size(); k++) {
                String[] datosOrganizador = lineasOrganizadores.get(k).split("\\|");
                if (datosOrganizador[0].equals(codigoUnico)) {
                    empresa = datosOrganizador[4]; // Índice de la empresa
                    cargo = datosOrganizador[5];   // Índice del cargo
                    break; // Salimos del bucle interno al encontrar la coincidencia
                }
            }
            
            Organizador organizador = new Organizador(codigoUnico, cedula, nombre, apellido, usuario, contraseña, correo, rol, empresa, cargo);
            this.usuarios.add(organizador);
        }
    }
} 
}
    

