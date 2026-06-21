package GestionEstadio;

public class Aficionado extends Usuario {
    private String celular;
    private String paisFavorito;

    public Aficionado(String codigoUnico, String cedula, String nombre, String apellido, String usuario, String contraseña, String correo, Rol rol){
        super(codigoUnico, cedula, nombre, apellido, usuario, contraseña, correo, rol);
        this.celular=celular;
        this.paisFavorito=paisFavorito;
    }

    @Override
    public void consularEntrada(){
        System.out.println();
    }

    public void comprar(Partido partido){

    }

    public void comprar(Kit kit){
        
    }
}