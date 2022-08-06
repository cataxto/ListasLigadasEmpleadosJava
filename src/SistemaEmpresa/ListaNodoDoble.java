package SistemaEmpresa;

public class ListaNodoDoble 
{
    private NodoDoble cab;
    private NodoDoble ult;
    private NodoDoble x;
    private Empleado e;
    
    public ListaNodoDoble()
    {
        cab = new NodoDoble("", "", 0, 0, 0);
        ult=x=cab;
    }
    
    public void nuevoEmpleado(String cedula, String nombre, float salarioBruto, float bonificacion, float deduccion)
    {
        x = new NodoDoble(cedula, nombre, salarioBruto, bonificacion, deduccion);
        ult.setLigaDer(x);
        ult=x;
        x=cab;
    }
    
    public boolean eliminarEmpleado(String cedula)
    {
        boolean elimino=false;
        x=x.getLigaDer();
        
        while(x!=null)
        {
            if(x.getEmpleado().getCedula().equals(cedula))
            {
                x.getLigaIzq().setLigaDer(x.getLigaDer());
                x.getLigaDer().setLigaIzq(x.getLigaIzq());
                elimino=true;
            } 
            x=x.getLigaDer();
        }
        x=cab;
        return elimino;
    }
    
    public Empleado mostrarEmpleado()
    {
        x=x.getLigaDer();
        if(x==null)
        {
            x=cab;
        }
        return x.getEmpleado();
    }
    
    public float salarioNetoPromedio()
    {
        float sumaSalario=0, promedioSalario=0;
        int cantidad=0;
        x=x.getLigaDer();

        while(x!=null)
        {
            e=x.getEmpleado();
            sumaSalario+=e.salarioNeto();
            cantidad++;
            x=x.getLigaDer();
        }
        
        x=cab;
        promedioSalario=Math.round(sumaSalario/cantidad);
        return promedioSalario;
    }
    
    public float montoTotalDeducciones()
    {
        float montoTotalDeducciones=0;
        x=x.getLigaDer();
        
        while(x!=null)
        {
           e=x.getEmpleado();
           montoTotalDeducciones+=e.getDeduccion();
           x=x.getLigaDer();
        }
        x=cab;
        return montoTotalDeducciones;
    }
    
    public float montoTotalBonificaciones()
    {
        float montoTotalBonificaciones=0;
        x=x.getLigaDer();
        
        while(x!=null)
        {
           e=x.getEmpleado();
           montoTotalBonificaciones+=e.getBonificacion();
           x=x.getLigaDer();
        }
        x=cab;
        return montoTotalBonificaciones;
    }
    
    public float salarioNetoMayor()
    {
        float salarioNetoMayor=0;
        x=x.getLigaDer();
        
        while(x!=null)
        {
            e=x.getEmpleado();
            if(e.salarioNeto()>salarioNetoMayor)
            {
                salarioNetoMayor=e.salarioNeto();
            }
            x=x.getLigaDer();
        }
        x=cab;
        return salarioNetoMayor;
    }
}
