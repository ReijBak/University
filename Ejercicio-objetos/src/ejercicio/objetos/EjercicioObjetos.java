
package ejercicio.objetos;

import java.util.Scanner;

public class EjercicioObjetos {
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nombre,id,celular,direccion,municipio;
        double salario;
        System.out.print("Digite su nombre empleado 1: ");
        nombre = sc.nextLine();
        System.out.print("Digite su id empleado 1: ");
        id = sc.nextLine();
        System.out.print("Digite su celular empleado 1: ");
        celular = sc.nextLine();
        System.out.print("Digite su dirección empleado 1: ");
        direccion = sc.nextLine();
        System.out.print("Digite su municipio empleado 1: ");
        municipio = sc.nextLine();
        System.out.print("Digite su salario empleado 1: ");
        salario = sc.nextDouble();
        
        Datos empleado1 = new Datos(nombre,id,celular,direccion,municipio,salario);
        
        System.out.print("Digite su nombre empleado 2: ");
        nombre = sc.nextLine();
        System.out.print("Digite su id empleado 2: ");
        id = sc.nextLine();
        System.out.print("Digite su celular empleado 2: ");
        celular = sc.nextLine();
        System.out.print("Digite su dirección empleado 2: ");
        direccion = sc.nextLine();
        System.out.print("Digite su municipio empleado 2: ");
        municipio = sc.nextLine();
        System.out.print("Digite su salario empleado 2: ");
        salario = sc.nextDouble();
        sc.nextLine();
                
        //Datos empleado2 = new Datos(nombre,id,celular,direccion,municipio,salario);
        Datos empleado2 = new Datos();
        empleado2.setNombre(nombre);
        empleado2.setSalario(salario);
        calculos cl= new calculos();
        cl.buscar_mayor(empleado1,empleado2);
    }
    
}
