package GestionEstadio;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Compra {
    private static int contadorCompras=0;
    private String codigoCompra;
    private String tipo;
    private String codigoReferencia;
    private Date fechacompra;
    private int cantidad;
    private double valorPagado;
    private String codigoAficionado;
    public Compra(String tipo, String codigoReferencia,Date fechacompra,int cantidad,double valorPagado,String codigoAficionado){
        this.codigoCompra="C"+String.format("%03d", ++contadorCompras);
        this.tipo=tipo;
        this.codigoReferencia=codigoReferencia;
        this.fechacompra=fechacompra;
        this.cantidad=cantidad;
        this.valorPagado=valorPagado;
        this.codigoAficionado=codigoAficionado;

    }
    public Compra(String codigoCompra, String tipo, String codigoReferencia, Date fechacompra, int cantidad, double valorPagado, String codigoAficionado) {
        this.codigoCompra = codigoCompra;
        this.tipo = tipo;
        this.codigoReferencia = codigoReferencia;
        this.fechacompra = fechacompra;
        this.cantidad = cantidad;
        this.valorPagado = valorPagado;
        this.codigoAficionado = codigoAficionado;
        String soloNumeros = codigoCompra.substring(1);
        int numeroActual = Integer.parseInt(soloNumeros);
        if (numeroActual > contadorCompras) {
            contadorCompras = numeroActual;
        }
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
    public String formatToLineaArchivo() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        return codigoCompra + "|" + tipo + "|" + codigoReferencia + "|" + sdf.format(fechacompra) + "|" + cantidad + "|" + valorPagado + "|" + codigoAficionado;
    }
    @Override
    public String toString(){
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        return "--------------------"+"\n"+
        "Compra: "+ codigoCompra+" ["+tipo+"] "+"\n"+
        "Ref: "+codigoReferencia+"\n"+
        "Fecha de compra: "+sdf.format(fechacompra)+"\n"+
        "Cantidad: "+cantidad+"\n"+
        "Total: $"+valorPagado+"\n"+
        "Codigo Aficionado: "+codigoAficionado+"\n"+
        "--------------------" ;    
    }

    
}