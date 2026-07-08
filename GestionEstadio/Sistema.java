package GestionEstadio;



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
            // Aquí es donde verificamos si el usuario y la contraseña coinciden
            // Usamos los métodos getUsuario() y getContraseña() de la clase Usuario
            if (u.getUsuario().equals(usuarioI) && u.getContraseña().equals(contraseñaI)) {
                usuarioEncontrado = true;
                System.out.println("¡Inicio de sesión exitoso!");
                System.out.println("Bienvenido/a " + u.getNombre() + " " + u.getApellido());
                break; // Salimos del método si encontramos al usuario
            } 
        }
        if(!usuarioEncontrado) {
            System.out.println("Usuario o contraseña incorrectos. Intente nuevamente.");
        }
    }








    public void notificar( Aficionado aficionado, Compra compra){

    }

    public void notificar( Organizador organizador){

    }

























    private void cargarUsuariosDesdeArchivo() {
        // Llamamos al método estático que ya creaste en tu clase Archivos
        ArrayList<String> lineas = Archivos.cargarUsuarios("usuarios.txt");

        // Recorremos las líneas. Empezamos en i = 1 para SALTAR la cabecera (CodigoUnico|Cedula...)
        for (int i = 1; i < lineas.size(); i++) {
            String linea = lineas.get(i);
            
            // Cortamos la línea usando el split
            String[] datos = linea.split("\\|");

            // Guardamos cada posición en variables (¡Tus índices calculados!)
            String codigoUnico = datos[0];
            String cedula = datos[1];
            String nombre = datos[2];
            String apellido = datos[3];
            String usuario = datos[4];       // Índice 4
            String contraseña = datos[5];       // Índice 5
            String correo = datos[6];
            Rol rol = Rol.valueOf(datos[7]);  
        
        Usuario usuario2 = new Usuario(codigoUnico, cedula, nombre, apellido, usuario, contraseña, correo, rol);
        this.usuarios.add(usuario2);      // Índice 7
        }
    }
}
