package clases;

public class Masajista extends Padre {

    int AniosExperiencia;
    String Titulacion;

    public void DarMensaje() {
        System.out.println("Dando el Mensaje ...");
    }

    @Override
    public void Concentrarse() {

        System.out.println("Concentrados los Masajistas");
    }

    @Override
    public void Viajar() {

        System.out.println("Viaje Programado para los masajistas");

    }
}
