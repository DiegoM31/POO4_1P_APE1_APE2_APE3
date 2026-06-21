package GestionEstadio;

public class Organizador extends Usuario {
    //Se definen sus atributos propias
    private String empresa;
    private String cargo;

    //Se define sus constructor
    public Organizador(String codigoUnico, String cedula, String nombre, String apellido, String usuario,
        String contraseña, String correo, Rol rol) {
        super(codigoUnico, cedula, nombre, apellido, usuario, contraseña, correo, rol);
        this.empresa=empresa;
        this.cargo=cargo;
    }

    @Override
    public void consularEntrada(){
        System.out.println();
    }

    public void generarReporteDeVentas(){

    }

    public void salir(){

    }
    //Metodos Getters y Setters
    public String getempresa() {
        return empresa;
    }

    public void setempresa(String empresa) {
        this.empresa = empresa;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

}
    

