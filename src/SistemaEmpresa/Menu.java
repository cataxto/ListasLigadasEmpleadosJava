/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaEmpresa;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author catax
 */
public class Menu 
{
    public static void main(String[] args) 
    {

        Scanner lector = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.00");
        Empleado emp;
        String pCed, pNomb;
        float pSalBruto, pBon, pDed;
        char opc;
        boolean pBool = false;
        //System.out.println(df.format(number));
        
        // Crear lista de Empleados
        ListaNodoDoble listaEmpleados = new ListaNodoDoble();
        
        System.out.print("Ingrese cédula del primer empleado: ");
        pCed=lector.nextLine();
        while(!pCed.equals("/*"))
        {
            System.out.print("Nombre:\t\t");
            pNomb = lector.nextLine();
            System.out.print("Salario bruto:\t");
            pSalBruto = lector.nextFloat();
            System.out.print("Bonificación:\t");
            pBon = lector.nextFloat();
            System.out.print("Deducción:\t");
            pDed = lector.nextFloat();
            listaEmpleados.nuevoEmpleado(pCed, pNomb, pSalBruto, pBon, pDed);
            System.out.print("\nIngrese cédula del siguiente empleado:(/* para salir): ");
            lector.nextLine();
            pCed=lector.nextLine();
        }
        
        do 
        {
            opc=menu();
            switch(opc)
            {
                case '1':
                        //1. Ingresar nuevo empleado
                        System.out.print("\nIngrese cédula del empleado: ");
                        pCed=lector.nextLine();
                        System.out.print("Nombre:\t\t");
                        pNomb = lector.nextLine();
                        System.out.print("Salario bruto:\t");
                        pSalBruto = lector.nextFloat();
                        System.out.print("Bonificación:\t");
                        pBon = lector.nextFloat();
                        System.out.print("Deducción:\t");
                        pDed = lector.nextFloat();
                        listaEmpleados.nuevoEmpleado(pCed, pNomb, pSalBruto, pBon, pDed);
                        break;
                case '2':        
                        //2. Eliminar un empleado
                        System.out.print("\nIngrese cédula del empleado a eliminar: ");
                        pCed=lector.nextLine();
                        lector.nextLine();
                        pBool = listaEmpleados.eliminarEmpleado(pCed);
                        System.out.println("pBool: "+pBool);
                        if(pBool)
                        {
                            System.out.println("Empleado eliminado exitosamente");
                        }
                        else
                        {
                            System.out.println("Cédula no hallada en la base de datos");
                        }
                        break;
                case '3':
                        //3.Mostrar listado de cedulas, nombres y salarios netos
                        emp=listaEmpleados.mostrarEmpleado();
                        System.out.println("\nCEDULA\tNOMBRE\tSALARIO_NETO");
                        while(!emp.getCedula().equals(""))
                        {
                            System.out.println(emp.getCedula()+"\t"+emp.getNombre()+"\t"+emp.salarioNeto());
                            emp=listaEmpleados.mostrarEmpleado();
                        }
                        break;
                case '4':
                        //4. Mostrar el salario neto promedio de los empleados
                        System.out.println("\nEl salario neto promedio de los empleados es :"+listaEmpleados.salarioNetoPromedio());
                        break;
                case '5':
                        //5. Mostrar el monto total de las deducciones
                        System.out.println("\nEl monto total de las deducciones es: "+listaEmpleados.montoTotalDeducciones());
                        break;
                case '6':
                        //6. Mostrar el monto total de las bonificaciones
                        System.out.println("\nEl monto total de las bonificaciones es: "+listaEmpleados.montoTotalBonificaciones());
                        break;
                case '7':
                        //7. Mostrar el mayor salario neto de los empleados
                        System.out.println("\nEl mayor salario neto de los empleados es: "+listaEmpleados.salarioNetoMayor());
                        break;
                case '8':
                        //8. Mostrar listado con las cédulas de los empleados con el mayor salario neto
                        emp=listaEmpleados.mostrarEmpleado();
                        System.out.println("\nCEDULA");
                        float salarioMayor=listaEmpleados.salarioNetoMayor();
                        while(!emp.getCedula().equals(""))
                        {
                            if(emp.salarioNeto()==salarioMayor)
                                {System.out.println(emp.getCedula());}
                            emp=listaEmpleados.mostrarEmpleado();
                        }
                        break;
                case '9':
                        System.out.println("Eligió salir, Hasta luego!!");
                        break;
                default:
                         break;
            }
        } while (opc!='9');
    }
    
    static char menu()
    {
        char opcion;
        Scanner lector = new Scanner(System.in);
        System.out.println("\n\t MENU DE OPCIONES");
        System.out.println("1. Ingresar un nuevo empleado");
        System.out.println("2. Eliminar un empleado (buscarlo por el campo cédula)");
        System.out.println("3. Mostrar listado cédulas, nombres y salarios netos");
        System.out.println("4. Mostrar el salario neto promedio de los empleados"); //
        System.out.println("5. Mostrar el monto total de deducciones");
        System.out.println("6. Mostrar el monto total de bonificaciones"); //
        System.out.println("7. Mostrar el mayor salario neto de los empleados"); //
        System.out.println("8. Mostrar listado con las cédulas de los empleados con el mayor salario neto");
        System.out.println("9. Salir");
        
        do {            
            System.out.print("\nIngrese opción (1 a 9):\t");
            opcion=lector.nextLine().charAt(0);
        } while (opcion<'1' || opcion> '9');
        return opcion;
    }
}
