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

    public void setcodigoUnico(String codigoUnico){
        this.codigoUnico= codigoUnico;
    }
    public String getcodigoUnico(){
        return this.codigoUnico;
    }
    
    public void setcedula(String cedula){
        this.cedula= cedula;
    }
    public String getcedula(){
        return this.cedula;
    }

    public void setnombre(String nombre){
        this.nombre= nombre;
    }
    public String getnombre(){
        return this.nombre;
    }

    public void setapellido(String apellido){
        this.apellido= apellido;
    }
    public String getapellido(){
        return this.apellido;
    }

    public void setusuario(String usuario){
        this.usuario= usuario;
    }
    public String getusuario(){
        return this.usuario;
    }

    public void setcontraseña(String contraseña){
        this.contraseña= contraseña;
    }
    public String getcontraseña(){
        return this.contraseña;
    }

    public void setcorreo(String correo){
        this.correo= correo;
    }
    public String getcorreo(){
        return this.correo;
    }
    
    public void setrol(Rol rol){
        this.rol= rol;
    }
    public Rol getrol(){
        return this.rol;
    }


    public void consularEntrada(){
    }



}
