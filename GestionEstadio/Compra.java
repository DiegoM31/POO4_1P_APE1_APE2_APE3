package GestionEstadio;
import java.util.Date;
public class Compra {
    private static int contadorCompras=-1;
    private String codigoCompra;
    private String tipo;
    private String codigoReferencia;
    private Date fechacompra;
    private int cantidad;
    private double valorPagado;
    private String codigoAficionado;
    public Compra(String tipo, String codigoReferencia,Date fechacompra,int cantidad,double valorPagado,String codigoAficionado){
        this.codigoCompra="C"+String.format("%03d", contadorCompras++);
        this.tipo=tipo;
        this.codigoReferencia=codigoReferencia;
        this.fechacompra=fechacompra;
        this.cantidad=cantidad;
        this.valorPagado=valorPagado;
        this.codigoAficionado=codigoAficionado;

    }
    public String getCodigoCompra() {
        return codigoCompra;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getCodigoReferencia() {
        return codigoReferencia;
    }
    public void setCodigoReferencia(String codigoReferencia) {
        this.codigoReferencia = codigoReferencia;
    }
    public Date getFechacompra() {
        return fechacompra;
    }
    public void setFechacompra(Date fechacompra) {
        this.fechacompra = fechacompra;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public double getValorPagado() {
        return valorPagado;
    }
    public void setValorPagado(double valorPagado) {
        this.valorPagado = valorPagado;
    }
    public String getCodigoAficionado(){
        return codigoAficionado;
    }
    public void setCodigoAficionado(String codigoAficionado){
        this.codigoAficionado=codigoAficionado;
    }
    @Override
    public String toString(){
        return "Compra: "+ codigoCompra+" ["+tipo+"]- Ref: "+codigoReferencia+" | Total: $"+valorPagado;     
    }

    
}