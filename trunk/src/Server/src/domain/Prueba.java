package domain;
// Generated 26-ene-2012 20:54:22 by Hibernate Tools 3.4.0.CR1



/**
 * Prueba generated by hbm2java
 */
public class Prueba  implements java.io.Serializable {


     private int idPrueba;
     private String nombre;

    public Prueba() {
    }

	
    public Prueba(int idPrueba) {
        this.idPrueba = idPrueba;
    }
    public Prueba(int idPrueba, String nombre) {
       this.idPrueba = idPrueba;
       this.nombre = nombre;
    }
   
    public int getIdPrueba() {
        return this.idPrueba;
    }
    
    public void setIdPrueba(int idPrueba) {
        this.idPrueba = idPrueba;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }




}


