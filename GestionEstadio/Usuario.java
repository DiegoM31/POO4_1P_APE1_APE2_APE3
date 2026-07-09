package GestionEstadio;

public class Usuario {
    protected String codigoUnico;
    protected String cedula;
    protected String nombre;
    protected String apellido;
    protected String usuario;
    protected String contraseña;
    protected String correo;
    public Rol rol;

    public Usuario(String codigoUnico, String cedula, String nombre, String apellido, String usuario, String contraseña, String correo, Rol rol){
        this.codigoUnico= codigoUnico;
        this.cedula= cedula;
        this.nombre= nombre;
        this.apellido=apellido;
        this.usuario= usuario;
        this.contraseña= contraseña;
        this.correo= correo;
        this.rol=rol;
    }

    public void setCodigoUnico(String codigoUnico){
        this.codigoUnico= codigoUnico;
    }
    public String getCodigoUnico(){
        return this.codigoUnico;
    }
    
    public void setCedula(String cedula){
        this.cedula= cedula;
    }
    public String getCedula(){
        return this.cedula;
    }

    public void setNombre(String nombre){
        this.nombre= nombre;
    }
    public String getNombre(){
        return this.nombre;
    }

    public void setApellido(String apellido){
        this.apellido= apellido;
    }
    public String getApellido(){
        return this.apellido;
    }

    public void setUsuario(String usuario){
        this.usuario= usuario;
    }
    public String getUsuario(){
        return this.usuario;
    }

    public void setContraseña(String contraseña){
        this.contraseña= contraseña;
    }
    public String getContraseña(){
        return this.contraseña;
    }

    public void setCorreo(String correo){
        this.correo= correo;
    }
    public String getCorreo(){
        return this.correo;
    }
    
    public void setRol(Rol rol){
        this.rol= rol;
    }
    public Rol getRol(){
        return this.rol;
    }


    public void consularEntrada(){
    }


    public void mostrarMenu() {
        System.out.println("Menú de opciones:");
    }

    



}
