
package modelo;

public class Req1 {

    private int idProyecto;
    private String pagado;
    private String proveedor;

    private int total;
    
    public Req1(int total, int idProyecto, String pagado, String proveedor) {
        this.total = total;
        this.idProyecto = idProyecto;
        this.pagado = pagado;
        this.proveedor = proveedor;
    }
    
    @Override
    public String toString() {
        return "Req1 [" + "idProyecto=" + idProyecto + ", pagado=" + pagado + ", proveedor=" + proveedor + ", total=" + total + ']';
    }
}
