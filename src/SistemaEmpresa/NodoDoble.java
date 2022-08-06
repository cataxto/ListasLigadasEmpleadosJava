package SistemaEmpresa;


public class NodoDoble 
{
    
    private Empleado empleado;
    private NodoDoble ligaIzq;
    private NodoDoble ligaDer;
    
    public NodoDoble(String cedula, String nombre, float salarioBruto, float bonificacion, float deduccion)
    {
        empleado = new Empleado(cedula, nombre, salarioBruto, bonificacion, deduccion);
        ligaDer=null;
        ligaIzq=null;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public NodoDoble getLigaIzq() {
        return ligaIzq;
    }

    public void setLigaIzq(NodoDoble ligaIzq) {
        this.ligaIzq = ligaIzq;
    }

    public NodoDoble getLigaDer() {
        return ligaDer;
    }

    public void setLigaDer(NodoDoble ligaDer) {
        this.ligaDer = ligaDer;
    }
}
