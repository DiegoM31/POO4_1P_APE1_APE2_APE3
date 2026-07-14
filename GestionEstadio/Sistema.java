package GestionEstadio;

import GestionEstadio.Aficionado;
import GestionEstadio.Organizador;  
import GestionEstadio.Usuario;

import GestionEstadio.Partido;

import java.util.Scanner;
import java.text.SimpleDateFormat;
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
        cargarKitsDesdeArchivo();
    }

    public ArrayList<Compra> getCompras() {
        return compras;
    }

    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        sistema.iniciarSecion();
        sistema.sc.close(); // Cerramos el Scanner al final del programa
    }




public void iniciarSecion() {
    // Este bucle mantiene el sistema encendido pidiendo nuevos logins
    boolean sistemaActivo = true;

    while (sistemaActivo) {
        System.out.println("\n\n\n\n\n");
        System.out.println("---- Iniciar Sesión ----");
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
                boolean sesionActiva = true;

                if (rol == Rol.A) {
                    System.out.println("Su rol es: Aficionado.");
                    System.out.println("Bienvenido/a " + u.getNombre() + " " + u.getApellido());
                    Aficionado a1 = (Aficionado) u;
                    System.out.println("Su numero de celular es: " + a1.getCelular());
                    System.out.print("¿Este número de celular es correcto? (S/N): ");
                    String confirmacion = sc.nextLine();

                    if (confirmacion.equalsIgnoreCase("S")) {
                        while (sesionActiva) {
                            int opcion = a1.mostrarMenu();
                            switch (opcion) {
                                case 1: a1.consultarPartidos(partidos); break;
                                case 2: a1.comprarEntrada(partidos, this); break;
                                case 3: a1.comprarKit(kits, partidos, this); break;
                                case 4: a1.consultarEntrada(compras); break;
                                case 5: 
                                    System.out.println("Cerrando sesión...");
                                    sesionActiva = false; // Rompe el while del menú
                                    break;
                                default: System.out.println("Opción no válida");
                            }
                        }
                    }

                } else if (rol == Rol.O) {
                    System.out.println("Su rol es: Organizador.");
                    System.out.println("Bienvenido/a " + u.getNombre() + " " + u.getApellido());
                    Organizador o1 = (Organizador) u;
                    System.out.println("Empresa asignada: " + o1.getEmpresa());
                    System.out.print("¿Esta empresa es correcta? (S/N): ");
                    String confirmacion = sc.nextLine();
                    
                    if (confirmacion.equalsIgnoreCase("S")) {
                        while (sesionActiva) {
                            int opcion = o1.mostrarMenu();
                            switch (opcion) {
                                case 1: o1.consultarEntrada(compras); break;
                                case 2: o1.generarReporte(compras); break;
                                case 3: 
                                    System.out.println("Cerrando sesión...");
                                    sesionActiva = false; // Rompe el while del menú
                                    break;
                                default: System.out.println("Opción no válida");
                            }
                        }
                    } else {
                        System.out.println("Verificación fallida. Cerrando sesión...");
                    }
                }
                break; // Sale del for de búsqueda de usuarios una vez logueado
            }
        }
        
        if (!usuarioEncontrado) {
            System.out.println("Usuario o contraseña incorrectos. Intente nuevamente.");
        }
    }
}

 








    public static void notificar(Aficionado a, Compra c) {
        if (c == null) {
            System.out.println("\nError: No se pudo realizar la notificación porque la compra no existe (es nula).");
            return;
        }

        System.out.println("\n\nDe: correoSistema");
        System.out.println("Para: " + a.getCorreo());
        System.out.println("Asunto: Compra de entrada realizada");
        System.out.println("Estimado/a " + a.getNombre() + " " + a.getApellido() + ",");
        
        System.out.println("Su compra ha sido registrada exitosamente con el código " + c.getCodigoCompra());
        System.out.println("Gracias por adquirir sus entradas.\n\n");
        
    }

    public static void notificar(Aficionado a, Compra c, Kit k) {
        if (c == null || k == null) {
            System.out.println("\nError: No se puede notificar, datos de compra o kit incompletos.");
            return;
        }

        System.out.println("\n\nAsunto: Compra de kit realizada");
        System.out.println("Hola " + a.getNombre() + ", has adquirido el kit: " + k.getNombre());
        System.out.println("Total pagado: $" + c.getValorPagado()+"\n\n");
    }


    public static void notificar(Organizador o, int totalCompras, int totalEntradas, int totalKits, double montoTotal) {
        System.out.println("\n\nDe: correoSistema");
        System.out.println("Para: " + o.getCorreo());
        System.out.println("Asunto: Reporte de compras registradas");
        System.out.println("Estimado/a " + o.getNombre() + ",");
        System.out.println("Se ha generado el reporte de compras del sistema.");
        System.out.println("Total de compras: " + totalCompras);
        System.out.println("Entradas: " + totalEntradas + " | Kits: " + totalKits);
        System.out.println("Monto total recaudado: $" + String.format("%.2f", montoTotal)+"\n\n");
    }










