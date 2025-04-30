
package ejercicio.objetos;

public class Datos {
    String nombre,id,celular,direccion,municipio;
    double salario;

    public Datos() {
    }

    public Datos(String nombre, String id, String celular, String direccion, String municipio, double salario) {
        this.nombre = nombre;
        this.id = id;
        this.celular = celular;
        this.direccion = direccion;
        this.municipio = municipio;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
}
