package GestionEstadio;

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








    @Override
    public void consularEntrada(){
        System.out.println();
    }

    public void generarReporteDeVentas(){

    }

    public void salir(){
  }

}
    

