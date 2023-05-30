/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package construrraptor.entidadesdenegocio;

/**
 *
 * @author H
 */
public class Marca {
    private int idMarca;
      private String imagen;
    
    private String nombreMarca;

    public Marca() {
    }

    public Marca(int idMarca,String imagen, String nombreMarca) {
        this.idMarca = idMarca;
         this.imagen = imagen;
        this.nombreMarca = nombreMarca;
    }

    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }
    
     public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }


    public String getNombreMarca() {
        return nombreMarca;
    }

    public void setNombreMarca(String nombreMarca) {
        this.nombreMarca = nombreMarca;
    }
}