private void cargarUsuariosDesdeArchivo() {
    // 1. Cargamos cada archivo UNA SOLA VEZ en memoria RAM al iniciar el método
    ArrayList<String> lineasUsuarios = Archivos.leerArchivo("usuarios.txt");
    ArrayList<String> lineasAficionados = Archivos.leerArchivo("aficionados.txt");
    ArrayList<String> lineasOrganizadores = Archivos.leerArchivo("organizadores.txt");
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
                    break; 
                }
            }
            
            Aficionado aficionado = new Aficionado(codigoUnico, cedula, nombre, apellido, usuario, contraseña, correo, rol, celular, paisFavorito);
            this.usuarios.add(aficionado); 
            
        } else if (rol == Rol.O) {
            String empresa = "No asignada";
            String cargo = "No asignado";

            for (int k = 1; k < lineasOrganizadores.size(); k++) {
                String[] datosOrganizador = lineasOrganizadores.get(k).split("\\|");
                if (datosOrganizador[0].equals(codigoUnico)) {
                    empresa = datosOrganizador[4]; // Índice de la empresa
                    cargo = datosOrganizador[5];   // Índice del cargo
                    break; 
                }
            }
            
            Organizador organizador = new Organizador(codigoUnico, cedula, nombre, apellido, usuario, contraseña, correo, rol, empresa, cargo);
            this.usuarios.add(organizador);
        }
    }
} 

public void cargarKitsDesdeArchivo() {
    ArrayList<String> lineas = Archivos.leerArchivo("kits.txt");
    
    // Saltamos la cabecera (si la tiene, empieza en 1)
    for (int i = 1; i < lineas.size(); i++) {
        String[] datos = lineas.get(i).split("\\|");
        String cadenaPartidos = datos[3];
        String[] arrayPartidos = cadenaPartidos.split(","); 
        ArrayList<String> listaPartidos = new ArrayList<>();
        for (String p : arrayPartidos) {
            listaPartidos.add(p.trim()); 
        }
        Kit k = new Kit(datos[0], datos[1], datos[2], listaPartidos, Double.parseDouble(datos[4]), Integer.parseInt(datos[5]));
        this.kits.add(k);
    }
}
// En Sistema.java, dentro de los métodos de carga:
public void cargarComprasDesdeArchivo() {
    // Usamos tu método de lectura (el genérico)
    ArrayList<String> lineas = Archivos.leerArchivo("compras.txt"); // O tu método unificado
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    
    for (int i = 0; i < lineas.size(); i++) {
        try {
            String[] datos = lineas.get(i).split("\\|");
            
            // Aquí usamos el SEGUNDO constructor (el que sincroniza el contador)
            Compra compraCargada = new Compra(
                datos[0], // Código existente (ej. C001)
                datos[1], // Tipo
                datos[2], // Referencia
                sdf.parse(datos[3]), // Fecha
                Integer.parseInt(datos[4]), // Cantidad
                Double.parseDouble(datos[5]), // Valor
                datos[6] // Código Aficionado
            );
            this.compras.add(compraCargada);
        } catch (Exception e) {
            // Ignora líneas vacías o cabeceras que puedan fallar
        }
    }
}
        
    
}



    

