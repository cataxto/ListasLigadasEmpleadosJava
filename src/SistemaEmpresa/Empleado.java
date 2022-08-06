package SistemaEmpresa;

public class Empleado 
{
    //Definicion de atributos de clase
    private String cedula;
    private String nombre;
    private float salarioBruto;
    private float bonificacion;
    private float deduccion;

    //Constructor
    public Empleado(String cedula, String nombre, float salarioBruto, float bonificacion, float deduccion) 
    {
        this.cedula = cedula;
        this.nombre = nombre;
        this.salarioBruto = salarioBruto;
        this.bonificacion = bonificacion;
        this.deduccion = deduccion;
    }

    //Metodo para calcular Salario Neto
    public float salarioNeto()
    {
        float salarioNeto=salarioBruto+bonificacion-deduccion;
        return salarioNeto;
    }
    
    //Getters y Setters
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSalarioBruto() {
        return salarioBruto;
    }

    public void setSalarioBruto(float salarioBruto) {
        this.salarioBruto = salarioBruto;
    }

    public double getBonificacion() {
        return bonificacion;
    }

    public void setBonificacion(float bonificacion) {
        this.bonificacion = bonificacion;
    }

    public double getDeduccion() {
        return deduccion;
    }

    public void setDeduccion(float deduccion) {
        this.deduccion = deduccion;
    }
        
        
}
