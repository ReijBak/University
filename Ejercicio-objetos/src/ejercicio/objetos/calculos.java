
package ejercicio.objetos;

public class calculos {
    
    public void buscar_mayor(Datos empleado1,Datos empleado2){
        
        if(empleado1.getSalario()>empleado2.getSalario()){
            System.out.print("El empleado con mayor salario es "+empleado1.getNombre());
        }
        else{
            System.out.print("El empleado con mayor salario es "+empleado2.getNombre());
        }
    }
    
}
