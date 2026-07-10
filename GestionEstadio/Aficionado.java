package GestionEstadio;

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



    @Override
    public void consultarEntrada(){
        System.out.println();
    }

    public void comprar(Partido partido){

    }

    public void comprar(Kit kit){
        
    }
}